import javax.swing.JOptionPane;


class Buscaminas3 {
	
	//metodo principal	
	public static void main(String[] args) {
		/*pide la cantidad de columnas y filas que desee el usuario en el buscaminas*/
		int x=0,y=0,tamaño=0;
		while(tamaño==0){
			x=Integer.parseInt(JOptionPane.showInputDialog("ingrese filas minimo de 5"));
			y=Integer.parseInt(JOptionPane.showInputDialog("ingrese columnas minimo de 5"));
			if(x>=5 && y >=5){
				tamaño=1;
			}
			else{
				JOptionPane.showMessageDialog(null,"INGRESE NUMEROS MAYORES A CINCO");
			}
		}
		//casillas se utiliza para multiplicar con el ramdon
		int casillas=x*y;
		/*tablero es una matriz que no se muestra en pantalla pero contiene la ubicacion de las 
		 *minas y los numeros de cada casilla con sus minas alrededor
		 */
		String[][] tablero= new String [x][y];
		/*tableroUsuario=no contiene inicialmente nada pero se utilizara para mostrar al usuario
		 * las jugadas que ha hecho
		 */
		String[][] tableroUsuario= new String [x][y];
		
		int arrMinas[]= generarMinas(casillas);
		arrMinas= organizarArreglo(arrMinas);
		tablero=llenarminas(tablero,arrMinas);
		tablero=numeros(tablero);
		boolean fin=false;
			dibujarTablero(tablero);
		
		while(fin!=true){
			int fil=Integer.parseInt(JOptionPane.showInputDialog("ingrese posicion fila	"));
			int col=Integer.parseInt(JOptionPane.showInputDialog("ingrese posicion columna"));
			
			if(tablero[fil][col]=="Mina"){
				fin=true;
				JOptionPane.showMessageDialog(null,"DESTAPASTE UNA MINA: PÈRDISTE!");
			}
			else if(tablero[fil][col]=="YA"){
				System.out.println("Posicion YA destapada");
			}
			else{
				tableroUsuario[fil][col]=tablero[fil][col];
				tablero[fil][col]="YA";
				fin=validarFin(tablero);
			}
			dibujarTablero(tableroUsuario);
		}
		System.exit(0);
		
	}
	
	
	/*genera un arreglo con 20 numeros que representan las casillas de la matriz*/
	public static int[] generarMinas (int casillas){
		int[] arr = new int[20];
		if (casillas < arr.length) {
			throw new IllegalArgumentException("El tablero requiere al menos 20 casillas");
		}
		boolean[] ocupadas = new boolean[casillas];
		for (int mina = 0; mina < arr.length; mina++) {
			int posicion;
			do {
				posicion = (int)(Math.random() * casillas);
			} while (ocupadas[posicion]);
			ocupadas[posicion] = true;
			arr[mina] = posicion;
		}
		return arr;
	}
	
	
	/*organiza el arreglo para facilitar el colocar las minas en las matriz*/
	public static int[] organizarArreglo(int[] arreglo){
		for(int i=0;i<arreglo.length-1;i++){
			for(int j=0;j<arreglo.length-1;j++){
				if(arreglo[j]>arreglo[j+1]){
					int temp=arreglo[j];
					arreglo[j]=arreglo[j+1];
					arreglo[j+1]=temp;
				}
			}
		}
		return arreglo;
	}
	
	
	/*Coloca las minas en las casillas elegidas por generarMinas.*/
	public static String[][] llenarminas(String[][] tablero, int[] arrMinas) {
		int columnas = tablero[0].length;
		for (int posicion : arrMinas) {
			tablero[posicion / columnas][posicion % columnas] = "Mina";
		}
		return tablero;
	}
	
	
	/*Compara cuantas minas hay alrededor de cada casilla de la matriz
	 *Si en la casilla se encuentra una mina pasa a la otra posicion sin modificar la matriz
	 */
	public static String[][]numeros(String[][]tablero){
		int k=0,contador=0,casillas=tablero.length*tablero[0].length;
		for(int i=0;i<tablero.length;i++){
			for(int j=0;j<tablero[0].length;j++){
				/*Cuenta cuantas minas hay alrededor de las casillas centrales*/
				if(i>=1 && i<tablero.length-1 && j>=1 && j<tablero[0].length-1 ){
					if(tablero[i-1][j-1]==("Mina")){
						contador++;
					}
					if(tablero[i-1][j]==("Mina")){
						contador++;
					}
					if(tablero[i-1][j+1]==("Mina")){
						contador++;
					}
					if(tablero[i][j+1]==("Mina")){
						contador++;
					}
					if(tablero[i+1][j+1]==("Mina")){
						contador++;
					}
					if(tablero[i+1][j]==("Mina")){
						contador++;
					}
					if(tablero[i+1][j-1]==("Mina")){
						contador++;
					}
					if(tablero[i][j-1]==("Mina")){
						contador++;
					}
					if(tablero[i][j]!="Mina"){
						tablero[i][j]="*"+String.valueOf(contador)+"**";	
					}
				}
				/*cuenta cuantas minas hay alrededor de la esquina superior izquierda*/
				else if(i==0 && j==0){
					if(tablero[i][j+1]=="Mina"){
						contador++;
					}
					if(tablero[i+1][j+1]=="Mina"){
						contador++;
					}
					if(tablero[i+1][j]=="Mina"){
						contador++;
					}
					if(tablero[i][j]!="Mina"){
						tablero[i][j]="*"+String.valueOf(contador)+"**";	
					}
				}
				/*Cuenta cuantas minas hay alrededor del eje i si esta cumple el no estar en la posicion 0 o
				 * en la ultima posicion de la columna, y la columna a su vez ser la numero 0 es decir j estar
				 * en 0
				 */
				else if(i>0 && i<tablero.length-1 && j==0){
					if(tablero[i-1][j]=="Mina"){
						contador++;
					}
					if(tablero[i-1][j+1]=="Mina"){
						contador++;
					}
					if(tablero[i][j+1]=="Mina"){
						contador++;
					}
					if(tablero[i+1][j+1]=="Mina"){
						contador++;
					}
					if(tablero[i+1][j]=="Mina"){
						contador++;
					}
					if(tablero[i][j]!="Mina"){
						tablero[i][j]="*"+String.valueOf(contador)+"**";	
					}
				}
				/*cuenta cuantas minas hay alrededor de la esquina inferior izquierda*/  
				else if(i==tablero.length-1 && j==0){
					if(tablero[i-1][j]=="Mina"){
						contador++;
					}
					if(tablero[i-1][j+1]=="Mina"){
						contador++;
					}
					if(tablero[i][j+1]=="Mina"){
						contador++;
					}
					if(tablero[i][j]!="Mina"){
						tablero[i][j]="*"+String.valueOf(contador)+"**";	
					}
				}
				
				
				/*Cuenta cuantas minas hay alrededor del eje j si esta cumple el no estar en la posicion 0 o
				 * en la ultima posicion de la fila, y la fila a su vez ser la numero 0 es decir i estar
				 * en 0
				 */
				else if(i==0 && j>0 && j<tablero[0].length-1 ){
					if(tablero[i][j-1]=="Mina"){
						contador++;
					}
					if(tablero[i+1][j-1]=="Mina"){
						contador++;
					}
					if(tablero[i+1][j]=="Mina"){
						contador++;
					}
					if(tablero[i][j+1]=="Mina"){
						contador++;
					}
					if(tablero[i+1][j+1]=="Mina"){
						contador++;
					}
					if(tablero[i][j]!="Mina"){
						tablero[i][j]="*"+String.valueOf(contador)+"**";	
					}
				}
				
				/*cuenta cuantas minas hay alrededor de la esquina superior derecha*/  
				else if(i==0 && j==tablero[0].length-1){
					if(tablero[i][j-1]=="Mina"){
						contador++;
					}
					if(tablero[i+1][j-1]=="Mina"){
						contador++;
					}
					if(tablero[i+1][j]=="Mina"){
						contador++;
					}
					if(tablero[i][j]!="Mina"){
						tablero[i][j]="*"+String.valueOf(contador)+"**";	
					}
				}
				
				/*Cuenta cuantas minas hay alrededor del eje i, si esta cumple el no estar en la posicion 0 o
				 * en la ultima posicion de la columna, y la columna a su vez ser la ultima de la matriz 
				 * es decir j estar en tablero[0].length
				 */
				else if(i>0 && i<tablero.length-1 && j==tablero[0].length-1){
					if(tablero[i-1][j]=="Mina"){
						contador++;
					}
					if(tablero[i-1][j-1]=="Mina"){
						contador++;
					}
					if(tablero[i][j-1]=="Mina"){
						contador++;
					}
					if(tablero[i+1][j-1]=="Mina"){
						contador++;
					}
					if(tablero[i+1][j]=="Mina"){
						contador++;
					}
					if(tablero[i][j]!="Mina"){
						tablero[i][j]="*"+String.valueOf(contador)+"**";	
					}
				}
				
				/*cuenta cuantas minas hay alrededor de la esquina inferior derecha*/  
				else if(i==tablero.length-1 && j==tablero[0].length-1){
					if(tablero[i][j-1]=="Mina"){
						contador++;
					}
					if(tablero[i-1][j-1]=="Mina"){
						contador++;
					}
					if(tablero[i-1][j]=="Mina"){
						contador++;
					}
					if(tablero[i][j]!="Mina"){
						tablero[i][j]="*"+String.valueOf(contador)+"**";	
					}
				}
				
				/*Cuenta cuantas minas hay alrededor del eje j, si esta cumple el no estar en la posicion 0 o
				 * en la ultima posicion de la fila, y la fila a su vez ser la ultima de la matriz 
				 * es decir i estar en tablero.length
				 */
				else if(i==tablero.length-1 && j>0 && j<tablero[0].length-1){
					if(tablero[i][j-1]=="Mina"){
						contador++;
					}
					if(tablero[i-1][j-1]=="Mina"){
						contador++;
					}
					if(tablero[i-1][j]=="Mina"){
						contador++;
					}
					if(tablero[i-1][j+1]=="Mina"){
						contador++;
					}
					if(tablero[i][j+1]=="Mina"){
						contador++;
					}
					if(tablero[i][j]!="Mina"){
						tablero[i][j]="*"+String.valueOf(contador)+"**";	
					}
				}
				contador=0;
			}	
		}
		return tablero;
	}
	
	public static boolean validarFin(String[][]mat){
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[0].length;j++){
				if(mat[i][j]!="Mina" && mat[i][j]!="YA"){
					return false;
				}
			}
		}
		JOptionPane.showMessageDialog(null,"!!!!!!!!!!GANASTE!!!!!!!!!!!!!!!");
		return true;
	}
	public static void dibujarTablero(String[][]mat){
		System.out.println("");
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[0].length;j++){
				System.out.print(mat[i][j]+" | ");
			}
			System.out.println("");
		}
	}
	
}

/*
 * Buscaminas.java
 *
 * Created on 4 de junio de 2007, 08:16 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

// package buscaminas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Buscaminas extends JFrame implements ActionListener {
    
    protected static int tamanox=10;
    protected static int tamanoy=10;
    
    protected JButton tablero[][];
    protected boolean minas[][];
    protected JPanel panel;
        
    public Buscaminas() {
        
        int f,c;
        panel= new JPanel();
        this.add(panel);
        panel.setLayout(new GridLayout(tamanox,tamanoy));
        tablero = new JButton[tamanox][tamanoy];
        minas = new boolean[tamanox][tamanoy];
        
        // creamos los botones y vaciamos la matriz donde
        // colocaremos las minas
        for(f=0; f<tamanox; f++)
            for(c=0; c<tamanoy; c++)
            {
                minas[f][c] = false;
                tablero[f][c] = new JButton("X");
                tablero[f][c].setBackground(new Color(200,200,200));
                panel.add(tablero[f][c]);
                tablero[f][c].addActionListener(this);
            }
        
        // colocamos minas donde tamanox es el maximo de minas.
        for(int n=0; n<tamanox; n++)
        {
            do {
                f = (int)(Math.random()*tamanox);
                c = (int)(Math.random()*tamanoy);
            }while(minas[f][c]);
            minas[f][c] = true;
        }
    }
    
    public JPanel GetPanel() {
        return panel;
    }
    
    public void Update() {
        for(int i=0; i<tamanox; i++)
            for(int c=0; c<tamanoy; c++)
            {
                tablero[i][c].setText(" ");
            }
    }
    
    public static void main(String[] args) {
        
        Buscaminas f = new Buscaminas();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        f.pack();
        f.show();
        f.Update();
    }
    
    protected int CuentaMinas(int ff, int cc){
        int nm = 0;
        for(int x=ff-1; x<=ff+1; x++)
            for(int y=cc-1; y<=cc+1; y++)
                if(!(x==ff && y==cc) &&
                    x>=0 && x<tamanox &&
                    y>=0 && y<tamanoy)
                    if(minas[x][y])
                        nm++;
        return nm;
    }
    
    protected int numDescubiertas() {
        int nd=0;
        for(int x=0; x<tamanox; x++)
            for(int y=0; y<tamanoy; y++)
                if(tablero[x][y].getText()!=" ")
                    nd++;
        return nd;
    }
    
    public void actionPerformed(ActionEvent e) {
        
            JButton boton= (JButton)e.getSource();
           int i=0, j=0;
           for(i=0; i<tamanox; i++) {
               for(j=0; j<tamanoy; j++) {
                   if(boton==tablero[i][j]) {
                       boton=null;
                       break;
                   }
               }
               if(boton==null)
                   break;
           }
           
           if(boton!=null)
             return;
            if(tablero[i][j].getText()==" ") {
             
                tablero[i][j].setBackground(new Color(0,255,0));
                if(minas[i][j])
                {
                    tablero[i][j].setText("*");
                    tablero[i][j].setBackground(new Color(255,0,0));
                    
                    for(int x=0; x<tamanox; x++) {
                        for(int y=0; y<tamanoy; y++) {
                            if(minas[x][y])
                            {
                                tablero[x][y].setBackground(new Color(255,0,0));
                                tablero[x][y].setText("*");
                            }
                        }
                    }
                    JOptionPane.showMessageDialog(this, "Lo siento, has perdido");
                    // System.exit(0);
                    return;
                }
                else
                {
                    int numMinas = CuentaMinas(i,j);
                    tablero[i][j].setText(Integer.toString(numMinas));
                }
                int nd = numDescubiertas();
                setTitle("Quedan " + Integer.toString(1500-nd)+" casillas");
                if(1500-nd ==tamanox)
                {
                    JOptionPane.showMessageDialog(this, "Muy bien, ya has terminado");
                    System.exit(0);
                }
           }
       }
}

# Java minesweeper exercises · Ejercicios de buscaminas en Java
[English](#english) · [Español](#español)

## English


Legacy Java minesweeper exercises for revealing tiles and counting nearby mines

> [!WARNING]
> **Status: Legacy.** Tested with Java 8. The June 2007 edition opens the board but never recognizes victory on a 10 × 10 board. The May edition can stop when it places repeated mines.

### Overview

These Java exercises use a grid with hidden mines. To play, reveal a square and use its number to work out which nearby squares can contain mines.

### Features

- Open a tile on the 30 × 50 AWT board to see its hint or reveal a mine.
- Set the board size and enter a move with Swing dialogs in the May edition.
- Open the 10 × 10 Swing board as a Java desktop window or an applet.

### Requirements

OpenJDK 8 with a graphical environment and the standard AWT and Swing packages. The build reads the archived files as Windows-1252. For the applet variant use the `appletviewer` shipped with JDK 8.

### Getting started

In PowerShell at the root, compile the available variants into separate output folders.

```powershell
New-Item -ItemType Directory -Force out/original | Out-Null
javac -encoding windows-1252 -d out/original Buscaminas.java

New-Item -ItemType Directory -Force out/may | Out-Null
javac -encoding windows-1252 -d out/may Buscaminas3.java

New-Item -ItemType Directory -Force out/june | Out-Null
javac -encoding windows-1252 -d out/june netbeans/buscaminas/src/buscaminas/Buscaminas.java netbeans/buscaminas/src/buscaminas/BuscaminasA.java

```

### Usage

- Start the 2003 board with `java -cp out/original Buscaminas`. Click a tile to reveal the number of nearby mines. Close the window to exit.
- Run `java -cp out/may Buscaminas3`. In the dialogs, enter the board dimensions (for example, 10 and 10) and a zero-based row and column. A mine displays the loss dialog. Some repeated mine positions can trigger `ArrayIndexOutOfBoundsException` before the first move.
- Run `java -cp out/june Buscaminas` to open the 10 × 10 Swing board. Run `appletviewer examples/applet.html` with JDK 8 to load the applet wrapper. The June counter still uses 1,500 as its total, so uncovering all 90 safe tiles does not trigger victory.

### Project structure

`Buscaminas.java` is the 2003 desktop entry point. `Buscaminas3.java` contains the May 2007 dialog variant. `netbeans/buscaminas/src/buscaminas/` holds the June desktop and applet classes.

### Contributing

This archive is kept for reference and does not accept contributions.

### Support

Use this repository’s Issues for questions about the archive.

### History

The source files match the archive entries. Snapshot dates use 12:00 UTC because the archive has no time zone.

### Verification

On November 18, 2026, the `javac` commands above built each commit with Eclipse Temurin 8u512-b09 in a separate copy. The test used Ubuntu 22.04 and Xvfb package `2:21.1.4-2ubuntu1.7~22.04.16` in a container with networking disabled. The separate `NocheMines` test harness called the original entry points and set a repeatable random seed. It tested the applet lifecycle in an AWT window and started the historical viewer separately for four seconds.

```text
java -cp out/original NocheMines original
java -cp out/may NocheMines may
java -cp out/may NocheMines duplicate
java -cp out/june NocheMines june
java -cp out/june NocheMines applet
timeout 4s appletviewer examples/applet.html
```

The 2003 board and the June desktop and applet revealed a tile. The May edition showed its loss dialog in the first test and raised `ArrayIndexOutOfBoundsException` in `llenarminas` with seed 1. After opening 90 safe squares in the June desktop window, the title still showed `Quedan 1410 casillas`. No victory dialog appeared.

![The 2003 board with a revealed numbered tile](docs/media/board.png)

The animation shows the actual resized board before and after the same reveal.

![Progress of a tile reveal on the 2003 board](docs/media/reveal.gif)

### License

[MIT License](LICENSE) applies to the project’s own contributions. The applet source retains an archived attribution whose redistribution terms require confirmation.

---

## Español


Legado de ejercicios de buscaminas en Java para destapar casillas y contar minas cercanas

> [!WARNING]
> **Estado: legado.** Probado con Java 8. La edición de junio de 2007 abre el tablero, pero no reconoce la victoria en 10 × 10. La edición de mayo puede detenerse al colocar minas repetidas.

### Descripción general

Estos ejercicios de Java usan una cuadrícula con minas ocultas. Destapa una casilla y usa su número para deducir cuáles de las casillas cercanas pueden contener minas.

### Funciones

- Abre una casilla del tablero AWT de 30 × 50 para ver su pista o descubrir una mina.
- Ajusta el tamaño del tablero e introduce la jugada con los cuadros de Swing de la edición de mayo.
- Abre el tablero Swing de 10 × 10 en una ventana de escritorio Java o en un applet.

### Requisitos

OpenJDK 8 con entorno gráfico y los paquetes AWT y Swing de la biblioteca estándar. La compilación lee los archivos archivados como Windows-1252. Para el applet usa `appletviewer`, incluido en JDK 8.

### Cómo empezar

Desde PowerShell en la raíz, compila las variantes disponibles en carpetas de salida separadas.

```powershell
New-Item -ItemType Directory -Force out/original | Out-Null
javac -encoding windows-1252 -d out/original Buscaminas.java

New-Item -ItemType Directory -Force out/may | Out-Null
javac -encoding windows-1252 -d out/may Buscaminas3.java

New-Item -ItemType Directory -Force out/june | Out-Null
javac -encoding windows-1252 -d out/june netbeans/buscaminas/src/buscaminas/Buscaminas.java netbeans/buscaminas/src/buscaminas/BuscaminasA.java

```

### Uso

- Inicia el tablero de 2003 con `java -cp out/original Buscaminas`. Haz clic en una casilla para ver cuántas minas hay cerca. Cierra la ventana para salir.
- Ejecuta `java -cp out/may Buscaminas3`. En los cuadros, introduce las dimensiones (por ejemplo, 10 y 10) y una fila y columna empezando por cero. Una mina abre el aviso de derrota. Algunas posiciones repetidas pueden provocar `ArrayIndexOutOfBoundsException` antes de la primera jugada.
- Ejecuta `java -cp out/june Buscaminas` para abrir el tablero Swing de 10 × 10. Ejecuta `appletviewer examples/applet.html` con JDK 8 para cargar el envoltorio applet. El contador de junio sigue usando 1.500 como total, por lo que destapar las 90 casillas libres no activa la victoria.

### Estructura del proyecto

`Buscaminas.java` es la entrada de escritorio de 2003. `Buscaminas3.java` contiene la variante con cuadros de mayo de 2007. `netbeans/buscaminas/src/buscaminas/` reúne las clases de escritorio y applet de junio.

### Contribuir

Este archivo se conserva como referencia y no acepta contribuciones.

### Soporte

Usa la sección Issues del repositorio para preguntas sobre el archivo.

### Historia

Los fuentes coinciden con las entradas del respaldo. Las fechas de las copias usan las 12:00 UTC porque el archivo carece de zona horaria.

### Verificación

El 18 de noviembre de 2026, los comandos `javac` de arriba compilaron cada commit con Eclipse Temurin 8u512-b09 en su propia copia. Se usaron Ubuntu 22.04 y el paquete Xvfb `2:21.1.4-2ubuntu1.7~22.04.16` en un contenedor sin red. El ejecutor de pruebas `NocheMines` llamó los puntos de entrada originales y fijó una semilla reproducible. Probó el ciclo del applet dentro de una ventana AWT e inició el visor histórico por separado durante cuatro segundos.

```text
java -cp out/original NocheMines original
java -cp out/may NocheMines may
java -cp out/may NocheMines duplicate
java -cp out/june NocheMines june
java -cp out/june NocheMines applet
timeout 4s appletviewer examples/applet.html
```

El tablero de 2003, la ventana y el applet de junio destaparon una casilla. La edición de mayo mostró el aviso de derrota en la primera prueba y lanzó `ArrayIndexOutOfBoundsException` en `llenarminas` con la semilla 1. Tras abrir 90 casillas libres en la ventana de junio, el título siguió mostrando `Quedan 1410 casillas`. No apareció el aviso de victoria.

![Tablero de 2003 con una casilla numerada destapada](docs/media/board.png)

La animación muestra el tablero real, ampliado para la captura, antes y después de destapar esa casilla.

![Apertura de una casilla en el tablero de 2003](docs/media/reveal.gif)

### Licencia

La [licencia MIT](LICENSE) se aplica a los aportes propios. El fuente del applet conserva una atribución archivada cuyos términos de redistribución requieren confirmación.

# Java minesweeper exercises · Ejercicios de buscaminas en Java
[English](#english) · [Español](#español)

## English


Legacy Java minesweeper exercises for revealing tiles and counting nearby mines

> [!WARNING]
> **Status: Legacy.** The archived desktop examples were built and run with Java 8.

### Overview

These Java exercises use a grid with hidden mines. To play, reveal a square and use its number to work out which nearby squares can contain mines.

### Features

- Open a tile on the 30 × 50 AWT board to see its hint or reveal a mine.

### Requirements

OpenJDK 8 with a graphical environment and the standard AWT and Swing packages. The build reads the archived files as Windows-1252.

### Getting started

In PowerShell at the root, compile the available variants into separate output folders.

```powershell
New-Item -ItemType Directory -Force out/original | Out-Null
javac -encoding windows-1252 -d out/original Buscaminas.java

```

### Usage

- Start the 2003 board with `java -cp out/original Buscaminas`. Click a tile to reveal the number of nearby mines. Close the window to exit.

### Project structure

`Buscaminas.java` is the 2003 desktop entry point.

### Contributing

This archive is kept for reference and does not accept contributions.

### Support

Use this repository’s Issues for questions about the archive.

### History

The source files match the archive entries. Snapshot dates use 12:00 UTC because the archive has no time zone.

### License

[MIT License](LICENSE) applies to the project’s own contributions.

---

## Español


Legado de ejercicios de buscaminas en Java para destapar casillas y contar minas cercanas

> [!WARNING]
> **Estado: legado.** Los ejemplos de escritorio archivados se compilaron y ejecutaron con Java 8.

### Descripción general

Estos ejercicios de Java usan una cuadrícula con minas ocultas. Destapa una casilla y usa su número para deducir cuáles de las casillas cercanas pueden contener minas.

### Funciones

- Abre una casilla del tablero AWT de 30 × 50 para ver su pista o descubrir una mina.

### Requisitos

OpenJDK 8 con entorno gráfico y los paquetes AWT y Swing de la biblioteca estándar. La compilación lee los archivos archivados como Windows-1252.

### Cómo empezar

Desde PowerShell en la raíz, compila las variantes disponibles en carpetas de salida separadas.

```powershell
New-Item -ItemType Directory -Force out/original | Out-Null
javac -encoding windows-1252 -d out/original Buscaminas.java

```

### Uso

- Inicia el tablero de 2003 con `java -cp out/original Buscaminas`. Haz clic en una casilla para ver cuántas minas hay cerca. Cierra la ventana para salir.

### Estructura del proyecto

`Buscaminas.java` es la entrada de escritorio de 2003.

### Contribuir

Este archivo se conserva como referencia y no acepta contribuciones.

### Soporte

Usa la sección Issues del repositorio para preguntas sobre el archivo.

### Historia

Los fuentes coinciden con las entradas del respaldo. Las fechas de las copias usan las 12:00 UTC porque el archivo carece de zona horaria.

### Licencia

La [licencia MIT](LICENSE) se aplica a los aportes propios.

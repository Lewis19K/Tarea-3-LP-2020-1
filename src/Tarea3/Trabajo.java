package Tarea3;

import java.util.Scanner;

public interface Trabajo {

	/*

	Funcion: trabajar

	Input: (Adulto) adulto, (int) horas, (Scanner) lectura

	Funcionalidad:  Se define la funcion trabajar, la cual sera redefinida en las clases hijos
					de Trabajo (Cientifico, Humanista, Artista y Streamer)

	*/

	void trabajar(Adulto adulto, int horas, Scanner lectura);

}
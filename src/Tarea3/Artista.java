package Tarea3;

import java.util.Scanner;
import java.util.Random;

public class Artista implements Trabajo {

	/*

	Funcion: trabajar

	Input: adulto (Adulto), lectura (Scanner)

	Funcionalidad:  Simula la accion trabajar definida para los Artistas, 
					pidiendo por consola la cantidad de horas que desea trabajar.

	*/

    public void trabajar(Adulto adulto, int horas, Scanner lectura){
		int res;

		while(horas-- > 0){
			System.out.println(adulto.getNombre() + ":  ¿En que trabajare esta hora?");
			System.out.println("1-Esculpir");
			System.out.println("2-Pintar");
			
			res = lectura.nextInt();
			if(res == 1){
				System.out.println(adulto.getNombre() + ": Voy a esculpir algo como este hermoso rostro!");
				this.esculpir(adulto);
			}
			else{
				System.out.println(adulto.getNombre() + ": A pintar se ha dicho!");
				this.pintar(adulto);
			}

			if(adulto.getEnergia() < 0){
				adulto.setEnergia(0);
				System.out.println(adulto.getNombre() + ": Puff estoy muy cansado, no doy más. A veces me gustaría ser un fontanero que rescata princesas...");
				break;
			}
			if(horas == 0){
				System.out.println(adulto.getNombre() + ": Hoy fue un día increible :D.");
			}
		}
	}

	/*

	Funcion: Esculpir

	Input: adulto (Adulto)

	Funcionalidad: Por esculpir el adulto gana entre 0 a 25 monedas y 
				   pierde entre 6 a 30 de energia

	*/

	public void esculpir(Adulto adulto){
		Random rand = new Random();
		int dinero, energia;

		//NextInt(11) -> 0, 10 -> 10 20
		dinero = rand.nextInt(26) + 0;
		energia = rand.nextInt(25) + 6;

		System.out.println(adulto.getNombre() + ": Que hermosura, igualito a Calamardo guapo! (*Inserte imagen del museo de cera de Chile*)");
		System.out.println(adulto.getNombre() + ": Gane " + dinero + " aunque me canse " + energia);
		adulto.setDinero(adulto.getDinero() + dinero);
		adulto.setEnergia(adulto.getEnergia() - energia);
	}

	/*

	Funcion: Pintar

	Input: adulto (Adulto)

	Funcionalidad: Por pintar el adulto gana entre 4 a 8 monedas y 
				   pierde entre 3 a 7 de energia

	*/

	public void pintar(Adulto adulto){
		Random rand = new Random();
		int dinero, energia;

		dinero = rand.nextInt(5) + 4;
		energia = rand.nextInt(5) + 3;

		System.out.println(adulto.getNombre() + ": Que bien dibujo, quedo buenardooooooo! (*Inserte dibujo de sasuke meme*)"); 
		System.out.println(adulto.getNombre() + ": Gane " + dinero + " aunque me canse " + energia);
		adulto.setDinero(adulto.getDinero() + dinero);
		adulto.setEnergia(adulto.getEnergia() - energia);
	}


}
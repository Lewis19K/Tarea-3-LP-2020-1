package Tarea3;

import java.util.Scanner;
import java.util.Random;

public class Humanista implements Trabajo {
    
    /*

	Funcion: trabajar

	Input: adulto (Adulto), horas (int), lectura (Scanner)

	Funcionalidad: Hace elegir adulto entre sus 2 pegas posibles, y una cantidad de Horas a trabajar.
				   Si es que el cansancio es menor a 0, se setea cansancio a 0 y se para el ciclo.
				   (lo que hace que si se cansa antes de terminar sus horas de trabajo, deja de trabajar).

	*/

    public void trabajar(Adulto adulto, int horas, Scanner lectura){
		int res;

		while(horas-- > 0){
			System.out.println(adulto.getNombre() + ":  ¿En que trabajare esta hora?");
			System.out.println("1-Ensenar");
			System.out.println("2-Escribir");
			
			res = lectura.nextInt();
			if(res == 1){
				System.out.println(adulto.getNombre() + ": Abrete Zoom #$@!...");
				this.ensenar(adulto);
			}
			else{
				System.out.println(adulto.getNombre() + ": Escribamos un par de cositas");
				this.escribir(adulto);
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

	Funcion: ensenar

	Input: adulto (Adulto)

	Funcionalidad:  Esta funcion simula  la accion de ensenar definida en la tarea.
					Por ensenar el adulto gana entre 9 a 13 monedas y 
				    pierde entre 6 a 9 de energia

	*/

    public void ensenar(Adulto adulto){
		Random rand = new Random();
		int dinero, energia;

        dinero = rand.nextInt(5) + 9;
		energia = rand.nextInt(4) + 6;

		System.out.println(adulto.getNombre() + ": Que wena clase, me dicen Julioprofe!");
		System.out.println(adulto.getNombre() + ": Gane " + dinero + " aunque me canse " + energia);
		adulto.setDinero(adulto.getDinero() + dinero);
		adulto.setEnergia(adulto.getEnergia() - energia);
    }
    
    /*

	Funcion: escribir

	Input: Adulto

	Funcionalidad: Por escribir el adulto gana entre 4 a 14 monedas y 
				   pierde entre 4 a 13 de energia

	*/

    public void escribir(Adulto adulto){
		Random rand = new Random();
		int dinero, energia;

		dinero = rand.nextInt(11) + 4;
		energia = rand.nextInt(10) + 4;

		System.out.println(adulto.getNombre() + ": Me llaman... Romeo"); 
		System.out.println(adulto.getNombre() + ": Gane " + dinero + " aunque me canse " + energia);
		adulto.setDinero(adulto.getDinero() + dinero);
		adulto.setEnergia(adulto.getEnergia() - energia);
    }
    


}
package Tarea3;

import java.util.Scanner;
import java.util.Random;

public class Streamer implements Trabajo {

    /*

	Funcion: Trabajar

	Input: adulto (Adulto), horas (int), lectura (Scanner)

	Funcionalidad: Hace elegir adulto entre sus 2 pegas posibles, y una cantidad de Horas a trabajar.
				   Si es que el cansancio es menor a 0, se setea cansancio a 0 y se para el ciclo.

	*/

    public void trabajar(Adulto adulto, int horas, Scanner lectura){
		int res;

		while(horas-- > 0){
			System.out.println(adulto.getNombre() + ":  ¿Que streameo ahora?");
			System.out.println("1-League of Legends");
			System.out.println("2-Mortal Kombat");
			
			res = lectura.nextInt();
			if(res == 1){
				System.out.println(adulto.getNombre() + ": Sale su lolcitooooo!");
				this.lolcito(adulto);
			}
			else{
				System.out.println(adulto.getNombre() + ": Peguemonos su mortal kombat!");
				this.mortalkombat(adulto);
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

	Funcion: Lolcito

	Input: adulto (Adulto)

    Funcionalidad: Por streamear league of legends el adulto gana entre 10 a 35 monedas y 
				   pierde entre 20 a 30 de energia

	*/

	public void lolcito(Adulto adulto){
		Random rand = new Random();
		int dinero, energia, frase;

		dinero = rand.nextInt(26) + 10;
        energia = rand.nextInt(11) + 20;
        frase = rand.nextInt(2);

        if (frase == 0){
            System.out.println(adulto.getNombre() + ": SUSPENSION PERMANENTEEEEE!!");
        }
        else{
            System.out.println(adulto.getNombre() + ": GG IZI");
        }
		System.out.println(adulto.getNombre() + ": Gane " + dinero + " aunque me canse " + energia);
		adulto.setDinero(adulto.getDinero() + dinero);
		adulto.setEnergia(adulto.getEnergia() - energia);
	}

	/*

	Funcion: Mortalkombat

	Input: adulto (Adulto)

	Funcionalidad: Por streamear mortal kombat el adulto gana entre 1 a 9 monedas y 
				   pierde entre 2 a 6 de energia

	*/

	public void mortalkombat(Adulto adulto){
		Random rand = new Random();
		int dinero, energia;

		dinero = rand.nextInt(9) + 1;
		energia = rand.nextInt(5) + 2;

		System.out.println(adulto.getNombre() + ": Brigidooooo!! Soy el mas brigido del mundo!"); 
		System.out.println(adulto.getNombre() + ": Gane " + dinero + " aunque me canse " + energia);
		adulto.setDinero(adulto.getDinero() + dinero);
		adulto.setEnergia(adulto.getEnergia() - energia);
	}


}
package Tarea3;

import java.util.Scanner;
import java.util.Random;

public class Adulto extends Personaje {

	public int estudios;
	public Trabajo trabajo;

	
	/*

	Funcion: getEstudios

	Input: Ninguno

	Funcionalidad: Retorna el atributo estudios.

	*/
	
	public int getEstudios(){
		return this.estudios;
	}

	/*

	Funcion: setEstudios

	Input: estudio (int)

	Funcionalidad: Asigna el input a el atributo Estudios

	*/
	
	public void setEstudios(int estudio){
		this.estudios = estudio;
	}

	/*

	Funcion: Adulto

	Input: nombre (String), sexo (String), dinero (int), edad (int), energia (int), fuerza (int), comida (int)

	Funcionalidad: Crea un Adulto, inicializandole los atributos con los valores dados por los input

	*/
	
	Adulto(String nombre, String sexo, int dinero, int edad, int energia, int fuerza, int comida){
		this.setNombre(nombre);
		this.setSexo(sexo);
		this.setDinero(dinero);
		this.setEdad(edad);
		this.setEnergia(energia);
		this.setFuerza(fuerza);
		this.setComida(comida);
		this.setEstudios(0);
	}

	/*
	Funcion: comer

	Input: input (Scanner)

	Funcionalidad:  Basicamente realiza la accion de comer definida en la tarea. 
					Primero verifica que el personaje tenga la cantidad de comida necesaria, luego pregunta la cantidad 
					de comida que desea comer y luego simula la accion de comer.
	*/

	public void comer(Scanner input){
		//en caso de no tener la suficiente comida para restaurar fuerzas, no come e imprime eso
		if (this.getComida() < 6){
			System.out.println("No tienes suficiente comida para restaurar fuerzas");
			return;
		}
		
		int cuanto, fuerzarecuperada;
		int contador = 0;
		int bandera = 0;
		int fuerzaprevia = this.getFuerza();

		System.out.println("¿Cuanto quieres comer?");
		System.out.println("(Tienes "+this.getComida()+" unidades de comida)");

		cuanto = input.nextInt();

		//Aqui me aseguro que haya ingresado una cantidad de comida valida, sino pido que ingrese denuevo.
		while (bandera != 1){
			if (cuanto > this.getComida()){
				while (cuanto > this.getComida()){
					System.out.println("No tienes tanta comida. Ingrese otra vez:");
					cuanto = input.nextInt();
				}
				continue;
			}
			else if (cuanto < 6){
				System.out.println("Con eso no te alcanza para recuperar fuerzas. Ingrese otra vez: ");
				cuanto = input.nextInt();
			}
			else{
				bandera = 1;
			}
		}

		while ((this.getComida() >= 3) && (this.getFuerza() != 100) && (contador+6 <= cuanto)){
			this.setComida(this.getComida()-6);
			this.setFuerza(this.getFuerza()+1);
			contador += 6;
		}

        if (this.getFuerza() > 100){
			this.setFuerza(100);
		}

		fuerzarecuperada = this.getFuerza() - fuerzaprevia;

		System.out.println(this.getNombre()+": Aah, un manjar!!");
		System.out.println("("+this.getNombre()+" ha recuperado "+fuerzarecuperada+" unidades de fuerza).");
	}

	/*

	Funcion: dameAlimento

	Input: input (Scanner)

	Funcionalidad:  Esta funcion simula la accion de comprar comida, la cual esta definida en la tarea. 
					Verifica que tengas el dinero suficiente y luego pregunta la cantidad de dinero que deseas gastar en alimento.

	*/

	public void dameAlimento(Scanner input){
		
		int cuanto, dinerogastado, comidacomprada;
		int bandera = 0;
		int contador = 0;
		int dineroprevio = this.getDinero();
		int comidaprevia = this.getComida();

		if (dineroprevio < 4){
			System.out.println("No tienes dinero suficiente para comprar comida.");
			System.out.println("");
			return;
		}

		System.out.println("¿Cuanto dinero desea gastar en alimento?");
		System.out.println("(Tienes "+this.getDinero()+" unidades de dinero)");

		cuanto = input.nextInt();
		
		//Aqui me aseguro que haya ingresado una cantidad valida, sino pido que ingrese denuevo.
		while (bandera != 1){
			if (cuanto > this.getDinero()){
				while (cuanto > this.getDinero()){
					System.out.println("No tienes tanto dinero. Ingrese otra vez:");
					cuanto = input.nextInt();
				}
				continue;
			}
			else if (cuanto < 4){
				System.out.println("Con eso no te alcanza para comprar alimento. Ingrese otra vez: ");
				cuanto = input.nextInt();
			}
			else{
				bandera = 1;
			}
		}

		while((this.getDinero() >= 4) && (contador+4 <= cuanto)){
            this.setComida(this.getComida()+6);
			this.setDinero(this.getDinero()-4);
			contador += 4;
		};
		
		dinerogastado = dineroprevio - this.getDinero();
		comidacomprada = this.getComida() - comidaprevia;

        System.out.println("Has comprado "+comidacomprada+" unidades de comida por "+dinerogastado+" unidades de dinero.");
	}

	/*

	Funcion: dormir

	Input: Ninguno

	Funcionalidad:  Esta funcion simula la accion de dormir definida en la tarea, 
					haciendo que el personaje recupere energia, etc...

	*/

	public void dormir(){
		Random rand = new Random();
		int energia;

		energia = rand.nextInt(31) + 20;

		this.setEnergia(this.getEnergia()+energia);

		if (this.getEnergia() > 100){
			this.setEnergia(100);
		}

		System.out.println(this.getNombre()+": Que sueñooo... Mimir time!");
		System.out.println(this.getNombre()+": zzzzZZZZzzzzzZZZzzzzZZZzzz...");
		System.out.println(this.getNombre()+": Que rica siesta uwu");
		System.out.println(this.getNombre()+" ha recuperado "+energia+" unidades de energia.");
	}

	/*

	Funcion: estudiar

	Input: input (Scanner)

	Funcionalidad:  Esta funcion hace que el personaje estudie, pidiendo por consola 
					el ingreso de cual carrera desea estudiar.

	*/

	public void estudiar(Scanner input){

		this.setEnergia(this.getEnergia()-50);

		int pega;

		System.out.println("¿A que te quieres dedicar?");
		System.out.println("1- Cientifico");
		System.out.println("2- Humanista");
		System.out.println("3- Artista");
		System.out.println("4- Streamer");
		System.out.println("");
		System.out.print("Ingrese una de las opciones: ");
		pega = input.nextInt();

		while ((pega != 1) && (pega != 2) && (pega != 3) && (pega != 4)){
			System.out.println("Ingresa un numero valido.");
			System.out.println("1- Cientifico");
			System.out.println("2- Humanista");
			System.out.println("3- Artista");
			System.out.println("4- Streamer");
			System.out.println("");
			System.out.print("Ingrese una de las opciones: ");
			pega = input.nextInt();
		}

		this.setEstudios(pega);
		
		System.out.println("Estudiando...");
		System.out.println("...");

		if (pega == 1){
			System.out.println(this.getNombre()+" ahora es cientifico.");
			Cientifico cienti = new Cientifico();
			this.trabajo = cienti;
			System.out.println(this.getNombre()+": Siiiii! A crear una maquina del tiempo WUAJAJAJA.");
		}
		else if (pega == 2){
			System.out.println(this.getNombre()+" ahora es humanista.");
			Humanista huma = new Humanista();
			this.trabajo = huma;
			System.out.println(this.getNombre()+": A ser el proximo Pablo Neruda, pero infunable.");
		}
		else if (pega == 3){
			System.out.println(this.getNombre()+" ahora es artista.");
			Artista art = new Artista();
			this.trabajo = art;
			System.out.println(this.getNombre()+": A ser el proximo Picasso jejeje.");
		}
		else{
			System.out.println(this.getNombre()+" ahora es streamer.");
			Streamer st = new Streamer();
			this.trabajo = st;
			System.out.println(this.getNombre()+": Buenardooooooo, soy el nuevo coscu ndeaaaa.");
		}
	}

}
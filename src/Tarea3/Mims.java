package Tarea3;
import java.util.ArrayList;
import java.util.Scanner;

public class Mims {

	static ArrayList<Personaje> personajes = new ArrayList<Personaje>();
	static ArrayList<Familia> familia = new ArrayList<Familia>();


	/*

	Funcion: agregarAdulto

	Input: adultoo (Adulto)

	Funcionalidad:  Esta funcion agrega un adulto a la lista de personajes. 
					Verifica antes que el adulto no este ya en la lista de personajes.

	*/

	static  void agregarAdulto(Adulto adultoo){
		for (int i = 0; i < personajes.size(); i++){
			if (personajes.get(i) == adultoo){
				System.out.println(adultoo.getNombre()+" ya estaba en la lista de personajes");
			}
		}
		personajes.add(adultoo);
	}

	/*

	Funcion: casarse

	Input: adult1 (Adulto), adult2 (Adulto)

	Funcionalidad:  Esta funcion casa a dos personajes adultos, creando una nueva familia. 
					En caso de que un adulto pertenezca anteriormente a otra familia, lo saca de esta familia,
					haciendo que pertenezca solo a la recientemenete creada.
	*/

	static  void casarse(Adulto adult1, Adulto adult2){
		if (adult1 == adult2){
			System.out.println("Esta bien que te quieras, pero nada de narcisismo...");
			return;
		}
		if ((estaCasado(adult1.getNombre()) == 1) || (estaCasado(adult2.getNombre()) == 1)){
			System.out.println("No se permiten infidelidades!");
		}
		
		for (int i = 0; i < familia.size(); i++){
			if ((familia.get(i).adulto1 == adult1) || (familia.get(i).adulto2 == adult1)){
				System.out.println("Hey "+adult1.getNombre()+", tu estas casado! Nada de infieles");
				return;
			}
			if ((familia.get(i).adulto1 == adult2) || (familia.get(i).adulto2 == adult2)){
				System.out.println("Hey "+adult2.getNombre()+", tu estas casado! Nada de infieles");
				return;
			}
		}
		Familia fam = new Familia();
		fam.adulto1 = adult1;
		fam.adulto2 = adult2;
		for (int i = 0; i < familia.size(); i++){
			for (int j = 0; j < familia.get(i).hijos.size(); j++){
				if (familia.get(i).hijos.get(j) == adult1){
					familia.get(i).hijos.remove(j);
				}
				if (familia.get(i).hijos.get(j) == adult2){
					familia.get(i).hijos.remove(j);
				}
			}
		}
		familia.add(fam);
	}

	/*

	Funcion: estaCasado

	Input: nombre (String)

	Funcionalidad:  Esta es una funcion auxiliar que defini para saber si un adulto esta casado.
					Retorna un entero que indica si esta o no casado.

	*/

	static  int estaCasado(String nombre){
		for (int i = 0; i < familia.size(); i++){
			if ((familia.get(i).adulto1.getNombre() == nombre) || (familia.get(i).adulto2.getNombre() == nombre)){
				return 1;
			}
		}
		return 0;
	}

	/*

	Funcion: printPersonajes

	Input: Ninguno

	Funcionalidad: Esta funcion es auxiliar, la cual imprime todos los personajes del juego.

	*/

	static  void printPersonajes(){
		int num;
		if (personajes.size() == 0){
			System.out.println("No hay ningun personaje");
		}
		else{
			for (int i = 0; i < personajes.size(); i++){
				num = i+1;
				System.out.println(num+"- "+personajes.get(i).getNombre());
			}
		}
	}

	/*

	Funcion: printFamilias

	Input: Ninguno

	Funcionalidad: Esta funcion es auxiliar, la cual imprime todas las familias del juego.

	*/

	static  void printFamilias(){
		int num;
		if (familia.size() == 0){
			System.out.println("No hay ninguna familia");
		}
		else{
			for (int i = 0; i < familia.size(); i++){
				num = i+1;
				System.out.println("-------------FAMILIA "+num+"-------------");
				if ((familia.get(i).adulto1 == null) && (familia.get(i).adulto2 == null)){
					System.out.println("Ambos padres muertos TT-TT");
				}
				else if (familia.get(i).adulto1 == null){
					System.out.println("Padres: "+familia.get(i).adulto2.getNombre());
				}
				else if (familia.get(i).adulto2 == null){
					System.out.println("Padres: "+familia.get(i).adulto1.getNombre());
				}
				else{
					System.out.println("Padres: "+familia.get(i).adulto1.getNombre()+" y "+familia.get(i).adulto2.getNombre());
				}
				if (familia.get(i).hijos.size() == 0){
					System.out.println("Esta familia no tiene hijos");
				}
				else{
					System.out.print("Hijos: "+familia.get(i).hijos.get(0).getNombre());
					if (familia.get(i).hijos.size() == 1){
						System.out.println("");
						continue;
					}
					for (int j = 1; j < familia.get(i).hijos.size(); j++){
						System.out.print(" - "+familia.get(i).hijos.get(j).getNombre());
					}
					System.out.println("");
				}
			}
			System.out.println("-----------------------------------");
		}
	}

	/*

	Funcion: verMiFamilia

	Input: currFam (int)

	Funcionalidad:  Esta funcion es auxiliar, la cual imprime la familia indicada
					por el parametro (la posicion de esta en la lista de familias).

	*/

	static  void verMiFamilia(int currFam){
		if (currFam < 0){
			System.out.println("No has seleccionado una familia.");
			return;
		}
		int numFam = currFam+1;
		System.out.println("-------------FAMILIA "+numFam+"-------------");
		if ((familia.get(currFam).adulto1 == null) && (familia.get(currFam).adulto2 == null)){
			System.out.println("Ambos padres muertos TT-TT");
		}
		else if (familia.get(currFam).adulto1 == null){
			System.out.println("Padres: "+familia.get(currFam).adulto2.getNombre());
		}
		else if (familia.get(currFam).adulto2 == null){
			System.out.println("Padres: "+familia.get(currFam).adulto1.getNombre());
		}
		else{
			System.out.println("Padres: "+familia.get(currFam).adulto1.getNombre()+" y "+familia.get(currFam).adulto2.getNombre());
		}
		if (familia.get(currFam).hijos.size() == 0){
			System.out.println("Esta familia no tiene hijos");
		}
		else{
			System.out.print("Hijos: "+familia.get(currFam).hijos.get(0).getNombre());
			if (familia.get(currFam).hijos.size() == 1){
				System.out.println("");
				return;
			}
			for (int j = 1; j < familia.get(currFam).hijos.size(); j++){
				System.out.print(" - "+familia.get(currFam).hijos.get(j).getNombre());
			}
			System.out.println("");
		}
	}

	/*

	Funcion: estadoPersonaje

	Input: nombrePersonaje (String)

	Funcionalidad:  Esta funcion es auxiliar, la cual imprime todos los atributos
					del personaje indicado por el parametro.

	*/

	static  void estadoPersonaje(String nombrePersonaje){
		int num = -1;
		for (int i = 0; i < personajes.size(); i++){
			if (personajes.get(i).getNombre() == nombrePersonaje){
				num = i;
				break;
			}
		}
		if (num == -1){
			System.out.println("Nombre invalido, personaje no encontrado");
			return;
		}
		System.out.println("----------Estado de "+nombrePersonaje+"----------");
		System.out.println("Nombre: " + personajes.get(num).getNombre());
		System.out.println("Sexo: " + personajes.get(num).getSexo());
		System.out.println("Edad: " + personajes.get(num).getEdad());
		System.out.println("Energia: " + personajes.get(num).getEnergia());
		System.out.println("Fuerza: " + personajes.get(num).getFuerza());
		System.out.println("Comida: " + personajes.get(num).getComida());
		System.out.println("Dinero: " + personajes.get(num).getDinero());
		System.out.print("------------------------------");
		for (int k = 0; k < nombrePersonaje.length(); k++){
			System.out.print("-");
		}
		System.out.println("");
	}

	/*

	Funcion: pasoUnAño

	Input: Ninguno

	Funcionalidad:  Esta funcion simula el paso del tiempo, la cual indica el paso de un año
					significando que a todos los personajes se les sume un año en la edad.
					En caso de que un personaje cumpla 80 años, muere.
					En caso de que un CabroChico cumpla 18 años, pasa a ser adulto.

	*/

	static  void pasoUnAño(){
		Adulto adultto;
		for (int i =0; i < personajes.size(); i++){
			personajes.get(i).setEdad(personajes.get(i).getEdad()+1);
			if (personajes.get(i).getEdad() == 18){
				System.out.println(personajes.get(i).getNombre()+" ha cumplido la mayoria de edad!");
				adultto = new Adulto(personajes.get(i).getNombre(), personajes.get(i).getSexo(), personajes.get(i).getDinero(), 18, personajes.get(i).getEnergia(), personajes.get(i).getFuerza(), personajes.get(i).getComida());
				personajes.set(i, adultto);
			}
			else if (personajes.get(i).getEdad() == 80){
				for (int j = 0; j < familia.size(); j++){
					if (familia.get(j).adulto1 == personajes.get(i)){
						familia.get(j).adulto1 = null;
					}
					else if (familia.get(j).adulto2 == personajes.get(i)){
						familia.get(j).adulto2 = null;
					}
					else{
						for (int k = 0; k < familia.get(j).hijos.size(); k++){
							if (personajes.get(i) == familia.get(j).hijos.get(k)){
								familia.get(j).hijos.remove(k);
								k--;
							}
						}
					}
				}
				System.out.println("Lamento informar, que en esta triste noche fallecio "+personajes.get(i).getNombre()+"... TT-TT");
				personajes.remove(i);
				i--;
			}
			else{
				continue;
			}
		}
	}

	/*

	Funcion: quitarFuerza

	Input: Ninguno

	Funcionalidad:  Esta funcion quita 2 de fuerza a todos los personajes, la cual es
					llamada cuando se realizan algunas acciones.
					En caso de que alguien se quede sin fuerzas, muere.

	*/

	static void quitarFuerza(){
		for (int i = 0; i < personajes.size(); i++){
			if (personajes.get(i).getFuerza() > 2){
				personajes.get(i).setFuerza(personajes.get(i).getFuerza()-2);
			}
			else{
				for (int j = 0; j < familia.size(); j++){
					if (familia.get(j).adulto1 == personajes.get(i)){
						familia.get(j).adulto1 = null;
					}
					else if (familia.get(j).adulto2 == personajes.get(i)){
						familia.get(j).adulto2 = null;
					}
					else{
						for (int k = 0; k < familia.get(j).hijos.size(); k++){
							if (personajes.get(i) == familia.get(j).hijos.get(k)){
								familia.get(j).hijos.remove(k);
								k--;
							}
						}
					}
				}
				System.out.println("Lamento informar, que en esta triste noche fallecio "+personajes.get(i).getNombre()+"... TT-TT");
				personajes.remove(i);
				i--;
			}
		}
	}

	/*

	Funcion: menu

	Input: posPersonaje (int), posFamilia(int), tiempo (int), in (Scanner), inS (Scanner), fueAccion (int)

	Funcionalidad:  Esta funcion es un menu recursivo, el cual dependiendo de los parametros ingresados funciona como
					menu principal, menu de personaje, menu de familias, etc...
					El parametro posPersonaje si es mayor o igual a 0 indica la posicion del personaje seleccionado.
					El parametro posFamilia si es mayor o igual a 0 indica la posicion de la familia seleccionada.
					El parametro tiempo es un contador, el cual indica el tiempo que ha pasado, el cual cuando es mayor a 0
					y multiplo de 4 indicara el paso de un año.
					El parametro fueAccion es un auxiliar que indica si la ultima vez que se llamo al menu, se realizo una accion
					que quita fuerzas a los personajes.

	*/

	static  void menu(int posPersonaje, int posFamilia, int tiempo, Scanner in, Scanner inS, int fueAccion){
		if (posPersonaje == -9999){
			return;
		}
		
		if (fueAccion == 1){
			quitarFuerza();
		}

		int INTput, INTput2, INTput3, famMasUno;

		if (personajes.size() == 0){
			System.out.println("No quedan personajes. Para continuar jugando debes crear personaje(s).");
			System.out.println("1- Agregar un nuevo adulto.");
			System.out.println("2- Cerrar juego.");

			System.out.println("");
			System.out.print("Ingrese una de las opciones: ");
			INTput = in.nextInt();
			System.out.println("");
			switch (INTput){
				case 1:
					System.out.println("Sexo:");
					System.out.println("1- Masculino.");
					System.out.println("2- Femenino.");
					INTput2 = in.nextInt();

					String nuevoSexo;

					if (INTput2 == 1){
						nuevoSexo = "Masculino";
					}
					else if (INTput2 == 2){
						nuevoSexo = "Femenino";
					}
					else{
						System.out.println("Ingreso invalido, no se agrego ningun adulto.");
						menu(-1, -1, tiempo, in, inS,0);
						break;
					}

					System.out.print("Nombre: ");
					String nuevoNombre = inS.nextLine();

					Adulto nuevo = new Adulto(nuevoNombre, nuevoSexo, 0, 18, 100, 30, 0);
					agregarAdulto(nuevo);
					menu(-1, -1, tiempo, in, inS,0);
					break;
				case 2:
					menu(-9999,-1,tiempo,in,inS,0);
					break;
			}
			return;
		}

		if ((tiempo != 0) && (tiempo % 4 == 0)){
			pasoUnAño();
			tiempo = 0;
		}

		System.out.println("------------------------------------------");
		

		//Cuando no se ha seleccionado personaje o familia
		if ((posFamilia < 0) && (posPersonaje < 0)){
			
			System.out.println("-MENU PRINCIPAL-");
			
			System.out.println("1- Seleccionar Personaje.");
			System.out.println("2- Seleccionar Familia.");
			System.out.println("3- Agregar un nuevo adulto.");
			System.out.println("4- Nuevo matrimonio.");
			System.out.println("5- Cerrar juego.");
			System.out.println("");
			System.out.print("Ingrese una de las opciones: ");
			INTput = in.nextInt();
			System.out.println("");
			switch (INTput){
				case 1:
					System.out.println("¿Cual personaje desea escoger?");
					printPersonajes();
					System.out.println("");
					System.out.print("Ingrese una de las opciones: ");
					INTput2 = in.nextInt();
					System.out.println("");
					menu(INTput2-1,-1,tiempo,in,inS,0);
					break;
				case 2:
					printFamilias();
					if (familia.size() == 0){
						menu(-1,-1,tiempo,in,inS,0);
						break;
					}
					else{
						System.out.println("Ingrese el numero de la familia:");
						INTput2 = in.nextInt()-1;
						menu(-1,INTput2,tiempo,in,inS,0);
						break;
					}
				case 3:
					System.out.println("Sexo:");
					System.out.println("1- Masculino.");
					System.out.println("2- Femenino.");
					INTput2 = in.nextInt();

					String nuevoSexo;

					if (INTput2 == 1){
						nuevoSexo = "Masculino";
					}
					else if (INTput2 == 2){
						nuevoSexo = "Femenino";
					}
					else{
						System.out.println("Ingreso invalido, no se agrego ningun adulto.");
						menu(posPersonaje, posFamilia, tiempo, in, inS,0);
						break;
					}

					System.out.print("Nombre: ");
					String nuevoNombre = inS.nextLine();

					Adulto nuevo = new Adulto(nuevoNombre, nuevoSexo, 0, 18, 100, 30, 0);
					agregarAdulto(nuevo);
					menu(posPersonaje, posFamilia, tiempo, in, inS,0);
					break;
				case 4:
					System.out.println("¿Quienes se van a casar?");
					printPersonajes();
					System.out.print("Adulto 1: ");
					INTput2 = in.nextInt()-1;
					System.out.print("Adulto 2: ");
					INTput3 = in.nextInt()-1;
					casarse((Adulto)personajes.get(INTput2), (Adulto)personajes.get(INTput3));
					menu(posPersonaje, posFamilia, tiempo+1,in,inS,0);
					break;
				case 5:
					menu(-9999,-1,tiempo,in,inS,0);
					break;
			}
			return;
		}

		famMasUno = posFamilia+1;

		if (posPersonaje >= 0){
			System.out.println("Menu de personaje - "+personajes.get(posPersonaje).getNombre());
			//Adulto
			if (personajes.get(posPersonaje).getEdad() >= 18){
				//Adulto sin trabajo
				if (((Adulto)personajes.get(posPersonaje)).estudios == 0){

					System.out.println("1- Ver estado del personaje.");
					System.out.println("2- Comer.");
					System.out.println("3- Dormir.");
					System.out.println("4- Comprar alimento.");
					System.out.println("5- Estudiar.");
					System.out.println("6- Volver al menu de seleccion.");
					System.out.println("7- Cerrar el juego.");
					System.out.println("");
					System.out.print("Ingrese una de las opciones: ");
					INTput = in.nextInt();
					System.out.println("");
					switch (INTput){
						case 1:
							estadoPersonaje(personajes.get(posPersonaje).getNombre());
							menu(posPersonaje,posFamilia,tiempo,in,inS,0);
							break;
						case 2:
							personajes.get(posPersonaje).comer(in);
							menu(posPersonaje, posFamilia,tiempo,in,inS,0);
							break;
						case 3:
							personajes.get(posPersonaje).dormir();
							menu(posPersonaje, posFamilia,tiempo+1,in,inS,1);
							break;
						case 4:
							personajes.get(posPersonaje).dameAlimento(in);
							menu(posPersonaje, posFamilia,tiempo,in,inS,0);
							break;
						case 5:
							if (personajes.get(posPersonaje).getEnergia() < 1){
								personajes.get(posPersonaje).setEnergia(0);
								System.out.println(personajes.get(posPersonaje).getNombre()+" no tiene energia, debe dormir.");
								menu(posPersonaje, posFamilia, tiempo, in, inS,0);
								break;
							}
							else{
								((Adulto)personajes.get(posPersonaje)).estudiar(in);
								menu(posPersonaje, posFamilia,tiempo+1,in,inS,1);
								break;
							}
						case 6:
							menu(-1, -1, tiempo, in, inS,0);
							break;
						case 7:
							menu(-9999,-1,tiempo,in,inS,0);
							break;
					}

				}
				//Adulto con trabajo
				else{

					System.out.println("1- Ver estado del personaje.");
					System.out.println("2- Comer.");
					System.out.println("3- Dormir.");
					System.out.println("4- Comprar alimento.");
					System.out.println("5- Estudiar otra profesion.");
					System.out.println("6- Trabajar.");
					System.out.println("7- Volver al menu de seleccion.");
					System.out.println("8- Cerrar el juego.");

					System.out.println("");
					System.out.print("Ingrese una de las opciones: ");
					INTput = in.nextInt();
					System.out.println("");
					switch (INTput){
						case 1:
							estadoPersonaje(personajes.get(posPersonaje).getNombre());
							menu(posPersonaje,posFamilia,tiempo,in,inS,0);
							break;
						case 2:
							personajes.get(posPersonaje).comer(in);
							menu(posPersonaje, posFamilia,tiempo,in,inS,0);
							break;
						case 3:
							personajes.get(posPersonaje).dormir();
							menu(posPersonaje, posFamilia,tiempo+1,in,inS,1);
							break;
						case 4:
							personajes.get(posPersonaje).dameAlimento(in);
							menu(posPersonaje, posFamilia,tiempo,in,inS,0);
							break;
						case 5:
							if (personajes.get(posPersonaje).getEnergia() < 1){
								personajes.get(posPersonaje).setEnergia(0);
								System.out.println(personajes.get(posPersonaje).getNombre()+" no tiene energia, debe dormir.");
								menu(posPersonaje, posFamilia, tiempo, in, inS,0);
								break;
							}
							else{
								((Adulto)personajes.get(posPersonaje)).estudiar(in);
								menu(posPersonaje, posFamilia,tiempo+1,in,inS,1);
								break;
							}
						case 6:
							if (personajes.get(posPersonaje).getEnergia() < 1){
								personajes.get(posPersonaje).setEnergia(0);
								System.out.println(personajes.get(posPersonaje).getNombre()+" no tiene energia, debe dormir.");
								menu(posPersonaje, posFamilia, tiempo, in, inS,0);
								break;
							}
							else{
								System.out.print("¿Cuanto quieres que trabaje?: ");
								INTput2 = in.nextInt();
								((Adulto)personajes.get(posPersonaje)).trabajo.trabajar(((Adulto)personajes.get(posPersonaje)),INTput2,in);
								menu(posPersonaje, posFamilia,tiempo,in,inS,1);
								break;
							}
						case 7:
							menu(-1, -1, tiempo, in, inS,0);
							break;
						case 8:
							menu(-9999,-1,tiempo,in,inS,0);
							break;
					}
				}
			}
			//CabroChico
			else{
				System.out.println("1- Ver estado del personaje.");
				System.out.println("2- Comer.");
				System.out.println("3- Dormir.");
				System.out.println("4- Comprar alimento.");
				System.out.println("5- Jugar.");
				System.out.println("6- Volver al menu de seleccion.");
				System.out.println("7- Cerrar el juego.");
				System.out.println("");
				System.out.print("Ingrese una de las opciones: ");
				INTput = in.nextInt();
				System.out.println("");
				switch (INTput){
					case 1:
						estadoPersonaje(personajes.get(posPersonaje).getNombre());
						menu(posPersonaje,posFamilia,tiempo,in,inS,0);
						break;
					case 2:
						personajes.get(posPersonaje).comer(in);
						menu(posPersonaje, posFamilia,tiempo,in,inS,0);
						break;
					case 3:
						personajes.get(posPersonaje).dormir();
						menu(posPersonaje, posFamilia,tiempo+1,in,inS,1);
						break;
					case 4:
						personajes.get(posPersonaje).dameAlimento(in);
						menu(posPersonaje, posFamilia,tiempo,in,inS,0);
						break;
					case 5:
						if (personajes.get(posPersonaje).getEnergia() < 1){
							personajes.get(posPersonaje).setEnergia(0);
							System.out.println(personajes.get(posPersonaje).getNombre()+" no tiene energia, debe dormir.");
							menu(posPersonaje, posFamilia, tiempo, in, inS,0);
							break;
						}
						else{
							((CabroChico)personajes.get(posPersonaje)).jugar();
							menu(posPersonaje, posFamilia,tiempo+1,in,inS,1);
							break;
						}
					case 6:
						menu(-1, -1, tiempo, in, inS,0);
						break;
					case 7:
						menu(-9999,-1,tiempo,in,inS,0);
						break;
				}
			}
		}
		//menu de familia
		else{
			System.out.println("Menu de Familia - FAMILIA "+famMasUno);

			System.out.println("1- Ver Familia seleccionada.");
			System.out.println("2- Alimentar hijos.");
			System.out.println("3- Hacer hijo.");
			System.out.println("4- Acostar hijos.");
			System.out.println("5- Volver al menu de seleccion.");
			System.out.println("6- Cerrar el juego.");
			System.out.println("");
			System.out.print("Ingrese una de las opciones: ");
			INTput = in.nextInt();
			System.out.println("");
			switch (INTput){
				case 1:
					verMiFamilia(posFamilia);
					menu(posPersonaje, posFamilia,tiempo,in,inS,0);
					break;
				case 2:
					if ((familia.get(posFamilia).adulto1 == null) && (familia.get(posFamilia).adulto2 == null)){
						System.out.println("Ambos padres estan muertos, no hay quien los alimente TT-TT");
						menu(posPersonaje, posFamilia,tiempo,in,inS,0);
						break;
					}
					else if (familia.get(posFamilia).adulto1 == null){
						System.out.println(familia.get(posFamilia).adulto2.getNombre()+"es el unico padre vivo, por lo que el/ella es quien los va a alimentar");
						System.out.print("¿Cuanta comida deseas darle a cada hijo?: ");
						INTput3 = in.nextInt();
						System.out.println("");
						familia.get(posFamilia).alimentarHijos(familia.get(posFamilia).adulto2.getNombre(), INTput3);
						menu(posPersonaje, posFamilia,tiempo+1,in,inS,1);
						break;
					}
					else if (familia.get(posFamilia).adulto2 == null){
						System.out.println(familia.get(posFamilia).adulto1.getNombre()+"es el unico padre vivo, por lo que el/ella es quien los va a alimentar");
						System.out.print("¿Cuanta comida deseas darle a cada hijo?: ");
						INTput3 = in.nextInt();
						System.out.println("");
						familia.get(posFamilia).alimentarHijos(familia.get(posFamilia).adulto1.getNombre(), INTput3);
						menu(posPersonaje, posFamilia,tiempo+1,in,inS,1);
						break;
					}
					else{
						System.out.println("¿Cual de los padres es quien le da la comida a los hijos?");
						System.out.println("1- "+familia.get(posFamilia).adulto1.getNombre());
						System.out.println("2- "+familia.get(posFamilia).adulto2.getNombre());
						INTput2 = in.nextInt();
						System.out.println("");
						System.out.print("¿Cuanta comida deseas darle a cada uno?: ");
						INTput3 = in.nextInt();
						System.out.println("");
						if (INTput2 == 1){
							familia.get(posFamilia).alimentarHijos(familia.get(posFamilia).adulto1.getNombre(), INTput3);
						}
						else{
							familia.get(posFamilia).alimentarHijos(familia.get(posFamilia).adulto2.getNombre(), INTput3);
						}
						menu(posPersonaje, posFamilia,tiempo+1,in,inS,1);
						break;
					}
				case 3:
					if ((familia.get(posFamilia).adulto1 == null) || (familia.get(posFamilia).adulto2 == null)){
						System.out.println("Para hacer otro hijo se necesitan ambos padres vivos, mi mayor pesame TT-TT");
						menu(posPersonaje, posFamilia,tiempo,in,inS,0);
						break;
					}
					System.out.println("Esperando a la cigueña...");
					String nombrehijardo = familia.get(posFamilia).nombrarHijo(familia.get(posFamilia).saberSexo(),inS);
					personajes.add(familia.get(posFamilia).hacerHijo(nombrehijardo));
					menu(posPersonaje, posFamilia,tiempo+1,in,inS,1);
					break;
				case 4:
					familia.get(posFamilia).acostarHijos();
					menu(posPersonaje, posFamilia,tiempo,in,inS,1);
					break;
				case 5:
					menu(-1, -1, tiempo, in, inS,0);
					break;
				case 6:
					menu(-9999,-1,tiempo,in,inS,0);
					break;
			}
		}
		
	}



	/*

	Funcion: main

	Funcionalidad:  Es el main del programa.

	*/

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Scanner inputS = new Scanner(System.in);
		String nombre, sexo;
		Adulto auxAdulto;
		int sexoInt;
		System.out.println("******************************************");
		System.out.println("*         BIENVENIDO A LOS MIMS!         *");
		System.out.println("******************************************");
		System.out.println("");
		System.out.println("Debes ingresar los 4 personajes iniciales.");
		System.out.println("");
		//Agrega los 4 personajes iniciales
		for (int i = 1; i < 5; i++){
			System.out.println("------------------------------------------");
			System.out.println("PERSONAJE "+i+":");
			System.out.print("Nombre: ");
			nombre = inputS.nextLine();
			System.out.println("");
			System.out.println("Sexo: ");
			System.out.println("1- Masculino.");
			System.out.println("2- Femenino.");
			System.out.print("Ingrese una de las opciones: ");
			sexoInt = input.nextInt();
			if (sexoInt == 1){
				sexo = "Masculino";
			}
			else if (sexoInt == 2){
				sexo = "Femenino";
			}
			else{
				System.out.println("Sexo invalido.");
				break;
			}
			auxAdulto= new Adulto(nombre, sexo, 0, 18, 100, 30, 0);
			agregarAdulto(auxAdulto);
		}
		System.out.println("------------------------------------------");
		System.out.println("");
	
		menu(-1, -1,0,input,inputS,0);
		
		input.close();
		inputS.close();

		System.out.println("Cerrando juego...");
	}
}



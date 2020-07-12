Luis Corrales Palma
201804577-2

Maximo de energia: 100
Maximo de Fuerza: 100
Dinero y comida no tienen limite.

Utilice la version 11 de Java.

Para compilar sus clases dentro de la carpeta Tarea3, escriba por consola 
	- make run.

Para ejecutar su tarea compilada escriba por consola:
	- java -jar Mims.jar



Aclaracion:
	Para el correcto funcionamiento de los Scanner tuve que definir dos scanner
	en el main, y para aquellas funciones que requieren de uh ingreso por consola 
	tuve que agrearles por parametro dichos scanner.

	Lo anterior se debe a que si no cerraba los scanner me salian warnings, pero
	si los cerraba ocurrian distintos errores durante la ejecucion del programa,
	por lo que tuve que definir los Scanner como "globales".

Correcto funcionamiento del programa:
	Cada personaje debe tener un nombre distinto, es decir, dos
	personajes no pueden tener el mismo nombre.

	Cuando se pida ingresar un nombre, se debe de ingresar
	una cadena de caracteres (o string).

	Cuando se pida el ingreso de una de las opciones, las cuales son
	dadas por numeros, se debe de ingresar una de las opciones dadas,
	de lo contrario el juego se cierra.


Inicio del juego:
	El juego empieza con solo 4 adultos de 18 años, a los cuales
	tendras que asignarle su nombre y sexo por consola.



Luego se accede un menu, el cual lo defini recursivamente, pero
basicamente consta de un menu inicial del cual se puede acceder a un
menu de personaje y un menu de familia, ademas de poder finalizar el juego,
agregar adultos y crear un nuevo matrimonio (generando otra nueva familia)

El menu de personaje basicamente es cuando se selecciona un personaje, y el
menu te da las acciones que puedes realizar con el personaje seleccionado.
Ademas podras volver al menu principal o cerrar el juego directamente.

El menu de familias funciona de manera analoga al menu de personajes,
pero con las respectivas acciones de la familia.

Si los dos padres de una familia se mueren, la familia aun sigue figurando (con
los hijos huerfanos), pero las acciones que requieran de los padres no se
pueden ejecutar e imprimen cierto mensaje.



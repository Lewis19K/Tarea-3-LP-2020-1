package Tarea3;
import java.util.*;

public class Familia {
    
    public Adulto adulto1, adulto2;
    ArrayList<Personaje> hijos = new ArrayList<Personaje>();


    /*

	Funcion: saberSexo

	Input: Ninguno

    Funcionalidad:  Esta es una funcion auxiliar definida por mi, la cual
                    define el sexo de un nuevo (aleatoriamente) y retorna un entero
                    el cual indica el sexo resultante.

	*/
    
    public int saberSexo(){
        Random rand = new Random();

        // 0 para hombre, 1 para mujer
        int sexo = rand.nextInt(2);

        if (sexo == 0){
            System.out.println("Felicidades, es un niño!!");
        }
        else{
            System.out.println("Felicidades, es una niña!!");
        }
        return sexo;
    }

    /*

	Funcion: nombrarHijo

	Input: sexoHijo (int), input (Scanner)

    Funcionalidad: Esta funcion auxiliar la defini yo y lo que hace es nombrar el nuevo hijo,
                    una vez ya se sabe el sexo de este nuevo hijo.

	*/

    public String nombrarHijo(int sexoHijo,Scanner input){
        String nombreHijo;

        if (sexoHijo == 0){
            System.out.println("¿Como desea que se llame su hijo?");
            nombreHijo = input.nextLine();
            return nombreHijo+",Masculino";
        }
        else{
            System.out.println("¿Como desea que se llame su hija?");
            nombreHijo = input.nextLine();
            return nombreHijo+",Femenino";
        }
    }

    /*

	Funcion: alimentarHijos

	Input: nombreAdulto (String), comida (int)

    Funcionalidad:  Esta funcion simula la accion de alimentar los hijos de la familia,
                    pidiendo por parametros el nombre del adulto que va a ser quien los alimente,
                    y la cantidad de comida que se dara a cada hijo. 

	*/

    public void alimentarHijos(String nombreAdulto, int comida){
        if(nombreAdulto == adulto1.getNombre()){
            for (int i = hijos.size()-1; i >= 0; i--){
                if (adulto1.getComida() > comida){
                    if (hijos.get(i).getEdad() < 18){
                        if (hijos.get(i).getFuerza()+comida/3 < 100){
                            hijos.get(i).setFuerza(hijos.get(i).getFuerza()+comida/3);
                        }
                        else{
                            hijos.get(i).setFuerza(100);
                        }
                        adulto1.setComida(adulto1.getComida()-comida);
                    }
                    else{
                        if (hijos.get(i).getFuerza()+comida/6 < 100){
                            hijos.get(i).setFuerza(hijos.get(i).getFuerza()+comida/6);
                        }
                        else{
                            hijos.get(i).setFuerza(100);
                        }
                        adulto1.setComida(adulto1.getComida()-comida);
                    }
                }
                else{
                    break;
                }
            }
        }
        else if (nombreAdulto == adulto2.getNombre()){
            for (int i = hijos.size()-1; i >= 0; i--){
                if (adulto2.getComida() > comida){
                    if (hijos.get(i).getEdad() < 18){
                        if (hijos.get(i).getFuerza()+comida/3 < 100){
                            hijos.get(i).setFuerza(hijos.get(i).getFuerza()+comida/3);
                        }
                        else{
                            hijos.get(i).setFuerza(100);
                        }
                        adulto2.setComida(adulto2.getComida()-comida);
                    }
                    else{
                        if (hijos.get(i).getFuerza()+comida/6 < 100){
                            hijos.get(i).setFuerza(hijos.get(i).getFuerza()+comida/6);
                        }
                        else{
                            hijos.get(i).setFuerza(100);
                        }
                        adulto2.setComida(adulto2.getComida()-comida);
                    }
                }
                else{
                    break;
                }
            }
        }
        else{
            System.out.println("No existe ese adulto en esta familia.");
        }
    }

    /*

	Funcion: hacerHijo

	Input: nombreHijo (String)

    Funcionalidad:  Esta funcion simula la accion hacerHijo definida en la tarea, recibiendo el nombre
                    que se le dara a este nuevo hijo, insertandolo en la lista de hijos pertenecientes a 
                    la familia (para facilitar la tarea de esta accion defini 2 funciones anteriormente,
                    las cuales permiten saber el sexo antes de nombrar al hijo).

	*/

    public CabroChico hacerHijo(String nombreHijo){
        String[] nombreYSexo = nombreHijo.split(",");
        CabroChico hijo = new CabroChico(nombreYSexo[0],nombreYSexo[1],0,0,100,30,0);
        hijos.add(hijo);
        return hijo;
    }

    /*

	Funcion: acostarHijos

	Input: Ninguno

    Funcionalidad:  Esta funcion simula la accion acostarHijos definida en la tarea,
                    haciendo que cada uno de los hijos de la familia se vaya a dormir.

	*/

    public void acostarHijos(){
        for (int i = 0; i < hijos.size(); i++){
            hijos.get(i).dormir();
        }
    }

}
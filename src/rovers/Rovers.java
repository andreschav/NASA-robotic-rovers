package rovers;

import Classes.Robot;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Andres Percy Chavez O.
 */
public class Rovers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Pedimos al Usuario que introduzca la ruta y archivo.txt del archivo con las coordenadas
        //Ejemplo: /home/user/archivo.txt
        Scanner path=new Scanner(System.in); 
        System.out.println("introduzca ruta y archivo(/home/andres/rovers_input.txt):"); 
        String ruta=path.nextLine();
        //leemos linea por linea el archivo de texto para leer las coordenadas del mismo
        File f = new File( ruta );
        BufferedReader entrada;
        try {
            entrada = new BufferedReader( new FileReader( f ) );
            String linea;
            //variable que nos ayuda a determinar que lineas son de los robots
            int param_line = 1;
            //Creamos una nueva instancia de la Clase Robot
            Robot robot = new Robot();
            //iniciamos recorriendo linea por linea
            while(entrada.ready()){
                //leemos linea
                linea = entrada.readLine();
                //separamos la linea tipo string en valores individuales
                //y lo almacenamos a en un array
                String[] sa= linea.split(" ");
                //si param_line significa que es la primera line del archivo de texto
                //lo cual significa que son las 2 primeras coordenadas del Rectangulo a explorar
                if (param_line == 1){
                    //almacenamos los 2 valores correspondientes en limitx y limity
                    robot.setLimitx(Integer.parseInt(sa[0]));
                    robot.setLimity(Integer.parseInt(sa[1]));
                }else{
                    //caso contrario preguntamos si es par la variable param_line
                    //si es par significa que es la linea correspondiente al la 
                    //ubicacion del robot y su orientacion (E,O,N,S)
                    if (param_line % 2 == 0){
                        //almacenamos en el objeto los valores de posicion y orientacion
                        robot.setPosx(Integer.parseInt(sa[0]));
                        robot.setPosy(Integer.parseInt(sa[1]));
                        robot.setOrientation(sa[2]);
                    }else{
                        //si no es la primera linea del archivo y no es par la variable param_line
                        //significa que es la linea correpondiente al desplazamiento (LLMMLRRM)
                        //en este caso enviamos el desplazamiento y movemos el robot
                        robot.setDisplacement(sa[0]);
                    }
                }
                //incrementamos su valor para saber en que numero de linea estamos
                param_line++;
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

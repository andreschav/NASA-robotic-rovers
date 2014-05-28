/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rovers;

import Classes.Robot;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author andres
 */
public class Rovers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner path=new Scanner(System.in); 
        System.out.println("introduzca ruta y archivo(/home/andres/rovers_input.txt):"); 
        String ruta=path.nextLine();
        File f = new File( ruta );
        BufferedReader entrada;
        try {
            entrada = new BufferedReader( new FileReader( f ) );
            String linea;
            int param_line = 1;
            Robot robot = new Robot();
            while(entrada.ready()){
                linea = entrada.readLine();
                String[] sa= linea.split(" ");
                if (param_line == 1){
                    robot.setLimitx(Integer.parseInt(sa[0]));
                    robot.setLimity(Integer.parseInt(sa[1]));
                }else{
                    if (param_line % 2 == 0){
                        robot.setPosx(Integer.parseInt(sa[0]));
                        robot.setPosy(Integer.parseInt(sa[1]));
                        robot.setOrientation(sa[2]);
                    }else{
                        robot.setDisplacement(sa[0]);
                    }
                }
                
                param_line++;
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

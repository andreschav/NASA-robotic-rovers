package Classes;

/**
 *
 * @author Andres Percy Chavez O.
 */
public class Robot {
    private int limitx;         //tamanio maximo en coordenada x del rectangulo a explorar
    private int limity;         //tamanio maximo en coordenada y del rectangulo a explorar
    private int posx;           //posicion en coordenada x del robot
    private int posy;           //posicion en coordenada y del robot
    private String orientation; //orientacion del robot  N=norte E=este S=sur O=oeste
    private String displacement;//cadena contiene el desplazamiento total del robot (LLMMRMLM)

    public Robot(){

    }
    
    //Metodo privado que permite fijar la rotacion del robot 
    //@left_right = L,R
    //cambiamos la rotacion del robot segun si recibe L o R
    private void rotateRobot(char left_rigth){
        if (left_rigth == 'L'){
            switch (this.orientation) {
                case "E":
                    this.orientation = "S";
                    break;
                case "S":
                    this.orientation = "O";
                    break;
                case "O":
                    this.orientation = "N";
                    break;
                case "N":
                    this.orientation = "E";
                    break;
            }
        }
        if (left_rigth == 'R'){
            switch (this.orientation) {
                case "E":
                    this.orientation = "N";
                    break;
                case "S":
                    this.orientation = "E";
                    break;
                case "O":
                    this.orientation = "S";
                    break;
                case "N":
                    this.orientation = "O";
                    break;
            }
        }
        
    }
    //Metodo que mueve el robot segun la orientacion que tiene
    private void moveRobot(){
        
        switch (this.orientation) {
                case "E":
                    this.posx--;
                    break;
                case "S":
                    this.posy--;
                    break;
                case "O":
                    this.posx++;
                    break;
                case "N":
                    this.posy++;
                    break;
            }
        //Salida del sistema en caso de que el robot mediante su desplazamiento salgan fuera de los limites del Rectangulo
        if(!((this.posx >=0 && this.posx <=this.limitx) && (this.posy >=0 && this.posy <=this.limity))){
            System.out.println("Error can't move out of range");
            System.exit(0);
        }
            
            
    }
    public int getPosx(){
        return this.posx;
    }
    public int getPosy(){
        return this.posy;
    }
    public String getOrientation(){
        return this.orientation;
    }
    public void setLimitx(int limitx){
        this.limitx = limitx;
    }
    public void setLimity(int limity){
        this.limity = limity;
    }
    public void setPosx(int posx){
        this.posx = posx;
    }
    public void setPosy(int posy){
        this.posy = posy;
    }
    public void setOrientation(String orientation){
        this.orientation = orientation;
    }
    public void setDisplacement(String displacement){
        this.displacement = displacement;
        //movemos el robot
        Displacement();
        //mostramos la posicion actual del robot actual
        diplayCurrentPosition();
        
    }
    //Metodo que desplaza al robot desde su posicion inicial hasta terminar de 
    //leer caracter por caracter la variable @displacement(LLMMRRLLMLM)
    private void Displacement(){
        //Caracter el cual almacenara el tipo de accion (L,R,M)
        char displac;
        //recorremos todos los caracteres del @displacement (LLMMRRLMMML)
        for (int i = 0; i< this.displacement.length(); i++){
            //Obtenemos el caracter
            displac = this.displacement.charAt(i);
            //si es M el caracter movemos el robot
            if('M' == displac){
                moveRobot();
            }else{
                //caso contrarion solo lo rotamos en su posicion actual
                rotateRobot(displac);
            }
        }
    }
    //Metodo de impresion de la posicion actual del robot
    private void diplayCurrentPosition(){
        System.out.print(this.posx + " "+ this.posy+ " ");
        System.out.println(this.orientation);
    }
}

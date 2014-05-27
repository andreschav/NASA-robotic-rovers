/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author andres
 */
public class Robot {
    private int limitx;
    private int limity;
    private int posx;
    private int posy;
    private String orientation; //  N=norte E=este S=sur O=oeste
    private String displacement;
    public Robot(){
    
    }
    
    public Robot(int posx, int posy, String orientation){
        this.posx = posx;
        this.posy = posy;
        this.orientation = orientation;
    }
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
        Displacement();
        diplayCurrentPosition();
        
    }
    private void Displacement(){
        char displac;
        for (int i = 0; i< this.displacement.length(); i++){
            displac = this.displacement.charAt(i);
            if('M' == displac){
                moveRobot();
            }else{
                rotateRobot(displac);
            }
        }
    }
    private void diplayCurrentPosition(){
        System.out.print(this.posx + " "+ this.posy+ " ");
        System.out.println(this.orientation);
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menú here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menú extends World
{
    Flecha flecha= new Flecha();
    private int opcion= 0; 
    /**
     * Constructor for objects of class Menú.
     * 
     */
    public Menú()
    {   
        super(800, 600, 1); 
        GreenfootImage backgroundImage = new GreenfootImage("MenuF.png");
        setBackground(backgroundImage);
        prepararMundo();
    }
    
    private void prepararMundo(){
        addObject(new Jugar(), 550, 350); 
        addObject(flecha, 450, 350); 
    }
    
    public void act(){
        if (Greenfoot.isKeyDown("w") && opcion != 0) {opcion++;}
        if (Greenfoot.isKeyDown("s") && opcion != 0) {opcion--;}
        
        if (opcion>=2) opcion= 0; 
        if (opcion<0) opcion= 1; 
        
        flecha.setLocation(450, 350 + (opcion*100)); 
        
        if (Greenfoot.isKeyDown("SPACE") || Greenfoot.isKeyDown("ENTER")){
            switch(opcion){
                case 0: 
                    Greenfoot.setWorld(new MyWorld()); 
                    break; 
                case 1: 
                    Greenfoot.stop();
                    break;
            }
        }
    }
}

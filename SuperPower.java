import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SuperPower here.
 * 
 * @author Leonardo Dufrey Mejía Mejía
 * @version 1.0
 */
public class SuperPower extends Actor
{
    final int SUPER_POWER_LIMIT = 100; 
    int superCount; 
    int count; 
    public SuperPower()
    {
        setImage(new GreenfootImage(SUPER_POWER_LIMIT +2  , 12));
        getImage().drawRect(0,0,SUPER_POWER_LIMIT+1,11);
        getImage().setColor(Color.BLUE); 
        getImage().fillRect(1,1,superCount,10);
    }
    public void act()
    {
       setImage(new GreenfootImage(SUPER_POWER_LIMIT +2  , 12));
        getImage().drawRect(0,0,SUPER_POWER_LIMIT+1,11);
        getImage().setColor(Color.BLUE);
        getImage().fillRect(1,1,superCount,10); 
        World world = getWorld(); 
        MyWorld myWorld = (MyWorld)world; 
        setLocation(myWorld.getPlayer().getX()+10, myWorld.getPlayer().getY()-80);
        useSuper();
    }
    public void useSuper()
    {
        count++; 
        if(count % 10 == 0)
        {
            superCount ++; 
        }
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WeaponButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WeaponButton extends Actor
{
    
    Counter counter;
    int weaponUpgrade = 1;
    public WeaponButton(Counter counter)
    {
        this.counter = counter; 
        setImage("BotónArma.png");
        getImage().scale(100, 100);
    }
    
    public void act()
    {
        if(Greenfoot.mousePressed(this) && counter.money > 149)
        {
            counter.money -= 150; 
            weaponUpgrade++;
            Greenfoot.playSound("moneda.mp3");
        }
        if(weaponUpgrade>3)
            weaponUpgrade=3;
    }
}

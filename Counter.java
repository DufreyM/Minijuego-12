import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    int score; 
    int money;
    int time;
    public Counter()
    {
        setImage(new GreenfootImage("Score: " + score + "\n Cash: " + money + "\n Time: " + time/60,  40, Color.BLACK,new Color (0,0,0,0)));
    }
    public void act()
    {
        time++; 
        setImage(new GreenfootImage("Score: " + score + "\n Cash: " + money+ "\n Time: " + time/60, 40, Color.BLACK,new Color (0,0,0,0)));
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    int count = 0; 
    int spawnSpeed = 50; 
    int randomSpawn;
    public Player mainPlayer = new Player(); 
    Counter counter = new Counter(); 
    HealthBar healthbar = new HealthBar();
    WeaponButton weaponButton = new WeaponButton(counter);
    SuperPower superPower = new SuperPower(); 
    public MyWorld()
    {    
        super(800, 600, 1); 
        GreenfootImage backgroundImage = new GreenfootImage("FondoM.png");
        setBackground(backgroundImage);
        mainPlayer = new Player(weaponButton, superPower);
        addObject(mainPlayer, getWidth()/2, getHeight()/2);
        addObject(counter, 130, 100); 
        addObject(healthbar, mainPlayer.getX() - 5, mainPlayer.getY() - 50);
        addObject(weaponButton, 700, 100);
        addObject(superPower, mainPlayer.getX() +10, mainPlayer.getY() - 80);
        Greenfoot.playSound("Pista.wav");
    }
    public Player getPlayer()
    {
        return mainPlayer; 
    }
    public void act()
    {
        count++; 
        if(count % 600 == 0)
        {
            spawnSpeed--;
        }
    while(Greenfoot.isKeyDown("p")){
        Greenfoot.delay(1);
        }
        spawnZombies();
    }
    public void spawnZombies()
    {
       if (count % spawnSpeed == 0){
        randomSpawn = Greenfoot.getRandomNumber(9);
        switch(randomSpawn){
            case 0 : addObject(new Zombie(mainPlayer, counter), 0, 0); break;
            case 1: addObject(new Zombie(mainPlayer, counter), getWidth()/2, 0); break;
            case 2: addObject(new Zombie(mainPlayer, counter), getWidth(), 0); break;
            case 3: addObject(new Zombie(mainPlayer, counter), 0, getHeight()/2); break;
            case 4: addObject(new Zombie(mainPlayer, counter), getWidth(), getHeight()/2); break;
            case 5: addObject(new Zombie(mainPlayer, counter), 0, getHeight()); break;
            case 6: addObject(new Zombie(mainPlayer, counter), getWidth()/2, getHeight()); break;
            case 7: addObject(new Zombie(mainPlayer, counter), getWidth(), getHeight()); break;
        }
        } 
    }
}
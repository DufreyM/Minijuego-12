import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author Leonardo Dufrey Mejía Mejía 23648  
 * @version 1.0.0
 */
public class Player extends Actor
{
    MouseInfo mouse = Greenfoot.getMouseInfo();
    int speed = 3; 
    int time = 0; 
    WeaponButton weaponButton;
    SuperPower superPower;
    int superTimer; 
    public Player()
    {
        setImage(new GreenfootImage(70,50));
        getImage().setColor(Color.YELLOW);
        getImage().fillOval(0, 0, 50, 50);
        getImage().setColor(Color.BLACK); 
        getImage().fillRect(50, 25, 70, 10);
    }
    public Player(WeaponButton weaponButton, SuperPower superPower)
    {
        this.superPower = superPower;
        this.weaponButton = weaponButton; 
        setImage(new GreenfootImage(70,50));
        getImage().setColor(Color.YELLOW);
        getImage().fillOval(0, 0, 50, 50);
        getImage().setColor(Color.BLACK); 
        getImage().fillRect(50, 25, 70, 10);
    }
    public void act()
    {
        turnAround(); 
        moveAround();
        fireProjectile();
        superPowerUsed();
        hitByZombie();
    }
    public void turnAround()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null)
            turnTowards(mouse.getX(), mouse.getY());
    }
    public void moveAround()
    {
        if(Greenfoot.isKeyDown("w"))
        setLocation(getX(),getY() - speed);
        if(Greenfoot.isKeyDown("a"))
        setLocation(getX() - speed, getY());
        if(Greenfoot.isKeyDown("s"))
        setLocation(getX(), getY() + speed);
        if(Greenfoot.isKeyDown("d"))
        setLocation(getX() + speed, getY());   
    }
    public void fireProjectile()
    {
        if(Greenfoot.mousePressed(null) && weaponButton.weaponUpgrade == 1){
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation());
        }
        if(Greenfoot.mousePressed(null) && weaponButton.weaponUpgrade == 2){
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation()-10);
            projectile.move(25);
            Projectile projectile2 = new Projectile();
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation()+10);
            projectile2.move(20);
        }
            if(Greenfoot.mousePressed(null) && weaponButton.weaponUpgrade == 3){
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation()-10);
            projectile.move(25);
            Projectile projectile2 = new Projectile();
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation()+10);
            projectile2.move(20);
            Projectile projectile3 = new Projectile();
            getWorld().addObject(projectile3, getX(), getY());
            projectile3.setRotation(getRotation());
            projectile3.move(20);
        }
    }
    public void superPowerUsed()
    {
        if(superPower.superCount > 99 && superTimer < 30)
        {
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation()-60);
            projectile.move(25);
            Projectile projectile2 = new Projectile();
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation()+60);
            projectile2.move(20);
            Projectile projectile3 = new Projectile();
            getWorld().addObject(projectile3, getX(), getY());
            projectile3.setRotation(getRotation());
            projectile3.move(20);
            Projectile projectile4 = new Projectile();
            getWorld().addObject(projectile4, getX(), getY());
            projectile4.setRotation(getRotation()-180);
            projectile4.move(25);
            Projectile projectile5 = new Projectile();
            getWorld().addObject(projectile5, getX(), getY());
            projectile5.setRotation(getRotation()+120);
            projectile5.move(20);
            Projectile projectile6 = new Projectile();
            getWorld().addObject(projectile6, getX(), getY());
            projectile6.setRotation(getRotation()-120);
            projectile6.move(20);
            superTimer++; 
        }
        if(superTimer>29)
        {
            superPower.superCount = 0; 
            superTimer = 0;
        }
    }
    
    public boolean hitByZombie()
    {
        Actor zombie = getOneObjectAtOffset(0,0, Zombie.class);
        if(zombie!=null)
        {
            return true; 
        }
        else 
        return false; 
    }
}


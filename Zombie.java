import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author Leonardo Dufrey Mejía Mejía
 * @version 1.0.0
 */
public class Zombie extends Actor
{
    int animateImage = 0; 
    int animateSpeed = 5; 
    int count; 
    int health = 4; 
    Player player; 
    Counter counter; 
    public Zombie(Player mainPlayer, Counter counter)
    {
        this.counter= counter;
        player = mainPlayer;
        setImage("skeleton-idle_16.png");
        getImage().scale(80, 80);
        
    }
    public void act()
    {
        count++;
        animate();
        moveAround(); 
        hitByProjectile();
    }
    public void animate()
    {
        if(count % animateSpeed == 0)
        {
            if(animateImage > 16){
            animateImage = 0; 
            }
            setImage("skeleton-move_" + animateImage + ".png"); 
            animateImage++;
            getImage().scale(80, 80);
        }
    }
    public void moveAround()
    {
        move(1); 
        turnTowards(player.getX(), player.getY());
    }
    public void hitByProjectile()
    {
        Actor projectile = getOneIntersectingObject(Projectile.class);
        if(projectile!= null) 
        {
            health--; 
            getWorld().removeObject(projectile); 
        }
        if(health == 0)
        {
        counter.score++;
        counter.money+=5; 
        getWorld().removeObject(this);
        
        }
    }
}


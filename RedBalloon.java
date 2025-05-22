import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedBalloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedBalloon extends Actor
{
    public void act()
    {
        // Add your action code here.
        MyWorld world = (MyWorld) getWorld();
        int x = getX();
        int y = getY() + world.speed;
        setLocation(x, y);
        
        if(getY() <= 0)
        {
            world.gameOver();
        }
        if(Greenfoot.mouseDragged(this))
        {
            world.removeObject(this);
            world.spawnBalloon();
            world.increaseScore();
        }
    }
}

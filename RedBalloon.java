import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedBalloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedBalloon extends Actor
{
    int speed = -1;
    public void act()
    {
        // Add your action code here.
        int x = getX();
        int y = getY() + speed;
        setLocation(x, y);
        
        MyWorld world = (MyWorld) getWorld();
        if(getY() <= 0)
        {
            world.gameOver();
        }
        if(Greenfoot.mouseDragged(this))
        {
            world.removeObject(this);
            world.spawnBalloon();
        }
        
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlueBalloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlueBalloon extends Actor
{
    public BlueBalloon()
    {
        setImage("images/balloon2.png");
    }
    
    public void act()
    {
        // Add your action code here.
        MyWorld world = (MyWorld) getWorld();
        int x = getX() + world.xSpeed;
        int y = getY() + world.ySpeed;
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

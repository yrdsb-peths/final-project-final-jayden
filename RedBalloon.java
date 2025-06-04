import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedBalloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedBalloon extends SmoothMover
{
    int xSpeed;
    double ySpeed = -8;
    double acceleration = 0.25;
    public RedBalloon(int speedX)
    {
        setImage("images/balloon1.png");
        xSpeed = speedX;
    }
    
    public void act()
    {
        // Add your action code here.
        MyWorld world = (MyWorld) getWorld();
        ySpeed+=acceleration;
        double x = getX() + xSpeed;
        double y = getY() + ySpeed;
        super.setLocation(x, y);
        
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

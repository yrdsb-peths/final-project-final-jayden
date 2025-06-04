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
    double ySpeed = -10;
    public RedBalloon(int speedX)
    {
        setImage("images/balloon1.png");
        xSpeed = speedX;
    }
    
    public void act()
    {
        // Add your action code here.
        MyWorld world = (MyWorld) getWorld();
        double acceleration = 0.5;
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

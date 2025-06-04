import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedBalloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YellowBalloon extends RedBalloon
{
    public YellowBalloon(int speedX)
    {
        super(speedX);
        setImage("images/balloon3.png");
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

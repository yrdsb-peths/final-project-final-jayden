import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedBalloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedBalloon extends Actor
{
    int xSpeed;
    double ySpeed;
    public RedBalloon(int speedX, double speedY)
    {
        setImage("images/balloon1.png");
        xSpeed = speedX;
        ySpeed = speedY;
    }
    
    public void act()
    {
        // Add your action code here.
        MyWorld world = (MyWorld) getWorld();
        double acceleration = 0.02;
        int x = getX() + xSpeed;
        double y = getY() + ySpeed;
        setLocation(x, (int)y);
        if(ySpeed >= -5)
        {
            ySpeed-=acceleration;
        }
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

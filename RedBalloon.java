import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedBalloon here.
 * 
 * @author Li
 * @version June 2025
 */
public class RedBalloon extends SmoothMover
{
    int xSpeed;
    static double acceleration = 0.1;
    
    //apple constructor
    public RedBalloon(int speedX)
    {
        GreenfootImage apple = new GreenfootImage("images/apple.png");
        setImage(apple);
        xSpeed = speedX;
    }
    
    public void act()
    {
        // Add your action code here.
        MyWorld world = (MyWorld) getWorld();
        world.ySpeed+=acceleration;
        double x = getX() + xSpeed;
        double y = getY() + world.ySpeed;
        super.setLocation(x, y);
        setRotation(getRotation() + 5);
        
        if(getY() >= 399)
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

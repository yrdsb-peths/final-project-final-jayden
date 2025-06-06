import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class YellowBalloon here.
 * 
 * @author Li
 * @version June 2025
 */
public class YellowBalloon extends RedBalloon
{
    //RedBalloon constructor
    public YellowBalloon(int speedX)
    {
        super(speedX);
        setImage("images/watermelon.png");
    }
    
    public void act()
    {
        // Add your action code here.
        MyWorld world = (MyWorld) getWorld();
        world.ySpeed+=acceleration;
        double x = getX() + xSpeed;
        double y = getY() + world.ySpeed;
        super.setLocation(x, y);
        
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

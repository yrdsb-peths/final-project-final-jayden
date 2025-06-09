import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class YellowBalloon here.
 * 
 * @author Li
 * @version June 2025
 */
public class YellowBalloon extends RedBalloon
{
    
    //Watermelon constructor
    public YellowBalloon(int speedX)
    {
        super(speedX);
        GreenfootImage watermelon = new GreenfootImage("images/watermelon.png");
        watermelon.scale(50, 50);
        setImage(watermelon);
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

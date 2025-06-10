import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Half of the fruit that spawns after the user slices a fruit.
 * 
 * @author Li
 * @version June 2025
 */
public class SlicedFruit extends SmoothMover
{
    private double xSpeed;
    private double ySpeed;
    private GreenfootImage image;
    
    //SlicedFruit constructor
    public SlicedFruit(GreenfootImage img, double initialXSpeed, double initialYSpeed)
    {
        image = new GreenfootImage(img);
        setImage(image);
        xSpeed = initialXSpeed;
        ySpeed = initialYSpeed;
    }
    
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        
        //Falls down the world
        ySpeed += Apple.acceleration;
        double x = getX() + xSpeed;
        double y = getY() + ySpeed;

        setLocation(x, y);
        
        setRotation(getRotation() + 10);
        
        //Deletes when it reaches world floor
        if (getY() >= 399)
        {
            world.removeObject(this);
        }
    }
}

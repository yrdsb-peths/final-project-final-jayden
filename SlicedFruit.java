import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SlicedFruit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SlicedFruit extends SmoothMover
{
    private double xSpeed;
    private double ySpeed;
    private GreenfootImage image;
    
    public SlicedFruit(GreenfootImage img, double initialXSpeed, double initialYSpeed)
    {
        image = new GreenfootImage(img);
        setImage(image);
        xSpeed = initialXSpeed;
        ySpeed = initialYSpeed;
    }
    
    /**
     * Act - do whatever the SlicedFruit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        
        ySpeed += RedBalloon.acceleration;
        double x = getX() + xSpeed;
        double y = getY() + ySpeed;

        setLocation(x, y);
        
        setRotation(getRotation() + 10);
        
        if (getY() >= 399)
        {
            world.removeObject(this);
        }
    }
}

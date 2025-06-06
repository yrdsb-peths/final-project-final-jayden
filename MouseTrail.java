import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Objects that appears when the user drags their mouse.
 * 
 * @author Li
 * @version June 2025
 */
public class MouseTrail extends Actor
{
    private int duration = 5;
    
    //mousetrail constructor
    public MouseTrail() {
        GreenfootImage trail = new GreenfootImage(10, 10);
        trail.setColor(Color.BLACK);
        trail.fillOval(0, 0, 10, 10);
        setImage(trail);
    }
    
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        duration--;
        if(duration <= 0)
        {
            world.removeObject(this);
        }
    }
}

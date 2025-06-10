import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Objects that appear when the user drags their mouse.
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
        trail.setColor(Color.WHITE);
        trail.fillOval(0, 0, 10, 10);
        setImage(trail);
    }
    
    //Deletes the object after 5 actions
    public void act()
    {
        World world = (World) getWorld();
        duration--;
        
        if(duration <= 0)
        {
            world.removeObject(this);
        }
    }
    
    //Spawns the object at mouse position when mouse is dragged
    //Parameter asks for the world that the object will spawn in
    public static void dragTrail(World selectedWorld)
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        
        if(Greenfoot.mouseDragged(null))
        {
            MouseTrail trail = new MouseTrail();
            selectedWorld.addObject(trail, mouse.getX(), mouse.getY());
        } 
    }
}

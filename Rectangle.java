import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rectangle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rectangle extends Actor
{
    public Rectangle(int width, int height)
    {
        GreenfootImage img = new GreenfootImage(width, height);
        img.setColor(Color.LIGHT_GRAY);
        img.fillRect(0, 0, width, height);
        setImage(img);
    }
    
    /**
     * Act - do whatever the Rectangle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Gray rectangle, indicates thata label is clickable when it 
 * is inside the gray rectangle.
 * 
 * @author Li
 * @version June 2025
 */
public class Rectangle extends Actor
{
    //Rectangle constructor
    public Rectangle(int width, int height)
    {
        GreenfootImage img = new GreenfootImage(width, height);
        img.setColor(Color.LIGHT_GRAY);
        img.fillRect(0, 0, width, height);
        setImage(img);
    }
}

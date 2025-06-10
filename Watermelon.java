import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Watermelon, a fruit that the user can slice.
 * 
 * @author Li
 * @version June 2025
 */
public class Watermelon extends Apple
{
    
    //Watermelon constructor
    public Watermelon(int speedX)
    {
        super(speedX);
        GreenfootImage watermelon = new GreenfootImage("images/watermelon.png");
        watermelon.scale(50, 50);
        setImage(watermelon);
        
        this.halfFruit = new GreenfootImage("images/slicedWatermelon.png");
    }
    
    //Acts the same way as the Apple class
    public void act()
    {
        super.act();
    }
}

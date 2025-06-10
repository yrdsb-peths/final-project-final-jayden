import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Coconut, a fruit that the user can slice.
 * 
 * @author Li
 * @version June 2025
 */
public class Coconut extends Apple
{
    
    //coconut constructor
    public Coconut(int speedX)
    {
        super(speedX);
        GreenfootImage coconut = new GreenfootImage("images/coconut.png");
        coconut.scale(50, 50);
        setImage(coconut);
        
        this.halfFruit = new GreenfootImage("images/slicedCoconut.png");
    }
    
    //Acts the same way as Apple class
    public void act()
    {
        super.act();
    }
}

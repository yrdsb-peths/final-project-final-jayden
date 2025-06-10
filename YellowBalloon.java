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
        
        this.halfFruit = new GreenfootImage("images/slicedWatermelon.png");
    }
    
    public void act()
    {
        super.act();
    }
}

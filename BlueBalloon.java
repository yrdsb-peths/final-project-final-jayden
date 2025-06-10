import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlueBalloon here.
 * 
 * @author Li
 * @version June 2025
 */
public class BlueBalloon extends RedBalloon
{
    
    //coconut constructor
    public BlueBalloon(int speedX)
    {
        super(speedX);
        GreenfootImage coconut = new GreenfootImage("images/coconut.png");
        coconut.scale(50, 50);
        setImage(coconut);
    }
    
    public void act()
    {
        super.act();
    }
}

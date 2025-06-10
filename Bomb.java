import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends RedBalloon
{
    GreenfootSound bombFuse = new GreenfootSound("bomb.mp3");
    GreenfootImage[] bomb = new GreenfootImage[5];
    SimpleTimer animationTimer = new SimpleTimer();
    
    public Bomb(int speedX)
    {
        super(speedX);
        
        for(int i = 0; i < bomb.length; i++)
        {
            bomb[i] = new GreenfootImage("images/bomb_animation/bomb" + i + ".png");
            bomb[i].scale(50, 50);
        }
        
        animationTimer.mark();
        
        // Initial bomb image
        setImage(bomb[0]);
    }
    
    int imageIndex = 0;
    public void animateBomb()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark(); 
        
        setImage(bomb[imageIndex]); 
        imageIndex++;
    }
    
    /**
     * Act - do whatever the Bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        world.ySpeed+=acceleration;
        double x = getX() + xSpeed;
        double y = getY() + world.ySpeed;
        super.setLocation(x, y);
        setRotation(getRotation() + 5);
        bombFuse.play();
        
        if(getY() >= 399)
        {
            bombFuse.stop();
            world.removeObject(this);
            world.spawnBalloon();
            world.increaseScore();
        }
        
        if(Greenfoot.mouseDragged(this))
        {
            animateBomb(); //doesn't work
            
            world.gameOver();
        }
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bomb, an object that the user should avoid.
 * 
 * @author Li 
 * @version June 2025
 */
public class Bomb extends Apple
{
    GreenfootSound bombFuse = new GreenfootSound("bomb.mp3");
    GreenfootSound bombExplode = new GreenfootSound("explode.mp3");
    
    GreenfootImage[] bomb = new GreenfootImage[5];
    SimpleTimer animationTimer = new SimpleTimer();
    
    private boolean isSliced = false;
    
    //Bomb constructor
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
    
    //Animates the bomb
    int imageIndex = 0;
    public void animateBomb()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark(); 
        
        if (imageIndex < bomb.length) 
        {
            setImage(bomb[imageIndex]); 
            imageIndex++;
        }
    }
    
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        
        //Checks if bomb is sliced
        if (Greenfoot.mouseDragged(this) && !isSliced) 
        {
            isSliced = true;
            bombFuse.stop();
        }
        
        if(isSliced)
        {
            bombExplode.play();
            animateBomb();
            
            //Ends game after bomb animation
            if (imageIndex == bomb.length) 
            {
                bombExplode.stop();
                world.removeObject(this);
                world.gameOver();
            }
        }
        else
        {
            //Bomb falls down and rotates
            world.ySpeed+=acceleration;
            double x = getX() + xSpeed;
            double y = getY() + world.ySpeed;
            super.setLocation(x, y);
            setRotation(getRotation() + 5);
            bombFuse.play();
            
            //Adds score and new object when the bomb reaches the bottom
            if(getY() >= 399)
            {
                bombFuse.stop();
                world.removeObject(this);
                world.spawnObject();
                world.increaseScore();
            }
        }
    }
}

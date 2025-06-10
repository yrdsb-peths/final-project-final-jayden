import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedBalloon here.
 * 
 * @author Li
 * @version June 2025
 */
public class RedBalloon extends SmoothMover
{
    GreenfootSound sliceSound = new GreenfootSound("fruitSlice.mp3");
    GreenfootImage halfFruit = new GreenfootImage("images/slicedApple.png");
    int xSpeed;
    static double acceleration = 0.1;
    
    //apple constructor
    public RedBalloon(int speedX)
    {
        GreenfootImage apple = new GreenfootImage("images/apple.png");
        setImage(apple);
        xSpeed = speedX;
    }
    
    public void act()
    {
        // Add your action code here.
        MyWorld world = (MyWorld) getWorld();
        
        world.ySpeed+=acceleration;
        double x = getX() + xSpeed;
        double y = getY() + world.ySpeed;
        super.setLocation(x, y);
        setRotation(getRotation() + 5);
        
        if(getY() >= 399)
        {
            world.gameOver();
        }
        
        ifSliced(halfFruit);
    }
    
    public void ifSliced(GreenfootImage fruit)
    {
        if(Greenfoot.mouseDragged(this))
        {
            MyWorld world = (MyWorld) getWorld();
            
            sliceSound.stop();
            sliceSound.play();
            
            int x = getX();
            int y = getY();
            
            world.removeObject(this);
            
            SlicedFruit piece1 = new SlicedFruit(fruit, -2, world.ySpeed);
            SlicedFruit piece2 = new SlicedFruit(fruit, 2, world.ySpeed);
            
            world.addObject(piece1, x, y);
            world.addObject(piece2, x, y);
            
            world.spawnBalloon();
            world.increaseScore();
        }
    }
}

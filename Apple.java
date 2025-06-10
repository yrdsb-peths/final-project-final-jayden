import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Apple, a fruit that the user can slice.
 * 
 * @author Li
 * @version June 2025
 */
public class Apple extends SmoothMover
{
    GreenfootSound sliceSound = new GreenfootSound("fruitSlice.mp3");
    GreenfootImage halfFruit = new GreenfootImage("images/slicedApple.png");
    
    //Speed variables
    int xSpeed;
    static double acceleration = 0.1;
    
    //apple constructor
    public Apple(int speedX)
    {
        GreenfootImage apple = new GreenfootImage("images/apple.png");
        setImage(apple);
        xSpeed = speedX;
    }
    
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        
        //Apple falls down and rotates
        world.ySpeed+=acceleration;
        double x = getX() + xSpeed;
        double y = getY() + world.ySpeed;
        super.setLocation(x, y);
        setRotation(getRotation() + 5);
        
        //Game over when apple reach the bottom
        if(getY() >= 399)
        {
            world.gameOver();
        }
        
        ifSliced(halfFruit);
    }
    
    //Checks if a fruit is sliced
    //Parameter asks for an image, half of the fruit
    public void ifSliced(GreenfootImage half)
    {
        if(Greenfoot.mouseDragged(this))
        {
            MyWorld world = (MyWorld) getWorld();
            
            //Sound plays
            sliceSound.stop();
            sliceSound.play();
            
            int x = getX();
            int y = getY();
            
            //Remove original fruit
            world.removeObject(this);
            
            SlicedFruit piece1 = new SlicedFruit(half, -2, world.ySpeed);
            SlicedFruit piece2 = new SlicedFruit(half, 2, world.ySpeed);
            
            //Spawns half of a fruit at the same position
            world.addObject(piece1, x, y);
            world.addObject(piece2, x, y);
            
            //Spawns another fruit and adds score
            world.spawnObject();
            world.increaseScore();
        }
    }
}

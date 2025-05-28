import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen.
 * 
 * @author Li
 * @version May 2025
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Pop the Balloons", 60);
    Label tutorial = new Label("Click the balloons before they", 40);
    Label tutorial2 = new Label("fly out of the screen", 40);
    Label startLabel = new Label("Press space to start", 40);
    /**
     * Constructor for objects of class TitleScreen.
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground("images/brick.jpg");
        
        addObject(titleLabel, getWidth()/2, getHeight()/2-100);
        addObject(tutorial, getWidth()/2, getHeight()/2-25);
        addObject(tutorial2, getWidth()/2, getHeight()/2+15);
        addObject(startLabel, getWidth()/2, getHeight()/2+100);
    }
    
    /**
     * The main world act loop
     */
    public void act()
    {
        // Starts the game if user presses the space bar
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
}

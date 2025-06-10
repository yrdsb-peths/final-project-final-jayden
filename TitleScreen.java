import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen.
 * 
 * @author Li
 * @version May 2025
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Fruit Ninja", 60);
    
    Rectangle tutorialRect = new Rectangle(125, 50);
    Label tutorialLabel = new Label("Tutorial", 40);
    
    Rectangle startRect = new Rectangle(75, 50);
    Label startLabel = new Label("Play", 40);
    
    /**
     * Constructor for objects of class TitleScreen.
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        GreenfootImage background = new GreenfootImage("images/titleBackground.jpg");
        background.scale(600, 400);
        setBackground(background);
        
        addObject(titleLabel, getWidth()/2, getHeight()/2-100);
        
        addObject(tutorialRect, getWidth()/2, getHeight()/2+25);
        addObject(tutorialLabel, getWidth()/2, getHeight()/2+25);
        
        addObject(startRect, getWidth()/2, getHeight()/2+100);
        addObject(startLabel, getWidth()/2, getHeight()/2+100);
    }
    
    /**
     * The main world act loop
     */
    public void act()
    {
        MouseTrail.dragTrail(this);
        
        if(Greenfoot.mouseClicked(tutorialLabel))
        {
            Greenfoot.setWorld(new Tutorial());
        }
        
        // Starts the game if user presses the space bar
        if(Greenfoot.mouseClicked(startLabel))
        {
            Greenfoot.setWorld(new MyWorld());
        }
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tutorial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tutorial extends World
{
    Label tutorial1 = new Label("Slice the fruits with your mouse", 40);
    Label tutorial2 = new Label("Don't slice bombs", 40);
    Label returnLabel = new Label("Return", 40);
    
    /**
     * Constructor for objects of class Tutorial.
     * 
     */
    public Tutorial()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        GreenfootImage background = new GreenfootImage("images/tutorialBackground.jpeg");
        background.scale(600, 400);
        setBackground(background);
        
        addObject(tutorial1, getWidth()/2, getHeight()/2-150);
        addObject(tutorial2, getWidth()/2, getHeight()/2-75);
        addObject(returnLabel, 75, 350);
    }
    
    public void act()
    {
        MouseTrail.dragTrail(this);
        
        if(Greenfoot.mouseClicked(returnLabel))
        {
            TitleScreen startWorld = new TitleScreen();
            Greenfoot.setWorld(startWorld);
        }
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tutorial world, gives instructions on how to play the game.
 * 
 * @author Li
 * @version June 2025
 */
public class Tutorial extends World
{
    //Label implementations
    Label tutorial1 = new Label("Slice the fruits with your mouse", 40);
    Label tutorial2 = new Label("before they fall to the floor", 40);
    Label tutorial3 = new Label("Don't slice bombs", 40);
    
    Rectangle returnRect = new Rectangle(100, 50);
    Label returnLabel = new Label("Return", 40);
    
    //Tutorial constructor
    public Tutorial()
    {    
        super(600, 400, 1); 
        
        //Set world background
        GreenfootImage background = new GreenfootImage("images/tutorialBackground.jpeg");
        background.scale(600, 400);
        setBackground(background);
        
        //Add objects to world
        addObject(tutorial1, getWidth()/2, getHeight()/2-150);
        addObject(tutorial2, getWidth()/2, getHeight()/2-75);
        addObject(tutorial3, getWidth()/2, getHeight()/2);
        
        addObject(returnRect, 75, 350);
        addObject(returnLabel, 75, 350);
    }
    
    //Returns to TitleScreen world when return label is clicked
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

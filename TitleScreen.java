import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen of the game.
 * 
 * @author Li
 * @version May 2025
 */
public class TitleScreen extends World
{
    //Label implementation
    Label titleLabel = new Label("Fruit Slicing", 60);
    
    Rectangle tutorialRect = new Rectangle(125, 50);
    Label tutorialLabel = new Label("Tutorial", 40);
    
    Rectangle startRect = new Rectangle(75, 50);
    Label startLabel = new Label("Play", 40);
    
    //TitleScreen constructor
    public TitleScreen()
    {   
        super(600, 400, 1); 
        
        //Set world background
        GreenfootImage background = new GreenfootImage("images/titleBackground.jpg");
        background.scale(600, 400);
        setBackground(background);
        
        //Add objects to world
        addObject(titleLabel, getWidth()/2, getHeight()/2-100);
        
        addObject(tutorialRect, getWidth()/2, getHeight()/2+25);
        addObject(tutorialLabel, getWidth()/2, getHeight()/2+25);
        
        addObject(startRect, getWidth()/2, getHeight()/2+100);
        addObject(startLabel, getWidth()/2, getHeight()/2+100);
    }
    
    //Changes the world when user cilcks on tutorial or start label
    public void act()
    {
        MouseTrail.dragTrail(this);
        
        if(Greenfoot.mouseClicked(tutorialLabel))
        {
            Greenfoot.setWorld(new Tutorial());
        }
        
        if(Greenfoot.mouseClicked(startLabel))
        {
            Greenfoot.setWorld(new MyWorld());
        }
    }
}

import greenfoot.*;

/**
 * The world where the game takes place.
 * 
 * @author Li
 * @version June 2025
 */
public class MyWorld extends World {
    //Label implementation
    Label scoreLabel;
    public int score = 0;
    
    Rectangle retryRect = new Rectangle(150, 50);
    Label retry = new Label("Try again", 40);
    
    Rectangle returnRect = new Rectangle(100, 40);
    Label home = new Label("Return", 30);
    
    //Fruit speed variables
    int xSpeed;
    double ySpeed;
    int x;
    int y;
    
    //Constructor of MyWorld
    public MyWorld() {
        super(800, 400, 1, true);
        
        //Set world background
        GreenfootImage background = new GreenfootImage("images/worldBackground.jpeg");
        background.scale(800, 400);
        setBackground(background);
        
        //add objects to world
        Apple.acceleration = 0.1;
        spawnObject();
        
        //score function
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
    }
    
    //Changes world when user cilcks on home or retry label
    public void act()
    {
        MouseTrail.dragTrail(this);
        
        if(Greenfoot.mouseClicked(retry))
        {
            Greenfoot.setWorld(new MyWorld());
        }
        
        if(Greenfoot.mouseClicked(home))
        {
            Greenfoot.setWorld(new TitleScreen());
        }
    }
    
    //This method chooses the location that the objects spawn
    public int spawnLocation()
    {
        int location = Greenfoot.getRandomNumber(3);
        ySpeed = -4 + Greenfoot.getRandomNumber(3);
        
        if(location == 0)
        {
            ySpeed = 0;
            return 100 + Greenfoot.getRandomNumber(600);
        }
        else if(location == 1)
        {
            return 800;
        }
        
        return 0;
    }
    
    //This method sets a randomized horizontal speed
    public int setXSpeed()
    {
        return 5 - Greenfoot.getRandomNumber(3);
    }
    
    //Prepares object spawn by setting the spawn location and
    //object speed
    public void prepareSpawn()
    {
        x = spawnLocation();
        y = 200 - Greenfoot.getRandomNumber(150);
        
        if(x == 0)
        {
            xSpeed = setXSpeed();
        }
        else
        {
            xSpeed = setXSpeed() * -1;
        }
        
        if(x != 0 && x != 800)
        {
            y = 0;
            xSpeed = 4 - Greenfoot.getRandomNumber(8);
        }
    }
    
    //Randomizes fruit and bomb spawning
    public void spawnObject()
    {
        int color = Greenfoot.getRandomNumber(4);
        prepareSpawn();
        
        if(color == 0)
        {
            Apple app = new Apple(xSpeed);
            addObject(app, x, y);
        }
        else if(color == 1)
        {
            Coconut coconut = new Coconut(xSpeed);
            addObject(coconut, x, y);
        }
        else if(color == 2)
        {
            Watermelon watermelon = new Watermelon(xSpeed);
            addObject(watermelon, x, y);
        }
        else if(color == 3)
        {
            Bomb bomb = new Bomb(xSpeed);
            addObject(bomb, x, y);
        }
    }
    
    //Ends the game and writes game over
    public void gameOver()
    {
        removeObjects(getObjects(null));
        Label gameOverLabel = new Label("Game Over", 100);
        Label finalScore = new Label("Final score: " + score, 50);
        
        addObject(gameOverLabel, 400, 200);
        addObject(finalScore, 400, 100);
        
        addObject(retryRect, 400, 300);
        addObject(retry, 400, 300);
        
        addObject(returnRect, 75, 350);
        addObject(home, 75, 350);
    }
    
    //Increase score and difficulty
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        
        if(score % 15 == 0)
        {
            Apple.acceleration+=0.05;
        }
    }
}

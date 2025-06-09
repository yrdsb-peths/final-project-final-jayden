import greenfoot.*;

/**
 * The world where the game takes place.
 * 
 * @author Li
 * @version June 2025
 */
public class MyWorld extends World {
    public int score = 0;
    Label scoreLabel;
    int xSpeed;
    double ySpeed;
    int y = 0;
    
    //Constructor of MyWorld
    public MyWorld() {
        super(800, 400, 1, true);
        setBackground(new GreenfootImage("images/background.jpg"));
        
        //add objects to world
        RedBalloon.acceleration = 0.1;
        spawnBalloon();
        
        //score function
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
    }
    
    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(Greenfoot.mouseDragged(null))
        {
            MouseTrail trail = new MouseTrail();
            addObject(trail, mouse.getX(), mouse.getY());
        } 
    }
    
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
    
    public int setXSpeed()
    {
        return 5 - Greenfoot.getRandomNumber(3);
    }
    
    public void createRed()
    {
        int x = spawnLocation();
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
        RedBalloon red = new RedBalloon(xSpeed);
        addObject(red, x, y);
    }
    
    public void createBlue()
    {
        int x = spawnLocation();
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
            xSpeed = setXSpeed()-1;
        }
        BlueBalloon blue = new BlueBalloon(xSpeed);
        addObject(blue, x, y);
    }
    
    public void createYellow()
    {
        int x = spawnLocation();
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
            xSpeed = setXSpeed()-1;
        }
        YellowBalloon yellow = new YellowBalloon(xSpeed);
        addObject(yellow, x, y);
    }
    
    public void createBomb()
    {
        int x = spawnLocation();
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
            xSpeed = setXSpeed()-1;
        }
        Bomb bomb = new Bomb(xSpeed);
        addObject(bomb, x, y);
    }
    
    public void spawnBalloon()
    {
        int color = Greenfoot.getRandomNumber(4);
        if(color == 0)
        {
            createRed();
        }
        else if(color == 1)
        {
            createBlue();
        }
        else if(color == 2)
        {
            createYellow();
        }
        else if(color == 3)
        {
            createBomb();
        }
    }
    
    public void gameOver()
    {
        removeObjects(getObjects(null));
        Label gameOverLabel = new Label("Game Over", 100);
        Label finalScore = new Label("Final score: " + score, 50);
        addObject(gameOverLabel, 400, 200);
        addObject(finalScore, 400, 100);
    }
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        
        if(score % 15 == 0)
        {
            RedBalloon.acceleration+=0.05;
        }
    }
}

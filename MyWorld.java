import greenfoot.*;

public class MyWorld extends World {
    public int score = 0;
    Label scoreLabel;
    int balloons = 1;
    int y = 0;
    
    public MyWorld() {
        super(800, 400, 1, true);
        setBackground(new GreenfootImage("images/background.jpg"));
        
        //add objects to world
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
        if(location == 0)
        {
            return 0;
        }
        else if(location == 1)
        {
            return 800;
        }
        return Greenfoot.getRandomNumber(800);
    }
    
    public int randomXSpeed()
    {
        return -2 + Greenfoot.getRandomNumber(4);
    }
    
    public void createRed()
    {
        int x = spawnLocation();
        if(x == 0 || x == 800)
        {
            y = 300 - Greenfoot.getRandomNumber(200);
        }
        else
        {
            y = 0;
        }
        RedBalloon red = new RedBalloon(randomXSpeed());
        addObject(red, x, y);
    }
    
    public void createBlue()
    {
        int x = spawnLocation();
        if(x == 0 || x == 800)
        {
            y = 400 - Greenfoot.getRandomNumber(200);
        }
        else
        {
            y = 0;
        }
        BlueBalloon blue = new BlueBalloon(randomXSpeed());
        addObject(blue, x, y);
    }
    
    public void createYellow()
    {
        int x = spawnLocation();
        if(x == 0 || x == 800)
        {
            y = 400 - Greenfoot.getRandomNumber(200);
        }
        else
        {
            y = 0;
        }
        YellowBalloon yellow = new YellowBalloon(randomXSpeed());
        addObject(yellow, x, y);
    }
    
    public void spawnBalloon()
    {
        for(int i = 0; i < balloons; i++)
        {
            int color = Greenfoot.getRandomNumber(3);
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
            balloons++;
        }
    }
    

}

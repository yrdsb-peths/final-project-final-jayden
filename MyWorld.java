import greenfoot.*;

public class MyWorld extends World {
    public int score = 0;
    Label scoreLabel;
    int speed = -1;
    int balloons = 1;
    
    public MyWorld() {
        super(800, 400, 1, true);
        setBackground(new GreenfootImage("images/background.jpg"));
        
        //add objects to world
        spawnBalloon();
        
        //score function
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
    }
    
    public void createRed()
    {
        RedBalloon red = new RedBalloon();
        int x = Greenfoot.getRandomNumber(800);
        int y = 400;
        addObject(red, x, y);
    }
    
    public void createBlue()
    {
        BlueBalloon blue = new BlueBalloon();
        int x = Greenfoot.getRandomNumber(800);
        int y = 400;
        addObject(blue, x, y);
    }
    
    public void createYellow()
    {
        YellowBalloon yellow = new YellowBalloon();
        int x = Greenfoot.getRandomNumber(800);
        int y = 400;
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
            speed--;
            balloons++;
        }
    }
}

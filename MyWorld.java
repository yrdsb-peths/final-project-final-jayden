import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(800, 400, 1, true);
        
        //add objects to world
        spawnBalloon();
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

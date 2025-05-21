import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(600, 400, 1, true);
        
        //add objects to world
        createRed();
        createBlue();
        createYellow();
        
        
    }
    
    public void createRed()
    {
        RedBalloon red = new RedBalloon();
        int x = Greenfoot.getRandomNumber(600);
        int y = 400;
        addObject(red, x, y);
    }
    
    public void createBlue()
    {
        BlueBalloon blue = new BlueBalloon();
        int x = Greenfoot.getRandomNumber(600);
        int y = 400;
        addObject(blue, x, y);
    }
    
    public void createYellow()
    {
        YellowBalloon yellow = new YellowBalloon();
        int x = Greenfoot.getRandomNumber(600);
        int y = 400;
        addObject(yellow, x, y);
    }
}

import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(600, 400, 1);
        
        //add objects to world
        RedBalloon balloon1 = new RedBalloon();
        addObject(balloon1, 400, 300);
        BlueBalloon balloon2 = new BlueBalloon();
        addObject(balloon2, 300, 300);
        YellowBalloon balloon3 = new YellowBalloon();
        addObject(balloon3, 200, 300);
        

    }
    
    public void addYellowBalloon()
    {
        YellowBalloon balloon4 = new YellowBalloon();
        addObject(balloon4, 500, 350);
    }
}

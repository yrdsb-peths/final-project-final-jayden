import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(600, 400, 1);
        
        RedBalloon balloon1 = new RedBalloon();
        addObject(balloon1, 300, 300);
        BlueBalloon balloon2 = new BlueBalloon();
        addObject(balloon2, 350, 300);
        YellowBalloon balloon3 = new YellowBalloon();
        addObject(balloon3, 250, 300);
    }
}

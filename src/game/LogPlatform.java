package game;

import city.cs.engine.*;

// styled bodies that player stands on
public class LogPlatform extends StaticBody {
    private static final BodyImage logImg = new BodyImage("data/l1platform.png");
    private static final Shape logShape = new PolygonShape(
            -2.173f,-0.002f, 2.05f,0.008f, 2.06f,-0.238f, 1.907f,-0.33f, -2.009f,-0.33f);

    public LogPlatform(World world, Body platform) {
        super(world, logShape);
        addImage(logImg);

    }
}

package game;

import city.cs.engine.*;

// class for item that restores life
public class Pellet extends DynamicBody {
    private static final Shape pelletShape = new PolygonShape(
            -0.114f,-0.228f, 0.119f,-0.237f, 0.241f,-0.067f, 0.008f,0.132f, -0.241f,-0.063f);
    private static final BodyImage pelletImage = new BodyImage("data/pellet.png",2);

    public Pellet(World world) {
        super(world, pelletShape);
        addImage(pelletImage);
    }
}

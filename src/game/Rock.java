package game;

import city.cs.engine.*;

// class for rock that falls and crushes player
public class Rock extends DynamicBody {
    private static final Shape rockShape = new PolygonShape(
            -0.201f,0.285f, 0.323f,0.185f, 0.45f,-0.08f, 0.442f,-0.175f, 0.22f,-0.377f, -0.196f,-0.361f, -0.538f,-0.032f);
    private static final BodyImage rockImage = new BodyImage("data/rock.png");

    public Rock(World world) {
        super(world, rockShape);
        addImage(rockImage);
    }
}

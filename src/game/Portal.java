package game;

import city.cs.engine.*;

// body of portal/door that takes player to the next level
public class Portal extends StaticBody {
    private static final BodyImage portalImage = new BodyImage("data/nportal.png", 2);
    private static final Shape portalShape = new PolygonShape(
            -0.639f,-0.692f, 0.549f,-0.98f, 0.637f,-0.816f, 0.641f,0.884f, 0.561f,0.988f, -0.643f,0.808f);

    public Portal(World world){
        super(world, portalShape);
        addImage(portalImage);
    }
}

package game;

import city.cs.engine.*;

// platforms that kill the player on impact
// implemented as class to allow them to load when saving
public class DeathPlatform extends StaticBody {

    private float width;
    private float height;

    public DeathPlatform(World world, float width, float height){
        super(world);
        Shape shape = new BoxShape(width, height);
        Fixture fixture = new SolidFixture(this, shape);
        this.width = width;
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}

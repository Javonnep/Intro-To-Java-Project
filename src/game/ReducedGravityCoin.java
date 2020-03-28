package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


// class for green hay stack
public class ReducedGravityCoin extends StaticBody {
    private static final BodyImage btcImage = new BodyImage("data/heyGreen.png");
    private static SoundClip rgcSound;
    private static final Shape btcShape = new PolygonShape(
            -0.56f, 0.5f, -0.564f, -0.498f, 0.564f, -0.5f, 0.56f, 0.493f);


    public ReducedGravityCoin(World world) {
        super(world, btcShape);
        addImage(btcImage);
    }

    static {
        try {
            rgcSound = new SoundClip("data/bite.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    @Override
    public void destroy()
    {
        Game.getControlPanel1().levelUpdated();
        Game.controlPanel1.levelUpdated();
        rgcSound.play();
        super.destroy();
    }
}

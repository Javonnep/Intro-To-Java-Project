package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

// Coin body implemented in levels 1-3, as
// well as the sound it creates when interacted with
public class Coin extends StaticBody {
    private Spitting spitting;
    private static final Shape btcShape = new PolygonShape(
            -0.56f,0.5f, -0.564f,-0.498f, 0.564f,-0.5f, 0.56f,0.493f);
    private static final BodyImage btcImage = new BodyImage("data/heyRed.png");
    private static SoundClip coinSound;


    public Coin(World world) {
        super(world, btcShape);
        addImage(btcImage);
    }

    static {
        try {
            coinSound = new SoundClip("data/bite.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    @Override
    public void destroy()
    {
        super.destroy();
        coinSound.play();
    }


}


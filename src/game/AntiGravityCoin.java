package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

// body to lower gravity
public class AntiGravityCoin extends StaticBody {
    private static final Shape btcShape = new PolygonShape(
            -0.56f,0.5f, -0.564f,-0.498f, 0.564f,-0.5f, 0.56f,0.493f);
    private static final BodyImage btcImage = new BodyImage("data/heyBlue.png");
    private static SoundClip agcSound;

    public AntiGravityCoin(World world) {
        super(world, btcShape);
        addImage(btcImage);
//      code to change gravity for playableCharacter object on line
//       of Game class
    }

    static {
        try {
            agcSound = new SoundClip("data/bite.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    
    @Override
    public void destroy() {
        agcSound.play();
        super.destroy();
    }
    
}


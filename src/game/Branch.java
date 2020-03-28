package game;

import city.cs.engine.*;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

// branch body implemented in level 3 of game, as
// well as the sound it creates when interacted with
public class Branch extends DynamicBody {
    private static final Shape branchShape = new PolygonShape(
            -0.452f,-0.059f, -0.365f,-0.106f, 0.422f,0.043f, 0.262f,0.179f, -0.091f,0.181f, -0.445f,-0.01f);
    private static final BodyImage branchImage = new BodyImage("data/branch.png",0.5f);
    private static SoundClip branchSound;

    public Branch(World world) {
        super(world, branchShape);
        addImage(branchImage);
    }

    static {
        try {
            branchSound = new SoundClip("data/branch.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    @Override
    public void destroy()
    {
        branchSound.play();
        super.destroy();
    }

}

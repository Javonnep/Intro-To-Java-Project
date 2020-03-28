package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import java.io.IOException;

// class that sends user to next level upon some completion criteria
public class DoorListener implements CollisionListener {

    private Game game;
    public DoorListener(Game game) {
        this.game = game;
    }
    @Override
    public void collide(CollisionEvent e) {
        PlayableCharacter playableCharacter = game.getPlayer();
        if (e.getOtherBody() == playableCharacter &&
                game.isCurrentLevelCompleted()) {

            System.out.println("Going to next level...");
            try {
                game.goNextLevel();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}

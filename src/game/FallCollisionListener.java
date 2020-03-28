package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

// collision listener added to bodies that kill the player and return them to the
// levels spawnpoint
public class FallCollisionListener implements CollisionListener {
    private PlayableCharacter playableCharacter;
    private Game game;

    public FallCollisionListener(PlayableCharacter playableCharacter, Game game){
        this.game = game;
        this.playableCharacter = playableCharacter;
    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() == playableCharacter){
            game.incrementDeathCount();
            System.out.println("Deathcount: " + Game.getDeathcount());

            if (Game.getLevel() == 1){
                playableCharacter.setPosition(new Vec2(0, -11));
            } else if (Game.getLevel() == 2){
                playableCharacter.setPosition(new Vec2(13.5f,-11.5f));
            } else if (Game.getLevel() == 3){
                playableCharacter.setPosition(new Vec2(-13f,-10f));
            }
        }

    }
}

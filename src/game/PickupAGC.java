package game;

import city.cs.engine.CollisionListener;
import city.cs.engine.CollisionEvent;

public class PickupAGC implements CollisionListener {
    private PlayableCharacter playableCharacter;
    private Game game;

    public PickupAGC(PlayableCharacter playableCharacter, Game game){
        this.playableCharacter = playableCharacter;
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent collisionEvent) {

        game.controlPanel1.levelUpdated();

        // code for collision with gravity reducing coin
        // once collected player has gravity reduced by 20%
        if (collisionEvent.getOtherBody() == playableCharacter){
            game.controlPanel1.levelUpdated();
            collisionEvent.getReportingBody().destroy();
            System.out.println("AntiGravityCoin obtained");
            playableCharacter.setSpecialGravity(true);
            System.out.println(playableCharacter.isSpecialGravity());
            System.out.println(playableCharacter.getGravityScale());

        }

    }
}

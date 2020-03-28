package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

// class for green hay stack
public class PickupRGC implements CollisionListener {
    private PlayableCharacter playableCharacter;
    private Game game;

    public PickupRGC(PlayableCharacter playableCharacter, Game game){
        this.playableCharacter = playableCharacter;
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent collisionEvent) {

        game.controlPanel1.levelUpdated();
        // code for collision with gravity reducing coin
        // once collected player has gravity reduced by 20%
        if (collisionEvent.getOtherBody() == playableCharacter){
            collisionEvent.getReportingBody().destroy();
            System.out.println("Gravity is now weaker");
            playableCharacter.setGravityScale(0.8f);
            System.out.println(playableCharacter.getGravityScale());
        }

    }
}

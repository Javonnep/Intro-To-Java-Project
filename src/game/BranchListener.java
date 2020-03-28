package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

// functionality of branch in game
public class BranchListener implements CollisionListener {
    private PlayableCharacter playableCharacter;
    private Game game;

    public BranchListener(PlayableCharacter playableCharacter, Game game) {
        this.playableCharacter = playableCharacter;
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() == playableCharacter){
            collisionEvent.getReportingBody().destroy();
//            playableCharacter.jump(30);
            playableCharacter.setLinearVelocity(new Vec2(0,30));
            System.out.println("the sound of a branch cracking startled you");
        }
    }
}
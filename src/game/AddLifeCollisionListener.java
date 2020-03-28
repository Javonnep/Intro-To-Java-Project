package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

// collision listener to restore life to character
public class AddLifeCollisionListener implements CollisionListener {
    private PlayableCharacter playableCharacter;
    private Game game;

    public  AddLifeCollisionListener(PlayableCharacter playableCharacter, Game game){
        this.playableCharacter = playableCharacter;
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() == playableCharacter){
            collisionEvent.getReportingBody().destroy();

            if (Game.getDeathcount() > 1){
                game.decrementDeathCount();
                System.out.println("Deathcount has reduced to: " + Game.getDeathcount());
            } else{
                System.out.println("You cant have negative lives");
            }
        }
    }
}

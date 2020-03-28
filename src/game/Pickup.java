package game;

import city.cs.engine.CollisionListener;

import city.cs.engine.CollisionEvent;

import java.util.logging.Level;

// collision logic for red hay stacks
public class Pickup implements CollisionListener {
    // class fields
    private PlayableCharacter playableCharacter;
    private Game game;

    // constructor
    public Pickup(PlayableCharacter playableCharacter, Game game){
        this.playableCharacter = playableCharacter;
        this.game = game;
    }

    // methods
    @Override
    public void collide(CollisionEvent collisionEvent) {

        if (Game.getLevel() == 1 && collisionEvent.getOtherBody() == playableCharacter){
            Level1.setLevel1items(Level1.getLevel1items()+1);
        } else if (Game.getLevel() == 2 && collisionEvent.getOtherBody() == playableCharacter){
            Level2.setLevel2items(Level2.getLevel2items()+1);
        } else if (Game.getLevel() == 3 && collisionEvent.getOtherBody() == playableCharacter){
            Level3.setLevel3items(Level3.getLevel3items()+1);
        }
        game.controlPanel1.levelUpdated();

        // coin collection code
        if (collisionEvent.getOtherBody() == playableCharacter){
            System.out.println("Coin obtained");
            collisionEvent.getReportingBody().destroy();
            playableCharacter.newItemCollected();
            System.out.println("Stacks of hay: "+ playableCharacter.getItemsCollected());
        }
    }
}

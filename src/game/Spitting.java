package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.StaticBody;

public class Spitting implements CollisionListener {
    private Projectile projectile;
    private PlayableCharacter playableCharacter;

    public Spitting(Projectile projectile, PlayableCharacter playableCharacter){
        this.projectile = projectile;
        this.playableCharacter = playableCharacter;
    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getReportingBody() == projectile && collisionEvent.getOtherBody() instanceof PlayableCharacter) {
            collisionEvent.getReportingBody().destroy();
            System.out.println("You spat on yourself :/ ");
        }
        else if (collisionEvent.getReportingBody() == projectile && collisionEvent.getOtherBody() instanceof Coin) {
            collisionEvent.getReportingBody().destroy();
            collisionEvent.getOtherBody().destroy();
            System.out.println("You spat on a stack of hay");
            playableCharacter.newItemCollected();
            if (Game.getLevel() == 1){
                Level1.setLevel1items(Level1.getLevel1items()+1);
            }
            else if (Game.getLevel() == 2){
                Level2.setLevel2items(Level2.getLevel2items()+1);
            }
            else {
                Level3.setLevel3items(Level3.getLevel3items()+1);
            }

            Game.controlPanel1.levelUpdated();
            System.out.println("Stacks of Hay: " + playableCharacter.getItemsCollected());
        }

        else if (collisionEvent.getReportingBody() == projectile && collisionEvent.getOtherBody()
                instanceof ReducedGravityCoin || collisionEvent.getOtherBody() instanceof AntiGravityCoin ){

            collisionEvent.getReportingBody().destroy();
            System.out.println("You cant spit on Green or Blue stacks of Hay!");

            Game.controlPanel1.levelUpdated();

        }

        else if (collisionEvent.getReportingBody() == projectile && collisionEvent.getOtherBody()
                instanceof LogPlatform || collisionEvent.getOtherBody() instanceof StaticBody){

            collisionEvent.getReportingBody().destroy();
            System.out.println("You cant spit on platforms");
        }

    }

}

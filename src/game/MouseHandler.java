package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class MouseHandler extends MouseAdapter {
    private static final BodyImage spitImage = new BodyImage("data/saliva.png");
    private PlayableCharacter playableCharacter;
    private WorldView view;
    private Game game;

    public MouseHandler(WorldView view, PlayableCharacter playableCharacter, Game game) {
        this.view = view;
        this.playableCharacter = playableCharacter;
        this.game = game;
    }

    /**
     * Create a bowling ball at the current mouse position.
     * @param e event object containing the mouse position
     */
    public void mousePressed(MouseEvent e) {
//        game.setSaveable(false);
        Projectile projectile = new Projectile(view.getWorld());
        projectile.addCollisionListener(new Spitting(projectile, playableCharacter));
        projectile.setPosition( new Vec2(playableCharacter.getPosition().x, playableCharacter.getPosition().y+2f));
        projectile.addImage(spitImage);

        Vec2 q = playableCharacter.getPosition();
        Vec2 p = view.viewToWorld(new Point2D.Float(e.getX(), e.getY()-2));
        Vec2 v = p.sub(q);
        v.normalize();
        projectile.setLinearVelocity(v.mul(10));

    }

    public void setBody(PlayableCharacter playableCharacter){
        this.playableCharacter = playableCharacter;
    }
}

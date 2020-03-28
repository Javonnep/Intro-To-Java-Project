package game;

import city.cs.engine.World;
import org.jbox2d.common.Vec2;

// superclass of each gamelevel to
// prevent code duplication
public abstract class GameLevel extends World {
    private PlayableCharacter playableCharacter;

    public PlayableCharacter getPlayableCharacter(){
        return playableCharacter;
    }

    public PlayableCharacter getPlayer(){
        return playableCharacter;
    }

    public void setPlayer(PlayableCharacter playableCharacter){
        this.playableCharacter = playableCharacter;
    }

    public void populate(Game game) {
        playableCharacter = new PlayableCharacter(this, 0, false, game);
        playableCharacter.setPosition(startPosition());
        Portal portal = new Portal(this);
        portal.setPosition(doorPosition());
        portal.addCollisionListener(new DoorListener(game));
    }

    public abstract Vec2 startPosition();
    public abstract Vec2 doorPosition();
    public abstract boolean isCompleted();
    public abstract int getLevel();
}


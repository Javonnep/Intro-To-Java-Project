package game;

import city.cs.engine.Body;
import city.cs.engine.DebugViewer;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

// third level of game
public class Level3 extends GameLevel {
    private static int level3items;

    public void populate(Game game) {

        game.setSaveable(true);
        level3items = Level2.getLevel2items();
        super.populate(game);
        System.out.println("Level " + Game.getLevel() + "!");
        JFrame debugView = new DebugViewer(this, 700, 700);
        System.out.println("Level 3 special controls: \n" +
                "J = super jump");

        Body platform = null;

        // branches
        Branch branch = new Branch(this);
        branch.setPosition(new Vec2(-11.5f, -10));
        branch.addCollisionListener(new BranchListener( getPlayableCharacter(), game ));

        Branch branch1 = new Branch(this);
        branch1.setPosition(new Vec2(-1.5f, -10/3));
        branch1.addCollisionListener(new BranchListener(getPlayableCharacter(), game));

        Branch branch2 = new Branch(this);
        branch2.setPosition(new Vec2(1.5f, -10/3));
        branch2.addCollisionListener(new BranchListener(getPlayableCharacter(), game));

        Branch branch3 = new Branch(this);
        branch3.setPosition(new Vec2(-11.5f, 10/3));
        branch3.addCollisionListener(new BranchListener(getPlayableCharacter(), game));

        Branch branch4 = new Branch(this);
        branch4.setPosition(new Vec2(-14.5f, 10/3));
        branch4.addCollisionListener(new BranchListener(getPlayableCharacter(), game));

        Branch branch5 = new Branch(this);
        branch5.setPosition(new Vec2(14.5f, 10/3));
        branch5.addCollisionListener(new BranchListener(getPlayableCharacter(), game));

        Branch branch6 = new Branch(this);
        branch6.setPosition(new Vec2(11.5f, 10/3));
        branch6.addCollisionListener(new BranchListener(getPlayableCharacter(), game));

        Branch branch7 = new Branch(this);
        branch7.setPosition(new Vec2(-1.5f, 10));
        branch7.addCollisionListener(new BranchListener(getPlayableCharacter(), game));

        Branch branch8 = new Branch(this);
        branch8.setPosition(new Vec2(1.5f, 10));
        branch8.addCollisionListener(new BranchListener(getPlayableCharacter(), game));

        Coin coin = new Coin(this);
        coin.setPosition(new Vec2(-13,-6));
        coin.addCollisionListener(new Pickup(getPlayableCharacter(), game));
        LogPlatform spawn = new LogPlatform(this,  platform);
        spawn.setPosition(new Vec2(-13,-10));

        // coins/ hay items
        Coin coin1 = new Coin(this);
        coin1.setPosition(new Vec2(0,(-10/3)+3));
        coin1.addCollisionListener(new Pickup(getPlayableCharacter(), game));
        LogPlatform lowerCentre = new LogPlatform(this,  platform);
        lowerCentre.setPosition(new Vec2(0,(-10/3)));

        Coin coin2 = new Coin(this);
        coin2.setPosition(new Vec2(-13,(10/3)+3));
        coin2.addCollisionListener(new Pickup(getPlayableCharacter(), game));
        LogPlatform higherLeft = new LogPlatform(this,  platform);
        higherLeft.setPosition(new Vec2(-13,(10/3)));

        Coin coin3 = new Coin(this);
        coin3.setPosition(new Vec2(13,-7));
        coin3.addCollisionListener(new Pickup(getPlayableCharacter(), game));

        Coin coin4 = new Coin(this);
        coin4.setPosition(new Vec2(13, (10/3)+3));
        coin4.addCollisionListener(new Pickup(getPlayableCharacter(), game));
        LogPlatform higherRight = new LogPlatform(this,  platform);
        higherRight.setPosition(new Vec2(13, (10/3)));

        Coin coin5 = new Coin(this);
        coin5.setPosition(new Vec2(0,13));
        coin5.addCollisionListener(new Pickup(getPlayableCharacter(), game));
        LogPlatform topCenter = new LogPlatform(this, platform);
        topCenter.setPosition(new Vec2(0,10));

        // death functionality
        DeathPlatform deathplat = new DeathPlatform(this, 400, 1);
//        Body deathplat = new StaticBody(this, death);
        deathplat.addCollisionListener(new FallCollisionListener(getPlayableCharacter(), game));
        deathplat.setPosition(new Vec2(30, -20));
        deathplat.setFillColor(Color.black);

        DeathPlatform deathplat1 = new DeathPlatform(this, 2, .1f);
//        Body deathplat1 = new StaticBody(this, deathTunnel);
        deathplat1.addCollisionListener(new FallCollisionListener(getPlayableCharacter(), game));
        deathplat1.setPosition(new Vec2(11.5f, -9));
        deathplat1.rotateDegrees(90);
        deathplat1.setFillColor(Color.black);

        DeathPlatform deathplat2 = new DeathPlatform(this, 2, .1f);
        deathplat2.addCollisionListener(new FallCollisionListener(getPlayableCharacter(), game));
        deathplat2.setPosition(new Vec2(14.5f, -9));
        deathplat2.rotateDegrees(90);
        deathplat2.setFillColor(Color.black);

        DeathPlatform deathUnder = new DeathPlatform(this, 1.95f,.1f);
        deathUnder.addCollisionListener(new FallCollisionListener(getPlayableCharacter(), game));
        deathUnder.setPosition(new Vec2(-13, 2.5f));
        deathUnder.setFillColor(Color.black);

        DeathPlatform deathUnder1 = new DeathPlatform(this, 1.95f,.1f);
        deathUnder1.addCollisionListener(new FallCollisionListener(getPlayableCharacter(), game));
        deathUnder1.setPosition(new Vec2(13, 2.5f));
        deathUnder1.setFillColor(Color.black);

        DeathPlatform deathUnder2 = new DeathPlatform(this, 1.95f,.1f);
        deathUnder2.setPosition(new Vec2(0, 9.5f));
        deathUnder2.addCollisionListener(new FallCollisionListener(getPlayableCharacter(), game));
        deathUnder2.setFillColor(Color.black);

        // death borders
        DeathPlatform deathBorder = new DeathPlatform(this, 400, .1f);
        deathBorder.addCollisionListener(new FallCollisionListener(getPlayableCharacter(), game));
        deathBorder.setPosition(new Vec2(0, 19));
        deathBorder.setFillColor(Color.black);

    }

    public static int getLevel3items() {
        return level3items;
    }

    public static void setLevel3items(int level3items) {
        Level3.level3items = level3items;
    }

    // spawn
    @Override
    public Vec2 startPosition() {
        return new Vec2(-13,-10);
    }

    // endpoint
    @Override
    public Vec2 doorPosition() {
        return new Vec2(13,-10);
    }

    @Override
    public boolean isCompleted() {
        return true;
    }

    public int getLevel() {
        return 3;
    }
}

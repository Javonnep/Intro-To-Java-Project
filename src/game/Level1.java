package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level1 extends GameLevel {
    private static int level1items = 0;

    @Override
    public void populate(Game game) {
        super.populate(game);
        game.setSaveable(true);

//        JFrame debugView = new DebugViewer(this, 700, 700);

        System.out.println("Level " + Game.getLevel() + "!");
        System.out.println("Basisic Controls: \n" +
                        "W = Jump \n" +
                        "A = Left \n" +
                        "D = Right \n" +
                        "K or S = Kill horizontal velocity");
        System.out.println("Level 1 special controls: \n" +
                "Right-click = shoot");

        // initialize platform
        Body platform = null;

        DeathPlatform bottomBarrier = new DeathPlatform(this, 400, 1);
        bottomBarrier.setFillColor(Color.black);
        bottomBarrier.addCollisionListener(new FallCollisionListener(getPlayableCharacter(), game));
        bottomBarrier.setPosition(new Vec2(5, -30));
        bottomBarrier.setFillColor(Color.black);


        // leftmid item
        Coin leftCoin = new Coin(this);
        leftCoin.setPosition(new Vec2(-6,-6));
        leftCoin.addCollisionListener(new Pickup(getPlayableCharacter(), game));

        // right mid item
        ReducedGravityCoin rightCoin = new ReducedGravityCoin(this);
        rightCoin.setPosition(new Vec2(6,-6));
        rightCoin.addCollisionListener(new PickupRGC(getPlayableCharacter(), game));

        // top item
        Coin topCoin = new Coin(this);
        topCoin.setPosition(new Vec2(0,-1));
        topCoin.addCollisionListener(new Pickup(getPlayableCharacter(), game) );

        // floor
        LogPlatform floor = new LogPlatform(this, platform);
        floor.setPosition(new Vec2(0,-11));

        // left mid staticbody
        LogPlatform platform0 = new LogPlatform(this, platform);
        platform0.setPosition(new Vec2(-6,-8));

        // right mid staticbody
        LogPlatform platform1 = new LogPlatform(this, platform);
        platform1.setPosition(new Vec2(6,-8));

        // top mid static body OR log
        LogPlatform platform2 = new LogPlatform(this,  platform);
        platform2.setPosition(new Vec2(0,-3));
    }

    public static void setLevel1items(int level1items) {
        Level1.level1items = level1items;
    }

    public static int getLevel1items() {
        return level1items;
    }

    // spawn
    public Vec2 startPosition() {
        return new Vec2(0,-11);
    }

    // endpoint
    public Vec2 doorPosition() {
        return new Vec2(10.8f, 0);
    }

    @Override
    // completion condition
    public boolean isCompleted() {
        return true;
    }

    @Override
    public int getLevel() {
        return 1;
    }
}

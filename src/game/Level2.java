package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import javafx.application.Platform;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
// second level of game
public class Level2 extends GameLevel {
    private static int level2items = Level1.getLevel1items();

    public void populate(Game game) {
        game.setSaveable(true);
        super.populate(game);
        System.out.println("Level " + Game.getLevel() + "!");
        System.out.println("Level 2 special controls: \n" +
                "Up = Anti gravity mode \n" +
                "Down = Regular Gravity mode");

        JFrame debugView = new DebugViewer(this, 700, 700);


        // death platforms
        DeathPlatform deathBorder = new DeathPlatform(this, 400, .1f);
        deathBorder.addCollisionListener(new FallCollisionListener(getPlayableCharacter(), game));
        deathBorder.setPosition(new Vec2(5, -15));
        deathBorder.setFillColor(Color.black);

        DeathPlatform deathBorder1 = new DeathPlatform(this, 400, .1f);
        deathBorder1.addCollisionListener(new FallCollisionListener(getPlayableCharacter(), game));
        deathBorder1.setPosition(new Vec2(-18, 0));
        deathBorder1.setFillColor(Color.black);
        deathBorder1.rotateDegrees(90);

        DeathPlatform deathBorder2 = new DeathPlatform(this, 400, .1f);
        deathBorder2.addCollisionListener(new FallCollisionListener(getPlayableCharacter(), game));
        deathBorder2.setPosition(new Vec2(0, 12));
        deathBorder2.setFillColor(Color.black);

        DeathPlatform deathplat = new DeathPlatform(this, 400, .1f);
        deathplat.addCollisionListener(new FallCollisionListener(getPlayableCharacter(), game));
        deathplat.setPosition(new Vec2(5, -30));
        deathplat.setFillColor(Color.black);

        // one
        DeathPlatform one = new DeathPlatform(this, 20, 0.1f);
        one.addCollisionListener(new FallCollisionListener(getPlayableCharacter(), game));
        one.setPosition(new Vec2(12,0));
        one.setFillColor(Color.black);

        DeathPlatform two = new DeathPlatform(this, 1.25f,.1f);
        two.addCollisionListener(new FallCollisionListener(getPlayableCharacter(), game));
        two.setPosition(new Vec2(9,-4.5f));
        two.setFillColor(Color.black);

        DeathPlatform three = new DeathPlatform(this, 1.25f,.1f);
        three.addCollisionListener(new FallCollisionListener(getPlayableCharacter(), game));
        three.setPosition(new Vec2(5,-7));
        three.setFillColor(Color.black);

        DeathPlatform four = new DeathPlatform(this, 1.25f,.1f);
        four.addCollisionListener(new FallCollisionListener(getPlayableCharacter(), game));
        four.setPosition(new Vec2(4, -6));
        four.setFillColor(Color.black);
        four.rotateDegrees(90);

        DeathPlatform five = new DeathPlatform(this, .1f,2);
        five.addCollisionListener(new FallCollisionListener(getPlayableCharacter(), game));
        five.setPosition(new Vec2(0,-2));
        five.setFillColor(Color.black);

        DeathPlatform six = new DeathPlatform(this, .1f,2);
        six.addCollisionListener(new FallCollisionListener(getPlayableCharacter(), game));
        six.setPosition(new Vec2(0,-10));
        six.setFillColor(Color.black);

        DeathPlatform seven = new DeathPlatform(this, 1,.1f);
        seven.addCollisionListener(new FallCollisionListener(getPlayableCharacter(), game));
        seven.setPosition(new Vec2(-1, -8));
        seven.setFillColor(Color.black);

        DeathPlatform eight  = new DeathPlatform(this, 3.5f,.1f);
        eight.addCollisionListener(new FallCollisionListener(getPlayableCharacter(), game));
        eight.setPosition(new Vec2(-8,-7));
        eight.setFillColor(Color.black);
        eight.rotateDegrees(45);

        DeathPlatform nine = new DeathPlatform(this, 6.25f,.1f);
        nine.addCollisionListener(new FallCollisionListener(getPlayableCharacter(), game));
        nine.setPosition(new Vec2(-15,-5));
        nine.setFillColor(Color.black);
        nine.rotateDegrees(135);

        DeathPlatform twelve = new DeathPlatform(this, 6.25f,.1f);
        twelve.addCollisionListener(new FallCollisionListener(getPlayableCharacter(), game));
        twelve.setPosition(new Vec2(-15,5));
        twelve.setFillColor(Color.black);
        twelve.rotateDegrees(45);

        DeathPlatform threet  = new DeathPlatform(this, 2,.1f);
        threet.addCollisionListener(new FallCollisionListener(getPlayableCharacter(), game));
        threet.setPosition(new Vec2(0,5));
        threet.setFillColor(Color.black);

        DeathPlatform fourt  = new DeathPlatform(this, 2, .1f);
        fourt.addCollisionListener(new FallCollisionListener(getPlayableCharacter(), game));
        fourt.setPosition(new Vec2(-10, 7.5f));
        fourt.setFillColor(Color.black);
        fourt.rotateDegrees(90);

        DeathPlatform fivet  = new DeathPlatform(this, 2,.1f);
        fivet.addCollisionListener(new FallCollisionListener(getPlayableCharacter(), game));
        fivet.setPosition(new Vec2(-5,2.5f));
        fivet.setFillColor(Color.black);
        fivet.rotateDegrees(90);

        DeathPlatform sixt  = new DeathPlatform(this, 2,.1f);
        sixt.addCollisionListener(new FallCollisionListener(getPlayableCharacter(), game));
        sixt.setPosition(new Vec2(5,2.5f));
        sixt.setFillColor(Color.black);
        sixt.rotateDegrees(90);

        DeathPlatform sevent  = new DeathPlatform(this, 2,.1f);
        sevent.addCollisionListener(new FallCollisionListener(getPlayableCharacter(), game));
        sevent.setPosition(new Vec2(10, 7.5f));
        sevent.setFillColor(Color.black);
        sevent.rotateDegrees(90);

        Body platform = null;
        LogPlatform platform2 = new LogPlatform(this,  platform);
        platform2.setPosition(new Vec2(13.5f,-11.5f));


        AntiGravityCoin antiGravityCoin = new AntiGravityCoin(this);
        antiGravityCoin.setPosition(new Vec2(13.5f,-7.5f));
        antiGravityCoin.addCollisionListener(new PickupAGC(getPlayableCharacter(), game));

        Coin coin1 = new Coin(this);
        coin1.setPosition(new Vec2(9,-3));
        coin1.addCollisionListener(new Pickup(getPlayableCharacter(), game));

        Coin coin2 = new Coin(this);
        coin2.setPosition(new Vec2(-1,-9));
        coin2.addCollisionListener(new Pickup(getPlayableCharacter(), game));

        for(int i = -1; i < 4; i++){
            Coin coin3 = new Coin(this);
            coin3.setPosition(new Vec2( -1 + i, 2.5f));
            coin3.addCollisionListener(new Pickup(getPlayableCharacter(), game));

            Pellet pellets = new Pellet(this);
            pellets.setPosition(new Vec2( -1 + i, 3f));
            pellets.addCollisionListener( new AddLifeCollisionListener(getPlayableCharacter(), game));
        }

        Coin coin4 = new Coin(this);
        coin4.setPosition(new Vec2(-11.5f,6));
        coin4.addCollisionListener(new Pickup(getPlayableCharacter(), game));

        Coin coin5 = new Coin(this);
        coin5.setPosition(new Vec2(9,6));
        coin5.addCollisionListener(new Pickup(getPlayableCharacter(), game));

        Rock rock = new Rock(this);
        rock.setPosition(new Vec2(-11, 7));
        rock.addCollisionListener(new FallCollisionListener(getPlayableCharacter(), game));

        Rock rock1 = new Rock(this);
        rock1.setPosition(new Vec2(9, 7));
        rock1.addCollisionListener(new FallCollisionListener(getPlayableCharacter(), game));
    }

    public static int getLevel2items() {
        return level2items;
    }

    public static void setLevel2items(int level2items) {
        Level2.level2items = level2items;
    }

    // spawn
    public Vec2 startPosition() {
        return new Vec2(13.5f,-11.5f);
    }

    // endpoint
    public Vec2 doorPosition() {
        return new Vec2(15f, 10);
    }

    @Override
    public boolean isCompleted() {
        return true;
    }

    @Override
    public int getLevel() {
        return 2;
    }


}



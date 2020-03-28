package game;

import city.cs.engine.Body;
import city.cs.engine.DebugViewer;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * class that enables you to load your progression in-game after saving
 * */
public class GameLoader {
    private String fileName;
    private  Game game;
//    static Vec2 posPlayer;
    private GameLevel gameLevel;

    public GameLoader(String fileName, Game game) {
        this.fileName = fileName;
        this.game = game;
    }

    /**
     * method to load a previous save
     * */
    public GameLevel LoadGame() throws IOException {
        FileReader fr = null;
        BufferedReader reader = null;

        try {
            System.out.println("Reading " + fileName + " data/saves.txt");

            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);

            String line = reader.readLine();
            int levelNumber = Integer.parseInt(line);

            //--------------------------------------------------------------------------------------------

            if (levelNumber == 1){
                gameLevel = new Level1();
            } else if(levelNumber == 2){
                gameLevel = new Level2();
                JFrame debugView = new DebugViewer(gameLevel, 700, 700);
            } else {
                gameLevel = new Level3();
            }

            //------------------------------------------------------------------------------------------


            while ((line = reader.readLine()) != null){
                String[] tokens = line.split(",");
                String className = tokens[0];
                float x = Float.parseFloat(tokens[1]);
                float y = Float.parseFloat(tokens[2]);
                Vec2 pos = new Vec2(x, y);
                Body platform = null;

                if (className.equals("PlayableCharacter")){
                    PlayableCharacter playableCharacter  = new PlayableCharacter(gameLevel, PlayableCharacter.getItemsCollected(),PlayableCharacter.isSpecialGravity(),game);
                    playableCharacter.setPosition(pos);
                    gameLevel.setPlayer(playableCharacter);

                }

                if (className.equals("LogPlatform")){
                    Body body = new LogPlatform(gameLevel, platform);
                    body.setPosition(pos);
                }

                if (className.equals("Coin")){
                    Body body = new Coin(gameLevel);
                    body.setPosition(pos);
                    body.addCollisionListener(new Pickup(gameLevel.getPlayableCharacter(), game));
                }

                if (className.equals("ReducedGravityCoin")){
                    Body body  = new ReducedGravityCoin(gameLevel);
                    body.setPosition(pos);
                    body.addCollisionListener(
                            new PickupRGC(gameLevel.getPlayer(), game)

                    );
                }

                if (className.equals("AntiGravityCoin")){
                    Body body  = new AntiGravityCoin(gameLevel);
                    body.setPosition(pos);
                    body.addCollisionListener(
                            new PickupAGC(gameLevel.getPlayer(), game) );
                }

                if (className.equals("Rock")){
                    Body body  = new Rock(gameLevel);
                    body.setPosition(pos);
                    body.addCollisionListener(
                            new FallCollisionListener(gameLevel.getPlayableCharacter(), game));
                }

                if (className.equals("Pellet")){
                    Body body  = new Pellet(gameLevel);
                    body.setPosition(pos);
                    body.addCollisionListener(
                            new AddLifeCollisionListener(gameLevel.getPlayer(), game));
                }

                if (className.equals("Branch")){
                    Body body = new Branch(gameLevel);
                    body.setPosition(pos);
                    body.addCollisionListener(new BranchListener(gameLevel.getPlayableCharacter(), game));
                }

                if (className.equals("Portal")){
                    Body portal = new Portal(gameLevel);
                    portal.setPosition(pos);
                    portal.addCollisionListener(new DoorListener(game));
                }

                if (className.equals("DeathPlatform")){
                    float w = Float.parseFloat(tokens[3]);
                    float h = Float.parseFloat(tokens[4]);
                    float deg = Float.parseFloat(tokens[5]);

                    Body body = new DeathPlatform(gameLevel, w, h);
                    body.setPosition(pos);
                    body.addCollisionListener(new FallCollisionListener(gameLevel.getPlayer(), game));
                    body.setFillColor(Color.black);
                    body.setAngleDegrees(deg);

                }

            }

            return gameLevel;
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
    }
}


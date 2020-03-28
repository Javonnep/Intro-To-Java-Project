package game;

import city.cs.engine.DynamicBody;
import city.cs.engine.StaticBody;

import java.io.FileWriter;
import java.io.IOException;

// class to enable game saving
public class GameSaver {

    private String fileName;
    public GameSaver(String fileName){
        this.fileName = fileName;
    }

    public void saveGame(GameLevel gameLevel) throws IOException {
        boolean append = true;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, false);
            writer.write(gameLevel.getLevel() + "\n");
            writer.write(Game.getPlayer().getPosition().x + "," +
                    Game.getPlayer().getPosition().y + "," +
                    Scoreboard.getScore() + "\n");

            for (DynamicBody body: gameLevel.getDynamicBodies()){
                writer.write(body.getClass().getSimpleName() + "," + body.getPosition().x + "," + body.getPosition().y + "\n");
            }

            for (StaticBody body: gameLevel.getStaticBodies()){
                if (body instanceof DeathPlatform){
                    writer.write(body.getClass().getSimpleName() + "," +body.getPosition().x + "," + body.getPosition().y + "," +
                            ((DeathPlatform) body).getWidth() + "," + ((DeathPlatform) body).getHeight() + "," +
                            body.getAngleDegrees() + "\n");
                }
                else  {
                    writer.write(body.getClass().getSimpleName() + "," +body.getPosition().x + "," + body.getPosition().y + "\n");

                }
            }

        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}

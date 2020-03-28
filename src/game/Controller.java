package game;

import city.cs.engine.BodyImage;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * Controller class that includes all of the functionality
 * for character movements
 *
 * @author javonne
 * */

public class Controller extends KeyAdapter {
    // fields controlling the looks of character movement
    private static final float walkSpeed = 4;
    private PlayableCharacter playableCharacter;
    private BodyImage standingLeft = new BodyImage("data/standLeft2.png",3);
    private BodyImage standingRight= new BodyImage("data/standRight2.png",3);
    private BodyImage runLeft= new BodyImage("data/test3r.gif", 3);
    private BodyImage runRight= new BodyImage("data/test3.gif", 3);
    private GameLevel currentLevel;
    private Game game;
    private Scoreboard scoreboard;

    public Controller(PlayableCharacter playableCharacter, GameLevel gameLevel, Game game){
        this.playableCharacter = playableCharacter;
        currentLevel = gameLevel;
        this.game = game;
    }


    /**
     * the method where you define what a button press does in-game
     *
     * @param keyEvent any interaction with the keyboard
     * */
    public void keyPressed(KeyEvent keyEvent){
        int code = keyEvent.getKeyCode();
        if (code == KeyEvent.VK_D){                 // walk right
            game.setSaveable(false);
            playableCharacter.removeAllImages();
            playableCharacter.addImage(runRight);
            playableCharacter.startWalking(walkSpeed);
        } else if (code == KeyEvent.VK_A) {         // walk left
            game.setSaveable(false);
            playableCharacter.removeAllImages();
            playableCharacter.addImage(runLeft);
            playableCharacter.startWalking(-walkSpeed);
            game.controlPanel1.levelUpdated();
        } else if(code == KeyEvent.VK_W) {          // jump
            game.setSaveable(false);
            playableCharacter.jump(7);
            game.controlPanel1.levelUpdated();
        } else if(code == KeyEvent.VK_UP && playableCharacter.isSpecialGravity() == true
                && playableCharacter.getGravityScale()  == 1 ) {          // change gravity
            game.setSaveable(false);
            playableCharacter.setGravityScale(-0.4f);
            game.controlPanel1.levelUpdated();
        } else if(code == KeyEvent.VK_DOWN && playableCharacter.isSpecialGravity() == true &&
            playableCharacter.getGravityScale() == -0.4f ){
            game.controlPanel1.levelUpdated();
            game.setSaveable(false);
            playableCharacter.setGravityScale(1);
        } else if(code == KeyEvent.VK_J && Game.getLevel() == 3){
            game.setSaveable(false);
            playableCharacter.jump(15);
        } else if(code == KeyEvent.VK_K || code == KeyEvent.VK_S){
            game.controlPanel1.levelUpdated();
            game.setSaveable(false);
            playableCharacter.setLinearVelocity(new Vec2(0,playableCharacter.getLinearVelocity().y));
        }



        else if(code == KeyEvent.VK_O /*&& game.isSaveable() == true*/){
            System.out.println("saving");
            GameSaver gameSaver = new GameSaver("data/saves.txt");
            try {
                gameSaver.saveGame(currentLevel);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // the aim of each level is to reach the end whilst minimising deaths,
        // if the player could save at any point in-game, it would allow them to save at a difficult obstacle and
        // reduce their deathcount by reloading when they had fewer deaths
//        else if(code == KeyEvent.VK_O && game.isSaveable() == false){
//            System.out.println("You can only save at the start of a level!");
//        }

        else if (code == KeyEvent.VK_P){
            GameLoader gameLoader = new GameLoader("data/saves.txt", game);
            try {
                GameLevel loadedGame = gameLoader.LoadGame();
                game.goToLevel(loadedGame);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (code == KeyEvent.VK_T){
            System.out.println("Scr" + Scoreboard.getScore() + "Scr" + Scoreboard.getScore() + " items" + PlayableCharacter.getItemsCollected());

        }
    }

    /**
     * a method that allows the keyEvent to end when user releases the key
     *
     * @param keyEvent the released key
     * */
    public void keyReleased(KeyEvent keyEvent){     // stop walking when button is released
        int code = keyEvent.getKeyCode();
        if (code == KeyEvent.VK_D){
            playableCharacter.stopWalking();
            playableCharacter.removeAllImages();
            playableCharacter.addImage(standingRight);
        } else if (code == KeyEvent.VK_A) {
            playableCharacter.stopWalking();
            playableCharacter.removeAllImages();
            playableCharacter.addImage(standingLeft);
        }
    }

    public void setBody(PlayableCharacter playableCharacter){
        this.playableCharacter = playableCharacter;
    }

    /**
     * equivalent to setWorld
     * */
    public void setLevel(GameLevel gameLevel){
        this.currentLevel = gameLevel;

    }

}

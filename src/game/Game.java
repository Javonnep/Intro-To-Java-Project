package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Game {

    /** The World in which the bodies move and interact. */

    private UserView view;
    private static GameLevel world;
    private static int level;
    private static Controller controller;
    private static int deathcount = 1;
    private double score;
//    private static String playerName;
    private MouseHandler mouseHandler;
    private ControlPanel controlPanel;
    private final JFrame frame;
    public static ControlPanel controlPanel1;
    private boolean saveable = true;

    /** Initialise a new Game. */
    public Game() {

        // start level 1
        level = 1;
        world = new Level1();
        world.populate(this);

        //make a view / game window
        view = new BackgroundView(world, 640, 480);

        // uncomment this to draw a 1-metre grid over the view
         view.setGridResolution(1);

        // add some mouse actions
        mouseHandler = new MouseHandler(view, getPlayer(), this);
        view.addMouseListener(mouseHandler);

        // display the view in a frame
        frame = new JFrame("A Llama doing things");
        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // GUI on right hand side of screen
        controlPanel = new ControlPanel(this);
        frame.add(controlPanel.mainPanel, BorderLayout.EAST);

        // GUI on bottom panel of screen
        controlPanel1 = new ControlPanel(this);
        frame.add(controlPanel1.testPanel, BorderLayout.SOUTH);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);

        controller = new Controller(world.getPlayableCharacter(), world, this);
        frame.addKeyListener(controller);

        // instance of focus class to allow game to have focus
        Focus focus = new Focus(frame);
        frame.requestFocus();

        // uncomment this to make a debugging view
        JFrame debugView = new DebugViewer(world, 700, 700);

        view.addMouseListener(new Focus(frame));
        frame.requestFocus();
        // start!
        world.start();
    }


    public static PlayableCharacter getPlayer() {
        return world.getPlayableCharacter();
    }

    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }

    public void goNextLevel() throws IOException {

        if (level == 3){
            world.stop();
            JDialog jDialog = new JDialog(frame, true);
            HighScore highScore = new HighScore();
            jDialog.getContentPane().add(highScore.getMainPanel());
            jDialog.pack();
            jDialog.setVisible(true);
        }

        else if (level == 2){
            world.stop();
            level++;
            controlPanel1.levelUpdated();
            world = new Level3();
            world.populate(this);
            controller.setBody(world.getPlayableCharacter());
            controller.setLevel(world);
            view.setWorld(world);
            mouseHandler.setBody(world.getPlayableCharacter());
            world.start();
        }

        else if(level == 1){
            world.stop();
            level++;
            controlPanel1.levelUpdated();
            world = new Level2();
            world.populate(this);
            controller.setBody(world.getPlayableCharacter());
            controller.setLevel(world);
            view.setWorld(world);
            mouseHandler.setBody(world.getPlayableCharacter());
            world.start();
        }
    }

    public static int getLevel() {
//        Scoreboard scoreboard = new Scoreboard(getPlayer());
//        System.out.println("Score: " + scoreboard.getScore());

        return level;

    }

    public static int getDeathcount() {
        return deathcount;
    }

    public static String getGravityType(){
        if (getPlayer().getGravityScale() == 1){
            return "Normal";
        }
        else if (getPlayer().getGravityScale() < 0){
            return "Inverse";
        }
        else {
            return "80%";
        }
    }

    public void incrementDeathCount(){
        deathcount++;
        controlPanel1.levelUpdated();
        System.out.println("idc call");
        SoundClip deathSound = null;
        try {
            deathSound = new SoundClip("data/oof.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
        deathSound.play();

        Scoreboard scoreboard = new Scoreboard(getPlayer(), this);
        System.out.println("Score: " + scoreboard.getScore());

    }

    public void decrementDeathCount(){
        deathcount--;

        Scoreboard scoreboard = new Scoreboard(getPlayer(), this);
        System.out.println("Score: " + scoreboard.getScore());
        controlPanel1.levelUpdated();
    }

    public static GameLevel getWorld() {
        return world;
    }

    public static ControlPanel getControlPanel1() {
        return controlPanel1;
    }

    public static Controller getController() {
        return controller;
    }

    public boolean isSaveable() {
        return saveable;
    }

    public void setSaveable(boolean saveable) {
        this.saveable = saveable;
    }

    public void goToLevel(GameLevel lvl){
        world.stop();
        level = lvl.getLevel();
        world = lvl;
        controller.setBody(world.getPlayableCharacter());
        controller.setLevel(lvl);
        view.setWorld(world);
        world.start();
        mouseHandler.setBody(world.getPlayableCharacter());
    }


    public double getScore() {
        return score;
    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();

    }
}
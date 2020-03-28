package game;

import city.cs.engine.BodyImage;
import city.cs.engine.UserView;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


/**
 * A class that inherits UserView and allows for custom view
 * functionality
 *
 *
 * @author Javonne
 * */
public class BackgroundView extends UserView {
    private Image background;
    private Image background2;
    private Image background3;

    /**
     * A method that contains basic information such as the world we want to affect
     * and the features (height/ weight) of it
     *
     *
     * @param world the world that you wish to manipulate
     * @param width width of bg image in px
     * @param height height of bg image in px
     *
     * @author Javonne
     * */
    public BackgroundView(World world, int width, int height) {
        super(world, width, height);
        background = new ImageIcon("data/l1background.png").getImage();
        background2 = new ImageIcon("data/background2.png").getImage();
//        background3 = new ImageIcon("data/background3.png").getImage();
        background3 = new ImageIcon("data/output-onlinepngtools.png").getImage();

    }



    /**
     * the method that you use to actively change backgrounds
     *
     * @param g a Graphics2D object that you can paint or draw on.
     *
     * @author Javonne
     * */
    @Override
    public void paintBackground(Graphics2D g) {
        if(Game.getLevel() == 1){
            g.drawImage(background, 0, 0, this);
        } else if(Game.getLevel() == 2){
            g.drawImage(background2, 0, 0, this);
        } else if(Game.getLevel() == 3){
            g.drawImage(background3, -50, 0, this);
        }
    }

    /**
     * the method that you use to actively change foregrounds
     * it will be visible over background changes
     *
     * @param g a Graphics2D object that you can paint or draw on.
     *
     * @author Javonne
     * */
    @Override
    protected void paintForeground(Graphics2D g) {
        super.paintForeground(g);
        // if level is 4
        Vec2 playerPosition = Game.getPlayer().getPosition();
        Point2D.Float playerPositionScreen = this.worldToView(playerPosition);
        g.drawString(Scoreboard.getScoreString(), playerPositionScreen.x, playerPositionScreen.y - 25);


    }



}





















//
//        if (Game.getLevel() == 1){
//                background = new ImageIcon("data/l1background.png").getImage();
//                }
//                else if (Game.getLevel() == 2){
//                background2 = new ImageIcon("data/background2.png").getImage();
//
//                }
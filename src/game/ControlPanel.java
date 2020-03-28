package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import static game.Game.decrementDeathCount;
import static game.Game.getPlayer;

public class ControlPanel extends JPanel {
    public JButton playButton;
    public JButton pauseButton;
    public JButton quitButton;
    public JPanel mainPanel;
    public Game game;
    public JPanel testPanel;
    public JButton deathcountButton;
    public JButton levelButton;
    public JButton itemsButton;
    public JButton gravityButton;
    static int dc = Game.getDeathcount();
    static int lvl = Game.getLevel();
    static int itm = getPlayer().getItemsCollected();
    static String grv = Game.getGravityType();


    public ControlPanel(Game game) {
        Scoreboard scoreboard = new Scoreboard(getPlayer(), game);

        this.game = game;
        this.testPanel = new JPanel();
        testPanel.setLayout(new GridLayout(1,4));
        this.deathcountButton = new JButton("Deathcount: " + (dc - 1));
        this.levelButton = new JButton("Level: " + lvl);
        this.itemsButton = new JButton("Hay Collected: " + itm);
        this.gravityButton = new JButton("Gravity Mode: " + grv);
        this.testPanel.add(this.deathcountButton);
        this.testPanel.add(this.levelButton);
        this.testPanel.add(this.itemsButton);
        this.testPanel.add(this.gravityButton);
        this.add(this.testPanel);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Game.getWorld().start();
            }
        });
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Game.getWorld().stop();
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }

    public void levelUpdated(){
        dc = Game.getDeathcount();
        lvl = Game.getLevel();
        itm = getPlayer().getItemsCollected();
        grv = Game.getGravityType();

        this.deathcountButton.setText("Deathcount: " + (dc - 1));
        this.levelButton.setText("Level: " + lvl);
        this.itemsButton.setText("Hay Collected: " + itm);
        this.gravityButton.setText("Gravity Mode: " + grv);
     }
}

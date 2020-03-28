package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class HighScore {
    private JPanel mainPanel;
    private JPanel bottomPanel;
    private JLabel PlayerName;
    private JTextField nameInput;
    private JLabel score;
    private JLabel scoreOutput;
    private JButton saveButton;
    private JButton dontSaveButton;
    private JList<String> scoreList;
    private JScrollPane scrollPane;
    private HighScoreWriter highScoreWriter;
    private HighScoreReader highScoreReader;



    public HighScore() {
        score.setText(Scoreboard.getScoreString());

        highScoreWriter = new HighScoreWriter("data/score.txt");
        highScoreReader = new HighScoreReader("data/score.txt");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    highScoreWriter.writeHighScore(nameInput.getText(), (int) Scoreboard.getScore());
                } catch (IOException e) {

                }
                System.exit(0);

            }
        });

        dontSaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);

            }
        });

        DefaultListModel<String> model = new DefaultListModel<>();
        try {
            model.addAll(highScoreReader.readScores());
        } catch (IOException e) {
            e.printStackTrace();
        }

        scoreList.setModel(model);



    }

    public JPanel getMainPanel(){
        return mainPanel;
    }
}

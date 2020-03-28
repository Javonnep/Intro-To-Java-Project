package game;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// class to allow gameworld to attract focus over GUI
public class Focus implements MouseListener {
    private Component target;

    public Focus(Component target) {
        this.target = target;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        target.requestFocus();
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}

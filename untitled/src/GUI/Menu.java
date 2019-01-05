package GUI;

import GUI.Logic.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Menu extends JPanel implements KeyListener, MouseListener {
    Frame frame;
    int p = 0;
    Rectangle r = new Rectangle(75, 100, 315, 140);
    private Image menuI = Resources.getImage("/gui/Images/MENU.png"), Party = Resources.getImage("/gui/Images/Party.png");

    public Menu(Frame pframe) {
        frame = pframe;
        this.addKeyListener(this);
        this.addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
            g.drawImage(menuI, 0, 0, 960, 714, null);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //if (e.getKeyCode() == KeyEvent.VK_ESCAPE) frame.switchPanel(frame.r1, this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) frame.switchPanel(frame.r1, this);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (r.contains(e.getPoint())) {

            frame.switchPanel(frame.p1, frame.r1);

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

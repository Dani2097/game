package GUI;

import GUI.Logic.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Menu extends JPanel implements KeyListener {
    Frame frame;
    private Image menuI = Resources.getImage("/gui/Images/MENU.png");

    public Menu(Frame pframe) {
        frame = pframe;
        this.addKeyListener(this);


    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(menuI, 0, 0, 960, 714, null);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) frame.switchPanel(frame.r1, this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) frame.switchPanel(frame.r1, this);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

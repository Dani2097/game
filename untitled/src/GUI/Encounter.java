package GUI;

import Entities.Pokemon;
import GUI.Logic.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Encounter extends JPanel implements KeyListener {
    Frame frame;
    Image bg = Resources.getImage("/gui/Images/encounter.png");
    Image pokemon;
    public Pokemon P;
    private Font font,font1;

    public Encounter(Frame pframe) {
        P = new Pokemon();
        frame = pframe;
        font = new Font("Rockwell Extra Bold", 1, 25);font1 = new Font("Rockwell Extra Bold", 1, 20);
        this.addKeyListener(this);
        this.setSize(frame.width, frame.height);

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.white);
        pokemon = Resources.getImage("/gui/Images/Sprite" + P.sprite + ".png");
        g.fillRect(0, 0, 960, 960);
        g.drawImage(bg, 0, 180, 960, 563, null);
        g.drawImage(pokemon, 650, 200, 130, 130, null);
        g.setFont(font);
        g.drawString( P.name, 20, 230); g.setFont(font1);
        g.drawString("Lv. " + P.level, 320, 230);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) frame.switchPanel(frame.r1, this);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}



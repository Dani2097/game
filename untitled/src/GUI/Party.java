package GUI;

import Entities.Player;
import GUI.Logic.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Party extends JPanel implements KeyListener {
    Frame frame;
    float width;
    Player player;
    Font font,font1;
    public Party(Frame pframe){
        frame=pframe;
        player=frame.r1.p1;

        this.setSize(frame.width, frame.height);
        this.setLocation(0, 0);
        this.addKeyListener(this);
        font = new Font("Rockwell Extra Bold", 1, 20);
        font1 = new Font("Rockwell", 1, 15);
    }
    private Image partyI= Resources.getImage("/gui/Images/Party.png"),pokemon1;

    @Override
    public void paint(Graphics g) {
        pokemon1 = Resources.getImage("/gui/Images/Sprite" + player.pokemonTeam[0].sprite + "/a.png");

        g.setColor(Color.black);
        g.fillRect(0,0,960,960);
        g.drawImage(partyI,-10,100,960,714,null);
        g.drawImage(pokemon1,60,230,80,80,null);
        g.setColor(Color.red);
        g.fillRect(150 ,280,200,10);
        g.setColor(Color.white);   g.drawRect(150 ,280,200,10);
        g.setFont(font);
        g.drawString(""+ player.pokemonTeam[0].name+" lv."+ player.pokemonTeam[0].level,150,270);
        player.pokemonTeam[0].setHitPoint();
        g.setFont(font1);
        g.drawString(""+(int)player.pokemonTeam[0].healthpoint+"/"+(int)player.pokemonTeam[0].healthpointMax,300,310);
        g.setColor(Color.green);
        width=200*(player.pokemonTeam[0].healthpoint/player.pokemonTeam[0].healthpointMax);
        g.fillRect(150 ,280, (int)width,10);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
if (e.getKeyCode()==KeyEvent.VK_ENTER)frame.switchPanel(frame.r1,this);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}

package GUI;

import Entities.Pokemon;
import GUI.Logic.HotArea;
import Entities.Player;
import GUI.Logic.Resources;

import javax.swing.*;
import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Route1 extends JPanel implements KeyListener, MouseListener {//tile 1,13;1,14
    Frame frame;
    public int c = 0, l = 0, prova, misura = 48, pokemonR1 = 3;
    private int[] id, levelR1;
   private Image bg = Resources.getImage("/gui/Images/biancavilla.png"), tettoMK = Resources.getImage("/gui/Images/casaalto.png"), bassomk = Resources.getImage("/gui/Images/casabasso.png"),casaup= Resources.getImage("/gui/Images/casaalto.png"), casadown = Resources.getImage("/gui/Images/casabasso.png");
    public Player p1;
    HotArea[][] tileset;
    private Scanner file = null;
    public int collide = 0;
    Pokemon pokemon;
    private boolean grid = false;

    Route1(Frame pframe) {

        this.addKeyListener(this);
        this.addMouseListener(this);
        tileset = new HotArea[misura][misura];

        id = new int[pokemonR1];
        id[0] = 0;
        id[1] = 1;
        id[2] = 2;
        levelR1 = new int[5];
        levelR1[0] = 6;
        levelR1[1] = 7;
        levelR1[2] = 9;
        prova = (int) 3 / 2;
        System.out.println("" + prova);
        for (int i = 0; i < misura; i++) {
            for (int j = 0; j < misura; j++) {
                tileset[i][j] = new HotArea();
                tileset[i][j].x = 20 * i;
                tileset[i][j].y = 20 * j;
                tileset[i][j].width = tileset[i][j].height = 20;
            }
        }
        frame = pframe;
        p1 = new Player(frame);
        p1.x = 360;
        p1.y = 240;
        p1.sprite = Resources.getImage("/gui/Images/Sprite.png");
        ;
        pokemon = frame.getPokemonById(0);
        this.setSize(frame.width, frame.height);
        this.setLocation(0, 0);
        p1.sotto();
        this.scratch("prova.txt", tileset);
        System.out.println("l'id e' :" + pokemon.id + " il nome e':" + pokemon.name);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bg, 0, 0, frame.width, frame.height, null);
        g.drawImage(bassomk, 580 + 100, 123 + 91, 190, 123, null);
        g.drawImage(bassomk,   100+140, 123 + 91, -190, 123, null);
        g.drawImage(p1.sprite, p1.x, p1.y, p1.x + p1.width, p1.y + p1.width, c * 64, l * 64, 64 * (c + 1), 64 * (l + 1), null);
        g.drawImage(tettoMK, 580 + 100, 91, 190, 123, null);
        g.drawImage(tettoMK,  100+140, 91, -190, 123, null);
//        g.drawImage(boh,200,200,400,400,null);
        if (grid) {
            for (int i = 0; i < misura; i++) {
                for (int j = 0; j < misura; j++) {

                    tileset[i][j].paintID(g);

                }
            }

            for (int i = 0; i < frame.width / 20; i++) g.drawLine(0, 20 * i, frame.width, 20 * i);
            for (int i = 0; i < frame.width / 20; i++) g.drawLine(20 * i, 0, 20 * i, frame.height);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_F1) {
            if (!grid) grid = true;
            else grid = false;
        }
        if (key == KeyEvent.VK_BACK_SPACE) {
            p1.setPokemonTeam(1, 0);
            p1.setpokemonTeamLevel(54, 0);
            System.out.println(p1.pokemonTeam[0].hp);
        }
        if (key == KeyEvent.VK_ALT) {
            p1.setPokemonTeam(2, 0);

            p1.setpokemonTeamLevel(54, 0);
        }
        if (key == KeyEvent.VK_ESCAPE) frame.switchPanel(frame.menu, this);
        if (key == KeyEvent.VK_LEFT) {
            c++;
            if (c == 4) c = 0;
            l = 1;
            tileset[p1.px - 3][p1.py].eventtile(p1, frame, id, levelR1, this);
            if (!(tileset[p1.px - 3][p1.py].id_tile == 1)) {
                p1.sinistra();
            }
            repaint();
        }

        if (key == KeyEvent.VK_RIGHT) {
            c++;
            if (c == 4) c = 0;
            l = 2;
            tileset[p1.px][p1.py].eventtile(p1, frame, id, levelR1, this);
            if (!(tileset[p1.px][p1.py].id_tile == 1))
                p1.destra();

            repaint();
        }

        if (key == KeyEvent.VK_UP) {
            c++;
            if (c == 4) c = 0;
            l = 3;
            tileset[p1.px - 2][p1.py - 1].eventtile(p1, frame, id, levelR1, this);
            if (!(tileset[p1.px - 2][p1.py - 1].id_tile == 1) && !(tileset[p1.px - 1][p1.py - 1].id_tile == 1))
                p1.sopra();
            repaint();
        }

        if (key == KeyEvent.VK_DOWN) {
            c++;
            if (c == 4) c = 0;
            l = 0;
            tileset[p1.px - 2][p1.py + 1].eventtile(p1, frame, id, levelR1, this);
            if (!(tileset[p1.px - 2][p1.py + 1].id_tile == 1) && !(tileset[p1.px - 1][p1.py +1].id_tile == 1))
                p1.sotto();

            repaint();
        }
        if (key == KeyEvent.VK_SPACE) {
            frame.saveAllID(tileset, misura);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (int i = 0; i < misura; i++) {
            for (int j = 0; j < misura; j++) tileset[i][j].setId_tile(e);

        }

        repaint();
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


    public void scratch(String prova, HotArea[][] tileset) {

        try {
            this.file = new Scanner(new File(prova));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < misura - 1; i++) {

            String line = this.file.nextLine();

            for (int j = 0; j < misura - 1; j++) {

                if (Integer.parseInt(line.substring(j, j + 1)) != 0) {

                    tileset[j][i].id_tile = Integer.parseInt(line.substring(j, j + 1));

                    this.collide++;
                }

            }
        }
    }
}

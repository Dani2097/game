package GUI.Logic;

import Entities.Player;
import GUI.Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.Random;

public class HotArea extends Rectangle {
    public Image sprite;
    public int id_tile = 0;
    public int nx, ny;

    public void setId_tile(MouseEvent e) {
        nx = this.x / 20;
        ny = (int) this.y / 20;
        if (this.contains(e.getPoint())) {


            this.id_tile++;
            if (id_tile > 3) id_tile = 0;

            System.out.println("id of the tile[" + nx + "][ " + ny + "]" + this.id_tile);
            System.out.println("tilex " + x + "tiley" + y);

        }
    }

    public void eventtile(Player p1, Frame frame,int[] id,int[]level,JPanel route) {
        switch (id_tile) {
            case 1:
                break;
            case 2:
                if (p1.playerInTheGrass()) {
                Random r = new Random();
                frame.ec.P  = frame.getPokemonById(id[r.nextInt(3)]);
                frame.ec.P.level=level[r.nextInt(3)];
                //System.out.println("Encounter"+pokemon.sprite);

                    frame.ec.initializate();

                frame.switchPanel(frame.ec, route);

            } else System.out.println("not Encounter");
                break;
        }
    }
    public void paintID(Graphics g) {
        switch (id_tile) {
            case 1:
                g.setColor(Color.red);
                g.fillRect(this.x, this.y, 20, 20);
                break;
            case 2:
                g.setColor(Color.blue);
                g.fillRect(this.x, this.y, 20, 20);
                break;
            case 3:
                g.setColor(Color.green);
                g.fillRect(this.x, this.y, 20, 20);
        }
    }
}


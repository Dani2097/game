package GUI.Logic;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.*;

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
            System.out.println("tilex "+x+"tiley" + y);

        }
    }
    public void paintID(Graphics g){
        switch (id_tile){
            case 1:
                g.setColor(Color.red);

                g.fillRect(this.x, this.y, 20, 20);

break;
            case 2:
                g.setColor(Color.blue);

                g.fillRect(this.x, this.y, 20, 20);
        }
    }
}


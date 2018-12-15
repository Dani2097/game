package GUI;

import GUI.Logic.HotArea;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Frame extends JFrame {
    public int width = 960, height = 960;
    Route1 r1 = new Route1(this);

    public Frame() {

        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().add(r1);
        r1.setVisible(true);
        r1.setFocusable(true);
        r1.requestFocus();
    }
    public void saveAllID(HotArea[][] _tileset, int _n) {
        try {
            FileOutputStream prova = new FileOutputStream("prova.txt");
            PrintStream scrivi = new PrintStream(prova);
            for (int i = 0; i < _n; i++) {
                for (int j = 0; j < _n; j++) {
                    if (j == _n-1) scrivi.println( + _tileset[j][i].id_tile);
                    else {
                        scrivi.print( + _tileset[j][i].id_tile);
                        System.out.println("Saving...");
                    }

                }
            }
        } catch (IOException f) {
            System.out.println("Errore: " + f);
            System.exit(1);
        }
    }

}

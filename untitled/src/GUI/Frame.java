package GUI;

import Entities.Pokemon;
import GUI.Logic.HotArea;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Frame extends JFrame {
    public int width = 960, height = 960;
    Route1 r1 = new Route1(this);
    Encounter ec = new Encounter(this);
    Menu menu=new Menu(this);
    int[] levelR1;
    public Frame() {

        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().add(r1);
        this.getContentPane().add(ec);this.getContentPane().add(menu);
        menu.setVisible(false);
        ec.setVisible(false);
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
                    if (j == _n - 1) scrivi.println(+_tileset[j][i].id_tile);
                    else {
                        scrivi.print(+_tileset[j][i].id_tile);
                        System.out.println("Saving...");
                    }

                }
            }
        } catch (IOException f) {
            System.out.println("Errore: " + f);
            System.exit(1);
        }
    }

    public void switchPanel(JPanel toActive, JPanel toDisable) {
        toDisable.setVisible(false);
        toDisable.setFocusable(false);
        toActive.setVisible(true);
        toActive.setFocusable(true);
        toActive.requestFocus();
    }

    public Pokemon getPokemonById(int id) {
        Scanner file = null;
        String line;
        try {
            file = new Scanner(new File("Pokedex.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10 * id; i++)    line =file.nextLine();
        Pokemon p = new Pokemon();

        int k;


         line = file.nextLine();
        p.id = Integer.parseInt(line.substring(3, 3 + 1));
        line = file.nextLine();
        k = Integer.parseInt(line.substring(11, 12));
        line = file.nextLine();
        p.name = line.substring(5, 5 + k);
        line = file.nextLine();
        p.captureRate = Integer.parseInt(line.substring(12, 14));
        line = file.nextLine();
        p.experienceGrowth = Integer.parseInt(line.substring(17, 20));
        line = file.nextLine();
        p.type = Integer.parseInt(line.substring(5, 6));
        line = file.nextLine();
        p.moveset = Integer.parseInt(line.substring(8, 9));
        line = file.nextLine();
        p.sprite = Integer.parseInt(line.substring(7, 8));
        line = file.nextLine();
        p.hp = Integer.parseInt(line.substring(10, 12));

        p.attack = Integer.parseInt(line.substring(13, 15));

        return p;
    }

}

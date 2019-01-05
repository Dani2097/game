package GUI;

import Entities.Moves;
import Entities.Pokemon;
import GUI.Logic.HotArea;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Frame extends JFrame {
    public int width = 960, height = 960,moveset=0;
    public Route1 r1 = new Route1(this);
    public Encounter ec = new Encounter(this);
     Party p1=new Party(this);
    Menu menu = new Menu(this);
    int[] levelR1;

    public Frame() {

        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().add(r1);
        this.getContentPane().add(ec);
        this.getContentPane().add(p1);
        this.getContentPane().add(menu);
        menu.setVisible(false);
        p1.setVisible(false);
        ec.setVisible(false);
        r1.setVisible(true);
        r1.setFocusable(true);
        r1.requestFocus();
    }
//    public JPanel getActiveRoute

    public void saveAllID(HotArea[][] _tileset, int _n) {
        try {
            FileOutputStream prova = new FileOutputStream("prova.txt");
            PrintStream scrivi = new PrintStream(prova);
            for (int i = 0; i < _n; i++) {
                for (int j = 0; j < _n; j++) {
                    if (j == _n - 1) {
                        scrivi.println(+_tileset[j][i].id_tile);
                        System.out.println("Saving...");
                    } else {
                        scrivi.print(+_tileset[j][i].id_tile);

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
        for (int i = 0; i < 10 * id; i++) line = file.nextLine();
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
        for(int i=0;i<4;i++)
        p.moveset[i] = Integer.parseInt(line.substring(8+2*i, 9+2*i));
        line = file.nextLine();
        p.sprite = Integer.parseInt(line.substring(7, 8));
        line = file.nextLine();
        p.hp = Integer.parseInt(line.substring(10, 12));

        p.attack = Integer.parseInt(line.substring(13, 15));
        p.defence = Integer.parseInt(line.substring(16, 18));
        p.Sattak = Integer.parseInt(line.substring(19, 21));
        p.Sdefene = Integer.parseInt(line.substring(22, 24));

        p.speed= Integer.parseInt(line.substring(25, 27));

        return p;
    }

}

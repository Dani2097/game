package Entities;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Pokemon {
    public int id, captureRate, experienceGrowth, type, sprite, hp, attack,effectiveAtk, level, defence,effectiveDfs, Sattak, Sdefene, speed;
    public float healthpoint, healthpointMax,damage;
    public String name;
    public int[] id_moves, moveset=new int[4];
    public Moves[] moves =new Moves[4];
    public void Pokemon() {
        id_moves=new int[4];
        setHitPoint();
        System.out.println(hp);

    }
public void statsCalculator(){
        effectiveAtk=(attack*2*level)/100+5;
    effectiveDfs=(defence*2*level)/100+5;

}
    public void setMoves(Moves moves,int n) {
        this.moves[n] = moves;
    }

    public void setHitPoint() {
        healthpoint =    healthpointMax = (hp * 2 * level / 100) + level + 10;
        healthpoint = healthpointMax;
    }
    public Moves getMovesById(int id) {
        Scanner file = null;
        String line;
        try {
            file = new Scanner(new File("moves.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 8 * id; i++) line = file.nextLine();
        Moves m = new Moves();

        int k;



        line = file.nextLine();
        k = Integer.parseInt(line.substring(11, 12));
        line = file.nextLine();
        m.name = line.substring(5, 5 + k);
        line = file.nextLine();
        m.type = Integer.parseInt(line.substring(5, 6));
        line = file.nextLine();
        m.power = Integer.parseInt(line.substring(8, 11));
        line = file.nextLine();
        m.accuracy = Integer.parseInt(line.substring(11, 12));
        line = file.nextLine();
        m.priority = Integer.parseInt(line.substring(9,10));
        line = file.nextLine();
        m.side = Integer.parseInt(line.substring(18, 19));

        return m;
    }

}

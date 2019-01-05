package Entities;

import GUI.Frame;
import GUI.Logic.HotArea;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Player extends HotArea {
    int speed = 20;
    public int py, width = 80;
    public int px, height = 80;
    public Pokemon[] pokemonTeam;
    Frame frame;

    public Player(Frame pframe) {
        frame = pframe;
        pokemonTeam = new Pokemon[6];
        setPokemonTeam(0, 0);
        calcolapxpy();
        setpokemonTeamLevel(20, 0);
        pokemonTeam[0].setMoves(pokemonTeam[0].getMovesById(0),0);
        pokemonTeam[0].setMoves(pokemonTeam[0].getMovesById(1),1);
        pokemonTeam[0].setMoves(pokemonTeam[0].getMovesById(2),2);
        pokemonTeam[0].setMoves(pokemonTeam[0].getMovesById(3),3);
        pokemonTeam[0].setHitPoint();
    }

    public void setpokemonTeamLevel(int level, int change) {
        pokemonTeam[change].level = level;
    }

    public void setPokemonTeam(int id, int change) {
        pokemonTeam[change] = frame.getPokemonById(id);

    }

    public void sotto() {
        y += speed;
        calcolapxpy();
    }

    public void sopra() {
        y -= speed;
        calcolapxpy();

    }

    public void sinistra() {

        x -= speed;
        calcolapxpy();

    }

    public void destra() {
        x += speed;


        calcolapxpy();

    }

    public void calcolapxpy() {
        px = (int) (x + 60) / 20;

        py = (int) (y + 60) / 20;
    }

    public boolean playerInTheGrass() {

        Random r = new Random();
        return (r.nextInt() % 2 == 0) && (r.nextInt() % 2 == 0);

    }

}

package Entities;

import GUI.Logic.HotArea;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Player extends HotArea {
    int speed = 20;
    public int py, width = 80;
    public int px, height = 80;
    Pokemon[] pokemonTeam;
    public Player() {
        pokemonTeam=new Pokemon[6];
        calcolapxpy();
    }

    public void sotto() {

        y += speed;
        calcolapxpy();



    }

    public void sopra() {y -= speed;
        calcolapxpy();

    }

    public void sinistra() {

        x -= speed;
        calcolapxpy();

    }

    public void destra() {
        x+= speed;


        calcolapxpy();

    }
    public void calcolapxpy(){
        px = (int) (x + 60) / 20;

        py = (int) (y + 60) / 20;
    }
   public boolean playerInTheGrass(){

       Random r=new Random();
      return(r.nextInt()%2==0)&&(r.nextInt()%2==0);

   }

}

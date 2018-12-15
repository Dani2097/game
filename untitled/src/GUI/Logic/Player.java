package GUI.Logic;

import java.util.Random;

public class Player extends HotArea {
    int speed = 20;
    public int py, width = 80;
    public int px, height = 80;

    public Player() {

        calcolapxpy();
    }

    public void sotto() {

        y += speed;
        calcolapxpy();


        System.out.println("griglia " + px + ";" + py);
    }

    public void sopra() {y -= speed;
        calcolapxpy();
         System.out.println("griglia " + px + ";" + py);
    }

    public void sinistra() {

        x -= speed;
        calcolapxpy();
        System.out.println("griglia " + px + ";" + py);
    }

    public void destra() {
        x+= speed;


        calcolapxpy();
        System.out.println("griglia " + px + ";" + py);
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

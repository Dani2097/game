package GUI;

import Entities.Player;
import Entities.Pokemon;
import GUI.Logic.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Encounter extends JPanel implements KeyListener, MouseListener {
    private Rectangle fight = new Rectangle(600, 620, 140, 55),
            attack1 = new Rectangle(20, 630, 250, 50),
            attack2 = new Rectangle(280, 630, 250, 50),
            attack3 = new Rectangle(20, 680, 250, 50),
            attack4 = new Rectangle(280, 680, 250, 50);
    private Frame frame;
    private Image gui = Resources.getImage("/gui/Images/encounter1.png"), guiB = Resources.getImage("/gui/Images/encounterBottom.png"), bg = Resources.getImage("/gui/Images/sfondo foresta.jpg");
    private Image front, back, bottom, move1, move2, move3, move4;
    public Pokemon P, P1;
    private Font font, font1, font2;
    public Player p1;
    float width, width1, damage;
    public int opacity = 0, opacity1 = 0, xWild = 1050, click = 0;
    public boolean playerTurn = true, showMessage = true, another = false;
    public String inizio, attacco, mossa, message;
    public Timer tAnim = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            xWild -= 4;
            opacity++;

            repaint();
            if (opacity == 100) {
                tAnim.stop();
            }
        }
    }), t1 = new Timer(1, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            opacity1 += 10;
            repaint();
            if (opacity1 == 100) {
                t1.stop();
            }
        }
    }), thp = new Timer(1, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            P.healthpoint = P.healthpoint - damage / 50;
            counter += 2;
            if (P.healthpoint <= 0) {

                JOptionPane.showMessageDialog(null, "You won");
                frame.switchPanel(frame.r1, frame.ec);
            }


            repaint();
            if ((counter == 100) || (P.healthpoint <= 0)) {
                thp.stop();
            }
        }
    }),
            thwp = new Timer(1, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    p1.pokemonTeam[0].healthpoint = p1.pokemonTeam[0].healthpoint - damage / 50;
                    counter += 2;
                    if (p1.pokemonTeam[0].healthpoint <= 0) {

                        JOptionPane.showMessageDialog(null, "You won");
                        frame.switchPanel(frame.r1, frame.ec);
                    }
                    frame.r1.p1.pokemonTeam[0].healthpoint=p1.pokemonTeam[0].healthpoint;

                    repaint();
                    if ((counter == 100) || (p1.pokemonTeam[0].healthpoint <= 0)) thwp.stop();
                }
            });
    int counter = 0;

    public void setFront() {
        front = Resources.getImage("/gui/Images/Sprite" + P.sprite + "/a.png");
    }

    public void setBack() {
        back = Resources.getImage("/gui/Images/Sprite" + p1.pokemonTeam[0].sprite + "/b.png");
    }

    public Encounter(Frame pframe) {

        P = new Pokemon();
        frame = pframe;
        p1 = frame.r1.p1;
        bottom = Resources.getImage("/gui/Images/ecinfo.png");
        setFront();
        back = Resources.getImage("/gui/Images/Sprite" + p1.pokemonTeam[0].sprite + "/b.png");
        font2 = new Font("Rockwell Extra Bold ", Font.PLAIN, 25);
        font = new Font("Agency Extra Bold FB", Font.BOLD, 25);
        font1 = new Font("Agency FB", Font.BOLD, 20);
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.setSize(frame.width, frame.height);
        move1 = Resources.getImage("/gui/Images/moves/" + p1.pokemonTeam[0].moves[0].name + ".png");
        move2 = Resources.getImage("/gui/Images/moves/" + p1.pokemonTeam[0].moves[1].name + ".png");
        move3 = Resources.getImage("/gui/Images/moves/" + p1.pokemonTeam[0].moves[2].name + ".png");
        move4 = Resources.getImage("/gui/Images/moves/" + p1.pokemonTeam[0].moves[3].name + ".png");
    }

    @Override
    protected void paintComponent(Graphics g) {

        g.setColor(new Color(43, 47, 12, 255));
        g.fillRect(0, 0, 960, 960);
        g.fillRect(600, 620, 140, 55);
//        g.setColor(Color.white);
        g.fillRect(0, 0, 960, 960);
        g.drawImage(bg, 0, 180, 942, 563, null);
        this.paintCmponents((Graphics2D) g);
        //g.fillRect(280, 680, 250, 50);
    }

    protected void paintCmponents(Graphics2D g) {

        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1 * (float) opacity / 100));
        g.setColor(Color.white);
        g.drawImage(gui, 0, 180, 960, 563, null);
        g.drawImage(guiB, 0, 613, 942, 134, null);

        g.drawImage(front, xWild, 200, 130, 130, null);
        g.setFont(font);
        g.drawString(P.name, 20, 230);
        g.setFont(font1);
        g.drawString("Lv. " + P.level, 320, 230);
        g.drawImage(back, 180, 465, 220, 145, null);
        g.setFont(font);
        g.drawString(p1.pokemonTeam[0].name, 580, 527);
        g.setFont(font1);
        g.drawString("Lv. " + p1.pokemonTeam[0].level, 850, 527);
        g.drawString("" + (int) p1.pokemonTeam[0].healthpoint + "/" + (int) p1.pokemonTeam[0].healthpointMax, 820, 580);
        g.setColor(Color.red);
        g.fillRect(580, 540, 300, 10);
        g.setColor(Color.white);
        g.drawRect(20, 260, 300, 10);
        g.drawRect(580, 540, 300, 10);
        width = 300 * p1.pokemonTeam[0].healthpoint / p1.pokemonTeam[0].healthpointMax;
        width1 = 300 * P.healthpoint / P.healthpointMax;
        g.setColor(Color.green);
        g.fillRect(580, 540, (int) width, 10);
        g.fillRect(20, 260, (int) width1, 10);
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1 * (float) opacity1 / 100));

        g.drawImage(move1, 20, 630, 250, 50, null);
        g.drawImage(move2, 280, 630, 250, 50, null);
        g.drawImage(move3, 20, 680, 250, 50, null);
        g.drawImage(move4, 280, 680, 250, 50, null);
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
        g.setFont(font2);
        g.setColor(Color.white);
        if (showMessage) {
            g.drawImage(bottom, 0, 603, 942, 150, null);
            g.drawString(message, 20, 640);
        }
    }

    public void damageCalculator(int levelA, int power, int attackA, int defenceA) {
        damage = (float) ((2 * levelA / 5 + 2) * power * attackA / defenceA) / 50 + 2;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) frame.switchPanel(frame.r1, this);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void initializate() {
        counter=0;
        p1.pokemonTeam[0].statsCalculator();
        P.statsCalculator();
        P.setHitPoint();
        setPMoves();
        setBack();
        setFront();
        opacity = 0;
        opacity1 = 0;
        xWild = 1050;
        tAnim.start();
        click = 0;
        inizio = "A wild " + P.name + " appear...";
        message = inizio;
        playerTurn=true;
        showMessage = true;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        showMessage = false;
        repaint();
        if (playerTurn) {
            if (attack1.contains(e.getPoint()) && (click == 1) && (another)) {
                playerAttack(0);

            }
            if (attack2.contains(e.getPoint()) && (click == 1) && (another)) {
                playerAttack(1);
            }
            if (attack3.contains(e.getPoint()) && (click == 1) && (another)) {
                playerAttack(2);
            }
            if (attack4.contains(e.getPoint()) && (click == 1) && (another)) {
                playerAttack(3);
            }
            if (!showMessage) another = true;

            if (fight.contains(e.getPoint()) && click == 0) {
                System.out.println("click");
                opacity1 = 0;
                t1.start();
                click = 1;
                repaint();
            } else if (fight.contains(e.getPoint())) {
                click = 0;
                opacity1 = 0;
                repaint();
            }
        } else wildAttack();
    }

    public void setPMoves() {
        P.moves[0] = P.getMovesById(P.moveset[0]);
        P.moves[1] = P.getMovesById(P.moveset[1]);
        P.moves[2] = P.getMovesById(P.moveset[2]);
        P.moves[3] = P.getMovesById(P.moveset[3]);
    }

    public void wildAttack() {
        counter = 0;
        String mossa;
        Random r = new Random();
        int m = r.nextInt(3);
        mossa = P.moves[m].name;
        attacco = "Wild "+ P.name + " use " + mossa;
        message = attacco;
        showMessage = true;
        another = false;
        damageCalculator(P.level, P.moves[m].power, P.effectiveAtk, p1.pokemonTeam[0].effectiveDfs);
        thwp.start();
        System.out.println(" mossa" + P.moves[m].power + " danno" + damage + " hp" + p1.pokemonTeam[0].healthpoint);
        playerTurn = true;
    }

    public void playerAttack(int slot) {
        counter = 0;
        String mossa;
        mossa = p1.pokemonTeam[0].moves[slot].name;
        attacco = p1.pokemonTeam[0].name + " use " + mossa;
        message = attacco;
        showMessage = true;
        another = false;
        damageCalculator(p1.pokemonTeam[0].level, p1.pokemonTeam[0].moves[slot].power, p1.pokemonTeam[0].effectiveAtk, P.effectiveDfs);

        thp.start();
        //System.out.println(" mossa" + p1.pokemonTeam[0].moves[slot].power + " danno" + damage + " hp" + P.healthpoint);

        if (P.healthpoint <= 0) {
            repaint();
            JOptionPane.showMessageDialog(null, "You won");
            frame.switchPanel(frame.r1, this);
        }
        playerTurn = false;
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

    public void moveAssign() {
        Random r = new Random();

    }
}



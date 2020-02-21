package thomar2048;

import package2048.Jeu2048;
import thomar2048.controller.GameKeyListener;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Canvas2048 extends Canvas implements Observer {


    private final Jeu2048 jeu;

    public Canvas2048(Jeu2048 jeu){
        this.jeu = jeu;

        jeu.addObserver(this);
        this.addKeyListener(new GameKeyListener(jeu));
        this.setVisible(true);
    }


    public void paint(Graphics g){
        // font declaration
        Font myFont = new Font ("Roboto", 1, 18);
        // recuperer le tableau des nombres en String
        String[][] tabS = jeu.getGrilleString();
        int[][] tabI = jeu.getGrilleInt();

        int X,Y; X = 0; Y = 0;
        int nbcols = jeu.getNbCols();

        for(int i = 0; i < nbcols; i++){
            if(i != 0){ X = X+getWidth()/nbcols;}

            for(int j = 0; j < nbcols; j++){
                if(j != 0){ Y = Y + getHeight()/nbcols;}

                // dessine les carrés
                g.setColor(Color.ORANGE);
                g.fillRect(X,Y,99,99);
                g.setColor(Color.BLACK);
                g.drawRect(X,Y, 100,100);

                // n'affiche pas les 0
                if(tabI[j][i] != 0) {
                    g.setFont(myFont);
                    g.drawString(tabS[j][i], X + 45, Y + 50);
                }

                if(jeu.estVainquer()){
                    g.setColor(Color.GREEN);
                    g.fillRect(0,0,getWidth(),getHeight());
                    g.setColor(Color.BLACK);
                    g.drawString("VICTOIRE",170,200);
                }else if(jeu.estTermine()){
                    g.setColor(Color.RED);
                    g.fillRect(0,0,getWidth(),getHeight());
                    g.setColor(Color.YELLOW);
                    g.drawString("ECHEC",170,200);
                }
            }
            // remise a 0 pour changement de ligne
            Y = 0;
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
    }

}

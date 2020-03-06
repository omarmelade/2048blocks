package thomar2048.view;

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

                int caseDim = this.getWidth()/nbcols;
                // dessine les carrés
                g.setColor(Color.WHITE);
                g.fillRect(X,Y,caseDim,caseDim);
                g.setColor(Color.BLACK);
                g.drawRect(X,Y, caseDim,caseDim);

                // n'affiche pas les 0
                if(tabI[j][i] != 0) {
                    int nb = tabI[j][i];
                    // color les cases qui contiennent une valeur
                    colorCase(g, nb);
                    g.fillRect(X, Y, caseDim, caseDim);
                    // affiche les valeurs dans les cases > 0
                    g.setColor(Color.BLACK);
                    g.setFont(myFont);
                    g.drawString(tabS[j][i], X + caseDim/2, Y + caseDim/2);
                }

                if(jeu.estVainquer()){
                    estVainqueur(g);
                }else if(jeu.estTermine()){
                    estPerdant(g);
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


    public void colorCase(Graphics g, int nb){
        switch (nb){
            case 2:
                g.setColor(new Color(153, 186, 240));
                break;
            case 4:
                g.setColor(new Color(114, 161, 237));
                break;
            case 8:
                g.setColor(new Color(77, 139, 240));
                break;
            case 16:
                g.setColor(new Color(38, 115, 240));
                break;
            case 32:
                g.setColor(new Color(32, 97, 201));
                break;
            case 64:
                g.setColor(new Color(22, 76, 161));
                break;
            case 128:
                g.setColor(new Color(17, 60, 128));
                break;
            case 256:
                g.setColor(new Color(14, 46, 97));
                break;
            case 512:
                g.setColor(new Color(13, 34, 66));
                break;
            case 1024:
                g.setColor(new Color(42, 56, 77));
                break;
            case 2048:
                g.setColor(new Color(48, 39, 89));
                break;
        }
    }

    public void estVainqueur(Graphics g){
        g.setColor(new Color(48, 112, 57));
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.BLACK);
        g.drawString("VICTOIRE",getWidth()/2-50,getHeight()/2);

    }

    public void estPerdant(Graphics g){
        g.setColor(new Color(173, 47, 33));
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.YELLOW);
        g.drawString("ECHEC",170,200);
    }
}

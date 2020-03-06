package thomar2048.view;

import package2048.Jeu2048;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class ScoreText extends Label implements Observer {
    private Jeu2048 jeu;
                //Constructeur
    public ScoreText(Jeu2048 jeu){
        this.jeu = jeu;
        this.setText(" SCORE : 0 ");
    }
                //Permet de changer le score du jeu en fonction de la partie.
    @Override
    public void update(Observable o, Object arg) {
        this.setText(" SCORE : " + jeu.getScore());
    }
}

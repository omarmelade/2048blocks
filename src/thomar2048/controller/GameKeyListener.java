package thomar2048.controller;

import package2048.Jeu2048;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class GameKeyListener extends KeyAdapter {
    private final Jeu2048 jeu;

                //Constructeur
    public GameKeyListener(Jeu2048 jeu){
        this.jeu = jeu;
    }

    @Override
                //fonction qui permet de jouer à notre jeu avec les fleches du clavier.
    public void keyPressed(KeyEvent e) {
                //On test la direction de la fleche et on la renvoie dans la fonction lié au mouvement.
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                jeu.decaler(Jeu2048.HAUT);
            break;
            case KeyEvent.VK_DOWN:
                jeu.decaler(Jeu2048.BAS);
                break;
            case KeyEvent.VK_LEFT:
                jeu.decaler(Jeu2048.GAUCHE);
                break;
            case KeyEvent.VK_RIGHT:
                jeu.decaler(Jeu2048.DROITE);
                break;
            default:
                break;
        }
    }

}

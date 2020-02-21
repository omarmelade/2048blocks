import package2048.Jeu2048;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class GameKeyListener extends KeyAdapter {
    private final Jeu2048 jeu;

    public GameKeyListener(Jeu2048 jeu){
        this.jeu = jeu;
    }

    @Override
    public void keyPressed(KeyEvent e) {
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

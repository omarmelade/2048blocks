package thomar2048.view;

import package2048.Jeu2048;
import thomar2048.controller.CloseWindow;
import thomar2048.controller.RestartListener;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Fenetre extends Frame implements Observer {

    private final static int WIDTH = 600,
            HEIGHT = 600;
    private int nbCase = 4;

                //Défini la taille et le but final du jeu.
    Jeu2048 jeu = new Jeu2048(nbCase,nbCase,128);


    public Fenetre() {
        Frame f = new Frame();
        Canvas2048 cs48 = new Canvas2048(jeu);
            //basic init
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("2048");
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        this.add(cs48, BorderLayout.CENTER);

            //restart button.
        Button restart = new Button("Recommencer");
        restart.addActionListener(new RestartListener(jeu));
        this.add(restart, BorderLayout.SOUTH);
            //Score
        ScoreText score = new ScoreText(jeu);
        jeu.addObserver(score);

        this.add(score, BorderLayout.NORTH);

        this.addWindowListener(new CloseWindow(this));
            //Rend visible les dessins.
        setVisible(true);
    }


    @Override
    public void update(Observable o, Object arg) {
        System.out.println("update moi jeune fou");
    }

}
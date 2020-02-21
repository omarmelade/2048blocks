package thomar2048;

import package2048.Jeu2048;
import thomar2048.controller.CloseWindow;

import java.awt.*;

public class Fenetre extends Frame {

    Jeu2048 jeu = new Jeu2048(4,4,16);

    private final static int WIDTH = 400,
            HEIGHT = 400;

    public Fenetre() {
        Frame f = new Frame();
        Canvas2048 cs48 = new Canvas2048(jeu);
        // basic init
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("2048");
        this.setLayout(new BorderLayout());
        this.setBackground(Color.DARK_GRAY);
        this.add(cs48, BorderLayout.CENTER);

        // button restart
        Button restart = new Button("Recommencer");

        if(jeu.estTermine()){
            this.add(restart, BorderLayout.SOUTH);
        }

        this.addWindowListener(new CloseWindow(this));
        setVisible(true);
    }



}
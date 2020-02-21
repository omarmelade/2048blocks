package thomar2048.view;

import package2048.Jeu2048;
import thomar2048.controller.CloseWindow;
import thomar2048.controller.RestartListener;
import thomar2048.view.Canvas2048;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Fenetre extends Frame implements Observer {

    Jeu2048 jeu = new Jeu2048(4,4,64);

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

        // restart button
        Button restart = new Button("Recommencer");
        restart.addActionListener(new RestartListener(jeu));
        this.add(restart, BorderLayout.SOUTH);

        this.addWindowListener(new CloseWindow(this));
        setVisible(true);
    }


    @Override
    public void update(Observable o, Object arg) {
        System.out.println("update moi jeune fou");
    }
}
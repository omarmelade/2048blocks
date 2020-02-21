package thomar2048.controller;

import package2048.Jeu2048;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestartListener implements ActionListener {
    private final Jeu2048 jeu2048;

    public RestartListener(Jeu2048 jeu2048) {
        this.jeu2048 = jeu2048;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.jeu2048.nouveauJeu();
    }
}

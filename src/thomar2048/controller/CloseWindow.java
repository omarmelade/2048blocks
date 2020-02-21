package thomar2048.controller;

import thomar2048.view.Fenetre;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class CloseWindow extends WindowAdapter {
    private Fenetre f;
    public CloseWindow(Fenetre f) {
        this.f = f;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        f.dispose();
    }
}

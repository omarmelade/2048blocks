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

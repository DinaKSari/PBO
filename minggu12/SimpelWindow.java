package minggu12;

import javax.swing.JWindow;

public class SimpelWindow extends JWindow {
    public SimpelWindow() {
        super();
        setBounds(250, 225, 300, 150);
    }

    public static void main(String[] args) {
        SimpelWindow sw = new SimpelWindow();
        sw.setVisible(true);
    }
}
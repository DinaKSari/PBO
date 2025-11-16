package minggu12;

import javax.swing.JFrame;

public class SimpleFrame extends JFrame {
    public SimpleFrame() {
        super("Frame title");
        setSize(450, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SimpleFrame sf = new SimpleFrame();
    }
}
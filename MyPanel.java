import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel implements ActionListener {
    Image img = new ImageIcon("images/menu_image.jpg").getImage();
    Timer timer = new Timer(20, this);
    JFrame frame;

    public MyPanel(JFrame frame) {
        this.frame = frame;
    }

    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, frame.getWidth(),
                frame.getHeight(), null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        repaint();
    }
}

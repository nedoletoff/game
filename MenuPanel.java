import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel implements ActionListener {
    Menu menu = new Menu();

    public MenuPanel(Frame frame) {
        JLabel jLabel = new JLabel(menu.getBack());
        frame.add(jLabel);
        jLabel.add(menu.getMenu());
        jLabel.add(menu.getGameName());
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
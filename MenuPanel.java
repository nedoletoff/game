import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class MenuPanel extends JPanel implements ActionListener {
    Menu menu = new Menu();

    public MenuPanel(Frame frame) {
        MenuPanel menuPanel = this;
        JLabel jLabel = new JLabel(menu.getBack());
        frame.add(jLabel);
        jLabel.add(menu.getMenu());
        jLabel.add(menu.getGameName());
        final int[] selected = new int[1];
        menu.getMenu().addListSelectionListener(e -> selected[0] = ((JList<?>)e.getSource()).
                getSelectedIndex());
        menu.getMenu().addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.out.println("Pressed " + selected[0]);
                    menuPanel.actionPerformed(new ActionEvent(e.getSource(),
                            e.getID(), "Enter " + selected[0]));
                }
            }
        });

        menu.getMenu().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    System.out.println("Pressed " + selected[0]);
                    menuPanel.actionPerformed(new ActionEvent(e.getSource(),
                            e.getID(), "Enter " + selected[0]));
                }
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (Objects.equals(e.getActionCommand(), "Enter 3"))
            System.exit(0);

    }
}
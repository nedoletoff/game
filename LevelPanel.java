import javax.swing.*;
import java.awt.event.*;
import java.util.Objects;

public class LevelPanel extends JPanel implements ActionListener {
    static LevelMenu menu = new LevelMenu();
    Window mainListener;

    public LevelPanel(Window window) {
        mainListener = window;
        LevelPanel levelPanel = this;
        JLabel jLabel = new JLabel(menu.getBack());
        this.add(jLabel);
        window.frame.getContentPane().add(this);
        jLabel.add(menu.getMenu());
        jLabel.add(menu.getGameName());
        jLabel.add(menu.getBackButton());

        menu.getBackButton().addActionListener(e -> levelPanel.actionPerformed(new ActionEvent(e.getSource(), e.getID(),
                "Back")));

        final int[] selected = new int[1];
        menu.getMenu().addListSelectionListener(e -> selected[0] = ((JList<?>)e.getSource()).
                getSelectedIndex());
        menu.getMenu().addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.out.println("Pressed " + selected[0]);
                    levelPanel.actionPerformed(new ActionEvent(e.getSource(),
                        e.getID(), "" + selected[0]));
                }
            }
        });

        menu.getMenu().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    System.out.println("Pressed " + selected[0]);
                    if (selected[0] == menu.getMenu().getModel().getSize() - 1)
                        levelPanel.actionPerformed(new ActionEvent(e.getSource(),
                                e.getID(), "Back"));
                    else
                        levelPanel.actionPerformed(new ActionEvent(e.getSource(),
                            e.getID(), "" + selected[0]));
                }
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (Objects.equals(e.getActionCommand(), "Back"))
            mainListener.actionPerformed(new ActionEvent(e.getSource(),
                    e.getID(), "Back to main menu"));
        else
            mainListener.actionPerformed(new ActionEvent(e.getSource(),
                    e.getID(), "Go to level -" + e.getActionCommand()));

    }
}

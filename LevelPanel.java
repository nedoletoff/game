import javax.swing.*;
import java.awt.event.*;
import java.util.Objects;

public class LevelPanel extends JPanel implements ActionListener {
    protected static LevelMenu menu = new LevelMenu();
    Window mainListener;
    protected JLabel jLabel = new JLabel(menu.getBack());

    public LevelPanel(Window window) {
        mainListener = window;
        LevelPanel levelPanel = this;
        this.add(jLabel);
        window.frame.getContentPane().add(this);
        jLabel.add(menu.getMenu());
        jLabel.add(menu.getGameName());
        jLabel.add(menu.getBackButton());

        menu.getBackButton().addActionListener(e -> levelPanel.actionPerformed(new ActionEvent(e.getSource(),
                e.getID(), "Back")));

        final int[] selected = new int[1];
        menu.getMenu().addListSelectionListener(e -> selected[0] = ((JList<?>)e.getSource()).
                getSelectedIndex());
        menu.getMenu().addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.out.println("Pressed " + menu.getMenu().getSelectedValue());
                    levelPanel.actionPerformed(new ActionEvent(e.getSource(),
                            777,  menu.getMenu().getSelectedValue()));
                }
            }
        });

        menu.getMenu().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    //System.out.println("Pressed " + menu.getMenu().getSelectedValue());
                    levelPanel.actionPerformed(new ActionEvent(e.getSource(),
                            777,  menu.getMenu().getSelectedValue()));
                }
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (Objects.equals(e.getActionCommand(), "Back"))
            mainListener.actionPerformed(new ActionEvent(e.getSource(),
                    e.getID(), "Back to main menu"));
        switch (e.getID()) {
           case (777) -> {
               System.out.println(e.getActionCommand());
               mainListener.actionPerformed(new ActionEvent(e.getSource(),
                       e.getID(), e.getActionCommand()));
           }
            case (999) -> mainListener.actionPerformed(new ActionEvent(e.getSource(),
                   e.getID(), "New level"));
        }
    }
}

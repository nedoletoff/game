import javax.swing.*;

public class LevelMenu {
    JList<String> menu;
    ImageIcon back;
    JLabel gameName;

    public LevelMenu() {
        Levels levels = new Levels("levels");
        DefaultListModel<String> menuList = new DefaultListModel<>();
        menuList.addAll(levels.getLevelsNames());
        menuList.addElement("Back");

        menu = new JList<>(menuList);
        menu.setBounds(Window.WIDTH / 2 - 800,Window. HEIGHT / 2 - 250,
                800, 400);
        menu.setName("LevelMenu");
        menu.setFont(Window.menuFont);
        menu.setForeground(Window.levelFontColor);
        menu.setBackground(Window.background);
        menu.setOpaque(false);
        DefaultListCellRenderer listCellRenderer = (DefaultListCellRenderer)
                menu.getCellRenderer();
        listCellRenderer.setHorizontalAlignment(JLabel.LEFT);
        listCellRenderer.setOpaque(false);

        gameName = new JLabel("Circle Adventure");
        gameName.setName("gameName");
        gameName.setFont(Window.nameFont);
        gameName.setForeground(Window.nameFontColor);
        gameName.setHorizontalAlignment(JLabel.CENTER);
        gameName.setBounds(Window.WIDTH / 2 - 400,Window.HEIGHT / 2 - 450,
                800, 200);

        back = new ImageIcon("images/game_image.jpg");
    }

    public ImageIcon getBack() {
        return back;
    }

    public JLabel getGameName() {
        return gameName;
    }

    public JList<String> getMenu() {
        return menu;
    }
}

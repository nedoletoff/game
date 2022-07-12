import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Locale;

public class Display {
    JFrame frame = new JFrame("Circle Adventure");
    public static final int HEIGHT = 1080;
    public static final int WIDTH = 1920;
    public static Font menuFont = new Font("Comic Sans MS", Font.PLAIN, 45);
    public static Color menuFontColor = new Color(255, 255, 51);
    public static Color background = new Color(20, 150, 180);
    public static Font nameFont = new Font("Trebuchet MS", Font.PLAIN, 82);
    public static Color nameFontColor = new Color(255, 255, 0);
    public static void main(String[] args) {
        Display display = new Display();
        //Display.start();
    }

    public Display() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(false);


        DefaultListModel<String> l = new DefaultListModel<>();
        l.addElement("Start");
        l.addElement("Choose Level");
        l.addElement("Level Editor");
        l.addElement("Exit");
        JList<String> menu = new JList<>(l);
        menu.setBounds(WIDTH / 2 - 200, HEIGHT / 2 - 150,
                400, 400);
        menu.setName("Menu");
        menu.setFont(menuFont);
        menu.setForeground(menuFontColor);
        menu.setBackground(background);
        menu.setOpaque(false);
        DefaultListCellRenderer listCellRenderer = (DefaultListCellRenderer)
                menu.getCellRenderer();
        listCellRenderer.setHorizontalAlignment(JLabel.CENTER);

        JLabel gameName = new JLabel("Circle Adventure");
        gameName.setBounds(WIDTH / 2 - 400, HEIGHT / 2 - 400,
                800, 200);
        gameName.setLabelFor(menu);
        gameName.setFont(nameFont);
        gameName.setForeground(nameFontColor);
        gameName.setName("gameName");
        gameName.setHorizontalAlignment(JLabel.CENTER);

        frame.add(menu);
        frame.add(gameName);
        frame.getContentPane().add(new MyPanel(frame));

        frame.setVisible(true);
    }
}

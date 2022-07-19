import javax.swing.*;
import java.awt.*;

public class Window {
    public JFrame frame = new JFrame("Circle Adventure");
    public Mode[] modes;
    public int mode = MENU;
    public static final int MENU = 0;
    public static final int PLAY = 1;
    public static final int REDACTOR = 2;
    public static final int HEIGHT = 1080;
    public static final int WIDTH = 1920;
    public static Font menuFont = new Font("Comic Sans MS", Font.PLAIN, 45);
    public static Color menuFontColor = new Color(255, 255, 51);
    public static Color background = new Color(20, 150, 180);
    public static Font nameFont = new Font("Trebuchet MS", Font.PLAIN, 82);
    public static Color nameFontColor = new Color(255, 255, 0);
    public static void main(String[] args) {
        Window display = new Window();
        display.show();
        //Display.start();
    }

    public Window() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(false);
        frame.setIconImage(new ImageIcon(
                "C:\\Users\\nedoletoff\\IdeaProjects\\game\\images\\circle.png").getImage());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

        MenuPanel menuPanel = new MenuPanel(frame);
    }

    public void show() {
    }
}
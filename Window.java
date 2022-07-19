import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window implements ActionListener {
    public JFrame frame = new JFrame("Circle Adventure");
    public static final int MENU = 0;
    public static final int PLAY = 1;
    public static final int REDACTOR = 2;
    public static final int HEIGHT = 1080;
    public static final int WIDTH = 1920;
    public static Font menuFont = new Font("Comic Sans MS",
            Font.PLAIN, 55);
    public static Color menuFontColor = new Color(255, 255, 51);
    public static Color background = new Color(20, 150, 180);
    public static Font nameFont = new Font("Trebuchet MS",
            Font.PLAIN, 92);
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

    }

    public void show() {
        goToMainMenu();
    }

    private void goToMainMenu() {
        frame.getContentPane().removeAll();
        frame.invalidate();
        new MenuPanel(this);
        frame.revalidate();
        System.out.println("To main");
    }

    private void goToLevelMenu() {
        frame.getContentPane().removeAll();
        frame.invalidate();
        new LevelPanel(this);
        frame.revalidate();
        System.out.println("To level");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        switch (e.getActionCommand()) {
            case ("Back to main menu") -> {
                goToMainMenu();
            }
            case ("Go to level menu") -> {
                goToLevelMenu();
            }
        }
    }
}

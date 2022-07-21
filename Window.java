import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window implements ActionListener {
    public JFrame frame = new JFrame("Circle Adventure");
    public static final int HEIGHT = 1080;
    public static final int WIDTH = 1920;
    public static Font menuFont = new Font("Comic Sans MS",
            Font.PLAIN, 52);
    public static Font buttonFont = new Font("Comic Sans MS",
            Font.BOLD, 60);
    public static Font levelFont = new Font("Comic Sans MS",
            Font.PLAIN, 50);
    public static Font miniButtonFont = new Font("Comic Sans MS",
            Font.PLAIN, 30);
    public static Font nameFont = new Font("Trebuchet MS",
            Font.PLAIN, 92);
    public static Font dialogFont = new Font("Trebuchet MS",
            Font.PLAIN, 20);
    public static Color buttonFontColor = new Color(243, 198, 20 );
    public static Color menuFontColor = new Color(255, 255, 51);
    public static Color levelFontColor = new Color(170, 255, 0);
    public static Color background = new Color(20, 150, 180);
    public static Color buttonBackground = new Color(33, 68, 182);
    public static Color nameFontColor = new Color(255, 255, 0);
    public static void main(String[] args) {
        GameComponents.load();
        Window display = new Window();
        display.show();
        //Display.start();
    }

    public Window() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(false);
        frame.setIconImage(new ImageIcon(
                "images\\circle.png").getImage());
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
        System.out.println("To level menu");
    }

    private void goToLevelRedactorMenu() {
        frame.getContentPane().removeAll();
        frame.invalidate();
        new LevelRedactorPanel(this);
        frame.revalidate();
        System.out.println("To level redactor menu");
    }

    private void goToRedactor() {
        frame.getContentPane().removeAll();
        frame.invalidate();
        new RedactorPanel(this);
        frame.revalidate();
        System.out.println("To Redactor");
    }

    private void goToRedactor(String levelName) {
        frame.getContentPane().removeAll();
        frame.invalidate();
        new RedactorPanel(this, levelName);
        frame.revalidate();
        System.out.println("To Redactor " + levelName);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println(e.getActionCommand());
        //System.out.println(e.getSource());
        //System.out.println(e.getID());
        switch (e.getActionCommand()) {
            case ("Back to main menu") -> {
                goToMainMenu();
            }
            case ("Go to level menu") -> {
                goToLevelMenu();
            }
            case ("Go to level redactor") -> {
                goToLevelRedactorMenu();
            }
            default -> {
                switch (e.getID()) {
                    case (999) -> goToRedactor();
                    case (888) -> goToRedactor(e.getActionCommand());
                }
            }
            //case ("Go to level -")
        }
    }
}

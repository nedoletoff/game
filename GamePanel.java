import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class GamePanel extends JPanel implements ActionListener {

    GameMenu gameMenu = new GameMenu();
    Platformer platformer;
    final Window mainListener;
    Timer timerPlatformer;
    Timer timer;

    int count = 0;
    KeyListener keyListener = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            System.out.println("key" + e.getKeyCode());
            platformer.pressedKeys.add(e.getKeyCode());
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                mainListener.actionPerformed(new ActionEvent(e.getSource(),
                        e.getID(), "Back to main menu"));
        }
        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
            platformer.pressedKeys.remove(e.getKeyCode());
        }
    };

    public GamePanel(Window window, String levelName) {
        super();
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameMenu.setTimer(gameMenu.getTimer()+1);
            }
        });
        timerPlatformer = new Timer(60, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                platformer.update();
                repaintLevel();
            }
        });

        mainListener = window;
        Level level = Level.load(levelName);
        platformer = new Platformer(level.getPlayer(), level);
        JLabel jLabel = new JLabel(gameMenu.getBack());
        this.add(jLabel);
        window.frame.getContentPane().add(this);
        jLabel.add(gameMenu.getScoreLabel());
        jLabel.add(gameMenu.getTimerLabel());
        jLabel.add(gameMenu.getBackButton());
        jLabel.add(gameMenu.getRestartButton());

        gameMenu.getBackButton().addActionListener(e -> actionPerformed(new
                ActionEvent(e.getSource(), e.getID(), "Back")));
        gameMenu.getRestartButton().addActionListener(e -> actionPerformed((new
                ActionEvent(e.getSource(), 11, "Restart"))));
        timer.start();
        timerPlatformer.start();
        addKeyListener(keyListener);
        grabFocus();
        System.out.println(Arrays.toString(getKeyListeners()));
    }

    public void repaintLevel() {
        //if (count++ == 20) {
        //    eraseAll();
        //    count = 0;
        //}
        ArrayList<GameObject> gameObjects = platformer.currentLevel.getLevelsObjects();
        for (GameObject gameObject : gameObjects) {
            paintObject(gameObject);
        }
    }

    public void paintObject(GameObject gameObject) {
        ImageIcon icon = new ImageIcon(gameObject.getComponent().imageName);
        JLabel label = new JLabel(icon);
        Coordinates coordinate = gameObject.getCoordinates();
        GameComponent gameComponent = gameObject.getComponent();
        label.setBounds(coordinate.x, coordinate.y, gameComponent.getHorizontalSize(),
                gameComponent.getVerticalSize());
        Graphics g = getGraphics();
        g.drawImage(icon.getImage(), coordinate.x, coordinate.y,
                gameComponent.getHorizontalSize(), gameComponent.getVerticalSize(),
                null);
    }

    private void eraseAll() {
        Graphics g = getGraphics();
        g.drawImage(gameMenu.getBack().getImage(), 0, 0,
                Window.WIDTH, Window.HEIGHT, null);
        hideButtons();
        showButtons();
    }

    public void hideButtons() {
        gameMenu.getBackButton().setVisible(false);
        gameMenu.getRestartButton().setVisible(false);
        gameMenu.getTimerLabel().setVisible(false);
        gameMenu.getScoreLabel().setVisible(false);
    }

    public void showButtons() {
        gameMenu.getBackButton().setVisible(true);
        gameMenu.getRestartButton().setVisible(true);
        gameMenu.getTimerLabel().setVisible(true);
        gameMenu.getScoreLabel().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Objects.equals(e.getActionCommand(), "Back")) {
            mainListener.actionPerformed(new ActionEvent(e.getSource(),
                    e.getID(), "Back to main menu"));
        }
        switch (e.getID()) {
            case (11) -> {
                mainListener.actionPerformed(new ActionEvent(e.getSource(),
                        e.getID(), "Back to main menu"));
                mainListener.actionPerformed(new ActionEvent(e.getSource(),
                        777, platformer.currentLevel.getLevelName()));
            }
        }

    }
}

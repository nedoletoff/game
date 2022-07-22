import javax.swing.*;

public class GameMenu {
    ImageIcon back;
    JButton backButton;
    JButton restartButton;
    JLabel scoreLabel;
    JLabel timerLabel;

    public GameMenu() {
        backButton = new JButton("Back");
        backButton.setBounds(10, 10, 180, 40);
        backButton.setFont(Window.miniButtonFont);
        backButton.setForeground(Window.buttonFontColor);
        backButton.setBackground(Window.buttonBackground);
        backButton.setHorizontalAlignment(JLabel.CENTER);

        restartButton = new JButton("Restart");
        restartButton.setBounds(10, 50, 180, 40);
        restartButton.setFont(Window.miniButtonFont);
        restartButton.setForeground(Window.levelFontColor);
        restartButton.setBackground(Window.background);
        restartButton.setHorizontalAlignment(JLabel.CENTER);


        back = new ImageIcon("images/game_image.jpg");


        timerLabel = new JLabel("Timer: 0");
        timerLabel.setBounds(Window.WIDTH - 150, 10, 150, 25);
        timerLabel.setFont(Window.miniButtonFont);
        timerLabel.setForeground(Window.levelFontColor);
        timerLabel.setOpaque(false);

        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setBounds(Window.WIDTH - 150, 35, 150, 25);
        scoreLabel.setFont(Window.miniButtonFont);
        scoreLabel.setForeground(Window.levelFontColor);
        scoreLabel.setOpaque(false);
    }

    public ImageIcon getBack() {
        return back;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getRestartButton() {
        return restartButton;
    }

    public JLabel getScoreLabel() {
        return scoreLabel;
    }

    public JLabel getTimerLabel() {
        return timerLabel;
    }

    public void setTimer(int time) {
        timerLabel.setText("Timer: " + time);
    }

    public int getTimer() {
        return Integer.parseInt(timerLabel.getText().split(": ")[1]);
    }

    public void setScore(int score) {
        scoreLabel.setText("Score: " + score);
    }

    public int getScore() {
        return Integer.parseInt(scoreLabel.getText().split(": ")[1]);
    }
}


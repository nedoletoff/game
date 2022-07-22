import java.util.TreeSet;

public class Platformer {
    Player player;
    public Level currentLevel;
    public TreeSet<Integer> pressedKeys;

    public Platformer(Player player, Level currentLevel) {
        this.player = player;
        this.currentLevel = currentLevel;
        this.pressedKeys = currentLevel.pressedKeys;
    }

    public void update() {
        for (GameObject gameObject : currentLevel.getLevelsObjects())
            gameObject.update(currentLevel);
    }
}

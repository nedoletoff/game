import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;

public class Platformer {
    GameObject player;
    Level currentLevel;
    HashSet<Integer> pressedKeys;

    public Platformer(GameObject player, Level currentLevel) {
        this.player = player;
        this.currentLevel = currentLevel;
    }

    public void movePlayer(int x, int y) {
        player.move(x, y);
    }

}

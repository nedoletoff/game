import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Level {
    String levelName;
    List<GameComponent> gameObjects;

    public Level(String levelName) {
        this.levelName = levelName;
        this.gameObjects = new LinkedList<>();
    }

    public String getLevelName() {
        return levelName;
    }

    public int getGameObjectsNum() {
        return gameObjects.size();
    }

    public GameComponent getGameObjects(int num) {
        ListIterator<GameComponent> it = gameObjects.listIterator();
        for (int i = 0; i < num; i++) {
            it.next();
        }
        return it.next();

    }
}

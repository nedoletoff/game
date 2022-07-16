import java.io.Serializable;
import java.util.*;

public class Level {
    String levelName;
    int timer;
    int points = 0;
    TreeMap<Integer, GameObject> gameObjects;
    public TreeSet<Integer> pressedKeys;

    public Level(String levelName) {
        this.levelName = levelName;
        this.gameObjects = new TreeMap<>();
        pressedKeys = new TreeSet<>();
    }

    public void addGameObject(GameObject gameObject) {
        Integer id = gameObject.getId();
        if (!gameObjects.containsKey(id))
            gameObjects.put(id, gameObject);
    }

    public void removeGameObject(Integer id) {
        gameObjects.remove(id);
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getLevelName() {
        return levelName;
    }

    public int getGameObjectsNum() {
        return gameObjects.size();
    }

    public GameObject getGameObject(Integer id) {
        return gameObjects.get(id);
    }

    public ArrayList<GameObject> getLevelsObjects() {
        Iterator<GameObject> it = gameObjects.values().iterator();
        ArrayList<GameObject> arrayList = new ArrayList<>();
        while (it.hasNext())
            arrayList.add(it.next());
        return arrayList;
    }

    public TreeMap<Integer, GameObject> getGameObjects() {
        return gameObjects;
    }
    public int getPoints() {
        return points;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public void addPoint() {
        points++;
    }

    public static Level load(String filename) {
        SavedLevel sl = SavedLevel.load(filename);
        Level l = new Level(sl.levelName);
        l.gameObjects = sl.gameObjects;
        return l;
    }

    public void save(String filename) {
        String path = "C:\\Users\\nedoletoff\\IdeaProjects\\game\\levels\\";
        SavedLevel sl = SavedLevel.load(path + levelName);
        sl.bestPoints = Math.max(sl.bestPoints, getPoints());
        sl.bestTime = Math.min(sl.bestTime, getTimer());
    }

    public void redactorSave() {
        String path = "C:\\Users\\nedoletoff\\IdeaProjects\\game\\levels\\";
        SavedLevel sl = new SavedLevel(this);
        sl.save(path + levelName);
    }
}


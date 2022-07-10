import java.util.*;

public class Level {
    String levelName;
    TreeMap<Integer, GameObject> gameObjects;

    public Level(String levelName) {
        this.levelName = levelName;
        this.gameObjects = new TreeMap<>();
    }

    public void addGameObject(GameObject gameObject) {
        Integer id = gameObject.getId();
        if (!gameObjects.containsKey(id))
            gameObjects.put(id, gameObject);
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

    public GameObject getGameObjects(int id) {
        return gameObjects.get(id);
    }

    public ArrayList<GameObject> getLevelsObjects() {
        Iterator<GameObject> it = gameObjects.values().iterator();
        ArrayList<GameObject> arrayList = new ArrayList<>();
        while (it.hasNext())
            arrayList.add(it.next());
        return arrayList;
    }
}


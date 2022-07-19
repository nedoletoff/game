import java.io.*;
import java.util.TreeMap;

public class SavedLevel implements Serializable {
    public int bestTime = 9999;
    public int bestPoints = 0;
    public TreeMap<Integer, GameObject> gameObjects;
    public String levelName;

    public SavedLevel(Level level) {
        gameObjects = level.getGameObjects();
        levelName = level.getLevelName();
    }

    public SavedLevel(SavedLevel other) {
        gameObjects = other.gameObjects;
        levelName = other.levelName;
        bestPoints = other.bestPoints;
        bestTime = other.bestTime;
    }

    public static SavedLevel load(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (SavedLevel) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void save(String filename) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "SavedLevel{" +
                "bestTime=" + bestTime +
                ", bestPoints=" + bestPoints +
                ", gameObjects=" + gameObjects +
                ", levelName='" + levelName + '\'' +
                '}';
    }
}

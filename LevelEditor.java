public class LevelEditor {
    Level level;
    Levels levels;

    public LevelEditor(String levelName) {
        levels = new Levels("levels");
        if (levels.getLevelsNames().contains(levelName))
            level = Level.load(levelName);
        else
            level = new Level(levelName);
    }

    public void saveChanges() {
        level.redactorSave();
    }
}

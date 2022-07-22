public class TestLevel {
    public static void main(String[] args) {
        int x = 100;
        int y = 100;
        Coordinates coordinates = new Coordinates(x, y);
        GameComponent component = new GameComponent("circle",
                "images/circle.png", 100, 100);
        Level level = new Level("test");

        GameObject gameObject = new Player(component, x, y);
        GameObject gameObject1 = new GameObject(component, x*10, 0);
        GameObject gameObject2 = new GameObject(component, 0, 0);
        GameObject gameObject3 = new GameObject(component, x, 200);

        System.out.print("addGameObject test1:");
        level.addGameObject(gameObject);
        System.out.println(level.getGameObjectsNum() == 1);

        System.out.print("addGameObject test2:");
        level.addGameObject(gameObject1);
        System.out.println(level.getGameObjectsNum() == 2);

        System.out.print("removeGameObject test2:");
        level.removeGameObject(gameObject.getId());
        System.out.println(level.getGameObjectsNum() == 1);

        level.addGameObject(gameObject);
        level.addGameObject(gameObject2);
        level.addGameObject(gameObject3);

        System.out.println("getGameObjectId test1:" +
                (gameObject1.getId() == level.getGameObjectId(new
                        Coordinates(1000, 5))));

        System.out.println("getGameObjectId test2:" +
                (gameObject.getId() == level.getGameObjectId(new
                        Coordinates(110, 150))));

        level.generateSurface();
        System.out.println("onSurface test1:" +
                level.onSurface(gameObject2));

        System.out.println("onSurface test2:" +
                level.onSurface(gameObject));

        level.removeGameObject(gameObject3.id);
        level.generateSurface();
        System.out.println("onSurface test3:" +
                !level.onSurface(gameObject));
    }
}

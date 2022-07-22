public class TestGameObject {
    public static void main(String[] args) {
        int x = 100;
        int y = 100;
        Coordinates coordinates = new Coordinates(x, y);
        GameComponent component = new GameComponent("circle",
                "images/circle.png", 100, 100);
        GameObject gameObject = new GameObject(component, x, y);
        GameObject gameObject1 = new GameObject(component, x*10, 0);
        GameObject gameObject2 = new GameObject(component, 0, 0);


        System.out.println("getCoordinates test:"
                + coordinates.equals(gameObject.getCoordinates()));

        System.out.println("getGameComponent test:"
                + component.equals(gameObject.getComponent()));

        System.out.println("isInHitBox test1:" +
                gameObject.isInHitBox(gameObject));

        System.out.println("isInHitBox test2:" +
                !gameObject.isInHitBox(gameObject1));

        System.out.println("isInHitBox test3:" +
                gameObject.isInHitBox(110, 110));

        System.out.println("isInHitBox test4:" +
                !gameObject.isInHitBox(110, 1000));

        System.out.println("isNearHitBox test1:" +
                gameObject.isNearHitBox(gameObject2));

        System.out.println("isNearHitBox test1:" +
                gameObject2.isNearHitBox(gameObject));

        System.out.println("isNearHitBox test2:" +
                !gameObject.isNearHitBox(gameObject1));

       System.out.println("whereIsObject test1:" +
               (gameObject.whereIsObject(gameObject2) == GameObject.UP));

        System.out.println("whereIsObject test2:" +
                (gameObject2.whereIsObject(gameObject) == GameObject.DOWN));

        System.out.println("whereIsObject test3:" +
                (gameObject.whereIsObject(gameObject1) == GameObject.RIGHT));

        System.out.println("whereIsObject test4:" +
                (gameObject1.whereIsObject(gameObject) == GameObject.LEFT));

        System.out.println("isStandOn test1:" +
                gameObject.isStandOn(gameObject2));

        System.out.println("isStandOn test2:" +
                gameObject2.isStandOn(gameObject));
    }
}

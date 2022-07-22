import java.io.FileNotFoundException;

public class MainTest {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("GameComponent:");
        TestComponent.main(args);
        System.out.println("GameObject:");
        TestGameObject.main(args);
        System.out.println("Player:");
        TestGameObject.main(args);
        System.out.println("Level:");
        TestLevel.main(args);
    }
}

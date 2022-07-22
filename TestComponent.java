import java.io.*;

public class TestComponent {
    public static void main(String[] args) throws FileNotFoundException {
        GameComponent g = new GameComponent("Enemy",
                "images\\enemy.png",
                100, 100);
        //System.out.println(g);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("g.data"))) {
            oos.writeObject(g);
            System.out.println("Save test:true");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("g.data"))) {
            GameComponent gg = (GameComponent)ois.readObject();
            //System.out.println(gg);
            System.out.println("Load test:" + g.equals(gg));
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}

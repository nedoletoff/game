import javax.swing.*;

public class GameComponent {
    public static int num;
    int horizontalSize;
    int verticalSize;
    String name;
    String imageLocation;
    ImageIcon png;


    public GameComponent(String name, String imageLocation, int horizontalSize, int verticalSize) {
        num++;
        this.name = name;
        this.imageLocation = imageLocation;
        this.png = new ImageIcon(imageLocation);
        this.horizontalSize = horizontalSize;
        this.verticalSize = verticalSize;
    }

    public GameComponent(GameComponent other){
        num++;
        this.name = other.name;
        this.imageLocation = other.imageLocation;
        this.png = new ImageIcon(imageLocation);
        this.horizontalSize = other.horizontalSize;
        this.verticalSize = other.verticalSize;
    }

    public ImageIcon getPng() {
        return png;
    }

    public int getHorizontalSize() {
        return horizontalSize;
    }

    public int getVerticalSize() {
        return verticalSize;
    }

    public String getName() {
        return name;
    }
}



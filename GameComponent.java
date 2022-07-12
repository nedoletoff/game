import javax.swing.*;
import java.io.Serializable;
import java.util.Objects;

public class GameComponent implements Serializable {
    public static int num;
    int horizontalSize;
    int verticalSize;
    String name;
    String imageLocation;
    //ImageIcon png;


    public GameComponent(String name, String imageLocation,
                         int horizontalSize, int verticalSize) {
        num++;
        this.name = name;
        this.imageLocation = imageLocation;
        //this.png = new ImageIcon(imageLocation);
        this.horizontalSize = horizontalSize;
        this.verticalSize = verticalSize;
    }

    public GameComponent(GameComponent other){
        num++;
        this.name = other.name;
        this.imageLocation = other.imageLocation;
        //this.png = new ImageIcon(imageLocation);
        this.horizontalSize = other.horizontalSize;
        this.verticalSize = other.verticalSize;
    }

   // public ImageIcon getPng() {
   //     return png;
   // }

    public int getHorizontalSize() {
        return horizontalSize;
    }

    public int getVerticalSize() {
        return verticalSize;
    }

    public String getName() {
        return name;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameComponent that = (GameComponent) o;
        return getHorizontalSize() == that.getHorizontalSize() &&
                getVerticalSize() == that.getVerticalSize() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getImageLocation(), that.getImageLocation());
                //Objects.equals(getPng(), that.getPng());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHorizontalSize(), getVerticalSize(),
                getName(), getImageLocation());
    }

    @Override
    public String toString() {
        return "GameComponent{" +
                "horizontalSize=" + horizontalSize +
                ", verticalSize=" + verticalSize +
                ", name='" + name + '\'' +
                ", imageLocation='" + imageLocation + '\'' +
                '}';
    }
}



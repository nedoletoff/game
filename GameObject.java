import java.util.Arrays;
import java.util.Objects;

public class GameObject {
    final int id;
    GameComponent component;
    int horizontalCoordinate;
    int verticalCoordinate;
    int damage = 0;
    int hitPoints = 10;
    int[] damageCoefficient = {0, 0, 0, 0}; //up, down, left, right
    boolean canMove = false;
    int protection = 5;
    public static int ObjectId = 0;
    public static final int MAXHEIGHT = 1080;
    public static final int MAXWIDTH = 1920;

    public GameObject(GameComponent component, int horizontalCoordinate,
                      int verticalCoordinate) {
        this.component = component;
        this.horizontalCoordinate = horizontalCoordinate;
        this.verticalCoordinate = verticalCoordinate;
        id = ObjectId++;
    }

    public GameObject(GameComponent component, int horizontalCoordinate,
                      int verticalCoordinate, int damage, int hitPoints,
                      int[] coefficients, boolean canMove) throws Error {

        this.component = component;
        this.horizontalCoordinate = horizontalCoordinate;
        this.verticalCoordinate = verticalCoordinate;
        if (coefficients.length > 4)
            throw new Error("wrong coefficients");
        System.arraycopy(coefficients, 0, this.damageCoefficient,
                0, coefficients.length);
        this.damage = damage;
        this.hitPoints = hitPoints;
        this.canMove = canMove;
        id = ObjectId++;
    }

    public void setHorizontalCoordinate(int horizontalCoordinate) {
        this.horizontalCoordinate = horizontalCoordinate;
    }

    public void setVerticalCoordinate(int verticalCoordinate) {
        this.verticalCoordinate = verticalCoordinate;
    }

    public void setDamageCoefficient(int[] coefficients) throws Error {
        if (coefficients.length > 4)
            throw new Error("wrong coefficients");
        System.arraycopy(coefficients, 0, this.damageCoefficient,
                0, coefficients.length);
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }

    public int getDamage() {
        return damage;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int[] getDamageCoefficient() {
        return damageCoefficient;
    }

    public int getId() {
        return id;
    }

    public int[] getHitBox() {
        int[] hitBox = new int[4];
        hitBox[0] = horizontalCoordinate;
        hitBox[1] = verticalCoordinate;
        hitBox[2] = horizontalCoordinate + component.getHorizontalSize();
        hitBox[3] = verticalCoordinate + component.getVerticalSize();
        return hitBox;
    }

    public void hitOther(GameObject other, int side) {
        if (other.protection < damage * damageCoefficient[side] || damage < 0) {
            other.hitPoints -= damage * damageCoefficient[side] + other.protection;
        }
    }

    public void moveHorizontal(int horizontalDelta) {
        if (canMove) {
            horizontalCoordinate += horizontalDelta;
            if (horizontalCoordinate > MAXWIDTH)
                horizontalCoordinate = MAXWIDTH;
            else if (horizontalCoordinate < 0)
                horizontalCoordinate = 0;
        }
    }

    public void moveVertical(int verticalDelta) {
        if (canMove) {
            verticalCoordinate += verticalDelta;
            if (verticalCoordinate > MAXHEIGHT)
                verticalCoordinate = MAXHEIGHT;
            else if (verticalCoordinate < 0)
                verticalCoordinate = 0;
        }
    }

    public void move(int horizontalDelta, int verticalDelta) {
        moveHorizontal(horizontalDelta);
        moveVertical(verticalDelta);
    }

    public boolean equals(GameObject other) {
        return (id == other.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameObject other = (GameObject) o;
        return id == other.id &&
                horizontalCoordinate == other.horizontalCoordinate &&
                verticalCoordinate == other.verticalCoordinate &&
                getDamage() == other.getDamage() &&
                getHitPoints() == other.getHitPoints() &&
                canMove == other.canMove && protection == other.protection &&
                Arrays.equals(getDamageCoefficient(), other.getDamageCoefficient());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, horizontalCoordinate,
                verticalCoordinate, getDamage(), getHitPoints(),
                canMove, protection);
        result = 31 * result + Arrays.hashCode(getDamageCoefficient());
        return result;
    }

    @Override
    public String toString() {
        return "GameObject{" +
                "id=" + id +
                ", component=" + component +
                ", horizontalCoordinate=" + horizontalCoordinate +
                ", verticalCoordinate=" + verticalCoordinate +
                ", damage=" + damage +
                ", hitPoints=" + hitPoints +
                ", damageCoefficient=" + Arrays.toString(damageCoefficient) +
                ", canMove=" + canMove +
                ", protection=" + protection +
                '}';
    }
}

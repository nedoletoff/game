import java.awt.event.KeyEvent;
import java.util.HashSet;

public class Player extends GameObject {
    int jumpSpeed = speed;
    public Player(GameComponent component, int horizontalCoordinate, int verticalCoordinate) {
        super(component, horizontalCoordinate, verticalCoordinate);
        damage = 1;
        damageCoefficient[DOWN] = 7;
        damageCoefficient[UP] = 3;
        damageCoefficient[LEFT] = 1;
        damageCoefficient[RIGHT] = 1;
        canMove = true;
        hitPoints = 4;
        protection = 0;
    }

    @Override
    public void update(Level level) {
        super.update(level);
        if (level.pressedKeys.contains(KeyEvent.VK_A)) {
            move(-speed, 0);
        }
        if (level.pressedKeys.contains(KeyEvent.VK_D)) {
            move(speed, 0);
        }

        if (level.pressedKeys.contains(KeyEvent.VK_SPACE)) {
            move(0, jumpSpeed--);
        }
        else
            jumpSpeed = speed;
        for (GameObject gameObject : level.getLevelsObjects()) {
            if (this.equals(gameObject))
                continue;
            if (isInHitBox(gameObject)) {
                hit(gameObject);
                moveOut(gameObject);
            }
        }
        for (GameObject gameObject : level.getLevelsObjects()) {
            if (this.equals(gameObject))

                continue;
            if (isOnObject(gameObject)) {
                hit(gameObject);
                return;
            }
        }
        move(0, -jumpSpeed);
    }
}

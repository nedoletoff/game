public class Enemy extends GameObject {
    int direct = 1;
    boolean onObject;
    int leftBorder;
    int rightBorder;

    public Enemy(GameComponent component, int horizontalCoordinate, int verticalCoordinate) {
        super(component, horizontalCoordinate, verticalCoordinate);
        damage = 2;
        damageCoefficient[UP] = -1;
        damageCoefficient[LEFT] = 2;
        damageCoefficient[RIGHT] = 2;
        canMove = true;
        hitPoints = 6;
        protection = 1;
    }

    @Override
    public void update(Level level) {
        super.update(level);
        if (hitPoints >= 0) {
            if (!onObject)
                for (GameObject gameObject : level.getLevelsObjects())
                    if (isOnObject(gameObject)) {
                        leftBorder = gameObject.getHitBox()[LEFT];
                        rightBorder = gameObject.getHitBox()[RIGHT];
                        onObject = true;
                        break;
                    }
            if (onObject) {
                if (leftBorder >= getHitBox()[LEFT] || rightBorder <= getHitBox()[RIGHT]) {
                    direct *= -1;
                }
                move(direct * speed, 0);
            }
            else
               move(0, speed);
        }
    }
}

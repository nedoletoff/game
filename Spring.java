public class Spring extends GameObject {
    public Spring(GameComponent component, int horizontalCoordinate, int verticalCoordinate) {
        super(component, horizontalCoordinate, verticalCoordinate);
        canFall = true;
    }

    @Override
    public boolean isOnObject(GameObject other) {
        return  (whereIsObject(other) == DOWN && isNearHitBox(other));
    }
}

public class Coin extends GameObject{

    public Coin(GameComponent component, int horizontalCoordinate, int verticalCoordinate) {
        super(component, horizontalCoordinate, verticalCoordinate);
        hitPoints = 1;
        protection = 0;
    }

    @Override
    public void update(Level level) {
        super.update(level);
        if (hitPoints <= 0)
            level.addPoint();
    }
}

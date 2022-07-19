public class Spikes extends GameObject {

    public Spikes(GameComponent component, int horizontalCoordinate,
                  int verticalCoordinate) {
        super(component, horizontalCoordinate, verticalCoordinate);
        damage = 100;
        damageCoefficient[UP] = 1;
        damageCoefficient[LEFT] = 1;
        damageCoefficient[RIGHT] = 1;
        protection = 10;
    }
}

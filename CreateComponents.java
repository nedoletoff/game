public class CreateComponents {
    public static void main(String[] args) {
        GameComponent player = new GameComponent("player", "player.png",
                150, 150);
        GameComponent block = new GameComponent("block", "block2.png",
                200, 200);
        GameComponent enemy = new GameComponent("enemy", "enemy.png",
                150, 150);
        GameComponent coin = new GameComponent("coin", "coin.png",
                50, 50);
        GameComponent spring = new GameComponent("spring", "spring.png",
                200, 200);
        GameComponent spike = new GameComponent("spike", "spike.png",
                200, 200);
        GameComponent portal = new GameComponent("portal", "portal.png",
                150, 100);
        GameComponents.newComponent(player);
        GameComponents.newComponent(block);
        GameComponents.newComponent(enemy);
        GameComponents.newComponent(coin);
        GameComponents.newComponent(spring);
        GameComponents.newComponent(spike);
        GameComponents.newComponent(portal);
        GameComponents.save();

    }
}

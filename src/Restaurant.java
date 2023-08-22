public class Restaurant extends Defaults {
    Restaurant(Player player) {
        super(player, "restaurant");
    }

    @Override
    public boolean getLoc() {
        System.out.println("Welcome to the Restaurant!");
        return true;

    }
}

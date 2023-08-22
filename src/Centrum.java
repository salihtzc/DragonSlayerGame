public class Centrum extends Defaults {
    Centrum(Player player) {
        super(player, "centrum");
    }

    @Override
    public boolean getLoc() {
        System.out.println("Welcome to the city centre!");
        System.out.println("You can go to the restaurant, petshop and market !");
        return true;
    }
}

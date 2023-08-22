import java.util.Random;

public class HealthRoom extends Defaults {

    HealthRoom(Player player) {
        super(player,"Health Room");
    }

    @Override
    public boolean getLoc() {
        Random randomHealth = new Random();
        int incHealth = randomHealth.nextInt(10) + 1;
        System.out.println("You are in the " + this.getName());
        getPlayer().setHealth(getPlayer().getHealth() + incHealth);
        System.out.println("You are healed. Your health increased by " + incHealth);
        return true;
    }
}

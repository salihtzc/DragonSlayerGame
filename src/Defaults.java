import java.util.HashMap;
import java.util.Scanner;


public abstract class Defaults {
    private Player player;
    private String name;
    private HashMap<String, Defaults> exits;
    Scanner scan = new Scanner(System.in);


    Defaults(Player player, String name) {
        this.player = player;
        this.name = name;
        exits = new HashMap<>();
    }


    public void putExit(String direction,Defaults location) {
        exits.put(direction,location);
    }

    public HashMap<String, Defaults> getExits() {
        return exits;
    }

    public abstract boolean getLoc();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}

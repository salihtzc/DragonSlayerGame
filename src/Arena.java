import java.util.HashMap;
import java.util.Scanner;


public class Arena extends Defaults
{
    private Scanner scan = new Scanner(System.in);
    private Player player;
    private String name;
    private Monster monster;
    private HashMap<String, Arena> exits;
//    private int rewardGold;




    public Arena(Player player, String name, Monster monster /*, int rewardGold */)
    {
        super(player,name);
        this.monster = monster;
//        this.rewardGold = rewardGold;
        exits = new HashMap<>();

    }

    public boolean getLoc() {
        System.out.println("\nYou are in the : " +this.getName());
        System.out.println("Be careful! Here lives a " + monster.getName());
        System.out.println("Make a decision! <B>attle or <R>un Away");
        String letter = scan.nextLine();
        letter = letter.toUpperCase();
        if (letter.equals("B") || letter.equals("R")) {
            if (letter.equals("B")) {
                if (canHeroWinTheBattle()) {
                    if (monster.getName().equals("dragon")) {
                        player.addCrown();
                    }
                    System.out.println("You succeeded in " + this.getName() + " by killing the " + monster.getName());
                    System.out.println("");
                    return true;
                }
            }

            if (letter.equals("R")) {
                getPlayer().setHealth(getPlayer().getHealth()*80/100);
                getPlayer().setGold(getPlayer().getGold()*60/100);
                System.out.println("You ran away like a chicken");
                System.out.println("Your health and gold decreased");
                System.out.println("Current Health : " + getPlayer().getHealth());
                System.out.println("Current Gold : " + getPlayer().getGold());
                return true;
            }
            if (getPlayer().getHealth() <= 0) {
                System.out.println("You are dead! Game is over!");
                return false;
            }
        }
        return true;
    }

    public boolean canHeroWinTheBattle() {
//        getPlayer().playerStats(); yapabilirsin!!!!!!
        monsterStats();
        while (getPlayer().getHealth() > 0 && monster.getHealth() > 0) {
            System.out.println("You attacked!");
            monster.setHealth(monster.getHealth() - getPlayer().getTotalDamage());
            numbersAfterAttack();
            if (monster.getHealth() > 0) {
                System.out.println(monster.getName() + " hit!");
//               !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                getPlayer().setHealth(getPlayer().getHealth() - monster.getDamage());
//               !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                numbersAfterAttack();
            }
        }

        if (monster.getHealth() < getPlayer().getHealth()) {
            System.out.println("Congrats! You killed the" + monster.getName() + " in " + this.getName());
            System.out.println("You are rewarded with " + monster.getAward() + " gold.");
            addGold();
            return true;
        }
        else {
            return false;
        }

    }

    public void monsterStats() {
        System.out.println("Monster :" + monster.getName());
        System.out.println("Health: " + monster.getHealth());
        System.out.println("Damage: " + monster.getDamage());
        System.out.println("If you win this battle you'll be rewarded with " + monster.getAward() + " gold.");
    }

    public void numbersAfterAttack() {
        System.out.println("Your health : " + getPlayer().getHealth());
        System.out.println(monster.getName() + "health : " +monster.getHealth());
    }

    public void addGold() {
        getPlayer().setGold(getPlayer().getGold() + monster.getAward());
    }


    public void setExit(String direction, Arena room) {
        if (room!=null) exits.put(direction, room);
    }

    public Arena getExit(String direction) {
        return exits.get(direction);
    }


    public String getExitString() {
        String returnString = "Exits: ";
        for(String direction : exits.keySet()) {
            returnString += direction + " ";
        }
        return returnString;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

//    public Player getPlayer() {
//        return player;
//    }

    public void setPlayer(Player player) {
        this.player = player;
    }


}

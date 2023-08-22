import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    private int damage,health,gold;
    private String name, heroName;

    private ArrayList<Item> bag;
    private Item defaultWeapon;
    private Item defaultArmor;

    private Defaults currentLoc;
    private Defaults preLoc;

    private Item crown;

    Scanner scan = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        bag = new ArrayList<>();
        defaultWeapon = new Item("knife","weapon",1,1);
        defaultArmor = new Item("tshirt", "armor", 0, 1);
        crown = new Item("KingsCrown","Legendary",0,0);
//        currentLoc = new Market(this);
//        preLoc = new Restaurant(this);
    }

    public Item getCrown() {
        return crown;
    }

    public ArrayList<Item> getBag() {
        return bag;
    }
    public void addBag(Item item) {
        bag.add(item);
    }


    /** !!!!!!!!!!!!!!!!!!!!!!!!!   */
    public void addCrown() {
        bag.add(getCrown());
    }

    public Defaults getCurrentLoc() {
        return currentLoc;
    }

    public void setCurrentLoc(Defaults currentLoc) {
        this.currentLoc = currentLoc;
    }

    public String getName() {
        return name;
    }





    public void selectHero() {
        switch (heroMenu()) {
            case 1 :
                makePlayer("Zed",20,20,20);
                break;
            case 2 :
                makePlayer("Camille",15,30,20);
                break;
            case 3 :
                makePlayer("lucian", 25,15,20);
                break;
            case 4 :
                makePlayer("Sett",10,40,20);
                break;
            case 5 :
                makePlayer("Lux",10,15,50);
                break;
            default:
                makePlayer("Teemo",5,5,30);
                break;
        }
        System.out.println("Your hero is " + getHeroName()
                + "\n Damage: "+getDamage() + ", Health: "
                + getHealth() + ", Gold: " + getGold());

    }


    public int heroMenu() {
        System.out.println("Choose your hero! ");
        System.out.println("1- Zed, Damage:20 Health:20 Gold:20");
        System.out.println("2- Camille, Damage:15 Health:30 Gold:20");
        System.out.println("3- Lucian, Damage:25 Health:15 Gold:20");
        System.out.println("4- Sett, Damage:10 Health:40 Gold:20");
        System.out.println("5- Lux, Damage:10 Health:15 Gold:50");
        System.out.println("Your decision is: ");

        int heroID = 0;

        try {
            heroID = scan.nextInt();
            if (heroID < 1 || heroID > 5) {
                System.out.println("Hero ID should be between 1 and 5 !");
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Please enter a valid input type!");
            scan.next();
            heroMenu();
        }
        catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Something went wrong. Please enter a valid input type to choose hero you want.");
            heroMenu();
        }

        return heroID;
    }



    public void makePlayer(String hName, int dmg,int hlth, int gld) {
        setHeroName(hName);
        setDamage(dmg);
        setHealth(hlth);
        setGold(gld);
    }


    public int getTotalDamage() {
        return this.getDamage()+getDefaultWeapon().getDamage();
    }

    public int getTotalHealth() {
        return getHealth()+getDefaultArmor().getBlock();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }


    public Item getDefaultWeapon() {
        return defaultWeapon;
    }

    public void setDefaultWeapon(Item defaultWeapon) {
        this.defaultWeapon = defaultWeapon;
    }

    public Item getDefaultArmor() {
        return defaultArmor;
    }

    public void setDefaultArmor(Item defaultArmor) {
        this.defaultArmor = defaultArmor;
    }


    public Defaults getPreLoc() {
        return preLoc;
    }

    public void setPreLoc(Defaults preLoc) {
        this.preLoc = preLoc;
    }
}


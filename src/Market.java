import java.util.Scanner;

public class Market extends Defaults {

    Market(Player player)
    {
        super(player,"market");
    }

    private Scanner scan = new Scanner(System.in);

    public boolean getLoc() {
        System.out.println("Welcome to the Market!");
        System.out.println("You have : " + getPlayer().getGold() + " gold." );
        System.out.println("1. Weapons");
        System.out.println("2. Armors");
        System.out.println("3. Legendary Items");
        System.out.println("4. Quit");
        System.out.println("Your choice: ");

        int selItem = scan.nextInt();
        int itemID;
        switch (selItem) {
            case 1 :
                itemID = weaponMenu();
                buyWeapon(itemID);
                break;
            case 2 :
                itemID = armorMenu();
                buyArmor(itemID);
                break;
            case 3 :
                itemID = legendaryMenu();
                buyLegendary(itemID);
                break;
            default :
                break;
        }

        return true;
    }

    public int weaponMenu() {
        System.out.println("1. Sheen\t Price : 25 - Damage : 10 ");
        System.out.println("2. Dagger\t Price : 35 - Damage : 15 ");
        System.out.println("3. Phage\t Price : 45 - Damage : 20 ");
        System.out.println("4. Quit");
        System.out.print("Your choice : ");
        int selWeaponID = scan.nextInt();
        return selWeaponID;
    }

    public void buyWeapon(int itemID) {
        Item item = null;
        int price = 0;
        Item sheen = new Item("Sheen", "Weapon", 10, 0);
        Item dagger = new Item("Dagger", "Weapon", 15, 0);
        Item phage = new Item("Phage", "Weapon", 20, 0);


        switch (itemID) {
            case 1:
                item = sheen;
                price = 25;
                break;
            case 2:
                item = dagger;
                price = 35;
                break;
            case 3:
                item = phage;
                price = 45;
                break;
            case 4:
                System.out.println("Quitting");
                break;
            default:
                System.out.println("Invalid entry !");
                break;
        }

        if (price > 0) {
            if (getPlayer().getGold() > price) {

                getPlayer().setGold(getPlayer().getGold() - price);
                System.out.println("You bought a" + item.getiName());
                System.out.println("Remaining money :" + getPlayer().getGold());
                getPlayer().getBag().add(item);
                getPlayer().setDamage(getPlayer().getDamage() + item.getDamage());
            } else {
                System.out.println("Not enough money. !");
            }
        }
    }


    public int armorMenu() {
        System.out.println("1. Light Armor \t Price : 15 - Block : 10 ");
        System.out.println("2. Normal Armor \t Price : 25 - Block : 15 ");
        System.out.println("3. Heavy Armor \t Price : 40 - Block : 20 ");
        System.out.println("4. Quit");
        System.out.print("Your choice : ");
        int selArmorID = scan.nextInt();
        return selArmorID;
    }

    public void buyArmor(int itemID) {
        Item item = null;
        int price = 0;
        Item doranShield = new Item("Doran Shield", "Armor", 0, 10);
        Item chainVest = new Item("Chain Vest", "Armor", 0, 15);
        Item giantsBelt = new Item("Giant's Belt", "Armor", 0, 20);
        switch (itemID) {
            case 1:
                item = doranShield;
                price = 15;
                break;
            case 2:
                item = chainVest;
                price = 25;
                break;
            case 3:
                item = giantsBelt;
                price = 40;
                break;
            case 4:
                System.out.println("Quitting.");
                break;
            default:
                System.out.println("Invalid entry !");
                break;
        }

        if (price > 0) {
            if (getPlayer().getGold() >= price) {
                getPlayer().setGold(getPlayer().getGold() - price);
                System.out.println("You bought " + item.getiName() + ".");
                System.out.println("Remaining Money :" + getPlayer().getGold());
                getPlayer().getBag().add(item);
                getPlayer().setHealth(getPlayer().getHealth() + item.getBlock());
            } else {
                System.out.println("Not enough money. !");
            }
        }
    }

    public int legendaryMenu() {
        System.out.println("1. Zhonya \t Price : 250 - Damage : 60 - Block : 80 ");
        System.out.println("2. Doran \t Price : 350 - Damage : 80 - Block : 100");
        System.out.println("3. Rabadon \t Price : 500 - Damage : 100 - Block : 120");
        System.out.println("4. Quit");
        System.out.println("Your choice : ");
        int legendaryID = scan.nextInt();
        return legendaryID;
    }



    public void buyLegendary(int itemID) {
        Item item = null;
        int price = 0;
        Item zhonya = new Item("Zhonya", "Legendary",60,80);
        Item doran = new Item("Doran", "Legendary",80,100);
        Item rabadon = new Item("Rabadon", "Legendary",100,120);

        switch (itemID) {
            case 1 :
                item = zhonya;
                price = 250;
                break;
            case 2 :
                item = doran;
                price = 350;
                break;
            case 3 :
                item = rabadon;
                price = 500;
                break;
            case 4 :
                System.out.println("Quitting");
                break;
            default:
                System.out.println("Please enter a valid number!");
                break;
        }

        if (price > 0) {
            if (getPlayer().getGold() > price) {
                getPlayer().setGold(getPlayer().getGold() - price);
                System.out.println("You bought a " + item.getiName());
                System.out.println("You have " + getPlayer().getGold() + "gold.");
                getPlayer().getBag().add(item);
                getPlayer().setHealth(getPlayer().getHealth() + item.getBlock());
                getPlayer().setDamage(getPlayer().getDamage() + item.getDamage());
            }
            else {
                System.out.println("Not enough money!");
            }
        }
    }

}

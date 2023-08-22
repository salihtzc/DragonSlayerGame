
public class Petshop extends Defaults{

    Petshop(Player player) {
        super(player,"Petshop");
    }
    @Override
    public boolean getLoc() {
        System.out.println("Welcome!");
        System.out.println("You are in : " + this.getName());
        System.out.println("Your gold: " + getPlayer().getGold());
        System.out.println("Would you like to buy a new pet ?");
        System.out.println("<Y>es or <N>o");
        String letter = scan.nextLine();
        letter = letter.toUpperCase();
        if (letter.equals("Y")) {
            buyPet(petMenu());
            return true;
        }
        else {
            System.out.println("Quitting");
        }
        return true;
    }

    public int petMenu() {
        System.out.println("1.Cat \t Price: 15 ");
        System.out.println("2.Dog \t Price: 15 ");
        System.out.println("3.Bird \t Price: 15 ");
        System.out.println("4.Little Dino \t Price: 100 ");
        System.out.println("5.Turtle \t Price: 25 ");
        System.out.println("6.Horse \t Price: 40 ");
        System.out.println("7.Quit");
        System.out.println("Your choice : ");

        int number = scan.nextInt();
        return number;
    }

    public void buyPet(int itemId) {
        Item item = null;
        int price = 0;

        Item cat = new Item("Cat","Pet",0,0);
        Item dog = new Item("Dog","Pet",0,0);
        Item bird = new Item("Bird","Pet",0,0);
        Item littleDino = new Item("Little Dino","Pet",0,0);
        Item turtle = new Item("Turtle","Pet",0,0);
        Item horse = new Item("Horse","Pet",0,0);

        switch (itemId) {
            case 1:
                item = cat;
                price = 15;
                break;
            case 2:
                item = dog;
                price = 15;
                break;
            case 3:
                item = bird;
                price = 15;
                break;
            case 4:
                item = littleDino;
                price = 100;
                break;
            case 5:
                item = turtle;
                price = 25;
                break;
            case 6:
                item = horse;
                price = 40;
                break;
            case 7:
                System.out.println("Quitting");
                break;
            default:
                System.out.println("Invalid entry! ");
                break;

        }

        if (price > 0) {
            if (getPlayer().getGold() >= price) {
                getPlayer().setGold(getPlayer().getGold() - price);
                System.out.println("You bought a new" + item.getiName() );
                System.out.println("Remaining gold = " + getPlayer().getGold());
                getPlayer().getBag().add(item);
            }
            else {
                System.out.println("Not enough gold!");
            }
        }
    }
}

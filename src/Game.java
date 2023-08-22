import java.util.HashMap;
import java.util.Scanner;

public class Game {
    Player player;

    Scanner scan = new Scanner(System.in);



    public void play() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Java game !!!");
        System.out.println("The character names and items in this game are inspired by League of Legends");
        System.out.println("Please enter a player name :");
        String newName = scan.nextLine();
        player = new Player(newName);
        player.selectHero();
        createGame(player);

        start();
    }

//    public static Arena dungeonOfDragon(){
//        return dungeonOfDragon = new Arena(player,"Dungeon Of Dragon",dragon);
//    }

    public  void createGame(Player player) {



        Monster gromp = new Monster("gromp",10,20,20);
        Monster blueSentinel = new Monster("blueSentinel",25,40,60);
        Monster redBrumblebrack = new Monster("redBrumblebrack",30,50,75);
        Monster riftScuttler = new Monster("riftScuttler",15,25,40);
        Monster crimsonRaptor = new Monster("crimsonRaptor",10,20,30);
        Monster murkWolf = new Monster("murkWolf",20,30,35);
        Monster ancientKrug = new Monster("ancientKrug",20,25,45);
        Monster dragon = new Monster("Dragon",200,200,30000);



        Defaults arena1 = new Arena(player,"arena1",crimsonRaptor);
        Defaults arena2 = new Arena(player,"arena2",riftScuttler);
        Defaults arena3 = new Arena(player,"arena3",ancientKrug);
        Defaults arena4 = new Arena(player,"arena4",blueSentinel);
        Defaults arena5 = new Arena(player,"arena5",redBrumblebrack);
        Defaults bonusRoom1 = new Arena(player,"bonusRoom1",gromp);
        Defaults bonusRoom2 = new Arena(player,"bonusRoom2",murkWolf);
        Defaults dungeonOfDragon = new Arena(player,"Dungeon Of Dragon",dragon);


        Defaults market = new Market(player);
        Defaults petshop = new Petshop(player);
        Defaults restaurant = new Restaurant(player);
        Defaults centrum = new Centrum(player);
        Defaults healthroom = new HealthRoom(player);
        Defaults base = new Base(player);

        centrum.putExit("restaurant",restaurant);
        centrum.putExit("healthroom",healthroom);
        centrum.putExit("market",market);
        centrum.putExit("petshop",petshop);
        centrum.putExit("base",base);

        market.putExit("arena1",arena1);
        market.putExit("arena2",arena2);
        market.putExit("arena3",arena3);
        market.putExit("arena4",arena4);
        market.putExit("arena5",arena5);
        market.putExit("centrum",centrum);
        market.putExit("base",base);



        restaurant.putExit("centrum",centrum);
        restaurant.putExit("petshop",petshop);
        restaurant.putExit("healthroom",healthroom);
        restaurant.putExit("base",base);


        petshop.putExit("centrum",centrum);
        petshop.putExit("restaurant",restaurant);
        petshop.putExit("healthroom",healthroom);
        petshop.putExit("base",base);


        healthroom.putExit("centrum",centrum);
        healthroom.putExit("restaurant",restaurant);
        healthroom.putExit("petshop",petshop);
        healthroom.putExit("base",base);


        base.putExit("centrum",centrum);
        base.putExit("restaurant",restaurant);
        base.putExit("arena1",arena1);
        base.putExit("market",market);
        base.putExit("petshop",petshop);
        base.putExit("healthroom",healthroom);


        arena1.putExit("market",market);
        arena1.putExit("arena2",arena2);
        arena1.putExit("base",base);


        arena2.putExit("market",market);
        arena2.putExit("arena1",arena1);
        arena2.putExit("arena3",arena3);
        arena2.putExit("bonusroom1",bonusRoom1);

        bonusRoom1.putExit("arena2",arena2);

        arena3.putExit("market",market);
        arena3.putExit("arena2",arena2);
        arena3.putExit("arena4",arena4);

        arena4.putExit("market",market);
        arena4.putExit("arena3",arena3);
        arena4.putExit("arena5",arena5);
        arena4.putExit("bonusRoom2",bonusRoom2);

        bonusRoom2.putExit("arena4",arena4);

        arena5.putExit("market",market);
        arena5.putExit("arena4",arena4);
        arena5.putExit("dungeonofdragon",dungeonOfDragon);


        dungeonOfDragon.putExit("arena5",arena5);

        player.setCurrentLoc(market);
        player.setPreLoc(restaurant);



    }

//     public  static Item getCrown() {
//         return new Item("Princess Crown","Legendary",0,0);
//     }


    public void start() {

        while (true) {


            if (player.getBag().contains(player.getCrown())) {
                System.out.println("You killed all the monsters in the game.");
                System.out.println("You killed the dragon and saved the king.");
                System.out.println("The king honored you by giving a crown to you");
                System.out.println("You WIN !!!");

                break;
            }

            HashMap<String, Defaults> exits = player.getCurrentLoc().getExits();
//            playerStats(); !1
            System.out.println("\nPossible Locations");
            places();
            System.out.println("Where do you want to go?");
            String loca = scan.nextLine();
            loca = loca.replaceAll("\\s", "")
                    .toLowerCase();


            if (!exits.containsKey(loca) /*&& !loca.equals("back")*/) {

                    System.out.println("Enter a valid location name!");
                    System.out.println("");
                    loca = scan.nextLine();

            }

                else{
                    player.setPreLoc(player.getCurrentLoc());
                    player.setCurrentLoc(exits.get(loca));
                }

                if (!player.getCurrentLoc().getLoc()) {
                    System.out.println("GAME OVER!");
                    break;
                }


        }
    }



        public void places() {

            Defaults currentLocation = player.getCurrentLoc();
            HashMap<String,Defaults> exits = currentLocation.getExits();
            for (String room : exits.keySet()) {
                System.out.println("Go " + exits.get(room).getName());
            }

        }





}
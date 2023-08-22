public class Base extends Defaults{

    Base(Player player) {
        super(player, "base");
    }
    @Override
    public boolean getLoc() {
        System.out.println(" ");
        System.out.println("Welcome to your Base!\n");

            if (getPlayer().getBag().isEmpty()) {
                System.out.println("There is no item in your bag. It's empty. ");
            }
            else {
                System.out.println("-----------   Items   -----------");
            }


            for (int i = 0 ; i< getPlayer().getBag().size(); i++) {
//                System.out.println("List of items you have : ");
                System.out.println("\n" + getPlayer().getBag().get(i).getiName() );
            }
            System.out.println(" ");
            System.out.println(" ------------------------------ ");


        return true;
    }

}



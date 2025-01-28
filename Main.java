import java.util.*;

public class Main
{

    public static void main(String[] args)
    {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        boolean gameState = true;

        while(gameState)
        {

            System.out.println("What do you want to do?");
            String command = scanner.nextLine();

            if (command.equals("add"))
            {
                System.out.println("Type the name of the item you would like to add.");
                String name = scanner.next();
                System.out.println("Type the rarity of the item you would like to add.");
                System.out.println("0 - COMMON \n 1 - GREAT \n 2 - RARE \n 3 - EPIC \n 4 - LEGENDARY ");
                int rarity = scanner.nextInt();
                int count = 0;

                if (rarity == 3)
                {
                    System.out.println("Type the number of EPIC Upgrade Count from 0 to 2.");
                    count = -1;
                    while (count < 0 || count > 2)
                    {
                        count = scanner.nextInt();
                        if (count < 0 || count > 2)
                            System.out.println("Invalid value");
                    }

                }
                Item item = new Item(name, Rarity.rarityConvertor(rarity), count);
                inventory.addItem(item);
                System.out.println("Successfully added");
            }

            else if (command.equals("show"))
            {
                System.out.println("You have");
                System.out.println(inventory.showInventory());
            }

            else if (command.equals("upgrade"))
            {
                System.out.println("What item do you want to upgrade?");
                String name = scanner.next();
                inventory.upgradeItem(name);
            }


            else if (command.equals("exit"))
            {
                break;
            }
            else
            {
                System.out.println("Invalid command,try again.");
            }
            scanner.nextLine();
        }
    }


}

import java.net.InterfaceAddress;
import java.util.*;

public class Inventory
{
    ArrayList<Item> inventory = new ArrayList<Item>();

    public Inventory()
    {

    }

    public void addItem(Item item)
    {
        inventory.add(item);
    }

    public void addItem(String name, Rarity rarity, int upgradeCount)
    {
        Item item = new Item(name, rarity, upgradeCount);
        inventory.add(item);
    }

    public void removeItem(Item item)
    {
        inventory.remove(item);
    }


    public String showInventory()
    {
        StringBuilder output = new StringBuilder();
        for (Item item : inventory)
        {
            output.append(item.toString());
        }
        return output.toString();
    }


    public boolean upgradeItem(String name)
    {
        Map<Rarity, List<Item>> groupedItems = new HashMap<>();

        for (Item item : inventory)
        {
            if (item.getName().equals(name))
            {
                groupedItems.computeIfAbsent(item.getRarity(), k -> new ArrayList<>()).add(item);
            }
        }



        for (Rarity rarity : groupedItems.keySet())
        {
            List<Item> sameRarityItems = groupedItems.get(rarity);

            if (rarity == Rarity.EPIC)
            {
                Map<Integer, List<Item>> groupedItemsByCount0 = new HashMap<>();
                Map<Integer, List<Item>> groupedItemsByCount1 = new HashMap<>();
                Map<Integer, List<Item>> groupedItemsByCount2 = new HashMap<>();
                for (Item item : sameRarityItems)
                {
                    if (item.getUpgradeCount() == 0)
                    {
                        groupedItemsByCount0.computeIfAbsent(0, k -> new ArrayList<>()).add(item);
                    }
                    if (item.getUpgradeCount() == 1)
                    {
                        groupedItemsByCount1.computeIfAbsent(1, k -> new ArrayList<>()).add(item);
                    }
                    if (item.getUpgradeCount() == 2)
                    {
                        groupedItemsByCount2.computeIfAbsent(2, k -> new ArrayList<>()).add(item);
                    }
                }

                boolean bRet = false;
                if (groupedItemsByCount0.size() > 0)
                {
                    List<Item> count0Items = groupedItemsByCount0.get(0);
                    if(count0Items.size() >= 2)
                    {
                        for (int i = 0; i < 2; i++)
                        {
                            removeItem(count0Items.get(i));
                        }
                        Item upgradedItem = new Item(name, rarity, 1);
                        addItem(upgradedItem);
                        System.out.println("Successfully upgraded " +name+ " to Epic 2.");
                        bRet = true;
                    }
                }
                if (groupedItemsByCount1.size() > 0 && groupedItemsByCount0.size() > 0)
                {
                    List<Item> count0Items = groupedItemsByCount0.get(0);
                    List<Item> count1Items = groupedItemsByCount1.get(1);
                    if (count0Items.size() >= 1 && count1Items.size() >= 1)
                    {
                        for (int i = 0; i < 1; i++)
                        {
                            removeItem(count0Items.get(i));
                            removeItem(count1Items.get(i));
                        }
                        Item upgradedItem = new Item(name, rarity, 2);
                        addItem(upgradedItem);
                        System.out.println("Successfully upgraded " +name+ " to Epic 2.");
                        bRet = true;
                    }
                }

                if (groupedItemsByCount2.size() > 0)
                {
                    List<Item> count2Items = groupedItemsByCount2.get(2);
                    if (count2Items.size() >= 3 )
                    {
                        for (int i = 0; i < 3; i++)
                        {
                            removeItem(count2Items.get(i));
                        }

                        Item upgradedItem = new Item(name, rarity.nextRarity(), 0);
                        addItem(upgradedItem);
                        System.out.println("Successfully upgraded " + name + " to Legendary.");
                        bRet = true;
                    }
                }
                if(bRet)
                    return bRet;
            }
            else
            {


                if (sameRarityItems.size() >= 3)
                {
                    for (int i = 0; i < 3; i++)
                    {
                        removeItem(sameRarityItems.get(i));
                    }

                    Item upgradedItem = new Item(name, rarity.nextRarity(), 0);
                    addItem(upgradedItem);
                    System.out.println("Successfully upgraded " + name + " to " + upgradedItem.getRarity() + ".");
                    return true;
                }
            }
        }

        System.out.println("Not enough items to upgrade " + name + ".");
        return false;
    }






}

public class Item
{
    private String name;
    private Rarity rarity;
    private int upgradeCount;


    public boolean setName(String name)
    {
        if (name == null || name.isBlank() )
            return false;
        this.name = name;
        return true;
    }
    public String getName()
    {
        return name;
    }

    public void setRarity(Rarity rarity)
    {
        this.rarity = rarity;
    }
    public Rarity getRarity()
    {
        return rarity;
    }

    public boolean setUpgradeCount(int upgradeCount)
    {
        if (upgradeCount < 0 || upgradeCount > 2)
            return false;
        this.upgradeCount = upgradeCount;
        return true;
    }
    public int getUpgradeCount()
    {
        return upgradeCount;
    }


    public Item(String name, Rarity rarity, int upgradeCount)
    {
        setName(name);
        setRarity(rarity);
        setUpgradeCount(upgradeCount);
    }


    public Item(Item item)
    {
        setName(item.name);
        setRarity(item.rarity);
        setUpgradeCount(item.upgradeCount);
    }



    @Override
    public String toString ()
    {
        return "|Name: " + getName() + "\t |Rarity: " + getRarity() + "\t |Upgrade count  "+ getUpgradeCount() + "\n" ;
    }



    @Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }

        if (!(o instanceof Item)) {
            return false;
        }

        Item c = (Item) o;

        return c.name.equals(this.name)
                && this.rarity == c.rarity && this.upgradeCount == c.upgradeCount;
    }





}

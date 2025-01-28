public enum Rarity
{
    COMMON, GREAT, RARE, EPIC, LEGENDARY;

    public Rarity nextRarity()
    {
        int nextOrdinal = this.ordinal() + 1;
        if (nextOrdinal < Rarity.values().length)
        {
            return Rarity.values()[nextOrdinal];
        }
        return null;
    }

    public static Rarity rarityConvertor(int rarity)
    {
        Rarity r = Rarity.values()[rarity];
        return r;
    }



}

package shop;

import items.Item;

public class ShopItem
{
    public ShopItem(int prize, Item item, int quantity)
    {
        this.prize = prize;
        this.item = item;
        this.quantity = quantity;
    }

    public int getPrize()
    {
        return prize;
    }

    public Item getItem()
    {
        return item;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void addQuantity(int amount)
    {
        quantity += amount;
    }

    public void subQuantity(int amount)
    {
        quantity -= amount;
    }

    private final int prize;
    private final Item item;
    private int quantity;
}

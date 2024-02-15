package shop;

import items.Weapon;
import utils.GameLogic;

public class ShopWeapon
{
    public ShopWeapon(Weapon weapon, int prize)
    {
        this.weapon = weapon;
        this.prize = prize;
    }

    public int getPrize()
    {
        return prize;
    }

    public Weapon getWeapon()
    {
        return weapon;
    }

    public void showShopInfo()
    {
        GameLogic.println(weapon.getName() + "\t" + prize);
    }

    private final int prize;
    private final Weapon weapon;
}

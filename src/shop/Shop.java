package shop;

import characters.Player;
import items.Weapon;
import utils.GameLogic;

import java.util.ArrayList;

public class Shop
{
    public Shop()
    {
        potionsQuantity = 1;
        weapons = new ArrayList<>();
        numberList = 2;
    }

    public void addWeapon(Weapon newWeapon, int prize)
    {
        ShopWeapon shopWeapon = new ShopWeapon(newWeapon, prize);
        weapons.add(shopWeapon);
    }

    public void resetWeapons()
    {
        weapons.clear();
    }

    public void shopping(Player player)
    {
        boolean quitShop = false;

        while (!quitShop)
        {
            GameLogic.println("You have: " + player.getGold() + " gold");
            showPotions();
            showWeapons();
            GameLogic.printSeparator(20);
            GameLogic.println("Which item you want to look closer?");
            int itemIndex = GameLogic.readInt(weapons.size() + 1);

            GameLogic.clearConsole();

            if (itemIndex == 1)
            {
                GameLogic.println("A potion is a magical concoction used to heal wounds and restore health, often contained in a small vial and brewed with a mix of mystical herbs and enchanted ingredients.");
            }
            else
            {
                weapons.get(itemIndex - 2).getWeapon().showInfo();
            }
            GameLogic.println("(1) Buy.");
            GameLogic.println("(2) Back to shop.");
            GameLogic.println("(3) Quit shop.");
            int input = GameLogic.readInt(3);
            boolean boughtWeapon = false;
            boolean boughtPotion = false;
            switch (input)
            {
                case 1:
                {
                    if (itemIndex == 1)
                    {
                        if (potionsQuantity < 1)
                        {
                            GameLogic.println("There is no potions to buy. Sorry.");
                        }
                        else
                        {
                            boughtPotion = player.buyPotion();
                        }
                    }
                    else
                    {
                        boughtWeapon = player.buyWeapon(weapons.get(itemIndex - 2));
                    }
                    GameLogic.enterToContinue();
                    GameLogic.clearConsole();
                    break;
                }
                case 2:
                {
                    GameLogic.clearConsole();
                    break;
                }
                case 3:
                {
                    quitShop = true;
                    GameLogic.clearConsole();
                    break;
                }
            }

            if (boughtWeapon)
            {
                weapons.remove(itemIndex - 2);
            }
            if (boughtPotion)
            {
                potionsQuantity--;
            }
        }
    }

    public void setPotionsQuantity(int quantity)
    {
        potionsQuantity = quantity;
    }

    private void showPotions()
    {
        GameLogic.printSeparator(20);
        GameLogic.println("POTIONS");
        GameLogic.printSeparator(20);
        GameLogic.println("(#) Name\t\tPrize\t\tQuantity");
        GameLogic.print("(1) ");
        GameLogic.println("Heal Potion" + "\t\t" + 5 + "\t\t" + potionsQuantity);
        numberList = 2;
    }

    private void showWeapons()
    {
        GameLogic.printSeparator(20);
        GameLogic.println("WEAPONS");
        GameLogic.printSeparator(20);
        GameLogic.println("(#) Name\t\tPrize");
        for (ShopWeapon weapon : weapons)
        {
            GameLogic.print("(" + numberList++ + ") ");
            weapon.showShopInfo();
        }
    }

    private int potionsQuantity;
    private ArrayList<ShopWeapon> weapons;
    private int numberList;
}

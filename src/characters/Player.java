package characters;

import utils.GameLogic;

public class Player extends Character
{
    // Player specific constructor
    public Player(String name)
    {
        // calling constructor of superclass
        super(name, 100, 0);
        // setting # of upgrades to 0
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;
        // set additional stats
        this.gold = 5;
        this.pots = 0;
        // let the player choose a trait when creating a new character
        chooseTrait();
    }

    // Player specific methods
    @Override
    public int attack()
    {
        return (int) (Math.random() * (xp / 4 + numAtkUpgrades * 3 + 3) + xp / 10 + numAtkUpgrades * 2 + numDefUpgrades + 1);
    }

    @Override
    public int defend()
    {
        return (int) (Math.random() * (xp / 4 + numDefUpgrades * 3 + 3) + xp / 10 + numDefUpgrades * 2 + numAtkUpgrades + 1);
    }

    // let the player choose a trait of either skill path
    public void chooseTrait()
    {
        GameLogic.clearConsole();
        GameLogic.printHeading("Choose a trait:");
        GameLogic.println("(1) " + atkUpgrades[numAtkUpgrades]);
        GameLogic.println("(2) " + defUpgrades[numDefUpgrades]);
        // get the players choice
        int input = GameLogic.readInt(2);
        GameLogic.clearConsole();
        // deal with both cases
        if (input == 1)
        {
            GameLogic.printHeading("You chose " + atkUpgrades[numAtkUpgrades] + "!");
            numAtkUpgrades++;
        }
        else
        {
            GameLogic.printHeading("You chose " + defUpgrades[numDefUpgrades] + "!");
            numDefUpgrades++;
        }
        GameLogic.enterToContinue();
    }

    // gold methods
    public int getGold()
    {
        return gold;
    }

    public void addGold(int gold)
    {
        this.gold += gold;
    }

    public void subGold(int gold)
    {
        this.gold -= gold;
    }

    // pots methods
    public int getPots()
    {
        return pots;
    }

    public void subPots()
    {
        pots--;
    }

    public void addPot()
    {
        pots++;
    }

    // hp methods
    public void restoreFullHp()
    {
        hp = maxHp;
    }

    public void restoreHp(int hp)
    {
        if (this.hp + hp > maxHp)
        {
            restoreFullHp();
        }
        else
        {
            this.hp += hp;
        }
    }

    // xp methods
    public void addXp(int xp)
    {
        this.xp += xp;
    }

    // integers to store number of upgrades/skills in each path
    public int numAtkUpgrades, numDefUpgrades;

    // arrays to store skill names
    public String[] atkUpgrades = {"Strength", "Power", "Might", "Godlike Strength"};
    public String[] defUpgrades = {"Heavy Bones", "Stoneskin", "Scale Armor", "Holy Aura"};

    // additional player stats
    private int gold;
    private int pots;
}

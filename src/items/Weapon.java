package items;

import utils.GameLogic;

public class Weapon extends Item
{
    // constructor
    public Weapon(String name, int strength, int intelligence, int prize)
    {
        this.name = name;
        this.strength = strength;
        this.intelligence = intelligence;
        this.prize = prize;
    }

    public void shopWindow()
    {
        showDescription();
        GameLogic.println("Prize:\t" + prize + "g");
    }

    public void showDescription()
    {
        GameLogic.println("Name:\t\t" + name);
        GameLogic.println("Strength:\t" + strength);
        GameLogic.println("Intelligence:\t" + intelligence);
    }

    public String getName()
    {
        return name;
    }

    public int getStrength()
    {
        return strength;
    }

    public int getIntelligence()
    {
        return intelligence;
    }

    public int getPrize()
    {
        return prize;
    }

    private final String name;
    private final int strength;
    private final int intelligence;
    private final int prize;
}

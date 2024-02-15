package weapons;

import utils.GameLogic;

public class Weapon
{
    // constructor
    public Weapon(String name, int strength, int intelligence)
    {
        this.name = name;
        this.strength = strength;
        this.intelligence = intelligence;
    }

    public void showDescription()
    {
        GameLogic.println("Name:\t" + name);
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

    private final String name;
    private final int strength;
    private final int intelligence;
}

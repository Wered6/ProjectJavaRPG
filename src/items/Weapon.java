package items;

import utils.GameLogic;

public class Weapon extends Item
{
    // constructor
    public Weapon(String name, int strength, int intelligence)
    {
        super(name);
        this.strength = strength;
        this.intelligence = intelligence;
    }

    @Override
    public void showInfo()
    {
        super.showInfo();
        GameLogic.println("Strength:\t" + strength);
        GameLogic.println("Intelligence:\t" + intelligence);
    }

    public int getStrength()
    {
        return strength;
    }

    public int getIntelligence()
    {
        return intelligence;
    }

    private final int strength;
    private final int intelligence;
}

package items;

import utils.GameLogic;

public class Weapon extends Item
{
    // constructor
    public Weapon(String name, int strength, int intelligence, String description)
    {
        super(name);
        this.strength = strength;
        this.intelligence = intelligence;
        this.description = description;
    }

    @Override
    public void showInfo()
    {
        super.showInfo();
        GameLogic.println("Description:\t" + description);
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
    private final String description;
}

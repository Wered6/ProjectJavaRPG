package spells;

import utils.GameLogic;

abstract public class Spell
{
    public Spell(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public String getName()
    {
        return name;
    }

    public void showInfo()
    {
        GameLogic.println("Name:\t\t" + name);
        GameLogic.println("Description:\t" + description);
    }

    private String name;
    private String description;
}

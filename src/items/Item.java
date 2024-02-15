package items;

import utils.GameLogic;

abstract public class Item
{
    public Item(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void showInfo()
    {
        GameLogic.println("Name:\t" + name);
    }

    protected final String name;
}

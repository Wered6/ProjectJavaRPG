package characters;

abstract public class Character
{
    // constructor for character
    public Character(String name, int maxHp, int xp)
    {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.xp = xp;
    }

    // methods every character has
    public abstract int attack();

    public abstract int defend();

    public void receiveDmg(int dmg)
    {
        hp -= dmg;
    }

    // getters
    public String getName()
    {
        return name;
    }

    public int getMaxHp()
    {
        return maxHp;
    }

    public int getHp()
    {
        return hp;
    }

    public int getXp()
    {
        return xp;
    }

    // attributes all characters have
    protected String name;
    protected int maxHp, hp, xp;
}

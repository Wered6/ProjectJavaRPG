package characters;

public abstract class Character
{
    // constructor for character
    public Character(String name, int maxHp, int hp, int xp)
    {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = hp;
        this.xp = xp;
    }

    // methods every character has
    public abstract int attack();

    public abstract int defend();

    // attributes all characters have
    private String name;
    private int maxHp, hp, xp;
}

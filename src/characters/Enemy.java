package characters;

public class Enemy extends Character
{

    public Enemy(String name, int maxHp, int hp, int xp)
    {
        super(name, maxHp, hp, xp);
    }

    @Override
    public int attack()
    {
        return 0;
    }

    @Override
    public int defend()
    {
        return 0;
    }
}

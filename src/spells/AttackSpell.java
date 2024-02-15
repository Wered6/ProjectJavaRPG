package spells;

import utils.GameLogic;

public class AttackSpell extends Spell
{
    public AttackSpell(String name, String description, int baseMinDamage, int baseMaxDamage)
    {
        super(name, description);
        this.baseMinDamage = baseMinDamage;
        this.baseMaxDamage = baseMaxDamage;
    }

    public int attack(int intelligence)
    {
        int damage = baseMinDamage + (int) (Math.random() * ((baseMaxDamage - baseMinDamage) + 1));
        return damage + intelligence;
    }

    @Override
    public void showInfo()
    {
        super.showInfo();
        GameLogic.println("Damage:\t\t" + baseMinDamage + "-" + baseMaxDamage);
    }

    int baseMinDamage;
    int baseMaxDamage;
}

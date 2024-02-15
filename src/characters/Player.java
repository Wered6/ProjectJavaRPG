package characters;

import spells.AttackSpell;
import spells.UtilitySpell;
import items.Weapon;
import utils.GameLogic;

import java.util.ArrayList;

public class Player extends Character
{
    // Player specific constructor
    public Player(String name)
    {
        // calling constructor of superclass
        super(name, 100, 0);

        // set additional stats
        this.gold = 5;
        this.pots = 0;

        // set skills
        // strength
        this.baseStrength = 5;
        this.weaponStrength = 0;
        this.buffStrength = 0;

        // intelligence
        this.baseIntelligence = 5;
        this.weaponIntelligence = 0;
        this.buffIntelligence = 0;

        // set spells
        this.attackSpells = new ArrayList<>();
        this.utilitySpells = new ArrayList<>();

        // set first weapon
//        setWeapon(new Weapon("Dagger", 1, 0));

        // set first spell
        addAttackSpell(new AttackSpell("Fire Ball", "Basic small fire ball.", 0, 2));

        // set skillPoints
        this.skillPoints = 4;
        // method to spend those Points
        spendSkillPoints();
    }

    // Player specific methods
    @Override
    public int attack()
    {
        GameLogic.printHeading("Choose attack type!");
        GameLogic.println("(1) Attack with weapon.");
        GameLogic.println("(2) Attack with spell.");
        int input = GameLogic.readInt(2);
        return switch (input)
        {
            case 1 -> attackWithWeapon();
            case 2 -> attackWithSpell();
            default -> 0;
        };
    }

    private int attackWithWeapon()
    {
        return getStrength();
    }

    private int attackWithSpell()
    {
        GameLogic.printHeading("Attack Spells");
        AttackSpell attackSpell = chooseSpell();
        int intelligence = getIntelligence();

        return attackSpell.attack(intelligence);
    }

    public void useUtilitySpell()
    {
        // buff
        // heal
    }
    // todo perform some magic action heal, buff

    public void spendSkillPoints()
    {
        int skillChoice;
        int points;
        String[] skillNames = {"Strength", "Intelligence"};

        while (skillPoints > 0)
        {
            GameLogic.clearConsole();
            GameLogic.printHeading("Spend skill points!");
            GameLogic.println("Remember!\nIntelligence will boost your spells.\nStrength will boost your attack with weapons.");
            GameLogic.printSeparator(20);
            GameLogic.println("You have " + skillPoints + " points to spend.");
            GameLogic.println("Which skill you want to increase?");
            GameLogic.println("(1) Strength" + "\t\t[have " + getStrength() + "]");
            GameLogic.println("(2) Intelligence" + "\t[have " + getIntelligence() + "]");
            skillChoice = GameLogic.readInt(2);
            String skillName = skillNames[skillChoice - 1];

            GameLogic.println("How many points you want to spend on " + skillName + "?");
            points = GameLogic.readInt(skillPoints);

            skillPoints -= points;
            addSkillByName(skillName, points);
            GameLogic.println("You have now " + getSkillByName(skillName) + " in " + skillName + ".");
            GameLogic.enterToContinue();
        }

        GameLogic.clearConsole();
        GameLogic.printHeading("You spend all of your points.");
        showAllSkills();
        GameLogic.enterToContinue();
    }

    // gold methods
    public int getGold()
    {
        return gold;
    }

    public void addGold(int gold)
    {
        this.gold += gold;
    }

    public void subGold(int gold)
    {
        this.gold -= gold;
    }

    // pots methods
    public int getPots()
    {
        return pots;
    }

    public void subPots()
    {
        pots--;
    }

    public void addPot()
    {
        pots++;
    }

    // hp methods
    public void restoreFullHp()
    {
        hp = maxHp;
    }

    public void restoreHp(int hp)
    {
        if (this.hp + hp > maxHp)
        {
            restoreFullHp();
        }
        else
        {
            this.hp += hp;
        }
    }

    // xp methods
    public void addXp(int xp)
    {
        this.xp += xp;
    }

    // skills methods
    public int getBaseStrength()
    {
        return baseStrength;
    }

    public int getBaseIntelligence()
    {
        return baseIntelligence;
    }

    public void addBaseStrength(int strength)
    {
        this.baseStrength += strength;
    }

    public void addBaseIntelligence(int intelligence)
    {
        this.baseIntelligence += intelligence;
    }

    public void addSkillPoints(int skillPoints)
    {
        this.skillPoints += skillPoints;
    }

    public void addSkillByName(String skillName, int points)
    {
        switch (skillName)
        {
            case "Strength" -> addBaseStrength(points);
            case "Intelligence" -> addBaseIntelligence(points);
        }
    }

    public int getSkillByName(String skillName)
    {
        return switch (skillName)
        {
            case "Strength" -> getBaseStrength();
            case "Intelligence" -> getBaseIntelligence();
            default -> 0;
        };
    }

    private void showAllSkills()
    {
        GameLogic.println("\t\tfull\tbase\tweapon\tbuff");
        GameLogic.println("Strength:\t" + getStrength() + "\t(" + baseStrength + "\t" + weaponStrength + "\t" + buffStrength + ")");
        GameLogic.println("Intelligence:\t" + getIntelligence() + "\t(" + baseIntelligence + "\t" + weaponIntelligence + "\t" + buffIntelligence + ")");
    }

    public void characterInfo()
    {
        GameLogic.printHeading("CHARACTER INFO");
        GameLogic.println("Name:\t\t" + name);
        GameLogic.println("HP:\t\t" + hp + "/" + maxHp);
        GameLogic.printSeparator(20);
        // player xp and gold
        GameLogic.println("XP:\t\t" + xp);
        GameLogic.println("Gold:\t\t" + gold);
        GameLogic.printSeparator(20);
        // skills
        showAllSkills();
        GameLogic.printSeparator(20);
        // # of pots
        GameLogic.println("Potions:\t" + pots);
        GameLogic.printSeparator(20);
        // weapon
        GameLogic.println("Weapon:");
        weapon.showDescription();
        GameLogic.printSeparator(20);
        // spells
        if (!attackSpells.isEmpty())
        {
            for (AttackSpell attackSpell : attackSpells)
            {
                attackSpell.showInfo();
            }
        }
    }

    public int getStrength()
    {
        return baseStrength + weaponStrength + buffStrength;
    }

    public int getIntelligence()
    {
        return baseIntelligence + weaponIntelligence + buffIntelligence;
    }

    public int getWeaponStrength()
    {
        return weaponStrength;
    }

    public int getBuffStrength()
    {
        return buffStrength;
    }

    public void setBuffStrength(int buffStrength)
    {
        this.buffStrength = buffStrength;
    }

    public int getWeaponIntelligence()
    {
        return weaponIntelligence;
    }

    public int getBuffIntelligence()
    {
        return buffIntelligence;
    }

    public void setBuffIntelligence(int buffIntelligence)
    {
        this.buffIntelligence = buffIntelligence;
    }

    public Weapon getWeapon()
    {
        return weapon;
    }

    public void setWeapon(Weapon weapon)
    {
        this.weapon = weapon;
        this.weaponStrength = weapon.getStrength();
        this.weaponIntelligence = weapon.getIntelligence();
    }

    public void addAttackSpell(AttackSpell attackSpell)
    {
        attackSpells.add(attackSpell);
    }

    // spells methods
    private AttackSpell chooseSpell()
    {
        for (int i = 0; i < attackSpells.size(); i++)
        {
            GameLogic.println("(" + (i + 1) + ") " + attackSpells.get(i).getName());
        }
        int input = GameLogic.readInt(attackSpells.size() + 1);

        return attackSpells.get(input - 1);
    }

    // spells
    private ArrayList<AttackSpell> attackSpells;
    private ArrayList<UtilitySpell> utilitySpells;

    // weapon
    private Weapon weapon;

    // additional player stats
    private int gold;
    private int pots;

    // skills
    private int baseStrength;
    private int weaponStrength;
    private int buffStrength;

    private int baseIntelligence;
    private int weaponIntelligence;
    private int buffIntelligence;

    private int skillPoints;
}

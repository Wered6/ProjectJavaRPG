package characters;

import utils.GameLogic;

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
        this.strength = 5;
        this.intelligence = 5;
        this.skillPoints = 4;
        spendSkillPoints();
    }

    // Player specific methods
    @Override
    public int attack()
    {
        return 0;
    }

    public void spendSkillPoints()
    {
        int skillChoice;
        int points;
        String[] skillNames = {"Strength", "Intelligence"};

        while (skillPoints > 0)
        {
            GameLogic.clearConsole();
            GameLogic.printHeading("Spend skill points!");
            GameLogic.println("You have " + skillPoints + " points to spend.");
            GameLogic.println("Which skill you want to increase?");
            GameLogic.println("(1) Strength" + "\t[have " + strength + "]");
            GameLogic.println("(2) Intelligence" + "\t[have " + intelligence + "]");
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

    public int getStrength()
    {
        return strength;
    }

    public int getIntelligence()
    {
        return intelligence;
    }

    public void addStrength(int strength)
    {
        this.strength += strength;
    }

    public void addIntelligence(int intelligence)
    {
        this.intelligence += intelligence;
    }

    public void addSkillPoints(int skillPoints)
    {
        this.skillPoints += skillPoints;
    }

    public void addSkillByName(String skillName, int points)
    {
        switch (skillName)
        {
            case "Strength" -> addStrength(points);
            case "Intelligence" -> addIntelligence(points);
        }
    }

    public int getSkillByName(String skillName)
    {
        return switch (skillName)
        {
            case "Strength" -> getStrength();
            case "Intelligence" -> getIntelligence();
            default -> 0;
        };
    }

    public void showAllSkills()
    {
        GameLogic.println("Strength:\t" + strength);
        GameLogic.println("Intelligence:\t" + intelligence);
    }

    // additional player stats
    private int gold;
    private int pots;

    // skills
    private int strength;
    private int intelligence;
    private int skillPoints;
}

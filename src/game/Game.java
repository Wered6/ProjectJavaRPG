package game;

import characters.Enemy;
import characters.Player;
import items.Weapon;
import shop.Shop;
import utils.GameLogic;
import utils.JsonScoreSaver;

import java.util.ArrayList;
import java.util.Arrays;

public class Game
{
    public void Play()
    {
        startGame();
        gameLoop();
    }

    private void startGame()
    {
        String name;
        // print title screen
        GameLogic.clearConsole();
        GameLogic.printSeparator(40);
        GameLogic.printSeparator(30);
        GameLogic.println("AGE OF THE AL'REK");
        GameLogic.println("CONSOLE RPG BY AREK AND ALBERT FOR JAVA CLASS");
        GameLogic.printSeparator(30);
        GameLogic.printSeparator(40);
        GameLogic.enterToContinue();

        // getting the player name
        GameLogic.clearConsole();
        name = readName();

        // print story intro
        Story.printIntro();

        // create new play object with the name
        player = new Player(name);

        // print first story act intro
        Story.printFirstActIntro();

        // setting isRunning to true, so the game loop can continue
        isRunning = true;

        // fill the shop
        shop.resetWeapons();
        for (Weapon weapon : weaponsAct1)
        {
            shop.addWeapon(weapon, 5);
        }
        shop.setPotionsQuantity(1);
    }

    private void gameLoop()
    {
        while (isRunning)
        {
            printMenu();
            int input = GameLogic.readInt(4);

            switch (input)
            {
                case 1 -> continueJourney();
                case 2 -> characterInfo();
                case 3 -> showShop();
                case 4 -> endGame();
            }
        }
    }

    private void endGame()
    {
        isRunning = false;
    }

    // method to read name of the player
    private String readName()
    {
        String name = null;
        boolean isNameChosen = false;

        while (!isNameChosen)
        {
            GameLogic.println("What's your name?");
            name = GameLogic.readString();
            GameLogic.println("Are you sure? [" + name + "]");
            GameLogic.println("(1) Yes.");
            GameLogic.println("(2) No, I want different name.");
            int input = GameLogic.readInt(2);

            switch (input)
            {
                case 1:
                {
                    isNameChosen = true;
                    break;
                }
                case 2:
                {
                    GameLogic.println("Ok, let's try again.");
                    break;
                }
            }
        }
        return name;
    }

    // method that changes the game's values based on player xp
    private void checkAct()
    {
        // change acts based on xp
        if (player.getXp() >= 10 && act == 1)
        {
            // increment act
            act = 2;
            // story
            Story.printFirstActOutro();
            // let the player "level up"
            player.addSkillPoints(8);
            player.spendSkillPoints();
            // story
            Story.printSecondActIntro();
            // assign new values to enemies
            enemies[0] = "Illusionist";
            enemies[1] = "Reanimated Defender";
            enemies[2] = "Exiled Sorcerer";
            enemies[3] = "Beast Tamer";
            enemies[4] = "Patriarch of Shadows";
            // fill the shop
            shop.resetWeapons();
            for (Weapon weapon : weaponsAct2)
            {
                shop.addWeapon(weapon, 10);
            }
            shop.setPotionsQuantity(2);
        }
        else if (player.getXp() >= 50 && act == 2)
        {
            // increment act
            act = 3;
            // story
            Story.printSecondActOutro();
            // let the player "level up"
            player.addSkillPoints(16);
            player.spendSkillPoints();
            // story
            Story.printThirdActIntro();
            // assign new values to enemies
            enemies[0] = "Flame Guardian";
            enemies[1] = "Warrior's Spirit";
            enemies[2] = "Night Smuggler";
            enemies[3] = "Archmage of Blood";
            enemies[4] = "Sower of Oblivion";
            // fully heal the player
            player.restoreFullHp();
            // fill the shop
            shop.resetWeapons();
            for (Weapon weapon : weaponsAct3)
            {
                shop.addWeapon(weapon, 15);
            }
            shop.setPotionsQuantity(2);
        }
        else if (player.getXp() >= 100 && act == 3)
        {
            // increment act
            act = 4;
            // story
            Story.printThirdActOutro();
            // let the player "level up"
            player.addSkillPoints(24);
            player.spendSkillPoints();
            // story
            Story.printFourthActIntro();
            // fully heal the player
            player.restoreFullHp();
            // fill the shop
            shop.resetWeapons();
            for (Weapon weapon : weaponsAct4)
            {
                shop.addWeapon(weapon, 20);
            }
            shop.setPotionsQuantity(3);
            // calling the final battle
            finalBattle();
        }
    }

    // method to continue the journey
    private void continueJourney()
    {
        // check if act must be increased
        checkAct();
        randomBattle();
    }

    // shopping
    private void showShop()
    {
        GameLogic.clearConsole();
        GameLogic.printHeading("You meet a mysterious stranger.\nHe offers you something:");
        shop.shopping(player);
    }

    // creating a random battle
    private void randomBattle()
    {
        GameLogic.clearConsole();
        GameLogic.printHeading("You encountered an evil minded creature. You'll have to fight it");
        GameLogic.enterToContinue();
        // creating new enemy with random name
        battle(new Enemy(enemies[(int) (Math.random() * enemies.length)], player.getXp()));
    }

    // the main battle method
    private void battle(Enemy enemy)
    {
        // main battle loop
        while (true)
        {
            GameLogic.clearConsole();
            GameLogic.printHeading(enemy.getName() + "\nHP: " + enemy.getHp() + "/" + enemy.getMaxHp());
            GameLogic.printHeading(player.getName() + "\nHP: " + player.getHp() + "/" + player.getMaxHp());
            GameLogic.println("Choose an action:");
            GameLogic.printSeparator(20);
            GameLogic.println("(1) Fight");
            GameLogic.println("(2) Use Potion");
            GameLogic.println("(3) Run Away");

            int input = GameLogic.readInt(3);

            // react accordingly to player input
            if (input == 1)
            {
                // FIGHT
                // calculate dmg and dmgTook (dmg enemy deals to player)
                int dmg = player.attack();
                int dmgTook = enemy.attack();
                // check that dmg and dmgTook isn't negative
                if (dmgTook < 0)
                {
                    // add some dmg if player defends very well
                    dmg -= dmgTook / 2;
                    dmgTook = 0;
                }
                if (dmg < 0)
                {
                    dmg = 0;
                }
                // deal dmg to both parties
                player.receiveDmg(dmgTook);
                enemy.receiveDmg(dmg);
                // print the info of this battle round
                GameLogic.clearConsole();
                GameLogic.printHeading("BATTLE");
                GameLogic.println("You dealt " + dmg + " damage to the " + enemy.getName() + ".");
                GameLogic.printSeparator(15);
                GameLogic.println("The " + enemy.getName() + " dealt " + dmgTook + " damage to you.");
                GameLogic.enterToContinue();
                // check if player is still alive or dead
                if (player.getHp() <= 0)
                {
                    playerDied();
                    break;
                }
                else if (enemy.getHp() <= 0)
                {
                    // tell the player he won
                    GameLogic.clearConsole();
                    GameLogic.printHeading("You defeated the " + enemy.getName() + "!");
                    // increase player xp
                    player.addXp(enemy.getXp());
                    GameLogic.println("You earned " + enemy.getXp() + " XP!");
                    // random drops
                    int goldEarned = (int) (Math.random() * enemy.getXp());
                    if (goldEarned > 0)
                    {
                        player.addGold(goldEarned);
                        GameLogic.println("You collect " + goldEarned + " gold from the " + enemy.getName() + "'s corpse");
                    }
                    GameLogic.enterToContinue();
                    break;
                }
            }
            else if (input == 2)
            {
                // use potion
                GameLogic.clearConsole();
                if (player.getPotions() > 0 && player.getHp() < player.getMaxHp())
                {
                    // player CAN take a potion
                    // make sure player wants to drink the potion
                    GameLogic.printHeading("Do you want to drink a potion? (" + player.getPotions() + " left).");
                    GameLogic.println("(1) Yes");
                    GameLogic.println("(2) No, maybe later");
                    input = GameLogic.readInt(2);
                    if (input == 1)
                    {
                        // player actually took it
                        player.restoreFullHp();
                        player.subPotions();
                        GameLogic.clearConsole();
                        GameLogic.printHeading("You drank a magic potion. It restored your health back to " + player.getMaxHp());
                        GameLogic.enterToContinue();
                    }
                }
                else
                {
                    // player CANNOT take a potion
                    GameLogic.printHeading("You don't have any potions, or you're at full health.");
                    GameLogic.enterToContinue();
                }
            }
            else
            {
                // RUN AWAY
                GameLogic.clearConsole();
                // check that player isn't in last act (final boss battle)
                if (act != 4)
                {
                    // chance of 35% to escape
                    if (Math.random() * 10 + 1 <= 3.5)
                    {
                        GameLogic.printHeading("You ran away from the " + enemy.getName() + "!");
                        GameLogic.enterToContinue();
                        break;
                    }
                    else
                    {
                        GameLogic.printHeading("You didn't manage to escape.");
                        // calculate damage the player takes
                        int dmgTook = enemy.attack();
                        GameLogic.println("In hurry, you took " + dmgTook + " damage!");
                        player.receiveDmg(dmgTook);
                        GameLogic.enterToContinue();
                        // check if player's still alive
                        if (player.getHp() <= 0)
                        {
                            playerDied();
                        }
                    }
                }
                else
                {
                    GameLogic.printHeading("YOU CANNOT ESCAPE THE AL'REK");
                    GameLogic.enterToContinue();
                }
            }
        }
    }

    // printing the main menu
    private void printMenu()
    {
        GameLogic.clearConsole();
        GameLogic.printHeading("MENU");
        GameLogic.println("Choose an action:");
        GameLogic.printSeparator(20);
        GameLogic.println("(1) Continue on your journey");
        GameLogic.println("(2) Character Info");
        GameLogic.println("(3) Shop");
        GameLogic.println("(4) Exit Game");
    }

    // the final (last) battle of the entire game
    private void finalBattle()
    {
        // creating the Al'rek and letting the player fight against him
        battle(new Enemy("Al'rek", 300));
        // printing the proper ending
        Story.printEnd(); // its only when we win, what happens when we loose
    }

    // method that gets called when the player is dead
    private void playerDied()
    {
        GameLogic.clearConsole();
        GameLogic.printHeading("You died...");
        GameLogic.printHeading("You earned " + player.getXp() + " XP on your journey. Try to earn more next time!");
        GameLogic.println("Thank you for playing my game. I hope you enjoyed it. :)");
        GameLogic.enterToContinue();
        JsonScoreSaver.addNewScore(player.getName(), player.getXp());
        isRunning = false;
    }

    // printing out the most important information about the player character
    private void characterInfo()
    {
        GameLogic.clearConsole();
        player.characterInfo();
        GameLogic.enterToContinue();
    }

    //enemy names
    private String[] enemies = {"Misty Forest Scout", "Shadow Mage", "Herald of Fear", "Undead Guardian", "Shadow Berserker"};

    // weapons
    // act 1
    ArrayList<Weapon> weaponsAct1 = new ArrayList<>(Arrays.asList(
            new Weapon("Rusty Sword\t", 5, 1, "An aged blade that's seen better days, offering modest damage with a hint of ancient reliability."),
            new Weapon("Wooden Shield", 3, 2, "A basic shield made from sturdy wood, providing minimal protection and a slight boost in defense."),
            new Weapon("Hunter's Bow", 4, 1, "A simple bow favored by hunters, balancing ease of use with effective range."),
            new Weapon("Novice's Wand", 1, 5, "A beginner's wand imbued with basic magical properties for aspiring magicians."),
            new Weapon("Enchanter's Stone", 2, 4, "A mystical stone that enhances magical abilities, though it holds limited physical use."),
            new Weapon("Book of Shadows", 1, 5, "An introductory tome of magic containing simple spells and incantations for the novice caster.")
    ));

    // act 2
    ArrayList<Weapon> weaponsAct2 = new ArrayList<>(Arrays.asList(
            new Weapon("Iron Sword\t", 8, 2, "A reliable sword forged from iron, offering improved strength and durability."),
            new Weapon("Battle Axe\t", 10, 1, "A heavy axe designed for combat, delivering powerful swings at the expense of finesse."),
            new Weapon("Reinforced Bow", 9, 2, "A bow strengthened with metal, providing increased damage and range."),
            new Weapon("Sorcerer's Staff", 3, 8, "A staff owned by sorcerers, channeling more powerful magic but requiring skill to wield."),
            new Weapon("Crystal Orb\t", 2, 9, "A magical orb that amplifies magical energy, ideal for spellcasters seeking greater power."),
            new Weapon("Ancient Grimoire", 3, 8, "A book filled with ancient spells, offering deeper magical knowledge and potency.")
    ));

    // act 3
    ArrayList<Weapon> weaponsAct3 = new ArrayList<>(Arrays.asList(
            new Weapon("Steel Sword\t", 12, 3, "A sword crafted from steel, combining sharpness and strength for superior battle performance."),
            new Weapon("War Hammer\t", 15, 2, "A devastating hammer capable of crushing foes with immense force."),
            new Weapon("Longbow\t", 13, 3, "A long-range bow designed for precision shooting, offering high damage from a distance."),
            new Weapon("Archmage's Wand", 4, 12, "A powerful wand that grants access to high-level spells, reserved for the most skilled magicians."),
            new Weapon("Elemental Scepter", 3, 15, "A scepter that commands the elements, offering a wide range of magical attacks."),
            new Weapon("TOTA\t", 4, 12, "Tome of the Ancients. A legendary book containing ancient wisdom and powerful spells, coveted by master spellcasters.")
    ));

    // act 4
    ArrayList<Weapon> weaponsAct4 = new ArrayList<>(Arrays.asList(
            new Weapon("Mythril Sword", 18, 4, "A lightweight yet incredibly strong sword made of mythril, offering unmatched cutting power."),
            new Weapon("Dragon Axe\t", 20, 3, "A fearsome axe forged from dragon bones, combining brutal power with mystical fire."),
            new Weapon("Crossbow\t", 19, 4, "A mechanically advanced bow that combines power and precision for lethal shots."),
            new Weapon("Celestial Staff", 5, 18, "A staff infused with celestial energies, granting immense magical power to its wielder."),
            new Weapon("Orb of Power", 4, 20, "An orb overflowing with raw magical energy, capable of unleashing devastating spells."),
            new Weapon("BOIS\t", 5, 18, "Book of Infinite Spells. An unparalleled tome of magic that contains endless spells, offering boundless magical possibilities.")
    ));


    private int act = 1;
    private boolean isRunning;
    private Player player;
    private Shop shop = new Shop();
}

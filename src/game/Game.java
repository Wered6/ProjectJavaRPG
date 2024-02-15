package game;

import characters.Enemy;
import characters.Player;
import utils.GameLogic;
import items.Weapon;

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
                case 3 -> shop();
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

            // story
            Story.printSecondActIntro();
            // assign new values to enemies
            enemies[0] = "Iluzjonista";
            enemies[1] = "Ożywiony Obrońca";
            enemies[2] = "Wygnany Czarownik";
            enemies[3] = "Zaklinacz Bestii";
            enemies[4] = "Patriarcha Cieni";
        }
        else if (player.getXp() >= 50 && act == 2)
        {
            // increment act
            act = 3;
            // story
            Story.printSecondActOutro();
            // let the player "level up"

            // story
            Story.printThirdActIntro();
            // assign new values to enemies
            enemies[0] = "Płomienny Strażnik";
            enemies[1] = "Duch Wojownika";
            enemies[2] = "Nocny Przemytnik";
            enemies[3] = "Arcymag Krwi";
            enemies[4] = "Siewca Zapomnienia";
            // fully heal the player
            player.restoreFullHp();
        }
        else if (player.getXp() >= 100 && act == 3)
        {
            // increment act
            act = 4;
            // story
            Story.printThirdActOutro();
            // let the player "level up"

            // story
            Story.printFourthActIntro();
            // fully heal the player
            player.restoreFullHp();
            // calling the final battle
            finalBattle();
        }
    }

    // method to continue the journey
    private void continueJourney()
    {
        // check if act must be increased
        checkAct();
    }

    // shopping / encountering a travelling trader
    private void shop()
    {
        GameLogic.clearConsole();
        GameLogic.printHeading("You meet a mysterious stranger.\nHe offers you something:");
        int pricePot = 5;
        GameLogic.println("- Magic Potion: " + pricePot + " gold.");
        GameLogic.printSeparator(20);
        // weapons
        GameLogic.println("- Weapons:");
        // ask the player to buy one
        GameLogic.println("Do you want to buy one?");
        GameLogic.println("(1) Yes!");
        GameLogic.println("(2) No thanks.");
        int input = GameLogic.readInt(2);
        // check if player wants to buy
        if (input == 1)
        {
            GameLogic.clearConsole();
            // check if player has enough gold
            if (player.getGold() >= pricePot)
            {
                GameLogic.printHeading("You bought a magical potion for " + pricePot + " gold.");
                player.addPot();
                player.subGold(pricePot);
            }
            else
            {
                GameLogic.printHeading("You don't have enough gold to buy this...");
            }
            GameLogic.enterToContinue();
        }
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
                if (player.getPots() > 0 && player.getHp() < player.getMaxHp())
                {
                    // player CAN take a potion
                    // make sure player wants to drink the potion
                    GameLogic.printHeading("Do you want to drink a potion? (" + player.getPots() + " left).");
                    GameLogic.println("(1) Yes");
                    GameLogic.println("(2) No, maybe later");
                    input = GameLogic.readInt(2);
                    if (input == 1)
                    {
                        // player actually took it
                        player.restoreFullHp();
                        player.subPots();
                        GameLogic.clearConsole();
                        GameLogic.printHeading("You drank a magic potion. It restored your health back to " + player.getMaxHp());
                        GameLogic.enterToContinue();
                    }
                }
                else
                {
                    // player CANNOT take a potion
                    GameLogic.printHeading("You don't have any potions or you're at full health.");
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
                        GameLogic.printHeading("You didnt manage to escape.");
                        // calculate damage the player takes
                        int dmgTook = enemy.attack();
                        GameLogic.println("In hurry you took " + dmgTook + " damage!");
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
    private String[] enemies = {"Zwiadowca Mglistych Lasów", "Cienisty Mag", "Posłaniec Strachu", "Nieumarły Strażnik", "Berserker Cienia"};

    // weapons
    // act 1
    ArrayList<Weapon> weaponsAct1 = new ArrayList<>(Arrays.asList(
            new Weapon("Rusty Sword", 5, 1, 5),
            new Weapon("Wooden Shield", 3, 2, 5),
            new Weapon("Hunter's Bow", 4, 1, 5),
            new Weapon("Novice's Wand", 1, 5, 5),
            new Weapon("Enchanter's Stone", 2, 4, 5),
            new Weapon("Book of Shadows", 1, 5, 5)
    ));

    // act 2
    ArrayList<Weapon> weaponsAct2 = new ArrayList<>(Arrays.asList(
            new Weapon("Iron Sword", 8, 2, 10),
            new Weapon("Battle Axe", 10, 1, 10),
            new Weapon("Reinforced Bow", 9, 2, 10),
            new Weapon("Sorcerer's Staff", 3, 8, 10),
            new Weapon("Crystal Orb", 2, 9, 10),
            new Weapon("Ancient Grimoire", 3, 8, 10)
    ));

    // act 3
    ArrayList<Weapon> weaponsAct3 = new ArrayList<>(Arrays.asList(
            new Weapon("Steel Sword", 12, 3, 15),
            new Weapon("War Hammer", 15, 2, 15),
            new Weapon("Longbow", 13, 3, 15),
            new Weapon("Archmage's Wand", 4, 12, 15),
            new Weapon("Elemental Scepter", 3, 15, 15),
            new Weapon("Tome of the Ancients", 4, 12, 15)
    ));

    // act 4
    ArrayList<Weapon> weaponsAct4 = new ArrayList<>(Arrays.asList(
            new Weapon("Mythril Sword", 18, 4, 20),
            new Weapon("Dragon Axe", 20, 3, 20),
            new Weapon("Crossbow", 19, 4, 20),
            new Weapon("Celestial Staff", 5, 18, 20),
            new Weapon("Orb of Power", 4, 20, 20),
            new Weapon("Book of Infinite Spells", 5, 18, 20)
    ));


    // story elements
    private int act = 1;
    private boolean isRunning;
    private Player player;
}

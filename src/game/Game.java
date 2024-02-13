package game;

import characters.Player;
import utils.GameLogic;

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
        GameLogic.anythingToContinue();

        // getting the player name
        GameLogic.clearConsole();
        name = GameLogic.readName();

        // print story intro
        Story.printIntro();

        // create new play object with the name
        player = new Player(name);

        // print first story act intro
        Story.printFirstActIntro();

        // setting isRunning to true, so the game loop can continue
        isRunning = true;

        GameLogic.anythingToContinue();
    }

    // method to continue the journey
    private void continueJourney()
    {

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
        GameLogic.println("(3) Exit Game");
    }

    // printing out the most important information about the player character
    private void characterInfo()
    {
        GameLogic.clearConsole();
        GameLogic.printHeading("CHARACTER INFO");
        GameLogic.println(player.getName() + "\tHP: " + player.getHp() + "/" + player.getMaxHp());
        GameLogic.printSeparator(20);
        GameLogic.println("XP: " + player.getXp());
        GameLogic.printSeparator(20);

        // printing the chosen traits
        if (player.numAtkUpgrades > 0)
        {
            GameLogic.println("Offensive trait: " + player.atkUpgrades[player.numAtkUpgrades - 1]);
            GameLogic.printSeparator(20);
        }
        if (player.numDefUpgrades > 0)
        {
            GameLogic.println("Defensive trait: " + player.defUpgrades[player.numDefUpgrades - 1]);
        }

        GameLogic.anythingToContinue();
    }

    private void gameLoop()
    {
        while (isRunning)
        {
            printMenu();
            int input = GameLogic.readInt(3);

            switch (input)
            {
                case 1:
                {
                    continueJourney();
                    break;
                }
                case 2:
                {
                    characterInfo();
                    break;
                }
                case 3:
                {
                    isRunning = false;
                    break;
                }
            }
        }
    }

    // story elements
    private int act;
    private boolean isRunning;
    private Player player;
}

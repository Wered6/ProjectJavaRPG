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
            player.chooseTrait();
            // story
            Story.printSecondActIntro();
            // assign new values to enemies
            enemies[0] = "Iluzjonista";
            enemies[1] = "Ożywiony Obrońca";
            enemies[2] = "Wygnany Czarownik";
            enemies[3] = "Zaklinacz Bestii";
            enemies[4] = "Patriarcha Cieni";
            // assign new values to encounters
            encounters[0] = "Walka";
            encounters[1] = "Walka";
            encounters[2] = "Walka";
            encounters[3] = "Odpoczynek";
            encounters[4] = "Sklep";
        }
        else if (player.getXp() >= 50 && act == 2)
        {
            // increment act
            act = 3;
            // story
            Story.printSecondActOutro();
            // let the player "level up"
            player.chooseTrait();
            // story
            Story.printThirdActIntro();
            // assign new values to enemies
            enemies[0] = "Płomienny Strażnik";
            enemies[1] = "Duch Wojownika";
            enemies[2] = "Nocny Przemytnik";
            enemies[3] = "Arcymag Krwi";
            enemies[4] = "Siewca Zapomnienia";
            // assign new valyes to encounters
            encounters[0] = "Walka";
            encounters[1] = "Walka";
            encounters[2] = "Walka";
            encounters[3] = "Walka";
            encounters[4] = "Sklep";
            // fully heal the player
            player.restoreHp();
        }
        else if (player.getXp() >= 100 && act == 3)
        {
            // increment act
            act = 4;
            // story
            Story.printThirdActOutro();
            // let the player "level up"
            player.chooseTrait();
            // story
            Story.printFourthActIntro();
            // fully heal the player
            player.restoreHp();
            // calling the final battle
            // finalBattle();
        }
    }

    // method to calculate a random encounter
    private void randomEncounter()
    {
        // random number between 0 and the length of the encounters array
        int encounter = (int) (Math.random() * encounters.length);
        // calling the respective methods
        if (encounters[encounter].equals("Walka"))
        {
            // randomBattle();
        }
        else if (encounters[encounter].equals("Rest"))
        {
            // takeRest();
        }
        else
        {
            // shop();
        }
    }

    // method to continue the journey
    private void continueJourney()
    {
        // check if act must be increased
        checkAct();
        // check if game isn't last act
        if (act != 4)
        {
             randomEncounter();
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

    // random encounters
    private String[] encounters = {"Walka", "Walka", "Walka", "Odpoczynek", "Odpoczynek"};
    //enemy names
    private String[] enemies = {"Zwiadowca Mglistych Lasów", "Cienisty Mag", "Posłaniec Strachu", "Nieumarły Strażnik", "Berserker Cienia"};

    // story elements
    private int act = 1;
    private boolean isRunning;
    private Player player;
}

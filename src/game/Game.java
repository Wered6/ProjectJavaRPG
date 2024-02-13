package game;

import characters.Player;
import utils.GameLogic;

public class Game
{
    public void Play()
    {
        startGame();
    }

    private void startGame()
    {
        boolean nameSet = false;
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

        // create new play object with the name
        player = new Player(name);
    }

    private Player player;
}

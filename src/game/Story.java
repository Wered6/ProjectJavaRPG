package game;

import utils.GameLogic;
import utils.JsonActsLoader;

abstract public class Story
{
    public static void printIntro()
    {
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        GameLogic.println("INTRO");
        GameLogic.printSeparator(30);
        GameLogic.println("In the era forgotten by time, where magic was as common as the air we breathe, there existed a world full of mysteries and unfathomed powers. This world, marked by ages of conflicts and alliances, witnessed the rise and fall of great kingdoms. Among them, in the shadow of prophecies and ancient lore, the legend of Al'rek, a tyrant who sought to subjugate all free peoples with forbidden magic and ruthless force, was born.");
        GameLogic.enterToContinue();
        GameLogic.println("Al'rek, once a respected mage, tempted by the promise of unlimited power, delved into the darkest corners of forbidden knowledge. His heart, poisoned by a desire for domination, transformed him into a being whose very name evoked fear and despair. Wielding powers that made nature itself tremble, Al'rek challenged the balance of the world, striving for its absolute dominion.");
        GameLogic.enterToContinue();
        GameLogic.println("However, as the ancient prophecy foretells, from the ashes of conflict, a hero is to rise, destined to face Al'rek and end his tyranny. This hero, chosen by fate, is you. Your heritage and courage are the keys to gathering allies, overcoming challenges, and facing the dark lord in a decisive battle for the future of the world.");
        GameLogic.enterToContinue();
        GameLogic.println("Thus begins your journey. With each step closer to your goal, with every battle, you grow stronger, ready to write history with the bravery that will turn darkness into light. Do you have what it takes to defeat Al'rek and become the hero whose songs will be sung for ages?");
        GameLogic.enterToContinue();
        GameLogic.println("Your legend in \"Age of Al'rek\" starts now. Embark on a journey that will decide the fate of the world.");
        GameLogic.enterToContinue();
    }

    public static void printFirstActIntro()
    {
        String actNumber = "I";
        boolean isIntro = true;
        printAct(actNumber, isIntro);
    }

    public static void printFirstActOutro()
    {
        String actNumber = "I";
        boolean isIntro = false;
        printAct(actNumber, isIntro);
    }

    public static void printSecondActIntro()
    {
        String actNumber = "II";
        boolean isIntro = true;
        printAct(actNumber, isIntro);
    }

    public static void printSecondActOutro()
    {
        String actNumber = "II";
        boolean isIntro = false;
        printAct(actNumber, isIntro);
    }

    public static void printThirdActIntro()
    {
        String actNumber = "III";
        boolean isIntro = true;
        printAct(actNumber, isIntro);
    }

    public static void printThirdActOutro()
    {
        String actNumber = "III";
        boolean isIntro = false;
        printAct(actNumber, isIntro);
    }

    public static void printFourthActIntro()
    {
        String actNumber = "IV";
        boolean isIntro = true;
        printAct(actNumber, isIntro);
    }

    public static void printEnd()
    {
        String actNumber = "IV";
        boolean isIntro = false;
        printAct(actNumber, isIntro);
    }


    private static void printAct(String actNumber, boolean isIntro)
    {
        String str;
        String actTitle = JsonActsLoader.getActTitle(actNumber);
        String content;
        if (isIntro)
        {
            str = "INTRO";
            content = JsonActsLoader.getIntro(actNumber);
        }
        else
        {
            str = "OUTRO";
            content = JsonActsLoader.getOutro(actNumber);
        }

        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        GameLogic.println("ACT " + actNumber + " - " + str);
        GameLogic.println(actTitle);
        GameLogic.printSeparator(30);
        GameLogic.println(content);
        GameLogic.enterToContinue();
    }
}

package game;

import utils.GameLogic;

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
        String actTitle = "Rise of the Hero";
        String content = "In a village plagued by bandits and wild beasts, an unexpected hero emerges. Destiny calls, and your journey begins now. With great hopes and a small inventory, you set out into the world to find the strength needed to face Al'rek.";
        boolean isIntro = true;
        printAct(actNumber, actTitle, content, isIntro);
    }

    public static void printFirstActOutro()
    {
        String actNumber = "I";
        String actTitle = "Rise of the Hero";
        String content = "After traversing boundless forests and overcoming initial challenges, you feel your power growing with each day. The first act of your odyssey comes to an end, but this is just the beginning. More dangers and adventures lie ahead.";
        boolean isIntro = false;
        printAct(actNumber, actTitle, content, isIntro);
    }

    public static void printSecondActIntro()
    {
        String actNumber = "II";
        String actTitle = "The Quest for Allies";
        String content = "Your fame grows, and legends of your deeds begin to attract other heroes who wish to stand by your side. Traveling through towns and settlements, you gather around you a team of staunch allies, ready to share the burden of battle.";
        boolean isIntro = true;
        printAct(actNumber, actTitle, content, isIntro);
    }

    public static void printSecondActOutro()
    {
        String actNumber = "II";
        String actTitle = "The Quest for Allies";
        String content = "With every enemy defeated, your companions become more experienced, and their belief in victory grows stronger. As a team, you are ready to face the next challenges that fate brings. Al'rek awaits, but you are no longer alone.";
        boolean isIntro = false;
        printAct(actNumber, actTitle, content, isIntro);
    }

    public static void printThirdActIntro()
    {
        String actNumber = "III";
        String actTitle = "The Prophecy";
        String content = "In pursuit of Al'rek, you reach ancient ruins where a prophecy carved in stone reveals the secrets of your destiny. You must delve into ancient magics and uncover hidden powers that will help you face the looming darkness.";
        boolean isIntro = true;
        printAct(actNumber, actTitle, content, isIntro);
    }

    public static void printThirdActOutro()
    {
        String actNumber = "III";
        String actTitle = "The Prophecy";
        String content = "The prophecy has been fulfilled, and your skills have reached the pinnacle of possibility. You feel the time for confrontation is near, and Al'rek's aura already looms on the horizon. The final act of your journey approaches with great strides.";
        boolean isIntro = false;
        printAct(actNumber, actTitle, content, isIntro);
    }

    public static void printFourthActIntro()
    {
        String actNumber = "IV";
        String actTitle = "The Final Confrontation";
        String content = "You stand at the gates of Al'rek's dark fortress, where evil swirls in the air. Your heart beats strongly, and the fighting spirit of your allies is unwavering. All paths have led to this moment – the ultimate battle that will decide the fate of the world.";
        boolean isIntro = true;
        printAct(actNumber, actTitle, content, isIntro);
    }

    public static void printEnd()
    {
        String actNumber = "IV";
        String actTitle = "The Final Confrontation";
        String content = "The battle that will forever be inscribed in the annals of history is behind you. Al'rek has been defeated, and his darkness dispersed to the winds. Peace has returned to the world, and your name will be sung by bards for endless ages. But remember, hero, the true adventure always finds a way to continue its story...";
        boolean isIntro = false;
        printAct(actNumber, actTitle, content, isIntro);
    }


    private static void printAct(String actNumber, String actTitle, String content, boolean isIntro)
    {
        String str = isIntro ? "INTRO" : "OUTRO";
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        GameLogic.println("ACT " + actNumber + " - " + str);
        GameLogic.println(actTitle);
        GameLogic.printSeparator(30);
        GameLogic.println(content);
        GameLogic.enterToContinue();
    }
}

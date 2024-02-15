package utils;

import java.io.IOException;
import java.util.Scanner;

abstract public class GameLogic
{
    public static int readInt(int userChoices)
    {
        int input;

        do
        {
            input = getInput();

            if (input < 1 || input > userChoices)
            {
                print(ANSI_RESET);
                println("Enter a number between [" + 1 + ", " + userChoices + "].");
            }
        }
        while (input < 1 || input > userChoices);

        return input;
    }

    public static int readIntZero(int userChoices)
    {
        int input;

        do
        {
            input = getInput();

            if (input < 0 || input > userChoices)
            {
                print(ANSI_RESET);
                println("Enter a number between [" + 0 + ", " + userChoices + "].");
            }
        }
        while (input < 0 || input > userChoices);

        return input;
    }

    private static int getInput()
    {
        int input;
        try
        {
            print("-> ");
            print(ANSI_GREEN);
            String line = scanner.nextLine();
            input = Integer.parseInt(line);
            print(ANSI_RESET);
        }
        catch (NumberFormatException e)
        {
            input = -1;
            print(ANSI_RESET);
            println("Enter integer!");
        }
        return input;
    }

    public static String readString()
    {
        String input;

        print("-> ");
        print(ANSI_GREEN);
        input = scanner.nextLine().trim();
        print(ANSI_RESET);

        return input;
    }

    // method to print anything letter by letter with custom delay
    public static void print(String str, long delayTime)
    {
        for (int i = 0; i < str.length(); i++)
        {
            System.out.print(str.charAt(i));
            try
            {
                Thread.sleep(delayTime);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    // method to print anything letter by letter with default delay
    public static void print(String str)
    {
        print(str, 30);
    }

    public static void println(String str)
    {
        print(str);
        System.out.println();
    }

    public static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else
            {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        }
        catch (IOException | InterruptedException e)
        {
            System.out.println("".repeat(100));

            if (e instanceof InterruptedException)
            {
                Thread.currentThread().interrupt();
            }
        }
    }

    // method to print separator with length n
    public static void printSeparator(int n)
    {
        for (int i = 0; i < n; i++)
        {
            print("-");
        }
        println("");
    }

    // method to print heading
    public static void printHeading(String title)
    {
        printSeparator(30);
        println(title);
        printSeparator(30);
    }

    public static void enterToContinue()
    {
        print(ANSI_BLUE);
        println("Press Enter to continue...");
        print(ANSI_RESET);

        try
        {
            System.in.read();
            scanner.nextLine();
        }
        catch (Exception ignored)
        {
        }
    }

    static String ANSI_BLUE = "\u001B[34m";
    static String ANSI_GREEN = "\u001B[32m";
    static String ANSI_RESET = "\u001B[0m";

    static Scanner scanner = new Scanner(System.in);
}

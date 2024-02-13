package utils;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

abstract public class GameLogic
{
    // method to get user input from console
    public static int readInt(int userChoices)
    {
        int input;

        do
        {
            try
            {
                print(ANSI_GREEN);
                input = scanner.nextInt();
                print(ANSI_RESET);
            }
            catch (InputMismatchException e)
            {
                input = -1;
                print("Wprowadź liczbę całkowitą (integer)!");
                scanner.next(); // clears buffer
            }

            if (input < 1 || input > userChoices)
            {
                print("Wprowadź liczbę z przedziału [" + 1 + ", " + userChoices + "].");
            }
        }
        while (input < 1 || input > userChoices);

        return input;
    }

    public static boolean readBoolean()
    {
        String str = "[T/N]?";
        println(str);

        while (true)
        {
            print(ANSI_GREEN);
            String input = scanner.nextLine();
            print(ANSI_RESET);
            if ("T".equalsIgnoreCase(input))
            {
                return true;
            }
            else if ("N".equalsIgnoreCase(input))
            {
                return false;
            }
            else
            {
                str = "Nieprawidłowy wybór. Proszę wprowadź 'T' lub 'N'";
                println(str);
            }
        }
    }

    public static String readName()
    {
        String name;
        while (true)
        {
            println("Jak masz na imię?");
            print(ANSI_GREEN);
            name = scanner.nextLine().trim();
            print(ANSI_RESET);
            println("Czy na pewno chcesz się tak nazywać? [" + name + "]");

            boolean confirmation = readBoolean();

            if (confirmation)
            {
                break;
            }
            else
            {
                println("Ok, spróbujmy jeszcze raz.");
            }
        }
        return name;
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

    public static void println(String str, long delayTime)
    {
        print(str, delayTime);
        System.out.println();
    }

    // method to print anything letter by letter with default delay
    public static void print(String str)
    {
        print(str, 35);
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

    // method to stop the game until user enters anything
    public static void anythingToContinue()
    {
        String str = "\nWprowadź cokolwiek by kontynuuować...";
        println(str);
        print(ANSI_GREEN);
        scanner.nextLine(); // to catch the rest of the line after the previous input
        scanner.nextLine(); // to actually wait for the new input
        print(ANSI_RESET);
    }

    static String ANSI_GREEN = "\u001B[32m";
    static String ANSI_RESET = "\u001B[0m";

    static Scanner scanner = new Scanner(System.in);
}

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
                input = scanner.nextInt();
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
        String str = "Wprowadź [T/N]";
        print(str);

        while (true)
        {
            String input = scanner.nextLine();
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
                print(str);
            }
        }
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
        System.out.println();
    }

    // method to print anything letter by letter with default delay
    public static void print(String str)
    {
        print(str, 35);
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
            for (int i = 0; i < 100; i++)
            {
                System.out.println();
            }
            if (e instanceof InterruptedException)
            {
                Thread.currentThread().interrupt();
            }
        }
    }


    // method to print separator with length n
    public static void printSeparator(int n)
    {
        System.out.println("-".repeat(n));
    }

    // method to print heading
    public static void printHeading(String title)
    {
        printSeparator(30);
        print(title);
        printSeparator(30);
    }

    // method to stop the game until user enters anything
    public static void anythingToContinue()
    {
        String str = "\nWprowadź cokolwiek by kontynuuować...";
        print(str);
        scanner.nextLine(); // to catch the rest of the line after the previous input
        scanner.nextLine(); // to actually wait for the new input
    }

    static Scanner scanner = new Scanner(System.in);
}

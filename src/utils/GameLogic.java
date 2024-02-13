package utils;

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
                input = Integer.parseInt(scanner.next());
                scanner.nextLine(); // clears buffer
            }
            catch (Exception e)
            {
                input = -1;
                printStringLetterByLetter("Wprowadź liczbę całkowitą (integer)!");
                scanner.nextLine(); // clears buffer
            }

            if (input < 1 || input > userChoices)
            {
                printStringLetterByLetter("Wprowadź liczbę z przedziału [" + 1 + ", " + userChoices + "].");
            }
        }
        while (input < 1 || input > userChoices);

        return input;
    }

    public static boolean readBoolean()
    {
        String str = "Wprowadź [T/N]";
        printStringLetterByLetter(str);

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
                printStringLetterByLetter(str);
            }
        }
    }

    // method to print anything letter by letter with custom delay
    public static void printStringLetterByLetter(String str, long delayTime)
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
    public static void printStringLetterByLetter(String str)
    {
        for (int i = 0; i < str.length(); i++)
        {
            System.out.print(str.charAt(i));
            try
            {
                Thread.sleep(35);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    // method to simulate clearing out the console
    public static void clearConsole()
    {
        for (int i = 0; i < 100; i++)
        {
            System.out.println();
        }
    }

    // method to print separator with length n
    public static void printSeparator(int n)
    {
        for (int i = 0; i < n; i++)
        {
            printStringLetterByLetter("-");
            System.out.println();
        }
    }

    // method to print heading
    public static void printHeading(String title)
    {
        printSeparator(30);
        printStringLetterByLetter(title);
        printSeparator(30);
    }

    // method to stop the game until user enters anything
    public static void anythingToContinue()
    {
        String str = "\nWprowadź cokolwiek by kontynuuować...";
        printStringLetterByLetter(str);
        scanner.next();
    }

    static Scanner scanner = new Scanner(System.in);
}

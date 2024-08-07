package programmingone.arraysandarraylists.stockpriceoperations;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * The StockPriceOperator class provides a console-based interface
 * for performing various operations on stock prices such as calculating
 * the average, finding the maximum, counting occurrences, and computing
 * the cumulative sum.
 */
public class StockPriceOperator {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * The main method that starts the program.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        startProgram();
    }

    /**
     * Prints a character repeatedly for a specified number of times.
     *
     * @param mark  the character to print
     * @param times the number of times to print the character
     */
    private static void printRepeatedMark(char mark, int times) {
        System.out.println(Character.toString(mark).repeat(times));
    }

    /**
     * Prints a character repeatedly for 40 times.
     *
     * @param mark the character to print
     */
    private static void printRepeatedMark(char mark) {
        printRepeatedMark(mark, 40);
    }

    /**
     * Prints the '=' character repeatedly for 40 times.
     */
    private static void printRepeatedMark() {
        printRepeatedMark('=', 40);
    }

    /**
     * Starts the program by displaying the menu and handling user choices.
     */
    private static void startProgram() {
        printMenu();
        int choice = doGetChoice();

        switch (choice) {
            case 1 -> {
                doCalculateAverage();
                startProgram();
                break;
            }
            case 2 -> {
                doFindMaximum();
                startProgram();
                break;
            }
            case 3 -> {
                doCountOccurrence();
                startProgram();
                break;
            }
            case 4 -> {
                doCumulativeSum();
                startProgram();
                break;
            }
            case 0 -> {
                doExit();
                break;
            }
            default -> {
                printRepeatedMark();
                System.out.println("Invalid option.");
                startProgram();
            }
        }
    }

    /**
     * Prints the menu options for the user to choose from.
     */
    private static void printMenuOptions() {
        printRepeatedMark();
        System.out.println("1. Calculate the average stock price");
        System.out.println("2. Find the maximum stock price");
        System.out.println("3. Determine the occurrence count of a specific price");
        System.out.println("4. Compute the cumulative sum of stock prices");
        System.out.println("0. Quit the program");
        printRepeatedMark();
    }

    /**
     * Prints the menu and prompts the user to enter a choice.
     */
    private static void printMenu() {
        printRepeatedMark();
        System.out.println("Enter a numeric value corresponding to the operation that you want to carry out");
        printMenuOptions();
    }

    /**
     * Prompts the user to enter their choice.
     */
    private static void printChoicePrompt() {
        System.out.print("Your Choice =>: ");
    }

    /**
     * Gets the user's choice from the menu.
     *
     * @return the user's choice as an integer
     */
    private static int doGetChoice() {
        int choice = -1;
        boolean isChoice = false;

        printChoicePrompt();

        String invalidChoiceMessage = "Invalid choice. The options are: 0, 1, 2, 3 or 4";

        while (!isChoice) {
            try {
                choice = Integer.parseInt(scanner.nextLine());

                if (choice < 0 || choice > 4) {
                    printRepeatedMark();
                    System.out.println(invalidChoiceMessage);
                    printRepeatedMark();
                    printChoicePrompt();
                } else {
                    isChoice = true;
                }
            } catch (NumberFormatException e) {
                printRepeatedMark();
                System.out.println(invalidChoiceMessage);
                printRepeatedMark();
                printChoicePrompt();
            }
        }

        return choice;
    }

    /**
     * Exits the program and displays an exit message.
     */
    private static void doExit() {
        printRepeatedMark();
        System.out.println("You chose to exit the program, bye for now!");
        printRepeatedMark();
    }

    /**
     * Prints instructions for entering a series of floats.
     */
    private static void printOperationInstructions() {
        printRepeatedMark();
        System.out.println("Please enter a series of floats separated by comma.");
        System.out.println("For example:");
        System.out.println("3.00, 3.45, 5.11, 100.01, 100, 20.34");
        System.out.println("Or");
        System.out.println("Enter 0 to quit");
        printRepeatedMark();
    }

    /**
     * Prompts the user to enter a series of floats.
     */
    private static void printFloatsPrompt() {
        System.out.print("Your series of floats =>: ");
    }

    /**
     * Prompts the user to enter a single float.
     */
    private static void printFloatPrompt() {
        System.out.print("Your float =>: ");
    }

    /**
     * Checks if all strings in the array can be parsed as floats.
     *
     * @param values the array of strings to check
     * @return true if all strings can be parsed as floats, false otherwise
     */
    private static boolean areAllFloats(String[] values) {
        try {
            for (String value : values) {
                Float.parseFloat(value);
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Gets an array of floats entered by the user.
     *
     * @return an array of floats
     */
    private static float[] doGetFloats() {
        String[] tokens;

        while (true) {
            printFloatsPrompt();
            String input = scanner.nextLine();

            if (input.equals("0")) return new float[0];

            tokens = input.split(",");

            if (areAllFloats(tokens)) {
                System.out.println("All inputs are valid floats");

                var list = new float[tokens.length];

                for (int index = 0; index < tokens.length; index += 1) {
                    list[index] = Float.parseFloat(tokens[index]);
                }

                return list;
            }
            printRepeatedMark();
            System.out.println("The input contains non-float values.");
            System.out.println("Try again or press 0 to quit.");
            printRepeatedMark();
        }
    }

    /**
     * Returns to the main menu.
     */
    private static void goBackToMainMenu() {
        printRepeatedMark();
        System.out.println("You chose to get back to main menu.");
    }

    /**
     * Calculates the average of an array of floats.
     *
     * @param values the array of floats
     * @return the average as a float
     */
    private static float calculateAverage(float[] values) {
        float sum = 0;

        for (float value : values) {
            sum += value;
        }

        return sum / values.length;
    }

    /**
     * Calculates and displays the average of stock prices entered by the user.
     */
    private static void doCalculateAverage() {
        printRepeatedMark();
        System.out.println("You chose to calculate the average stock price");
        printOperationInstructions();

        float[] floats = doGetFloats();

        if (floats.length == 0) {
            goBackToMainMenu();
            return;
        }
        
        float average = calculateAverage(floats);

        BigDecimal bd = new BigDecimal(Float.toString(average));
        bd = bd.setScale(2, RoundingMode.HALF_UP);

        printRepeatedMark('*');
        System.out.printf("The Average Price of the entered value(s) to 2 decimal places is == %.2f%n", bd.floatValue());
        printRepeatedMark('*');
    }

    /**
     * Finds the maximum value in an array of floats.
     *
     * @param values the array of floats
     * @return the maximum value as a float
     */
    private static float getGreaterFloat(float[] values) {
        float greater = values[0];

        for (float value : values) {
            if (value > greater) {
                greater = value;
            }
        }

        return greater;
    }

    /**
     * Finds and displays the maximum stock price entered by the user.
     */
    private static void doFindMaximum() {
        printRepeatedMark();
        System.out.println("You chose to find maximum price");
        printOperationInstructions();

        float[] floats = doGetFloats();

        if (floats.length == 0) {
            goBackToMainMenu();
            return;
        }
        
        float greater = getGreaterFloat(floats);

        BigDecimal bd = new BigDecimal(Float.toString(greater));
        bd = bd.setScale(2, RoundingMode.HALF_UP);

        printRepeatedMark('*');
        System.out.printf("The Maximum Price of the entered value(s) to 2 decimal places is == %.2f%n", bd.floatValue());
        printRepeatedMark('*');
    }

    /**
     * Gets a single float entered by the user.
     *
     * @return the entered float
     */
    private static float getFloat() {
        while (true) {
            printFloatPrompt();
            String input = scanner.nextLine();

            if (input.equals("0")) return 0;

            try {
                float value = Float.parseFloat(input);
                System.out.println("The input is a valid float.");
                return value;
            } catch (Exception e) {
                printRepeatedMark();
                System.out.println("The input contains non-float value.");
                System.out.println("Try again or press 0 to quit.");
                printRepeatedMark();
            }
        }
    }

    /**
     * Counts the occurrences of a target float in an array of floats.
     *
     * @param target the float to count
     * @param list   the array of floats
     * @return the number of occurrences
     */
    private static int countOccurrence(float target, float[] list) {
        int counter = 0;

        for (float value : list) {
            if (value == target) {
                counter += 1;
            }
        }

        return counter;
    }

    /**
     * Counts and displays the occurrences of a specific stock price entered by the user.
     */
    private static void doCountOccurrence() {
        printRepeatedMark();
        System.out.println("You chose to determine the occurrence count of a specific price.");
        printOperationInstructions();

        float[] floats = doGetFloats();

        if (floats.length == 0) {
            goBackToMainMenu();
            return;
        }

        printRepeatedMark('-');
        System.out.println("Please enter a target stock price whose occurrence you want to check");
        System.out.println("For example: 20.34 Or Enter 0 to discard method");
        printRepeatedMark('-');

        float target = getFloat();

        if (target == 0) {
            goBackToMainMenu();
            return;
        }
        
        int occurrences = countOccurrence(target, floats);

        printRepeatedMark('*');
        System.out.printf("%.2f   Occurred     %d%n", target, occurrences);
        printRepeatedMark('*');
    }

    /**
     * Computes the cumulative sum of an array of floats.
     *
     * @param values the array of floats
     * @return an array of cumulative sums
     */
    private static float[] getCumulativeSum(float[] values) {
        float sum = 0;
        float[] cumulativeList = new float[values.length];

        for (int index = 0; index < values.length; index += 1) {
            BigDecimal bd = new BigDecimal(Float.toString(sum + values[index]));
            bd = bd.setScale(2, RoundingMode.HALF_UP);

            cumulativeList[index] = bd.floatValue();
            sum = bd.floatValue();
        }

        return cumulativeList;
    }

    /**
     * Computes and displays the cumulative sum of stock prices entered by the user.
     */
    private static void doCumulativeSum() {
        printRepeatedMark();
        System.out.println("You chose to compute the cumulative sum of stock prices.");
        printOperationInstructions();

        float[] floats = doGetFloats();

        if (floats.length == 0) {
            goBackToMainMenu();
            return;
        }
        
        float[] cumulativeList = getCumulativeSum(floats);

        printRepeatedMark('*');
        System.out.println("Below is the cumulative sum of the stock prices");
        StringBuilder string = new StringBuilder();
        string.append("[");

        for (float value : cumulativeList) {
            string.append(value);
            string.append(", ");
        }

        string.append("]");
        System.out.println(string);
        printRepeatedMark('*');
    }
}

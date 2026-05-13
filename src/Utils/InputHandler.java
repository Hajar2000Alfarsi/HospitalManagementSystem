package Utils;

import java.time.LocalDate;
import java.util.Scanner;

public class InputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getStringInput(String prompt) {
     while (true) {
         //show message
         System.out.println(prompt);
         //take input from user
         String input = scanner.nextLine();

         //check it null or not
         if (HelperUtils.isValidString(input)) {
             return input;
         }
         System.out.println("Invalid Input. Try Again");
     }
    }


    public static int getIntInput(String prompt) {
        while (true){
            //to avoid any error which may came by write String input
            try {
                System.out.println(prompt);
                //take number as String and then convert it to integer
                int number = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid Input. Try Again.");
            }
        }
    }


    public static int getIntInput(String prompt, int min, int max) {
        while (true) {
            //call getIntInput function to check the input is number
            int number = getIntInput(prompt);

            if (number >= min && number <= max){
                return number;
            }

            System.out.println("Number must be between " + min + " and " + max);
        }
    }


    public static double getDoubleInput(String prompt){
        while (true) {

            try {

                System.out.print(prompt);

                double number = Double.parseDouble(scanner.nextLine());

                return number;

            } catch (Exception e) {

                System.out.println("Invalid decimal number. Try again.");
            }
        }
    }


    public static LocalDate getDateInput(String prompt){
        while (true) {

            try {

                System.out.print(prompt);

                String input = scanner.nextLine();

                if (HelperUtils.isValidDate(input)) {
                    return LocalDate.parse(input);
                }

                System.out.println("Invalid date format. Try again.");
            } catch (Exception e) {
                System.out.println("Invalid date. Try again.");
            }
        }
    }


    public static boolean getConfirmation(String prompt){
        while (true) {
            System.out.println(prompt + " (yes/no): ");

            //Make sure there is no extra spaces or uppercase latter
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("yes") || input.equals("y")) {
                return true;
            }
            if (input.equals("no") || input.equals("n")) {
                return false;
            }

            System.out.println("Invalid input. Please enter yes or no.");

        }
    }
}

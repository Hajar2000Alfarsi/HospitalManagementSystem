package Utils;

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

}

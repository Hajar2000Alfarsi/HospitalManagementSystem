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



}

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



}

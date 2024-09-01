import java.util.*;
import java.io.*;

public class PasswordEvaulator {
    public static void main(String[] args) throws IOException {

        Scanner commonScanner = new Scanner(new File("MostCommonPasswords.txt"));
        Scanner specialCharScanner = new Scanner(new File("SpecialCharacters.txt"));
        Scanner hasNumbersScanner = new Scanner(new File("NumbersList.txt"));
        
        Scanner userInput = new Scanner(System.in);
        System.out.println("Type your password:");
        String password = userInput.nextLine();

        boolean isCommon = isCommon(password, commonScanner);
        boolean hasEightChars = hasEightChars(password);
        boolean hasSpecialChars = hasSpecialChars(password, specialCharScanner);
        boolean hasNumbers = hasNumbers(password, hasNumbersScanner);
        boolean hasCapitals = hasCapitals(password);
        
        int rating = 0;
      
        if (isCommon) {
            System.out.println("Your password was found in the most popular passwords list.");
        } else {
            rating++;
        }
        
        if (!hasEightChars) {
            System.out.println("Your password doesn't have enough characters.");
        } else {
            rating++;
        }
        
        if (!hasSpecialChars) {
            System.out.println("Your password doesn't contain special characters.");
        } else {
            rating++;
        }
        
        if (!hasNumbers) {
            System.out.println("Your password doesn't have any numbers.");
        } else {
            rating++;
        }
        
        if (!hasCapitals) {
            System.out.println("Your password doesn't have any capitals");
        } else {
            rating++;
        }
        
        System.out.print(rating + "/" + 5);
        
        
    }

    
    static boolean isCommon(String userInput, Scanner commonScanner) {
        while (commonScanner.hasNextLine()) {
            String commonPassword = commonScanner.nextLine();
            if (userInput.equals(commonPassword)) {
                return true;
            }
        }
        return false;
    }
    
    static boolean hasEightChars(String userInput) {
        int length = userInput.length();
        if (length >= 8) {
            return true;
        }
        else {
            return false;
        }
    }
    
    static boolean hasSpecialChars(String userInput, Scanner specialCharScanner) {
        while (specialCharScanner.hasNextLine()){
            if (userInput.contains(specialCharScanner.nextLine())) {
               return true;
            }
        }
        return false;
    }
    
    static boolean hasNumbers(String userInput, Scanner hasNumbersScanner) {
        while (hasNumbersScanner.hasNextLine()){
            if (userInput.contains(hasNumbersScanner.nextLine())) {
               return true;
            }
        }
        return false;
    }
    
    static boolean hasCapitals(String userInput) {
         for (int i = 0; i < userInput.length(); i++) {
            if (Character.isUpperCase(userInput.charAt(i))) {
               return true;
            }
         }
         return false;
    }
    
}

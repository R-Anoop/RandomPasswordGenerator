package RandomPasswordGen;

import java.security.SecureRandom;
import java.util.Scanner;

public class RandomePwdGen {

	private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+{}[]|:;<>,.?/";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Random Password Generator!");

        // User inputs for length and character types
        System.out.print("Enter the desired password length: ");
        int length = scanner.nextInt();

        System.out.println("Select the types of characters to include:");
        System.out.println("1. Uppercase Letters (A-Z)");
        System.out.println("2. Lowercase Letters (a-z)");
        System.out.println("3. Numbers (0-9)");
        System.out.println("4. Special Characters (!@#$%^&*)");

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");
        
        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");
        
        System.out.print("Include numbers? (yes/no): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("yes");
        
        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecialChars = scanner.next().equalsIgnoreCase("yes");

        // Ensure at least one character set is selected
        if (!includeUppercase && !includeLowercase && !includeNumbers && !includeSpecialChars) {
            System.out.println("You must select at least one character type.");
        } else {
            // Generate and display the password
            String password = generatePassword(length, includeUppercase, includeLowercase, includeNumbers, includeSpecialChars);
            System.out.println("Generated Password: " + password);
        }

        scanner.close();
    }

    // Method to generate a random password based on user inputs
    private static String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, 
                                           boolean includeNumbers, boolean includeSpecialChars) {

        StringBuilder characterPool = new StringBuilder();
        
        // Add character types to the pool based on user selection
        if (includeUppercase) {
            characterPool.append(UPPERCASE_LETTERS);
        }
        if (includeLowercase) {
            characterPool.append(LOWERCASE_LETTERS);
        }
        if (includeNumbers) {
            characterPool.append(NUMBERS);
        }
        if (includeSpecialChars) {
            characterPool.append(SPECIAL_CHARACTERS);
        }

        // Ensure the character pool is not empty
        if (characterPool.length() == 0) {
            throw new IllegalArgumentException("No character types selected.");
        }

        // Generate the password using a secure random number generator
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(randomIndex));
        }

        return password.toString();
    }

}



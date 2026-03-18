package unit4;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PasswordGenerator {

    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS    = "0123456789";
    private static final String SYMBOLS   = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    private final SecureRandom random = new SecureRandom();

    /**
     * Generates a random password based on the given options.
     *
     * @param length         desired password length (minimum 4 if all types enabled)
     * @param useUppercase   include uppercase letters
     * @param useLowercase   include lowercase letters
     * @param useDigits      include digits
     * @param useSymbols     include special symbols
     * @return               the generated password
     */
    public String generate(int length, boolean useUppercase, boolean useLowercase,
                           boolean useDigits, boolean useSymbols) {

        if (length < 1) {
            throw new IllegalArgumentException("Password length must be at least 1.");
        }
        if (!useUppercase && !useLowercase && !useDigits && !useSymbols) {
            throw new IllegalArgumentException("At least one character type must be selected.");
        }


        StringBuilder pool = new StringBuilder();
        List<Character> mandatoryChars = new ArrayList<>();

        if (useUppercase) {
            pool.append(UPPERCASE);
            mandatoryChars.add(randomChar(UPPERCASE));
        }
        if (useLowercase) {
            pool.append(LOWERCASE);
            mandatoryChars.add(randomChar(LOWERCASE));
        }
        if (useDigits) {
            pool.append(DIGITS);
            mandatoryChars.add(randomChar(DIGITS));
        }
        if (useSymbols) {
            pool.append(SYMBOLS);
            mandatoryChars.add(randomChar(SYMBOLS));
        }

        if (mandatoryChars.size() > length) {
            throw new IllegalArgumentException(
                "Password length (" + length + ") is too short to include all selected character types (" +
                mandatoryChars.size() + " types selected)."
            );
        }

        List<Character> passwordChars = new ArrayList<>(mandatoryChars);
        
        String poolStr = pool.toString();
        for (int i = mandatoryChars.size(); i < length; i++) {
            passwordChars.add(randomChar(poolStr));
        }

        Collections.shuffle(passwordChars, random);

        StringBuilder password = new StringBuilder(length);
        for (char c : passwordChars) {
            password.append(c);
        }
        return password.toString();
    }

    private char randomChar(String source) {
        return source.charAt(random.nextInt(source.length()));
    }
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordGenerator generator = new PasswordGenerator();

        System.out.println("============================================");
        System.out.println("         STRONG PASSWORD GENERATOR         ");
        System.out.println("============================================");

        try {
            System.out.print("Enter desired password length (e.g. 16): ");
            int length = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Include UPPERCASE letters? (y/n): ");
            boolean upper = scanner.nextLine().trim().equalsIgnoreCase("y");

            System.out.print("Include LOWERCASE letters? (y/n): ");
            boolean lower = scanner.nextLine().trim().equalsIgnoreCase("y");

            System.out.print("Include DIGITS (0-9)?       (y/n): ");
            boolean digits = scanner.nextLine().trim().equalsIgnoreCase("y");

            System.out.print("Include SYMBOLS (!@#...)?   (y/n): ");
            boolean symbols = scanner.nextLine().trim().equalsIgnoreCase("y");

            String password = generator.generate(length, upper, lower, digits, symbols);

            System.out.println("\n--------------------------------------------");
            System.out.println("Generated Password: " + password);
            System.out.println("--------------------------------------------");

            System.out.println("Password Strength : " + evaluateStrength(length, upper, lower, digits, symbols));

        } catch (NumberFormatException e) {
            System.err.println("Invalid input: please enter a numeric value for the length.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static String evaluateStrength(int length, boolean upper, boolean lower, boolean digits, boolean symbols) {
        int score = 0;
        if (length >= 8)  score++;
        if (length >= 12) score++;
        if (length >= 16) score++;
        if (upper) score++;
        if (lower) score++;
        if (digits) score++;
        if (symbols) score++;

        if (score <= 3) return "Weak ⚠";
        if (score <= 5) return "Medium ★★";
        return "Strong ✔✔✔";
    }
}

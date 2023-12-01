/**
 * Get all calibration values
 * First and last digits on each line
 * Sum them all up at the end
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);

        int total = 0;
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            
            int firstDigitIndex = getFirstDigit(line);
            int lastDigitIndex = getLastDigit(line);

            // firstDigit == lastDigit if there's only one digit in the string.
            if(firstDigitIndex <= lastDigitIndex) {
                char firstDigit = line.charAt(firstDigitIndex);
                char lastDigit = line.charAt(lastDigitIndex);

                int tensPlace = Character.getNumericValue(firstDigit) * 10;
                int onesPlace = Character.getNumericValue(lastDigit);

                total += tensPlace + onesPlace;
            }
        }

        System.out.println("Total: " + total);
        scanner.close();
    }

    public static int getFirstDigit(String line) {
        for(int i = 0; i < line.length(); i++) {
            if(Character.isDigit(line.charAt(i))) {
                return i;
            }
        }
        return 0;
    }

    public static int getLastDigit(String line) {
        for(int i = line.length() - 1; i >= 0; i--) {
            if(Character.isDigit(line.charAt(i))) {
                return i;
            }
        }
        return line.length() - 1;
    }
}
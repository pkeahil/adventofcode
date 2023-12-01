/**
 * Get all calibration values
 * First and last digits on each line
 * Sum them all up at the end
 */

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);
        Map<String, Integer> numberMap = initalizeHashMap();

        int total = 0;
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            
            System.out.println("processing " + line);
            int tensPlace = getFirstDigit(line, numberMap) * 10;
            int onesPlace = getLastDigit(line, numberMap);
            System.out.println((tensPlace + onesPlace));
            total += tensPlace + onesPlace;
        }

        System.out.println("Total: " + total);
        scanner.close();
    }

    public static Map<String, Integer> initalizeHashMap() {
        Map<String, Integer> result = new HashMap<>();

        result.put("one", 1);
        result.put("two", 2);
        result.put("three", 3);
        result.put("four", 4);
        result.put("five", 5);
        result.put("six", 6);
        result.put("seven", 7);
        result.put("eight", 8);
        result.put("nine", 9);

        return result;
    }

    public static int getFirstDigit(String line, Map<String, Integer> numberMap) {
        int firstDigitIndex = line.length() - 1;
        int firstDigitValue = 0;

        for(Map.Entry<String, Integer> entry : numberMap.entrySet()) {
            String digitWord = entry.getKey();
            String digit = Integer.toString(entry.getValue());

            int digitIndex = line.indexOf(digit);
            int digitWordIndex = line.indexOf(digitWord);
            
            if((digitIndex != -1) && (digitIndex <= firstDigitIndex)) {
                firstDigitIndex = digitIndex;
                firstDigitValue = entry.getValue();
            }
            if((digitWordIndex != -1) && (digitWordIndex <= firstDigitIndex)) {
                firstDigitIndex = digitWordIndex;
                firstDigitValue = entry.getValue();
            }
        }

        return firstDigitValue;
    }

    public static int getLastDigit(String line, Map<String, Integer> numberMap) {
        int lastDigitIndex = 0;
        int lastDigitValue = 0;

        for(Map.Entry<String, Integer> entry : numberMap.entrySet()) {
            String digitWord = entry.getKey();
            String digit = Integer.toString(entry.getValue());

            int digitIndex = line.lastIndexOf(digit);
            int digitWordIndex = line.lastIndexOf(digitWord);

            if((digitIndex != -1) && (digitIndex >= lastDigitIndex)) {
                lastDigitIndex = digitIndex;
                lastDigitValue = entry.getValue();
            }
            if((digitWordIndex != -1) && (digitWordIndex >= lastDigitIndex)) {
                lastDigitIndex = digitWordIndex;
                lastDigitValue = entry.getValue();
            }
        }
        return lastDigitValue;
    }
}
/*
This file contains test cases for CalculatorService class Which provide
Service for Addition operation
 */

package org.example.Services;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatorService {

    private static final String DEFAULT_DELIMITER = ",|\n";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\n";
    private static final int MAX_NUMBER = 1000;

    public int add(String numbers) {

        // Return 0 if input is empty
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        List<String> delimiters = new ArrayList<>();
        delimiters.add(DEFAULT_DELIMITER);

        // Check if custom delimiter is present
        if (numbers.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            numbers = extractDelimiters(numbers, delimiters);
        }

        // Creation of regex pattern for delimiters is learned from ChatGPT
        // Create regex pattern for delimiters
        String delimiterRegex = delimiters.stream()
                .map(delimiter -> delimiter.replace("*", "\\*").replace("%", "\\%"))
                .collect(Collectors.joining("|"));

        // Split numbers by delimiters
        String[] numArray = numbers.split(delimiterRegex);

        // Calculate sum of numbers
        return calculateSum(numArray);
    }

    private String extractDelimiters(String numbers, List<String> delimiters) {
        int delimiterEndIndex = numbers.indexOf(CUSTOM_DELIMITER_SUFFIX);
        String delimiterSection = numbers.substring(CUSTOM_DELIMITER_PREFIX.length(), delimiterEndIndex);
        numbers = numbers.substring(delimiterEndIndex + 1);

        // Check if multiple delimiters are present
        if (delimiterSection.startsWith("[") && delimiterSection.endsWith("]")) {
            // Remove square brackets
            delimiterSection = delimiterSection.substring(1, delimiterSection.length() - 1);
            // Split by "][" to get multiple delimiters
            String[] delimiterArray = delimiterSection.split("]\\[");

            // Add each delimiter to the list
            // addAll is suggestion by IntelliJ
            delimiters.addAll(Arrays.asList(delimiterArray));
        } else {
            // Add single delimiter to the list
            delimiters.add(delimiterSection);
        }

        return numbers;
    }

    // Calculate sum of numbers
    private int calculateSum(String[] numArray) {
        List<Integer> integers = new ArrayList<>();
        List<Integer> negativeNumbers = new ArrayList<>();

        // Convert string numbers to integers
        for (String num : numArray) {
            int n = Integer.parseInt(num);

            // Check for negative numbers
            if (n < 0) {
                negativeNumbers.add(n);
            }
            if (n <= MAX_NUMBER) {
                integers.add(n);
            }
        }

        // map is used to convert the list of integers to a stream of integers is suggestion by IntelliJ
        // Throw exception if negative numbers are present
        if (!negativeNumbers.isEmpty()) {
            String message = MessageFormat.format("Negatives not allowed: {0}", negativeNumbers.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
            throw new IllegalArgumentException(message);
        }

        // Return sum of numbers
        return integers.stream().mapToInt(Integer::intValue).sum();
    }
}

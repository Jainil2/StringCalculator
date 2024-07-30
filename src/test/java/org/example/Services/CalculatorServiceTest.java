/*
JUnit Learn from https://www.youtube.com/watch?v=sq_pYMepfP0&t=232s
This file contains test cases for CalculatorService class
 */

package org.example.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {

    private CalculatorService calculatorService;

    // Setup method to create new instance of CalculatorService
    @BeforeEach
    public void setUp() {
        calculatorService = new CalculatorService();
    }

    // Test case for adding null
    @Test
    public void testAddNull() {
        assertEquals(0, calculatorService.add(null));
    }

    // Test case for adding empty string
    @Test
    public void testAddEmptyString() {
        assertEquals(0, calculatorService.add(""));
    }

    // Test case for adding single number
    @Test
    public void testAddSingleNumber() {
        assertEquals(1, calculatorService.add("1"));
    }

    // Test case for adding two numbers
    @Test
    public void testAddTwoNumbers() {
        assertEquals(3, calculatorService.add("1,2"));
    }

    // Test case for adding multiple numbers
    @Test
    public void testAddMultipleNumbers() {
        assertEquals(15, calculatorService.add("1,2,3,4,5"));
    }

    // Test case for adding new line delimiter
    @Test
    public void testAddNewLineDelimiter() {
        assertEquals(6, calculatorService.add("1\n2,3"));
    }

    // Test case for adding custom delimiter
    @Test
    public void testAddCustomDelimiter() {
        assertEquals(3, calculatorService.add("//;\n1;2"));
    }

    // Test case for adding negative number
    @Test
    public void testAddNegativeNumberThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calculatorService.add("-1,2"));
        assertEquals("Negatives not allowed: -1", exception.getMessage());
    }


    /* EXTRA TEST CASES FROM LINK DATA */


    // Test case for adding multiple negative numbers
    @Test
    public void testAddMultipleNegativeNumbersThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calculatorService.add("-1,-2,3"));
        assertEquals("Negatives not allowed: -1, -2", exception.getMessage());
    }

    // Test case for adding number greater than 1000
    @Test
    public void testAddNumberGreaterThan1000() {
        assertEquals(2, calculatorService.add("2,1001"));
    }

    // Test case for adding number equal to 1000
    @Test
    public void testAddCustomDelimiterOfAnyLength() {
        assertEquals(6, calculatorService.add("//[***]\n1***2***3"));
    }

    // Test case for adding multiple custom delimiters
    @Test
    public void testAddMultipleCustomDelimiters() {
        assertEquals(6, calculatorService.add("//[*][%]\n1*2%3"));
    }

    // Test case for adding multiple custom delimiters of any length
    @Test
    public void testAddMultipleCustomDelimitersOfAnyLength() {
        assertEquals(6, calculatorService.add("//[**][%%]\n1**2%%3"));
    }
}

package org.example;
import org.example.Services.CalculatorService;
import java.text.MessageFormat;

/**
 * This is project for TDD Kata - 1 Calculator Service
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Enter String to add numbers");
        String numbers = System.console().readLine();
        CalculatorService calculatorService = new CalculatorService();
        System.out.println(MessageFormat.format("Sum of numbers: {0}", calculatorService.add(numbers)));
    }
}

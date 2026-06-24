package com.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setUp() {
        System.out.println("Setting up test fixture.");
        calculator = new Calculator();
    }

    @Test
    public void testAddition_AAA() {
        // Arrange
        int firstNumber = 10;
        int secondNumber = 20;

        // Act
        int result = calculator.add(firstNumber, secondNumber);

        // Assert
        Assert.assertEquals(30, result);
    }

    @After
    public void tearDown() {
        System.out.println("Tearing down test fixture.");
        calculator = null;
    }
}

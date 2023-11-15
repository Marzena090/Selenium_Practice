package Beginnings;// ZADANIE Z SELENIUM - POLSKI KURS
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTest {
    // dane wejsciowe
    int first_num = 2;
    int second_num = 3;
    // wyniki oczekiwane
    int  correctExpectedResult = 5;
    int incorrectExpectedResult = 6;

    // tworzenie instancji kalkulatora
    Calculator calculator = new Calculator();

    @Test
    public void TestCase1(){
        int actualResult = calculator.add(first_num, second_num);
        assertTrue(correctExpectedResult == actualResult);
    }

    @Test
    public void TestCase2(){
        int actualResult = calculator.add(first_num, second_num);
        assertFalse(incorrectExpectedResult == actualResult);
    }

    @Test
    public void TestCase3(){
        int actualResult = calculator.add(first_num, second_num);
        assertEquals(correctExpectedResult, actualResult);
    }
}

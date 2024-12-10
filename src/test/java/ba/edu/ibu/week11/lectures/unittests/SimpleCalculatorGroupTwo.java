package ba.edu.ibu.week11.lectures.unittests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorGroupTwo {

    @Test
    public void twoPlusTwoShouldEqualToFour(){
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(4, calculator.add(2,2));
    }

    @Test
    public void twoPlusTwo_shouldEqualToFour(){

    }

}
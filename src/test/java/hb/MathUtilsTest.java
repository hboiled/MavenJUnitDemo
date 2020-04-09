package hb;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {
    MathUtils mathUtils;

    @BeforeEach
    public void init() {
        mathUtils = new MathUtils();
    }

    @AfterEach
    public void displayTestName(TestInfo info, TestReporter reporter) {
        System.out.println(info.getDisplayName() + " executed.");
        //reporter.publishEntry("Running the" +info.getDisplayName() + " test.");
    }

    @DisplayName("Add test")
    @Tag("BasicMath")
    @RepeatedTest(value = 2, name = "{displayName} - repetition {currentRepetition} of {totalRepetitions}")
    public void addTest(RepetitionInfo repetitionInfo) {
        int expected = 2;
        int actual = mathUtils.add(1, 1);
        assertEquals(expected, actual, "The method should add 2 numbers");
        //System.out.println("rep num: " + repetitionInfo.getCurrentRepetition());
    }
    
    @Test
    public void circleAreaTest(TestInfo info) {
        double radius = 3;
        double expected = 28.274333882308138;
        double actual = mathUtils.calcCircleArea(radius);
        assertEquals(expected, actual, "Area of circle calculation based on radius must be successful");
    }

    @Nested
    @Tag("BasicMath")
    class SquareTest {        
        
        @Test 
        @DisplayName("Nested square test with positive nums")
        public void squaresPosNum() {
            double expected = 25;
            double actual = mathUtils.squareNumber(5);
            assertEquals(expected, actual, "The square of number passed should be calculated");
        }

        @Test
        @DisplayName("Nested square test with negative nums")
        public void squaresNegNum() {
            double expected = 100;
            double actual = mathUtils.squareNumber(-10);
            assertEquals(expected, actual, "The square of negative num should be positive");
        }
    }
    

    @Test
    @Disabled
    public void pythagoreanTheoremWorks() {
        double baseSqr = mathUtils.squareNumber(4);
        double perpSqr = mathUtils.squareNumber(6);;
        
        double expected = Math.sqrt((baseSqr + perpSqr));
        double actual = mathUtils.calcHypotenuse(4, 6);
        assertEquals(expected, actual, "Calculates hypotenuse using Pythagorean theorem.");
    }

    @Test
    public void divisionTest() {        
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(3, 0), "Division by zero encountered");
    }

    @Test
    @Tag("assertAll")
    public void assertingAll() {
        assertAll(
            () -> assertEquals(4, mathUtils.multiply(2, 2), "Should return the correct product"),
            () -> assertEquals(15, mathUtils.multiply(5, 3), "Should return the correct product"),
            () -> assertEquals(20, mathUtils.multiply(10, 2), "Should return the correct product"),
            () -> assertEquals(100, mathUtils.multiply(50, 2), "Should return the correct product")
        );
    }

}
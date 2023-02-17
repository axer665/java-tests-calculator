import org.example.Calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorTest {

    Calculator sut = new Calculator();

    @Test
    public void testsAdditional() {
        System.out.println("Test add");

        // given:
        int a = 1, b= 2, expected = 3;

        // when:
        var result = sut.additional(a, b);

        // then:
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testsSubtraction() {
        System.out.println("Test subtraction");
        // given:
        int a = 3, b= 2, expected = 1;

        // when:
        var result = sut.subtraction(a, b);

        // then:
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("multiplicationSource") // given:
    public void testsMultiplication(int a, int b, int expected) {
        System.out.print("Test multiplication - ");
        System.out.print("param 1: " + a + ", param 2: " + b + "result: " + expected);
        System.out.println();

        // when:
        var result = sut.multiplication(a, b);

        // then:
        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> multiplicationSource () {
        return Stream.of(
                Arguments.of(2,2,4),
                Arguments.of(4,4,16),
                Arguments.of(2,5,10)
        );
    }

    @Test
    public void testsDivide() {
        System.out.println("Test divide");
        // given:
        int a = 12, b= 5;
        double expected = 2.4;

        // when:
        var result = sut.divide(a, b);

        // then:
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testsDivideByZero() {
        System.out.println("Test divide by zero");
        // given:
        int a = 11, b = 0;
        Class<ArithmeticException> expected = ArithmeticException.class;

        // when:
        Executable executable = () -> sut.divideInt(a, b);

        // then:
        Assertions.assertThrows(expected, executable);
    }
}

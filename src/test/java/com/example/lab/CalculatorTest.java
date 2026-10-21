package com.example.lab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * JUnit 5 单元测试示例。相比原 Python 版只演示普通断言，
 * 这里额外覆盖了三种"进阶"测试写法：
 * <ol>
 *   <li>@ParameterizedTest + @CsvSource：一组输入批量验证</li>
 *   <li>@ValueSource：单一参数源</li>
 *   <li>assertThrows：异常路径测试</li>
 * </ol>
 */
class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void testAdd() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(0, calculator.add(-1, 1));
        assertEquals(-5, calculator.add(-2, -3));
    }

    @Test
    void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));
        assertEquals(-1, calculator.subtract(2, 3));
    }

    @ParameterizedTest
    @CsvSource({
        "3, 4, 12",
        "2, 0, 0",
        "-3, 5, -15",
        "100, 100, 10000"
    })
    void testMultiply(long a, long b, long expected) {
        assertEquals(expected, calculator.multiply(a, b));
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.0, 2.5, 100.0})
    void testDivide(double dividend) {
        assertEquals(dividend, calculator.divide(dividend, 1.0), 1e-9);
    }

    @Test
    void testDivideByZeroThrows() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> calculator.divide(1.0, 0.0)
        );
        assertEquals("除数不能为零", ex.getMessage());
    }

    @Test
    void testFactorial() {
        assertEquals(1, calculator.factorial(0));
        assertEquals(1, calculator.factorial(1));
        assertEquals(120, calculator.factorial(5));
        assertEquals(3628800, calculator.factorial(10));
    }

    @Test
    void testFactorialNegativeThrows() {
        assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-1));
    }
}

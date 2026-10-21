package com.example.lab;

/**
 * 简易计算器。相比原 Python 版实验，这里增加了：
 * <ul>
 *   <li>类型安全（int / long / double 重载语义）</li>
 *   <li>除零与负数阶乘的异常处理（IllegalArgumentException）</li>
 *   <li>factorial 等更有"算法味"的方法，便于写边界测试</li>
 * </ul>
 * 该类是单元测试与被部署站点（report.html）共同演示的核心逻辑。
 */
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public long multiply(long a, long b) {
        return a * b;
    }

    /**
     * 除法。除数为 0 时抛出受检语义的运行时异常，便于演示异常测试。
     */
    public double divide(double dividend, double divisor) {
        if (divisor == 0.0) {
            throw new IllegalArgumentException("除数不能为零");
        }
        return dividend / divisor;
    }

    /**
     * 阶乘。负数输入非法。
     */
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("阶乘不支持负数: " + n);
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

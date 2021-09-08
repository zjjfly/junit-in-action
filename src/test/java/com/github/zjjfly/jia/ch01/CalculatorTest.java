package com.github.zjjfly.jia.ch01;

/**
 * 手写的测试框架,显然无法用于实际项目
 *
 * @author zjjfly[[https://github.com/zjjfly]]
 * @date 2021/3/13
 */
public class CalculatorTest {

    private int nbErrors = 0;

    public void testAdd() {
        Calculator calculator = new Calculator();
        double result = calculator.add(10, 50);
        if (result != 60) {
            throw new IllegalStateException("Bad result: " + result);
        }
    }

    public static void main(String[] args) {
        CalculatorTest test = new CalculatorTest();
        try {
            test.testAdd();
        } catch (Throwable e) {
            test.nbErrors++;
            e.printStackTrace();
        }
        if (test.nbErrors > 0) {
            throw new IllegalStateException("There were " + test.nbErrors + " error(s)");
        }
    }

}

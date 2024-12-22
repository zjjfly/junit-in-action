package com.github.zjjfly.jia.ch03;

import com.github.zjjfly.jia.ch01.Calculator;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author <a href="https://github.com/zjjfly"/>zjjfly</a>
 * @date 2022/1/15
 */
@RunWith(CustomTestRunner.class) //使用自定义的Runner
public class CalculatorTest {

    public void add() {
        Calculator calculator = new Calculator();
        double result = calculator.add(10, 50);
        assertEquals(60, result, 0);
    }

}

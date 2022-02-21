package com.github.zjjfly.jia.ch03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.zjjfly.jia.ch01.Calculator;
import org.junit.runner.RunWith;

/**
 * @author zijunjie[https://github.com/zjjfly]
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

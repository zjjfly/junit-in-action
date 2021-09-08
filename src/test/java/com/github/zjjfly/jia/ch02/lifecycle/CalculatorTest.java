package com.github.zjjfly.jia.ch02.lifecycle;

import com.github.zjjfly.jia.ch01.Calculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit的测试类可以使顶级类,静态内部类和以@Nested注释的内部类,它的访问基本最起码需要包私有的
 *
 * @author zjjfly[[https://github.com/zjjfly]]
 * @date 2021/3/13
 */
public class CalculatorTest {

    private int i = 0;

    /**
     * 生命周期方法是以@BeforeAll,@AfterAll,@BeforeEach或@AfterEach注释的方法
     */
    @BeforeAll
    static void setup() {
        System.out.println("test start....");
    }

    /**
     * 测试方法是一个以@Test,@RepeatedTest,@ParameterizedTest,@TestFactory或@TestTemplate注释的实例方法,
     * 而且这个方法不能是抽象的,也不能有返回值
     */
    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        double result = calculator.add(10, 50);
        assertEquals(60, result, 0);
        i = 2;
    }

    @Test
    void testInstanceVariable() {
        //所以版本的JUnit运行每个测试方法的时候,默认的行为是使用以个新的实例运行测试,这是为了防止测试代码中的副作用干扰测试
        assertEquals(0, i);
    }

}

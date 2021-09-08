package com.github.zjjfly.jia.ch02.displayname;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zjjfly[[https://github.com/zjjfly]]
 * @date 2021/4/19
 */
//@DisplayName可以设置测试类和测试方法在IDE或构建工具中的显示名称,支持emoji
@DisplayName("Test class showing the @DisplayName annotation.")
public class DisplayNameTest {

    private SUT systemUnderTest = new SUT();

    @Test
    @DisplayName("Our system under test says hello.")
    void testHello() {
        assertEquals("Hello", systemUnderTest.hello());
    }

    @Test
    @DisplayName("😱")
    void testTalking() {
        assertEquals("How are you?", systemUnderTest.talk());
    }

    @Test
    void testBye() {
        assertEquals("Bye", systemUnderTest.bye());
    }

}

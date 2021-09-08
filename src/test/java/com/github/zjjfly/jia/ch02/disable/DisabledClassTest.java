package com.github.zjjfly.jia.ch02.disable;

import com.github.zjjfly.jia.ch02.lifecycle.SUT;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author zjjfly[[https://github.com/zjjfly]]
 * @date 2021/4/19
 */
//@Disable可以禁止测试类或测试方法的执行,并可以传入一个字符串说明禁止原因
@Disabled("Feature is still under construction.")
public class DisabledClassTest {

    private SUT systemUnderTest = new SUT("Our system under test");

    @Test
    void testRegularWork() {
        boolean canReceiveRegularWork = systemUnderTest.canReceiveRegularWork();
        assertTrue(canReceiveRegularWork);
    }

    @Test
    void testAdditionalWork() {
        boolean canReceiveAdditionalWork = systemUnderTest.canReceiveAdditionalWork();
        assertFalse(canReceiveAdditionalWork);
    }

}

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
public class DisabledMethodsTest {

    private SUT systemUnderTest = new SUT("Our system under test");

    @Test
    @Disabled
    void testRegularWork() {
        boolean canReceiveRegularWork = systemUnderTest.canReceiveRegularWork();
        assertTrue(canReceiveRegularWork);
    }

    @Test
    @Disabled("Feature still under construction.")
    void testAdditionalWork() {
        boolean canReceiveAdditionalWork = systemUnderTest.canReceiveAdditionalWork();
        assertFalse(canReceiveAdditionalWork);
    }

}

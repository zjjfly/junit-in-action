package com.github.zjjfly.jia.ch04;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * @author <a href="https://github.com/zjjfly"/>zjjfly</a>
 * @date 2022/2/21
 */
@ExtendWith(CustomExtension.class)
public class JUnit5CustomExtensionTester {

    @Test
    public void myCustomRuleTest() {
        System.out.println("Call of a test method");
    }

}

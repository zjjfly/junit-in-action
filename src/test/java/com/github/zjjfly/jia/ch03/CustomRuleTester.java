package com.github.zjjfly.jia.ch03;

import org.junit.Rule;
import org.junit.Test;

/**
 * @author zijunjie[https://github.com/zjjfly]
 * @date 2022/2/20
 */
public class CustomRuleTester {

    @Rule
    public CustomRule myRule = new CustomRule();

    @Test
    public void myCustomRuleTest() {
        System.out.println("Call of a test method");
    }

}

package com.github.zjjfly.jia.ch04;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * Junit5提供了Extension来替代Junit4的TestRule
 *
 * @author zijunjie[https://github.com/zjjfly]
 * @date 2022/2/21
 */
public class CustomExtension implements AfterEachCallback, BeforeEachCallback {

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        System.out.println(this.getClass().getSimpleName() + " " +
            context.getDisplayName() + " has started");
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        System.out.println(this.getClass().getSimpleName() + " " +
            context.getDisplayName() + " has finished");
    }
}

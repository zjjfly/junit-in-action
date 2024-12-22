package com.github.zjjfly.jia.ch03;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * @author <a href="https://github.com/zjjfly"/>zjjfly</a>
 * @date 2022/2/20
 */
public class CustomRule implements TestRule {

    private Statement base;

    private Description description;

    @Override
    public Statement apply(Statement base, Description description) {
        this.base = base;
        this.description = description;
        return new CustomStatement(base, description);
    }
}

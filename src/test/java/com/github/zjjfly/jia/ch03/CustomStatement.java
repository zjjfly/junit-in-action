package com.github.zjjfly.jia.ch03;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * @author <a href="https://github.com/zjjfly"/>zjjfly</a>
 * @date 2022/2/20
 */
public class CustomStatement extends Statement {

    private Statement base;

    private Description description;

    public CustomStatement(Statement base, Description description) {
        this.base = base;
        this.description = description;
    }

    @Override
    public void evaluate() throws Throwable {
        System.out.println(
            this.getClass().getSimpleName() + " " + description.getMethodName() + " has started");
        try {
            base.evaluate();
        } finally {
            System.out.println(this.getClass().getSimpleName() + " " +
                description.getMethodName() + " has finished");
        }
    }
}

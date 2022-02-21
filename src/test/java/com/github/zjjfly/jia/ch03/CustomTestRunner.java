package com.github.zjjfly.jia.ch03;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

/**
 * Junit4运行测试是通过{@link Runner}进行的，这里实现了一个自定义的{@link Runner}
 *
 * @author zijunjie[https://github.com/zjjfly]
 * @date 2022/1/15
 */
public class CustomTestRunner extends Runner {

    private Class<?> testedClass;

    public CustomTestRunner(Class<?> testedClass) {
        this.testedClass = testedClass;
    }

    @Override
    public Description getDescription() {
        return Description
            .createTestDescription(testedClass, this.getClass().getSimpleName() + " description");
    }

    @Override
    public void run(RunNotifier notifier) {
        System.out.println(
            "Running tests with " + this.getClass().getSimpleName() + ": " + testedClass);
        try {
            Object testObject = testedClass.newInstance();
            Method[] methods = testedClass.getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Test.class)) {
                    notifier.fireTestStarted(
                        Description.createTestDescription(testedClass, method.getName()));
                    method.invoke(testObject);
                    notifier.fireTestFinished(
                        Description.createTestDescription(testedClass, method.getName()));
                }
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}

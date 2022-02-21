package com.github.zjjfly.jia.ch03;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.github.zjjfly.jia.ch01.Calculator;
import java.io.File;
import java.io.IOException;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

/**
 * {@link org.junit.rules.TestRule}在Junit4中用于拦截测试方法，执行一些前置或后置处理
 * <p>需要测试类的{@link org.junit.rules.TestRule}字段上加上注解{@link Rule}让其生效</p>
 *
 * @author zijunjie[https://github.com/zjjfly]
 * @date 2022/2/20
 */
public class RuleTester {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    private Calculator calculator = new Calculator();

    private static File createdFolder;

    private static File createdFile;

    @Test
    public void expectIllegalArgumentException() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Cannot extract the square root of a negative value");
        calculator.sqrt(-1);
    }

    @Test
    public void expectArithmeticException() {
        expectedException.expect(ArithmeticException.class);
        expectedException.expectMessage("Cannot divide by zero");
        calculator.divide(1, 0);
    }

    @Test
    public void testTemporaryFolder() throws IOException {
        createdFolder = folder.newFolder("createdFolder");
        createdFile = folder.newFile("createdFile.txt");
        assertTrue(createdFolder.exists());
        assertTrue(createdFile.exists());
    }

    @AfterClass
    public static void cleanUpAfterAllTestsRan() {
        assertFalse(createdFolder.exists());
        assertFalse(createdFile.exists());
    }
}

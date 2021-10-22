package com.github.zjjfly.jia.ch02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * assumption表示测试执行的前置条件，如果不满足则不执行测试
 *
 * @author zijunjie[[https://github.com/zjjfly]]
 * @date 2021/10/22
 */
public class AssumptionTest {

  private static String EXPECTED_JAVA_VERSION = "1.8";

  private String javaVersion() {
    return System.getProperty("java.vm.specification.version");
  }

  private String os() {
    return System.getProperty("os.name");
  }

  private String arch() {
    return System.getProperty("os.arch");
  }

  @BeforeEach
  void setUp() {
    Assumptions.assumeTrue(os().equals("Mac OS X"));
  }

  @Test
  void assumeThat() {
    Assumptions.assumingThat(
        () -> javaVersion().equals(EXPECTED_JAVA_VERSION),
        () -> Assertions.assertFalse(false)
    );
  }

  @Test
  void testJobToRun() {
    Assumptions.assumeTrue(arch().equals("aarch64"));
    Assertions.assertEquals(1, 1-1);
  }
}

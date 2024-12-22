package com.github.zjjfly.jia.ch02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

/**
 * JUnit5的测试类的构造方法和测试方法可以有参数
 * <p>
 * 它们是通过{@link org.junit.jupiter.api.extension.ParameterResolver}来注入的<br/>
 * 默认的三个ParameterResolver注入了了{@link TestInfo},{@link TestReporter},{@link RepetitionInfo}
 * </p>
 *
 * @author <a href="https://github.com/zjjfly"/>zjjfly</a>
 * @date 2022/1/8
 */
class ParameterResolverTest {

  ParameterResolverTest(TestInfo testInfo) {
    assertEquals("ParameterResolverTest", testInfo.getDisplayName());
  }

  @BeforeEach
  void setUp(TestInfo testInfo) {
    String displayName = testInfo.getDisplayName();
    assertTrue(displayName.equals("display name of the method") ||
        displayName.equals("testGetNameOfTheMethod(TestInfo, TestReporter)") ||
        displayName.equals("repeated test"));
  }

  @Test
  void testGetNameOfTheMethod(TestInfo testInfo, TestReporter testReporter) {
    assertEquals("testGetNameOfTheMethod(TestInfo, TestReporter)", testInfo.getDisplayName());
    testReporter.publishEntry("Key", "Value");
  }

  @Test
  @DisplayName("display name of the method")
  void testGetNameOfTheMethodWithDisplayNameAnnotation(TestInfo testInfo) {
    assertEquals("display name of the method", testInfo.getDisplayName());
  }

  @RepeatedTest(value = 3, name = "repeated test")
  void repeatedTest(RepetitionInfo repetitionInfo) {
    int currentRepetition = repetitionInfo.getCurrentRepetition();
    int totalRepetitions = repetitionInfo.getTotalRepetitions();
    System.out.println("current repetition: " + currentRepetition);
    System.out.println("total repetitions: " + totalRepetitions);
  }
}

package com.github.zjjfly.jia.ch02;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Iterator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

/**
 * @author zijunjie[https://github.com/zjjfly]
 * @date 2022/1/13
 */
public class DynamicTests {

  @BeforeAll
  static void setUpClass() {
    System.out.println("@BeforeAll method");
  }

  @AfterAll
  static void tearDownClass() {
    System.out.println("@AfterAll method");
  }

  @BeforeEach
  void setUp() {
    System.out.println("@BeforeEach method");
  }

  @AfterEach
  void tearDown() {
    System.out.println("@AfterEach method");
  }

  private boolean positiveNumberPredicate(int i) {
    return i > 0;
  }

  @TestFactory
  Iterator<DynamicTest> positiveNumberPredicateTestCases() {
    return asList(
        dynamicTest("negative number", () -> assertFalse(positiveNumberPredicate(-1))),
        dynamicTest("zero", () -> assertFalse(positiveNumberPredicate(0))),
        dynamicTest("positive number", () -> assertTrue(positiveNumberPredicate(1)))
    ).iterator();
  }

}

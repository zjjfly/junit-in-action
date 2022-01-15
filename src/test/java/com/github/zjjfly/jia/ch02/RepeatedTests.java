package com.github.zjjfly.jia.ch02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.zjjfly.jia.ch01.Calculator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestReporter;

/**
 * {@link RepeatedTest} 可以让测试重复进行
 * <p>
 *   它的name属性支持三个占位符:
 *   <li>{displayName}</li>
 *   <li>{currentRepetition}</li>
 *   <li>{totalRepetitions}</li>
 *
 * </p>
 *
 * @author zijunjie[https://github.com/zjjfly]
 * @date 2022/1/10
 */
@TestInstance(Lifecycle.PER_CLASS)
public class RepeatedTests {

  private int i = 0;

  private static Set<Integer> integerSet = new HashSet<>();

  private static List<Integer> integerList = new ArrayList<>();

  @RepeatedTest(name = "{displayName} - repetition {currentRepetition}/{totalRepetitions}", value = 5)
  @DisplayName("Test add operation")
  void test() {
    Calculator calculator = new Calculator();
    assertEquals(i * 2, calculator.add(i, i),
        String.format("%d + %d = %d", i, i, i * 2));
    i++;
  }

  @RepeatedTest(value = 5, name = "the list contains {currentRepetition} elements(s), the set contains 1 element")
  void testAddingToCollections(TestReporter testReporter, RepetitionInfo repetitionInfo) {
    integerSet.add(1);
    integerList.add(repetitionInfo.getCurrentRepetition());
    testReporter.publishEntry("Repetition number",
        String.valueOf(repetitionInfo.getCurrentRepetition()));
    assertEquals(1, integerSet.size());
    assertEquals(repetitionInfo.getCurrentRepetition(), integerList.size());
  }
}

package com.github.zjjfly.jia.ch02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.EnumSource.Mode.EXCLUDE;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * {@link ParameterizedTest} 表示这个测试方法是参数化的
 * <p>
 * 需要搭配{@link org.junit.jupiter.params.provider.ArgumentsSource}或其子注解进行参数注入
 * </p>
 *
 * @author zijunjie[https://github.com/zjjfly]
 * @date 2022/1/10
 */
@TestInstance(Lifecycle.PER_CLASS)
public class ParameterizedTests {

  private final WordCounter wordCounter = new WordCounter();

  /**
   * {@link ValueSource}可以注入单个值
   */
  @ParameterizedTest
  @ValueSource(strings = {"Check three parameters", "JUnit in Action"})
  void testWordsInSentence(String sentence) {
    assertEquals(3, wordCounter.countWords(sentence));
  }

  /**
   * {@link EnumSource}可以注入枚举的每个值
   */
  @ParameterizedTest
  @EnumSource(Sentences.class)
  void testWordsInSentence(Sentences sentence) {
    assertEquals(3, wordCounter.countWords(sentence.value()));
  }

  @ParameterizedTest
  @EnumSource(value = Sentences.class,
      names = {"JUNIT_IN_ACTION", "THREE_PARAMETERS"})
  void testSelectedWordsInSentence(Sentences sentence) {
    assertEquals(3, wordCounter.countWords(sentence.value()));
  }

  @ParameterizedTest
  @EnumSource(value = Sentences.class, mode = EXCLUDE, names =
      {"THREE_PARAMETERS"})
  void testExcludedWordsInSentence(Sentences sentence) {
    assertEquals(3, wordCounter.countWords(sentence.value()));
  }

  enum Sentences {
    JUNIT_IN_ACTION("JUnit in Action"),
    SOME_PARAMETERS("Check some parameters"),
    THREE_PARAMETERS("Check three parameters");

    private final String sentence;

    Sentences(String sentence) {
      this.sentence = sentence;
    }

    public String value() {
      return sentence;
    }
  }

  /**
   * {@link CsvSource}可以注入多组多个参数，多个参数通过分隔符（默认逗号）分隔
   */
  @ParameterizedTest
  @CsvSource({"2, Unit testing", "3, JUnit in Action", "4, Write solid Java code"})
  void testWordsInSentence(int expected, String sentence) {
    assertEquals(expected, wordCounter.countWords(sentence));
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/word_counter.csv")
  void testWordsInSentence2(int expected, String sentence) {
    assertEquals(expected, wordCounter.countWords(sentence));
  }

}

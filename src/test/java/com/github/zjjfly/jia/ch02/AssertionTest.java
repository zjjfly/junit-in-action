package com.github.zjjfly.jia.ch02;

import java.time.Duration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * @author zijunjie[[https://github.com/zjjfly]]
 * @date 2021/10/22
 */
public class AssertionTest {

  @Test
  @Disabled
  void assertAll() {
    //assertAll可以执行一起多个Executable，其中有报错的那么assetAll也会失败，
    //但所有的Executable都会执行完
    Assertions.assertAll("one of them will failed",
        () -> Assertions.assertTrue(true),
        Assertions::fail,
        () -> Assertions.assertEquals(1, 1 + 0)
    );
  }

  @Test
  @Disabled
  void lazyMessage() {
    //使用Supplier<String>来实现失败信息的lazy initialize，减少开销
    Assertions.assertEquals(1, 1 - 1, () -> "test failed");
  }

  @Test
  @Disabled
  void timeout() {
    //assertTimeout会在lambda执行完之后判断是否超时
    Assertions.assertTimeout(Duration.ofMillis(500), () -> {
      Thread.sleep(1000L);
    });
    //assertTimeout会在超过指定的超时时间之后马上结束，并抛出AssertionFailedError
    Assertions.assertTimeoutPreemptively(Duration.ofMillis(500), () -> {
      Thread.sleep(1000L);
    });
  }

  @Test
  void throwAssertion() {
    RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
      throw new RuntimeException("test message");
    });
    Assertions.assertEquals("test message", exception.getMessage());
  }
}

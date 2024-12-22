package com.github.zjjfly.jia.ch02;


import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="https://github.com/zjjfly"/>zjjfly</a>
 * @date 2022/1/13
 */
public class HamcrestMatchersTest {

  private static String FIRST_NAME = "John";

  private static String LAST_NAME = "Smith";

  private static Customer customer = new Customer(FIRST_NAME, LAST_NAME);

  @Test
  @DisplayName("Hamcrest is, anyOf, allOf")
  public void testHamcrestIs() {
    int price1 = 1, price2 = 1, price3 = 2;
    assertThat(1, is(price1));
    assertThat(1, anyOf(is(price2), is(price3)));
    assertThat(1, allOf(is(price1), is(price2)));
  }

  @Test
  @DisplayName("Null expected")
  void testNull() {
    assertThat(null, nullValue());
    assertThat(customer, notNullValue());
  }

  @Test
  @DisplayName("Check correct customer properties")
  void checkCorrectCustomerProperties() {
    assertThat(customer,
        allOf(hasProperty("firstName", is(FIRST_NAME)),
            hasProperty("lastName", is(LAST_NAME))));
  }

  @Test
  @DisplayName("Check size and element of list")
  void testList() {
    ArrayList<String> values = Lists.newArrayList("Oliver", "Jack", "Harry");
    assertThat(values, hasSize(3));
    assertThat(values, hasItem(anyOf(equalTo("Oliver"), equalTo("Jack"), equalTo("Harry"))));
  }

  @Data
  @AllArgsConstructor
  public static class Customer {

    private String firstName;
    private String lastName;
  }

}

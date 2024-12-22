package com.github.zjjfly.jia.ch02.tags;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="https://github.com/zjjfly"/>zjjfly</a>
 * @date 2021/10/21
 */
@Tag("repository")
public class CustomersRepositoryTest {

  private String CUSTOMER_NAME = "John Smith";
  private CustomersRepository repository = new CustomersRepository();

  @Test
  void testNonExistence() {
    boolean exists = repository.contains("John Smith");

    assertFalse(exists);
  }

  @Test
  void testCustomerPersistence() {
    repository.persist(new Customer(CUSTOMER_NAME));
    assertTrue(repository.contains("John Smith"));
  }
}

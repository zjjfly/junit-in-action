package com.github.zjjfly.jia.ch02.tags;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zijunjie[[https://github.com/zjjfly]]
 * @date 2021/10/21
 */
class CustomersRepository {

  private List<Customer> customers = new ArrayList<>();

  public boolean contains(String name) {
    return customers.stream().anyMatch(customer -> customer.getName().equals(name));
  }

  public void persist(Customer customer) {
    customers.add(customer);
  }
}

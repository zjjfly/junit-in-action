package com.github.zjjfly.jia.ch02.nested;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author <a href="https://github.com/zjjfly"/>zjjfly</a>
 * @date 2021/10/21
 */
@Data
@Builder(setterPrefix = "with")
public class Customer {

    private Gender gender;

    private String firstName;

    private String lastName;

    private String middleName;

    private Date becomeCustomer;

}

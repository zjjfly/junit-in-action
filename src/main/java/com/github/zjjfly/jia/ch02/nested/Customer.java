package com.github.zjjfly.jia.ch02.nested;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

/**
 * @author zijunjie[[https://github.com/zjjfly]]
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

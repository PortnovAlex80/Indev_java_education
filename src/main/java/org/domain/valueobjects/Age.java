package org.domain.valueobjects;

import org.domain.common.ValueObject;

public class Age extends ValueObject {
    private Integer age;

    public Age(Integer age) {
        if (age == null || age < 0 || age >= 90) {
            throw new IllegalArgumentException("Age must be between 0 and 89.");
        }
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }
}

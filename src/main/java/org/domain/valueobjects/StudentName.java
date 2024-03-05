package org.domain.valueobjects;

import org.domain.common.ValueObject;

public class StudentName extends ValueObject {
    private String name;

    public StudentName(String name) {
        if (name == null || name.length() <= 3) {
            throw new IllegalArgumentException("Name must be longer than 3 characters.");
        }
        if (containsNumbers(name)) {
            throw new IllegalArgumentException("Name cannot contain numbers.");
        }
        this.name = name;
    }

    private boolean containsNumbers(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }
}

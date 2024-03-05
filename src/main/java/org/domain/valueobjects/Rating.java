package org.domain.valueobjects;

import org.domain.common.ValueObject;

public class Rating extends ValueObject {
    private Double rating;
    public Rating(Double rating) {
        this.rating = rating;    };

    // Метод для получения значения оценки
    public Double getRatingValue() {
        return rating;
    }


}

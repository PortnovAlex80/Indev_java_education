package org.adapters.dto;

import org.domain.Subject;

import java.io.Serializable;

public class SubjectDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String subject;
    private Double rating;

    public SubjectDTO(Subject subject) {
        this.subject = subject.getSubject();
        this.rating = subject.getRatingValue();
    }

    public Subject toDomainObject() {
        return Subject.createSubjectWithRating(this.subject, this.rating);
    }
}

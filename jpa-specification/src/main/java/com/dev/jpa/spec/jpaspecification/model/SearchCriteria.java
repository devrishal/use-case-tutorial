package com.dev.jpa.spec.jpaspecification.model;

import lombok.Data;

@Data
public class SearchCriteria {
    private String searchKey;

    private String searchValue;

    private Operator operator;
}

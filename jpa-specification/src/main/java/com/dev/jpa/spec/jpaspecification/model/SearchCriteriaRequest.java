package com.dev.jpa.spec.jpaspecification.model;

import java.util.List;

import lombok.Data;

@Data
public class SearchCriteriaRequest {
    List<SearchCriteria> searchCriteria;
}

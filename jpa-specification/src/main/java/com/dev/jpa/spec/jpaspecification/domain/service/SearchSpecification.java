package com.dev.jpa.spec.jpaspecification.domain.service;

import java.util.List;

import com.dev.jpa.spec.jpaspecification.domain.entity.Customer;
import com.dev.jpa.spec.jpaspecification.model.SearchCriteria;
import jakarta.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

public class SearchSpecification {
    public static Specification<Customer> createSpecification(List<SearchCriteria> searchCriteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = searchCriteria.stream().map(criteria -> criteria.getOperator()
                    .buildCriteria(root, query, criteriaBuilder, criteria.getSearchKey(), criteria.getSearchValue())).toList();
            return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
        };
    }
}

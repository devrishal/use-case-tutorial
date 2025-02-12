package com.dev.jpa.spec.jpaspecification.model;

import java.util.List;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public enum Operator {
    LIKE {
        @Override
        public Predicate buildCriteria(Root root, CriteriaQuery query, CriteriaBuilder cb,
                String searchKey, String searchValue) {
            CriteriaAttributeBuilder criteriaAttributeBuilder = CriteriaAttributeBuilder.valueOf(searchKey);
            Expression<String> expression = criteriaAttributeBuilder.build(root, query, cb);
            Predicate predicate = cb.like(expression, "%" + searchValue + "%");
            return cb.and(predicate);
        }
    },
    EQUALS {
        @Override
        public Predicate buildCriteria(Root root, CriteriaQuery query, CriteriaBuilder cb,
                String searchKey, String searchValue) {
            CriteriaAttributeBuilder criteriaAttributeBuilder = CriteriaAttributeBuilder.valueOf(searchKey);
            Expression<String> expression = criteriaAttributeBuilder.build(root, query, cb);
            Predicate predicate = cb.equal(expression, searchValue);
            return cb.and(predicate);
        }
    },
    IN {
        @Override
        public Predicate buildCriteria(Root root, CriteriaQuery query, CriteriaBuilder cb,
                String searchKey, String searchValue) {
            CriteriaAttributeBuilder criteriaAttributeBuilder = CriteriaAttributeBuilder.valueOf(searchKey);
            List<String> inSearchParams = List.of(searchValue.split(","));
            return criteriaAttributeBuilder.build(root, query, cb).in(inSearchParams);
        }
    };

    public abstract Predicate buildCriteria(Root root, CriteriaQuery query, CriteriaBuilder cb,
            String searchKey, String searchValue);
}
package com.dev.jpa.spec.jpaspecification.model;

import com.dev.jpa.spec.jpaspecification.domain.entity.Customer_;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;

public enum CriteriaAttributeBuilder {
    FIRST_NAME {
        @Override
        public Path build(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return root.get(Customer_.FIRST_NAME);
        }
    },
    LAST_NAME {
        @Override
        public Path build(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return root.get(Customer_.LAST_NAME);
        }
    },
    EMAIL {
        @Override
        public Path build(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return root.get(Customer_.EMAIL);
        }
    },
    GENDER {
        @Override
        public Path build(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return root.get(Customer_.GENDER);
        }
    };

    public abstract Path build(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder);
}

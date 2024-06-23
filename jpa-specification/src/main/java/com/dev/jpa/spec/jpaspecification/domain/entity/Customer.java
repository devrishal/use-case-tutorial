package com.dev.jpa.spec.jpaspecification.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table
@Entity
public class Customer {
    @Id
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String gender;

    private String accountNumber;
}

package com.rds.barcodegen.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "Customers", schema = "CO")
public class Customer {

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "customerSequence")
	@SequenceGenerator(name = "customerSequence", sequenceName = "ISEQ$$_75864", allocationSize = 1)
	private long customerId;

	private String emailAddress;

	private String fullName;

}

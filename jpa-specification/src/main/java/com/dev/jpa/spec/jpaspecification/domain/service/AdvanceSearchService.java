package com.dev.jpa.spec.jpaspecification.domain.service;

import java.util.List;

import com.dev.jpa.spec.jpaspecification.domain.entity.Customer;
import com.dev.jpa.spec.jpaspecification.domain.repository.CustomerRepository;
import com.dev.jpa.spec.jpaspecification.model.SearchCriteriaRequest;
import com.dev.jpa.spec.jpaspecification.model.SearchResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdvanceSearchService {
    private final CustomerRepository customerRepository;

    private final ModelMapper modelMapper;

    public List<SearchResponse> searchCustomerByCriteria(SearchCriteriaRequest searchCriteriaRequest) {
        List<Customer> customers = customerRepository.findAll(
                SearchSpecification.createSpecification(searchCriteriaRequest.getSearchCriteria()));
        return customers.stream().map(i -> modelMapper.map(i, SearchResponse.class)).toList();
    }
}

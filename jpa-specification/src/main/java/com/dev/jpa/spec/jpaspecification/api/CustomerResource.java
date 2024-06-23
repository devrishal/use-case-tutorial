package com.dev.jpa.spec.jpaspecification.api;

import java.util.List;

import com.dev.jpa.spec.jpaspecification.domain.service.AdvanceSearchService;
import com.dev.jpa.spec.jpaspecification.model.SearchCriteriaRequest;
import com.dev.jpa.spec.jpaspecification.model.SearchResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/demo-service")
public class CustomerResource {
    private final AdvanceSearchService advanceSearchService;

    @PostMapping("/advance-search")
    public ResponseEntity<List<SearchResponse>> searchByCriteria(@RequestBody SearchCriteriaRequest searchCriteria) {
        return ResponseEntity.ok(advanceSearchService.searchCustomerByCriteria(searchCriteria));
    }
}

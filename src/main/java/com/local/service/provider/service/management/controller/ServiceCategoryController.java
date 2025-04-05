package com.local.service.provider.service.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.local.service.provider.service.management.entity.ServiceBooking;
import com.local.service.provider.service.management.entity.ServiceCategory;
import com.local.service.provider.service.management.service.ServiceCategoryService;

@RestController
@RequestMapping("/api/service-category")  
public class ServiceCategoryController {

    @Autowired
    private ServiceCategoryService serviceCategoryService;

    @PostMapping("/saveServiceCategoryDetails")
    public ResponseEntity<ServiceCategory> createServiceCategoryDetails(@RequestBody ServiceCategory serviceCategory) {
        ServiceCategory saveServiceCategory = serviceCategoryService.createServiceCategory(serviceCategory);
        return ResponseEntity.ok(saveServiceCategory);
    }
    @GetMapping("/fetchAllServiceCategoryDetails")
    public ResponseEntity<List<ServiceCategory>> fetchAllServiceDetails() {
        List<ServiceCategory> category = serviceCategoryService.fetchAllServiceDetails();
        return ResponseEntity.ok(category);
    }
    @GetMapping("/fetchServiceCategoryDetailsById")
    public ResponseEntity<ServiceCategory>fetchServiceCategoryDetailsById(@RequestParam Integer Id){
    	ServiceCategory category = serviceCategoryService.fetchServiceCategoryDetailsById(Id);
    	return ResponseEntity.ok(category);
    }
    @GetMapping("/fetchServiceCategoryDetailsByCategoryName")
    public ResponseEntity<ServiceCategory>fetchServiceCategoryDetailsByCategoryName(@RequestParam String categoryName){
    	ServiceCategory category = serviceCategoryService.fetchServiceCategoryDetailsByCategoryName(categoryName);
    	return ResponseEntity.ok(category);
    }
}

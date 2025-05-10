package com.local.service.provider.service.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.local.service.provider.service.management.entity.ServiceCategory;

public interface ServiceCategoryService {

	ServiceCategory createServiceCategory(ServiceCategory serviceCategory);

	List<ServiceCategory> fetchAllServiceDetails();

	ServiceCategory fetchServiceCategoryDetailsById(Integer id);

	ServiceCategory fetchServiceCategoryDetailsByCategoryName(String categoryName);


}

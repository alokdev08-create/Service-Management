package com.local.service.provider.service.management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.service.provider.service.management.entity.ServiceCategory;
import com.local.service.provider.service.management.repositry.ServiceCategoryRepository;
import com.local.service.provider.service.management.service.ServiceCategoryService;

@Service
public class ServiceCategoryServiceImpl implements ServiceCategoryService {
    @Autowired
    private ServiceCategoryRepository serviceCategoryRepository; 
    @Override
    public ServiceCategory createServiceCategory(ServiceCategory serviceCategory) {
        return serviceCategoryRepository.save(serviceCategory);
    }
	@Override
	public List<ServiceCategory> fetchAllServiceDetails() {
		return serviceCategoryRepository.findAll();
	}
	@Override
	public ServiceCategory fetchServiceCategoryDetailsById(Integer Id) {
		return serviceCategoryRepository.findById(Id);
	}
	@Override
	public ServiceCategory fetchServiceCategoryDetailsByCategoryName(String categoryName) {
		return serviceCategoryRepository.findByCategoryName(categoryName);
	}

}
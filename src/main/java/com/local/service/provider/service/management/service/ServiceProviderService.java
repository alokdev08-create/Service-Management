package com.local.service.provider.service.management.service;

import java.util.List;

import com.local.service.provider.service.management.entity.ServiceProvider;

public interface ServiceProviderService {

	ServiceProvider createServiceProvider(ServiceProvider serviceProvider);

	List<ServiceProvider> fetchAllServiceProviderDetails();


}

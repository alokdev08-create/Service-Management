package com.local.service.provider.service.management.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.service.provider.service.management.entity.ServiceProvider;
import com.local.service.provider.service.management.repositry.ServiceProviderRepository;
import com.local.service.provider.service.management.service.ServiceProviderService;
@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {
	@Autowired
	private ServiceProviderRepository serviceProviderRepository;

	@Override
	public ServiceProvider createServiceProvider(ServiceProvider serviceProvider) {
		return serviceProviderRepository.save(serviceProvider);
	}

}

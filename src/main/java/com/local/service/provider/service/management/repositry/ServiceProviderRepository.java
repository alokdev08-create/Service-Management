package com.local.service.provider.service.management.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.local.service.provider.service.management.entity.ServiceProvider;
@Repository
public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {

	ServiceProvider findById(Integer id);

}

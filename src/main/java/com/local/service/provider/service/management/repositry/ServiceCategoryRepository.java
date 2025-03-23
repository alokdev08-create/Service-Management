package com.local.service.provider.service.management.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.local.service.provider.service.management.entity.ServiceCategory;
@Repository
public interface ServiceCategoryRepository extends JpaRepository<ServiceCategory, Long> {

}

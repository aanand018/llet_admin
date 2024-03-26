package com.snipe.let.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snipe.let.admin.domain.CategoriesTypeDomain;

public interface CategoriesTypeRepository extends JpaRepository<CategoriesTypeDomain, Long> {

}

package com.snipe.let.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snipe.let.admin.domain.CategoriesDomain;

public interface CategoriesRepository extends JpaRepository<CategoriesDomain, Long> {

}

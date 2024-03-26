package com.snipe.let.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snipe.let.admin.domain.SubCategoriesDomain;

public interface SubCategoriesRepository extends JpaRepository<SubCategoriesDomain, Long> {

}

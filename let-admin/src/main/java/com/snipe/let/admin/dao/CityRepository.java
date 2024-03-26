package com.snipe.let.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snipe.let.admin.domain.CityDomain;

public interface CityRepository extends JpaRepository<CityDomain, Long> {

}

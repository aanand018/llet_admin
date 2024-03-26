package com.snipe.let.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snipe.let.admin.domain.CountryDomain;

public interface CountryRepository extends JpaRepository<CountryDomain, Long>{

}

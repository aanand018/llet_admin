package com.snipe.let.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snipe.let.admin.domain.StateDomain;

public interface StateRepository extends JpaRepository<StateDomain, Long> {

}

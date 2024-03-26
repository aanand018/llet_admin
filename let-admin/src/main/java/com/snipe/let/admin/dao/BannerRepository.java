package com.snipe.let.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.snipe.let.admin.domain.BannerDomain;

public interface BannerRepository extends  JpaRepository<BannerDomain, Long> {

}

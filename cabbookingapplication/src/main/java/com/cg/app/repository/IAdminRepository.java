package com.cg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.app.dao.IAdminDao;
import com.cg.app.entities.Admin;

@Repository("aDao")
public interface IAdminRepository extends IAdminDao,JpaRepository<Admin, Integer> {

}

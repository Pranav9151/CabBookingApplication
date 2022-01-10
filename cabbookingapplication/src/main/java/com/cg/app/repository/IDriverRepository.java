package com.cg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.app.dao.IDriverDao;
import com.cg.app.entities.Driver;

@Repository("dDao")
public interface IDriverRepository extends IDriverDao, JpaRepository<Driver, Integer> {


}

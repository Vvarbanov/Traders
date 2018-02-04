package com.diplomna.traders.repository;

import com.diplomna.traders.Models.MyProperties;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertiesRepository extends CrudRepository<MyProperties,Long> {



}

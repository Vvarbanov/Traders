package com.diplomna.traders.repository;

import com.diplomna.traders.Models.MyProperties;
import org.springframework.data.repository.CrudRepository;

public interface PropertiesRepository extends CrudRepository<MyProperties,Long> {
}

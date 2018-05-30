package com.diplomna.traders.repository;

import com.diplomna.traders.models.MyObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectRepository extends CrudRepository<MyObject,Long> {



}

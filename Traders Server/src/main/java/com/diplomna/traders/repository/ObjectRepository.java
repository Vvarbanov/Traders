package com.diplomna.traders.Repository;

import com.diplomna.traders.Models.MyObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectRepository extends CrudRepository<MyObject,Long> {



}

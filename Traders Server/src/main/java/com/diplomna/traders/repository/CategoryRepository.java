package com.diplomna.traders.repository;

import com.diplomna.traders.Models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {



}

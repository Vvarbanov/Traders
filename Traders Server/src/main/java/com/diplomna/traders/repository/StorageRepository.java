package com.diplomna.traders.repository;

import com.diplomna.traders.models.Storage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends CrudRepository<Storage, Long> {



}

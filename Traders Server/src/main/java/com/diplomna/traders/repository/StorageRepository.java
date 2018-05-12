package com.diplomna.traders.Repository;

import com.diplomna.traders.Models.Storage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends CrudRepository<Storage, Long> {



}

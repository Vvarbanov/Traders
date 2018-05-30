package com.diplomna.traders.repository;

import com.diplomna.traders.models.Listing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingRepository extends CrudRepository<Listing, Long>{
}

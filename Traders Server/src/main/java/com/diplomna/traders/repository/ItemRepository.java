package com.diplomna.traders.Repository;

import com.diplomna.traders.Models.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long>{



}

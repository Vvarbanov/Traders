package com.diplomna.traders.repository;

import com.diplomna.traders.Models.MeasurementUnit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementUnitRepository extends CrudRepository<MeasurementUnit, Long>{



}

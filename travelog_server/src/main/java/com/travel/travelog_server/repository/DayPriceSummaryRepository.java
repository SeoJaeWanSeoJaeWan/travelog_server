package com.travel.travelog_server.repository;

import com.travel.travelog_server.model.DayPriceSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DayPriceSummaryRepository extends JpaRepository<DayPriceSummary, Long> {
    DayPriceSummary findByDayId(@Param("dayId") Long dayId);
}

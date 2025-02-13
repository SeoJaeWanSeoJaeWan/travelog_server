package com.travel.travelog_server.repository;

import com.travel.travelog_server.model.DayPriceSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayPriceSummaryRepository extends JpaRepository<DayPriceSummary, Long> {
    @Query(value = """
        SELECT * FROM day_price_summary d WHERE d.day_id = :dayId
    """, nativeQuery = true)
    DayPriceSummary findByDayId(@Param("dayId") Long dayId);
}

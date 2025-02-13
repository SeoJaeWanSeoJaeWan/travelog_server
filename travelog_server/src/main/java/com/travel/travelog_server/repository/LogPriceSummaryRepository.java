package com.travel.travelog_server.repository;

import com.travel.travelog_server.model.LogPriceSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogPriceSummaryRepository extends JpaRepository<LogPriceSummary, Long> {

    @Query(value ="""
            select * from log_price_summary l where l.log_id=:logId
            """, nativeQuery = true)
    LogPriceSummary findByLogId(@Param("logId") Long logId);
}

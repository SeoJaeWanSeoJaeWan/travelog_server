package com.travel.travelog_server.repository;

import com.travel.travelog_server.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
    boolean existsByKey(String logKey);

    Optional<Log> findByKey(String logKey);
}
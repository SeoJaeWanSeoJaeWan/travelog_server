package com.travel.travelog_server.repository.day;

import com.travel.travelog_server.model.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayRepository  extends JpaRepository<Day, Long> {

    List<Day> findByLogIdOrderByIndexAsc(Long logId);
}

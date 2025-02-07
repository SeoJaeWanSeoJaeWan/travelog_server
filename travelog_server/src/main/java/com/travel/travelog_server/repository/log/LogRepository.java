package com.travel.travelog_server.repository.log;

import com.travel.travelog_server.controller.log.dto.FindAllLogDto;
import com.travel.travelog_server.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

    @Query("""
      SELECT l.id AS logId, 
             l.title AS title, 
             d.index AS dayIndex, 
             p.index AS pinIndex, 
             p.lat AS lat, 
             p.lng AS lng
      FROM Log l
      LEFT JOIN l.days d
      LEFT JOIN d.pins p
      ORDER BY l.id, d.index, p.index
    """)
    List<FindAllLogDto> findLogWithSelectedFields();

    boolean existsByKey(String logKey);
}
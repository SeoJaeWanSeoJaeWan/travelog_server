package com.travel.travelog_server.repository;

import com.travel.travelog_server.model.Pin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PinRepository extends JpaRepository<Pin, Long> {

    List<Pin> findByDayIdOrderByIndexAsc(Long dayId);
}

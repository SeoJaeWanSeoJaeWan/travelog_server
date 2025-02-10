package com.travel.travelog_server.repository;

import com.travel.travelog_server.model.PinType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PinTypeRepository extends JpaRepository<PinType, Long> {
}

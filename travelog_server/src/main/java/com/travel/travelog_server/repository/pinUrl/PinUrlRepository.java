package com.travel.travelog_server.repository.pinUrl;

import com.travel.travelog_server.model.PinUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PinUrlRepository extends JpaRepository<PinUrl, Long> {
}

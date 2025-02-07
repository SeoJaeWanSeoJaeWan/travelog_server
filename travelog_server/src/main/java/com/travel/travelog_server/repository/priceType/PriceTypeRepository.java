package com.travel.travelog_server.repository.priceType;

import com.travel.travelog_server.model.PriceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceTypeRepository  extends JpaRepository<PriceType,Long> {
}

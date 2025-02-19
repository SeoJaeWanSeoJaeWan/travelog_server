package com.travel.travelog_server.model;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Entity
@Getter
@Immutable
public class DayPriceSummary {
    @Id
    @Column(name = "day_id")
    private Long dayId;

    @Column(name = "price_type")
    private String priceType;

    @Column(name = "total_price")
    private Long totalPrice;

}


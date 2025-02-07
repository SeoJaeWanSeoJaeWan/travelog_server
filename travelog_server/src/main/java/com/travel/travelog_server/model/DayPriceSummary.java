package com.travel.travelog_server.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Subselect("select d.id as dayId, pt.type as priceType, SUM(p.price) as totalPrice from day d join pin p on p.dayId = d.id join priceType pt on pt.id = p.priceTypeId group by d.id, pt.type")
@Table(name="dayPriceSummary")
public class DayPriceSummary {
    @Id
    private Long dayId;

    private String priceType;

    private Integer totalPrice;
}

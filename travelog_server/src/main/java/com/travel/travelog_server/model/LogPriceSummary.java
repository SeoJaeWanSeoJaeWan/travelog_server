package com.travel.travelog_server.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Subselect("select l.id as logId, pt.type as priceType, sum(p.price) as totalPrice from log l join day d on d.logId = l.id join pin p on p.dayId = d.id join priceType pt on pt.id = p.priceTypeId group by l.id, pt.type")
@Table(name="logPriceSummary")
public class LogPriceSummary {
    @Id
    private Long logId;

    private String priceType;

    private Integer totalPrice;
}

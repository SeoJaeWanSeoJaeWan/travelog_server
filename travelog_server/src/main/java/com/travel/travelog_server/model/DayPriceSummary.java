package com.travel.travelog_server.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Subselect("""
	select
		d.id as dayId,
		pt.name as priceType,
		SUM(p.price) as totalPrice
	from days d
	join pins p on p.day_id = d.id
	join price_types pt on pt.id = p.price_type_id
	group by d.id, pt.name;
""")
@ToString
@Table(name="day_price_summary")
public class DayPriceSummary {
    @Id
    @JsonProperty("logId")
    private Long dayId;

    @JsonProperty("priceType")
    private String priceType;

    @JsonProperty("totalPrice")
    private Integer totalPrice;
}

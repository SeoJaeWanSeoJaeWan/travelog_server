package com.travel.travelog_server.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Subselect("""
	select
		l.id as logId,
		pt.name as pricType,
		SUM(p.price) as totalPrice
	from logs l
	join days d on d.log_id = l.id
	join pins p on p.day_id = d.id
	join price_types pt on pt.id = p.price_type_id
	group by l.id, pt.name;
""")
@Table(name="log_price_summary")
public class LogPriceSummary {
    @Id
    @JsonProperty("logId")
    private Long logId;

    @JsonProperty("priceType")
    private String priceType;

    @JsonProperty("totalPrice")
    private Integer totalPrice;
}

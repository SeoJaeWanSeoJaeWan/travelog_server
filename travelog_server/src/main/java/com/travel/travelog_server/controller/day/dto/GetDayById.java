package com.travel.travelog_server.controller.day.dto;

import com.travel.travelog_server.controller.pin.dto.DayPinsDto;
import com.travel.travelog_server.model.Day;
import com.travel.travelog_server.model.DayPriceSummary;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class GetDayById {
    private Long id;
    private Integer index;
    private Long dayPriceSummary;
    private List<DayPinsDto> pins;

    public GetDayById(Day day, List<DayPinsDto> pins, DayPriceSummary dayPriceSummary) {
        this.id = day.getId();
        this.index = day.getIndex();
        this.dayPriceSummary = Optional.ofNullable(dayPriceSummary).map(DayPriceSummary::getTotalPrice).orElse(0L);
        this.pins = pins;
    }
}

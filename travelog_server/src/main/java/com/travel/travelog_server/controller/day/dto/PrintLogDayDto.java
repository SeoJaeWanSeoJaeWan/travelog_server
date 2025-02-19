package com.travel.travelog_server.controller.day.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.travel.travelog_server.controller.pin.dto.PrintLogPinDto;
import com.travel.travelog_server.model.Day;
import com.travel.travelog_server.model.DayPriceSummary;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
public class PrintLogDayDto {
    @JsonProperty("index")
    private Integer index;

    @JsonProperty("pins")
    private List<PrintLogPinDto> pins;

    private Long dayPriceSummary;

    public PrintLogDayDto(Day day, DayPriceSummary dayPriceSummary) {
        this.index = day.getIndex();
        this.pins = day.getPins().stream()
                .sorted((p1,p2) -> Integer.compare(p1.getIndex(), p2.getIndex()))
                .map(PrintLogPinDto::new)
                .collect(Collectors.toList());
        this.dayPriceSummary = Optional.ofNullable(dayPriceSummary).map(DayPriceSummary::getTotalPrice).orElse(0L);
    }
}

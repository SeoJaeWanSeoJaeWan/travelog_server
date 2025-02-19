package com.travel.travelog_server.controller.log.dto;

import com.travel.travelog_server.controller.day.dto.PrintLogDayDto;
import com.travel.travelog_server.model.Log;
import com.travel.travelog_server.model.LogPriceSummary;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class GetPrintLogByIdDto {
    private Long id;
    private String title;
    private String key;
    private List<PrintLogDayDto> days;
    private Long logPriceSummary;

    public GetPrintLogByIdDto(Log log, List<PrintLogDayDto>  days, LogPriceSummary logPriceSummary) {
        this.id = log.getId();
        this.title = log.getTitle();
        this.key = log.getKey();
        this.days = days;
        this.logPriceSummary = Optional.ofNullable(logPriceSummary).map(LogPriceSummary::getTotalPrice).orElse(0L);
    }
}

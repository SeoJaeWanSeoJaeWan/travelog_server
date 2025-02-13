package com.travel.travelog_server.controller.log.dto;

import com.travel.travelog_server.controller.day.dto.LogByIdDaysDto;
import com.travel.travelog_server.model.Log;
import com.travel.travelog_server.model.LogPriceSummary;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetLogByIdDto {
    private Long id;
    private String title;
    private String key;
    private List<LogByIdDaysDto> days;
    private LogPriceSummary logPriceSummary;

    public GetLogByIdDto(Log log, List<LogByIdDaysDto> days, LogPriceSummary logPriceSummary) {
        this.id = log.getId();
        this.title = log.getTitle();
        this.key = log.getKey();
        this.days = days;
        this.logPriceSummary = logPriceSummary;
    }
}

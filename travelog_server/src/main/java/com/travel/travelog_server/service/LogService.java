package com.travel.travelog_server.service;

import com.travel.travelog_server.controller.day.dto.LogByIdDaysDto;
import com.travel.travelog_server.controller.day.dto.LogDaysDto;
import com.travel.travelog_server.controller.day.dto.PrintLogDayDto;
import com.travel.travelog_server.controller.log.dto.*;
import com.travel.travelog_server.exception.NotFoundKeyException;
import com.travel.travelog_server.model.Day;
import com.travel.travelog_server.model.DayPriceSummary;
import com.travel.travelog_server.model.Log;
import com.travel.travelog_server.model.LogPriceSummary;
import com.travel.travelog_server.repository.DayPriceSummaryRepository;
import com.travel.travelog_server.repository.DayRepository;
import com.travel.travelog_server.repository.LogPriceSummaryRepository;
import com.travel.travelog_server.repository.LogRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import lombok.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class LogService {
    private final LogRepository logRepository;
    private final DayRepository dayRepository;
    private final LogPriceSummaryRepository logPriceSummaryRepository;
    private final DayPriceSummaryRepository dayPriceSummaryRepository;

    public AllLogDto getLogByKey (String Key) {
        Log log = logRepository.findByKey(Key).orElseThrow(() -> new EntityNotFoundException("해당 로그를 찾을 수 없습니다."));
        List<Day> days = dayRepository.findByLogIdOrderByIndexAsc(log.getId());

        List<LogDaysDto> transformedDays = days.stream()
                .map(day -> {
                    DayPriceSummary dayPriceSummary = dayPriceSummaryRepository.findByDayId(day.getId());
                    return new LogDaysDto(day, dayPriceSummary);
                })
                .toList();

        return new AllLogDto(log,transformedDays);
    }

    public GetLogByIdDto getLogById(Long logId) {
        Log log = logRepository.findById(logId).orElseThrow(() -> new EntityNotFoundException("해당 로그를 찾을 수 없습니다."));

        LogPriceSummary logPriceSummary = logPriceSummaryRepository.findByLogId(logId);
        List<Day> days = dayRepository.findByLogIdOrderByIndexAsc(logId);

        List<LogByIdDaysDto> transformedDays = days.stream()
                .map(LogByIdDaysDto::new)
                .toList();

        return new GetLogByIdDto(log, transformedDays, logPriceSummary);
    }

    public GetPrintLogByIdDto getPrintLogById (Long logId) {
        Log log = logRepository.findById(logId).orElseThrow(() -> new EntityNotFoundException("해당 로그를 찾을 수 없습니다."));

        LogPriceSummary logPriceSummary = logPriceSummaryRepository.findByLogId(logId);

        List<Day> days = dayRepository.findByLogIdOrderByIndexAsc(logId);

        List<PrintLogDayDto> transformedDays = days.stream()
                .map(day -> {
                        DayPriceSummary dayPriceSummary = dayPriceSummaryRepository.findByDayId(day.getId());
                        return new PrintLogDayDto(day, dayPriceSummary);
                })
                .toList();

        return new GetPrintLogByIdDto(log, transformedDays, logPriceSummary);
    }

    public DeleteLogDto deleteLog(Long logId) {
        Log log = logRepository.findById(logId).orElseThrow(() -> new EntityNotFoundException("해당 로그를 찾을 수 없습니다."));

        logRepository.delete(log);
        return new DeleteLogDto(log.getKey());
    }

    public void updateLog(Long logId, UpdateLogBodyDto updateLogBodyDto) {
        Log log = logRepository.findById(logId).orElseThrow(() -> new EntityNotFoundException("해당 로그를 찾을 수 없습니다."));

        log.setTitle(updateLogBodyDto.getTitle());
        logRepository.save(log);
    }

    public CreateLogDto createLog(CreateLogBodyDto createLogBodyDto) {
        String title = createLogBodyDto.getTitle();
        String randomKey;

        do {
            int randomValue = ThreadLocalRandom.current().nextInt(0x100000);
            randomKey = String.format("%05X", randomValue);

        } while (logRepository.existsByKey(randomKey));

        Log log = new Log();
        log.setTitle(title);
        log.setKey(randomKey);

        logRepository.save(log);

        return new CreateLogDto(randomKey);
    }

    public CheckKeyDto checkKey(CheckKeyBodyDto checkKeyBodyDto) {
        String key = checkKeyBodyDto.getKey();

        if(!logRepository.existsByKey(key)) {
            throw new NotFoundKeyException("해당 로그를 찾을 수 없습니다.");
        }

        return new CheckKeyDto(key);
    }
}

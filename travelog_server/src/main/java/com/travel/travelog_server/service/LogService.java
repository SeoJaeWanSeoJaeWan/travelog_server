package com.travel.travelog_server.service;

import com.travel.travelog_server.controller.log.dto.FindAllLogDto;
import com.travel.travelog_server.model.Log;
import com.travel.travelog_server.repository.log.LogRepository;
import org.springframework.stereotype.Service;
import lombok.*;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LogService {
    private final LogRepository logRepository;

    public List<FindAllLogDto> getLogWithDaysAndPins() {
        List<Log> logs = logRepository.findAll();

        return logs.stream().map(FindAllLogDto::new).collect(Collectors.toList());
    }

    public void deleteLog(Long logId) {
        logRepository.deleteById(logId);
    }

    public Log createLog(String title) {
        String randomKey;

        do {
            int randomValue = ThreadLocalRandom.current().nextInt(0x100000);
            randomKey = String.format("%05X", randomValue);

        } while (logRepository.existsByKey(randomKey));

        Log log = new Log();
        log.setTitle(title);
        log.setKey(randomKey);

        logRepository.save(log);

        return log;
    }
}

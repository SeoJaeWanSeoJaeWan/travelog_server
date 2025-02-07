package com.travel.travelog_server.controller.log;

import com.travel.travelog_server.controller.log.dto.CreateLogDto;
import com.travel.travelog_server.controller.log.dto.FindAllLogDto;
import com.travel.travelog_server.model.Log;
import com.travel.travelog_server.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/log")
@RequiredArgsConstructor
public class LogController {
    private final LogService logService;

    @GetMapping("/all")
    public ResponseEntity<List<FindAllLogDto>> getAllLogs() {
        return ResponseEntity.ok(logService.getLogWithDaysAndPins());
    }

    @DeleteMapping("/{logId}")
    public ResponseEntity<Void> deleteLog(@PathVariable Long logId) {
        logService.deleteLog(logId);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("")
    public ResponseEntity<Log> createLog(@RequestBody CreateLogDto createLogDto) {
        URI location = URI.create("/api/log");

        return ResponseEntity.created(location).body(logService.createLog(createLogDto.getTitle()));
    }
}
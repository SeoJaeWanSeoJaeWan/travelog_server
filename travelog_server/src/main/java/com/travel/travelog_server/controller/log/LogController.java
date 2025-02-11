package com.travel.travelog_server.controller.log;

import com.travel.travelog_server.controller.log.dto.CreateLogDto;
import com.travel.travelog_server.controller.log.dto.FindAllLogDto;
import com.travel.travelog_server.model.Log;
import com.travel.travelog_server.service.LogService;
import jakarta.validation.Valid;
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
        return ResponseEntity.ok().body(logService.getLogWithDaysAndPins());
    }

    @DeleteMapping("/{logId}")
    public ResponseEntity<Void> deleteLog(@PathVariable Long logId) {
        logService.deleteLog(logId);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("")
    public ResponseEntity<Void> createLog(@Valid @RequestBody CreateLogDto createLogDto) {
        logService.createLog(createLogDto);

        return ResponseEntity.noContent().build();
    }
}
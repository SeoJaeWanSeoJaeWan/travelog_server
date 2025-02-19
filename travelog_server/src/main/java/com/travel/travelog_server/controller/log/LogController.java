package com.travel.travelog_server.controller.log;

import com.travel.travelog_server.controller.log.dto.*;
import com.travel.travelog_server.service.LogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/logs")
@RequiredArgsConstructor
public class LogController {
    private final LogService logService;

    @GetMapping("")
    public ResponseEntity<AllLogDto> getLogsByKey(@RequestParam String key) {
        return ResponseEntity.ok().body(logService.getLogByKey(key));
    }

    @GetMapping("/print/{logId}")
    public ResponseEntity<GetPrintLogByIdDto> getPrintLogById(@PathVariable Long logId) {
        return ResponseEntity.ok().body(logService.getPrintLogById(logId));
    }

    @GetMapping("/{logId}")
    public ResponseEntity<GetLogByIdDto> getLogById(@PathVariable Long logId) {
        return ResponseEntity.ok().body(logService.getLogById(logId));
    }

    @DeleteMapping("/{logId}")
    public ResponseEntity<DeleteLogDto> deleteLog(@PathVariable Long logId) {
        DeleteLogDto deleteLogDto = logService.deleteLog(logId);
        return ResponseEntity.ok().body(deleteLogDto);
    }

    @PatchMapping("/{logId}")
    public ResponseEntity<Void> updateLog(@PathVariable Long logId, @Valid @RequestBody UpdateLogBodyDto updateLogBodyDto) {
        logService.updateLog(logId, updateLogBodyDto);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("")
    public ResponseEntity<CreateLogDto> createLog(@Valid @RequestBody CreateLogBodyDto createLogBodyDto) {
        CreateLogDto createLogDto = logService.createLog(createLogBodyDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(createLogDto);
    }

    @PostMapping("/key")
    public ResponseEntity<CheckKeyDto> checkKey(@Valid @RequestBody CheckKeyBodyDto checkKeyBodyDto) {
        CheckKeyDto checkKeyDto =  logService.checkKey(checkKeyBodyDto);

        return ResponseEntity.ok().body(checkKeyDto);
    }
}
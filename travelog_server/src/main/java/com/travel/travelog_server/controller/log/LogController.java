package com.travel.travelog_server.controller.log;

import com.travel.travelog_server.controller.log.dto.CheckKeyDto;
import com.travel.travelog_server.controller.log.dto.CreateLogBodyDto;
import com.travel.travelog_server.controller.log.dto.AllLogDto;
import com.travel.travelog_server.controller.log.dto.GetLogByIdDto;
import com.travel.travelog_server.service.LogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
//    @GetMapping("")
//    public ResponseEntity<List<AllLogDto>> getAllLogs() {
//        return ResponseEntity.ok().body(logService.getLogWithDaysAndPins());
//    }

    @GetMapping("/{logId}")
    public ResponseEntity<GetLogByIdDto> getLogById(@PathVariable Long logId) {
        return ResponseEntity.ok().body(logService.getLogById(logId));
    }

    @DeleteMapping("/{logId}")
    public ResponseEntity<Void> deleteLog(@PathVariable Long logId) {
        logService.deleteLog(logId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("")
    public ResponseEntity<Void> createLog(@Valid @RequestBody CreateLogBodyDto createLogBodyDto) {
        logService.createLog(createLogBodyDto);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/key")
    public ResponseEntity<Boolean> checkKey(@Valid @RequestBody CheckKeyDto checkKeyDto) {
        logService.checkKey(checkKeyDto);

        return ResponseEntity.noContent().build();
    }
}
package com.travel.travelog_server.controller.day;

import com.travel.travelog_server.controller.day.dto.CreateDayDto;
import com.travel.travelog_server.controller.day.dto.UpdateDayDto;
import com.travel.travelog_server.model.Day;
import com.travel.travelog_server.service.DayService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/day")
public class DayController {
    private final DayService dayService;

    @GetMapping("/{logId}")
    public ResponseEntity<List<Day>> getDaysByLogId(@PathVariable Long logId) {
        return ResponseEntity.ok(dayService.getDaysByLogId(logId));
    }

    @PostMapping("")
    public ResponseEntity<Void> createDay(@Valid @RequestBody CreateDayDto createDayDto) {
        dayService.createDay(createDayDto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{dayId}")
    public ResponseEntity<Void> deleteDay(@PathVariable Long dayId) {
        dayService.deleteDay(dayId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{dayId}")
    public ResponseEntity<Void> updateDayIndex (@PathVariable Long dayId,@Valid @RequestBody UpdateDayDto updateDayDto) {
        dayService.updateDayIndex(dayId, updateDayDto.getIndex());
        return ResponseEntity.noContent().build();
    }
}

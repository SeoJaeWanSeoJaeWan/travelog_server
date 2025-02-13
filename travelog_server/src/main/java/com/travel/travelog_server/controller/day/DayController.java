package com.travel.travelog_server.controller.day;

import com.travel.travelog_server.controller.day.dto.CreateDayBodyDto;
import com.travel.travelog_server.controller.day.dto.UpdateDayBodyDto;
import com.travel.travelog_server.service.DayService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/day")
public class DayController {
    private final DayService dayService;

    @PostMapping("")
    public ResponseEntity<Void> createDay(@Valid @RequestBody CreateDayBodyDto createDayBodyDto) {
        dayService.createDay(createDayBodyDto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{dayId}")
    public ResponseEntity<Void> deleteDay(@PathVariable Long dayId) {
        dayService.deleteDay(dayId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{dayId}")
    public ResponseEntity<Void> updateDayIndex (@PathVariable Long dayId,@Valid @RequestBody UpdateDayBodyDto updateDayBodyDto) {
        dayService.updateDayIndex(dayId, updateDayBodyDto);
        return ResponseEntity.noContent().build();
    }
}

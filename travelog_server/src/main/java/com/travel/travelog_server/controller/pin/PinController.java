package com.travel.travelog_server.controller.pin;

import com.travel.travelog_server.controller.pin.dto.CreatePinDto;
import com.travel.travelog_server.controller.pin.dto.GetPinByIdDto;
import com.travel.travelog_server.controller.pin.dto.UpdatePinDto;
import com.travel.travelog_server.controller.pin.dto.UpdatePinIndexDto;
import com.travel.travelog_server.service.PinService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.net.URI;

@RestController
@RequestMapping("/api/pin")
@RequiredArgsConstructor
public class PinController {
    private final PinService pinService;

    @GetMapping("/{pinId}")
    public ResponseEntity<GetPinByIdDto> getPinById(@PathVariable Long pinId) {
        return ResponseEntity.ok(pinService.getPinById(pinId));
    }

    @PostMapping("")
    public ResponseEntity<Void> createPin(@RequestBody CreatePinDto createPinDto) {
        pinService.createPin(createPinDto);

        URI location = URI.create("/api/pin");

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{pinId}")
    public ResponseEntity<Void> updatePin(@RequestBody UpdatePinDto updatePinDto, @PathVariable Long pinId) {
        pinService.updatePin(updatePinDto, pinId);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{pinId}")
    public ResponseEntity<Void> updatePinIndex(@RequestBody UpdatePinIndexDto updatePinIndexDto, @PathVariable Long pinId) {
        pinService.updatePinIndex(pinId, updatePinIndexDto.getIndex());

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{pinId}")
    public ResponseEntity<Void> deletePin(@PathVariable Long pinId) {
        pinService.deletePin(pinId);

        return ResponseEntity.noContent().build();
    }
}

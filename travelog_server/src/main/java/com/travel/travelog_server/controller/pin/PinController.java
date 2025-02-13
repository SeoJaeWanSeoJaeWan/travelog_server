package com.travel.travelog_server.controller.pin;

import com.travel.travelog_server.controller.pin.dto.CreatePinBodyDto;
import com.travel.travelog_server.controller.pin.dto.GetPinByIdDto;
import com.travel.travelog_server.controller.pin.dto.UpdatePinBodyDto;
import com.travel.travelog_server.controller.pin.dto.UpdatePinIndexBodyDto;
import com.travel.travelog_server.service.PinService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

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
    public ResponseEntity<Void> createPin(@Valid @RequestBody CreatePinBodyDto createPinBodyDto) {
        pinService.createPin(createPinBodyDto);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{pinId}")
    public ResponseEntity<Void> updatePin(@Valid @RequestBody UpdatePinBodyDto updatePinBodyDto, @PathVariable Long pinId) {
        pinService.updatePin(updatePinBodyDto, pinId);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{pinId}")
    public ResponseEntity<Void> updatePinIndex(@Valid @RequestBody UpdatePinIndexBodyDto updatePinIndexBodyDto, @PathVariable Long pinId) {
        pinService.updatePinIndex(pinId, updatePinIndexBodyDto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{pinId}")
    public ResponseEntity<Void> deletePin(@PathVariable Long pinId) {
        pinService.deletePin(pinId);

        return ResponseEntity.noContent().build();
    }
}

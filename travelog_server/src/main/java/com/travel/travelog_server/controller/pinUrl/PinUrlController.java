package com.travel.travelog_server.controller.pinUrl;

import com.travel.travelog_server.controller.pinUrl.dto.CreatePinUrlBodyDto;
import com.travel.travelog_server.controller.pinUrl.dto.UpdatePinUrlBodyDto;
import com.travel.travelog_server.model.PinUrl;
import com.travel.travelog_server.service.PinUrlService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pinUrl")
public class PinUrlController {
    private final PinUrlService pinUrlService;

    @PostMapping("")
    public ResponseEntity<PinUrl> createPinUrl(@Valid @RequestBody CreatePinUrlBodyDto createPinUrlBodyDto) {
        pinUrlService.createPinUrl(createPinUrlBodyDto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{pinUrlId}")
    public ResponseEntity<Void> deletePinUrl(@PathVariable Long pinUrlId) {
        pinUrlService.deletePinUrl(pinUrlId);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{pinUrlId}")
    public ResponseEntity<Void> updatePinUrl(@PathVariable Long pinUrlId, @Valid @RequestBody UpdatePinUrlBodyDto updatePinUrlBodyDto) {
        pinUrlService.updatePinUrl(pinUrlId, updatePinUrlBodyDto);

        return ResponseEntity.noContent().build();
    }
}

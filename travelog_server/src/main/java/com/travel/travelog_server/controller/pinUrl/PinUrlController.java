package com.travel.travelog_server.controller.pinUrl;

import com.travel.travelog_server.controller.pinUrl.dto.CreatePinUrlDto;
import com.travel.travelog_server.controller.pinUrl.dto.UpdatePinUrlDto;
import com.travel.travelog_server.model.PinUrl;
import com.travel.travelog_server.service.PinUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pinUrl")
public class PinUrlController {
    private final PinUrlService pinUrlService;

    @PostMapping("")
    public ResponseEntity<PinUrl> createPinUrl(@RequestBody CreatePinUrlDto createPinUrlDto) {
        pinUrlService.createPinUrl(createPinUrlDto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{pinUrlId}")
    public ResponseEntity<Void> deletePinUrl(@PathVariable Long pinUrlId) {
        pinUrlService.deletePinUrl(pinUrlId);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{pinUrlId}")
    public ResponseEntity<Void> updatePinUrl(@PathVariable Long pinUrlId, @RequestBody UpdatePinUrlDto updatePinUrlDto) {
        pinUrlService.updatePinUrl(pinUrlId, updatePinUrlDto);

        return ResponseEntity.noContent().build();
    }
}

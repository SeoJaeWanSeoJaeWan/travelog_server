package com.travel.travelog_server.controller.pinType;

import com.travel.travelog_server.controller.pinType.dto.CreatePinTypeDto;
import com.travel.travelog_server.model.PinType;
import com.travel.travelog_server.service.PinTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pinType")
public class PinTypeController {
    private final PinTypeService pinTypeService;

    @PostMapping("")
    public ResponseEntity<Void> createPinType(@RequestBody CreatePinTypeDto createPinTypeDto) {
        pinTypeService.createPinType(createPinTypeDto);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    public ResponseEntity<List<PinType>> getAllPinTypes() {
        return ResponseEntity.ok(pinTypeService.getAllPinTypes());
    }
}

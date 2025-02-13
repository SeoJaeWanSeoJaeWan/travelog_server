package com.travel.travelog_server.controller.pinType;

import com.travel.travelog_server.controller.pinType.dto.CreatePinTypeBodyDto;
import com.travel.travelog_server.controller.pinType.dto.GetAllPinTypeDto;
import com.travel.travelog_server.service.PinTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pinType")
public class PinTypeController {
    private final PinTypeService pinTypeService;

    @PostMapping("")
    public ResponseEntity<Void> createPinType(@Valid @RequestBody CreatePinTypeBodyDto createPinTypeBodyDto) {
        pinTypeService.createPinType(createPinTypeBodyDto);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    public ResponseEntity<List<GetAllPinTypeDto>> getAllPinType() {
        return ResponseEntity.ok(pinTypeService.getAllPinType());
    }
}

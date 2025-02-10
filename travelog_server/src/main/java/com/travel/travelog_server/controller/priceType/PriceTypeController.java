package com.travel.travelog_server.controller.priceType;

import com.travel.travelog_server.controller.priceType.dto.CreatePriceTypeDto;
import com.travel.travelog_server.model.PriceType;
import com.travel.travelog_server.service.PriceTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/priceType")
public class PriceTypeController {

    private final PriceTypeService priceTypeService;

    @PostMapping("")
    public ResponseEntity<Void> createPriceType(@RequestBody CreatePriceTypeDto createPriceTypeDto) {
        priceTypeService.createPriceType(createPriceTypeDto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    public ResponseEntity<List<PriceType>> getAllPriceTypes() {
        return ResponseEntity.ok(priceTypeService.getAllPriceTypes());
    }
}

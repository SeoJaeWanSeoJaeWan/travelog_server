package com.travel.travelog_server.controller.priceType;

import com.travel.travelog_server.controller.priceType.dto.CreatePriceTypeBodyDto;
import com.travel.travelog_server.controller.priceType.dto.GetAllPriceTypeDto;
import com.travel.travelog_server.service.PriceTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/priceType")
public class
PriceTypeController {
    private final PriceTypeService priceTypeService;

    @GetMapping("")
    public ResponseEntity<List<GetAllPriceTypeDto>> getAllPriceType() {
        return ResponseEntity.ok(priceTypeService.getAllPriceType());
    }

    @PostMapping("")
    public ResponseEntity<Void> createPriceType(@Valid @RequestBody CreatePriceTypeBodyDto createPriceTypeBodyDto) {
        priceTypeService.createPriceType(createPriceTypeBodyDto);
        return ResponseEntity.noContent().build();
    }

}

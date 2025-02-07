package com.travel.travelog_server.service;

import com.travel.travelog_server.controller.priceType.dto.CreatePriceTypeDto;
import com.travel.travelog_server.model.PriceType;
import com.travel.travelog_server.repository.priceType.PriceTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PriceTypeService {
    private final PriceTypeRepository priceTypeRepository;

    public void createPriceType(CreatePriceTypeDto createPriceTypeDto) {
        String name = createPriceTypeDto.getName();

        PriceType priceType = new PriceType();
        priceType.setName(name);

        priceTypeRepository.save(priceType);
    }

    public List<PriceType> getAllPriceTypes() {
        return priceTypeRepository.findAll();
    }
}

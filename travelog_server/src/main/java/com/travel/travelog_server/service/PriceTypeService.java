package com.travel.travelog_server.service;

import com.travel.travelog_server.controller.priceType.dto.CreatePriceTypeBodyDto;
import com.travel.travelog_server.controller.priceType.dto.GetAllPriceTypeDto;
import com.travel.travelog_server.model.PriceType;
import com.travel.travelog_server.repository.PriceTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PriceTypeService {
    private final PriceTypeRepository priceTypeRepository;

    public void createPriceType(CreatePriceTypeBodyDto createPriceTypeBodyDto) {
        String name = createPriceTypeBodyDto.getName();

        PriceType priceType = new PriceType();
        priceType.setName(name);

        priceTypeRepository.save(priceType);
    }

    public List<GetAllPriceTypeDto> getAllPriceType() {
        List<PriceType> priceTypes = priceTypeRepository.findAll();
        return priceTypes.stream().map(GetAllPriceTypeDto::new).toList();
    }
}

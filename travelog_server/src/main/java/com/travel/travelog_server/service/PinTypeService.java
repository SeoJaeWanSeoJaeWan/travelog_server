package com.travel.travelog_server.service;

import com.travel.travelog_server.controller.pinType.dto.CreatePinTypeDto;
import com.travel.travelog_server.model.PinType;
import com.travel.travelog_server.repository.PinTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PinTypeService {
    private final PinTypeRepository pinTypeRepository;

    public void createPinType(CreatePinTypeDto createPinTypeDto) {
        String name = createPinTypeDto.getName();
        String icon = createPinTypeDto.getIcon();

        PinType pinType = new PinType();
        pinType.setName(name);
        pinType.setIcon(icon);

        pinTypeRepository.save(pinType);
    }

    public List<PinType> getAllPinTypes() {
        return pinTypeRepository.findAll();
    }
}

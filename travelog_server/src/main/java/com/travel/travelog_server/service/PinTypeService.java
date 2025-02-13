package com.travel.travelog_server.service;

import com.travel.travelog_server.controller.pinType.dto.CreatePinTypeBodyDto;
import com.travel.travelog_server.controller.pinType.dto.GetAllPinTypeDto;
import com.travel.travelog_server.model.PinType;
import com.travel.travelog_server.repository.PinTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PinTypeService {
    private final PinTypeRepository pinTypeRepository;

    public void createPinType(CreatePinTypeBodyDto createPinTypeBodyDto) {
        String name = createPinTypeBodyDto.getName();
        String icon = createPinTypeBodyDto.getIcon();

        PinType pinType = new PinType();
        pinType.setName(name);
        pinType.setIcon(icon);

        pinTypeRepository.save(pinType);
    }

    public List<GetAllPinTypeDto> getAllPinType() {
        List<PinType> pinTypes = pinTypeRepository.findAll();
        return pinTypes.stream().map(GetAllPinTypeDto::new).toList();
    }
}

package com.travel.travelog_server.service;

import com.travel.travelog_server.controller.pin.dto.CreatePinBodyDto;
import com.travel.travelog_server.controller.pin.dto.GetPinByIdDto;
import com.travel.travelog_server.controller.pin.dto.UpdatePinBodyDto;
import com.travel.travelog_server.controller.pin.dto.UpdatePinIndexBodyDto;
import com.travel.travelog_server.model.Day;
import com.travel.travelog_server.model.Pin;
import com.travel.travelog_server.model.PinType;
import com.travel.travelog_server.model.PriceType;
import com.travel.travelog_server.repository.*;
import com.travel.travelog_server.util.IndexUpdate;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PinService {
    private final PinRepository pinRepository;
    private final PinTypeRepository pinTypeRepository;
    private final DayRepository dayRepository;
    private final PriceTypeRepository priceTypeRepository;

    public GetPinByIdDto getPinById(Long pinId) {
        Pin pin = pinRepository.findById(pinId).orElseThrow(() -> new EntityNotFoundException(pinId + "에 해당하는 핀을 찾을 수 없습니다."));

        return new GetPinByIdDto(pin);
    }

    public void createPin(CreatePinBodyDto createPinBodyDto) {
        PinType pinType = pinTypeRepository.findById(createPinBodyDto.getPinTypeId()).orElseThrow(() -> new EntityNotFoundException("해당 핀 타입을 찾을 수 없습니다."));
        Day day = dayRepository.findById(createPinBodyDto.getDayId()).orElseThrow(() -> new EntityNotFoundException("해당 일자를 찾을 수 없습니다."));

        Pin pin = new Pin();

        pin.setIndex(createPinBodyDto.getIndex());
        pin.setLat(createPinBodyDto.getLat());
        pin.setLng(createPinBodyDto.getLng());
        pin.setPinType(pinType);
        pin.setDay(day);

        pinRepository.save(pin);
    }

    public void updatePin(UpdatePinBodyDto updatePinBodyDto, Long pinId) {

        Pin pin = pinRepository.findById(pinId).orElseThrow(() -> new EntityNotFoundException(pinId + "에 해당하는 핀을 찾을 수 없습니다."));

        PinType pinType = pinTypeRepository.findById(updatePinBodyDto.getPinTypeId()).orElseThrow(() -> new EntityNotFoundException("해당 핀 타입을 찾을 수 없습니다."));
        PriceType priceType = priceTypeRepository.findById(updatePinBodyDto.getPriceTypeId()).orElseThrow(() -> new EntityNotFoundException("해당 가격 타입을 찾을 수 없습니다."));

        if(updatePinBodyDto.getTitle() != null) {
            pin.setTitle(updatePinBodyDto.getTitle());
        }
        if(updatePinBodyDto.getDescription() != null) {
            pin.setDescription(updatePinBodyDto.getDescription());
        }
        if(updatePinBodyDto.getPicture() != null) {
            pin.setPicture(updatePinBodyDto.getPicture());
        }
        pin.setLat(updatePinBodyDto.getLat());
        pin.setLng(updatePinBodyDto.getLng());
        pin.setPrice(updatePinBodyDto.getPrice());
        pin.setPriceType(priceType);
        pin.setPinType(pinType);

        pinRepository.save(pin);
    }

    @Transactional
    public void updatePinIndex(Long pinId, UpdatePinIndexBodyDto updatePinIndexBodyDto) {
        Integer index = updatePinIndexBodyDto.getIndex();
        Pin pinToUpdate = pinRepository.findById(pinId).orElseThrow(() -> new EntityNotFoundException(pinId + "에 해당하는 핀을 찾을 수 없습니다."));

        List<Pin> pins = pinRepository.findByDayIdOrderByIndexAsc(pinToUpdate.getDay().getId());
        List<Pin> updatedPins = IndexUpdate.updateIndex(pins, pinToUpdate.getIndex(), index, pinId);

        pinRepository.saveAll(updatedPins);

        pinToUpdate.setIndex(index);
        pinRepository.save(pinToUpdate);
    }

    @Transactional
    public void deletePin(Long pinId) {
        Pin pinToDelete = pinRepository.findById(pinId).orElseThrow(() -> new EntityNotFoundException(pinId + "에 해당하는 핀을 찾을 수 없습니다."));

        Long dayId = pinToDelete.getDay().getId();
        Integer deleteIndex = pinToDelete.getIndex();

        pinRepository.deleteById(pinId);

        List<Pin> pins = pinRepository.findByDayIdOrderByIndexAsc(dayId);
        List<Pin> updatedPins = IndexUpdate.deleteIndex(pins, deleteIndex);

        pinRepository.saveAll(updatedPins);
    }
}

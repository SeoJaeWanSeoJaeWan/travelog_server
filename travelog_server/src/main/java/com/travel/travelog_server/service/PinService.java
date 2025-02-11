package com.travel.travelog_server.service;

import com.travel.travelog_server.controller.pin.dto.CreatePinDto;
import com.travel.travelog_server.controller.pin.dto.GetPinByIdDto;
import com.travel.travelog_server.controller.pin.dto.UpdatePinDto;
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

    public void createPin(CreatePinDto createPinDto) {
        PinType pinType = pinTypeRepository.findById(createPinDto.getPinTypeId()).orElseThrow(() -> new EntityNotFoundException("해당 핀 타입을 찾을 수 없습니다."));
        Day day = dayRepository.findById(createPinDto.getDayId()).orElseThrow(() -> new EntityNotFoundException("해당 일자를 찾을 수 없습니다."));

        Pin pin = new Pin();

        pin.setIndex(createPinDto.getIndex());
        pin.setLat(createPinDto.getLat());
        pin.setLng(createPinDto.getLng());
        pin.setPinType(pinType);
        pin.setDay(day);

        pinRepository.save(pin);
    }

    public void updatePin(UpdatePinDto updatePinDto, Long pinId) {

        Pin pin = pinRepository.findById(pinId).orElseThrow(() -> new EntityNotFoundException(pinId + "에 해당하는 핀을 찾을 수 없습니다."));

        PinType pinType = pinTypeRepository.findById(updatePinDto.getPinTypeId()).orElseThrow(() -> new EntityNotFoundException("해당 핀 타입을 찾을 수 없습니다."));
        PriceType priceType = priceTypeRepository.findById(updatePinDto.getPriceTypeId()).orElseThrow(() -> new EntityNotFoundException("해당 가격 타입을 찾을 수 없습니다."));

        pin.setLat(updatePinDto.getLat());
        pin.setLng(updatePinDto.getLng());
        pin.setTitle(updatePinDto.getTitle());
        pin.setDescription(updatePinDto.getDescription());
        pin.setPicture(updatePinDto.getPicture());
        pin.setPrice(updatePinDto.getPrice());
        pin.setPriceType(priceType);
        pin.setPinType(pinType);

        pinRepository.save(pin);
    }

    @Transactional
    public void updatePinIndex(Long pinId, Integer index) {
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

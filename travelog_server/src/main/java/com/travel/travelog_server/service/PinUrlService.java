package com.travel.travelog_server.service;

import com.travel.travelog_server.controller.pinUrl.dto.CreatePinUrlBodyDto;
import com.travel.travelog_server.controller.pinUrl.dto.UpdatePinUrlBodyDto;
import com.travel.travelog_server.model.Pin;
import com.travel.travelog_server.model.PinUrl;
import com.travel.travelog_server.repository.PinRepository;
import com.travel.travelog_server.repository.PinUrlRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PinUrlService {
    private final PinUrlRepository pinUrlRepository;
    private final PinRepository pinRepository;

    public void createPinUrl(CreatePinUrlBodyDto createPinUrlBodyDto) {
        PinUrl pinUrl = new PinUrl();
        Pin pin = pinRepository.findById(createPinUrlBodyDto.getPinId()).orElseThrow(() -> new EntityNotFoundException("해당 핀을 찾을 수 없습니다."));

        pinUrl.setUrl(createPinUrlBodyDto.getUrl());
        pinUrl.setTitle(createPinUrlBodyDto.getTitle());
        pinUrl.setPin(pin);

        pinUrlRepository.save(pinUrl);
    }

    public void deletePinUrl(Long pinUrlId) {
        if(!pinUrlRepository.existsById(pinUrlId)) {
            throw new EntityNotFoundException("해당 핀 URL을 찾을 수 없습니다.");
        }

        pinUrlRepository.deleteById(pinUrlId);
    }

    public void updatePinUrl(Long pinUrlId, UpdatePinUrlBodyDto updatePinUrlBodyDto) {
        PinUrl pinUrl = pinUrlRepository.findById(pinUrlId).orElseThrow(() -> new EntityNotFoundException("해당 핀 URL을 찾을 수 없습니다."));

        pinUrl.setTitle(updatePinUrlBodyDto.getTitle());
        pinUrl.setUrl(updatePinUrlBodyDto.getUrl());

        pinUrlRepository.save(pinUrl);
    }
}

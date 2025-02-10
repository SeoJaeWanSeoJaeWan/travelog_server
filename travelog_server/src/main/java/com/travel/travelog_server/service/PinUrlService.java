package com.travel.travelog_server.service;

import com.travel.travelog_server.controller.pinUrl.dto.CreatePinUrlDto;
import com.travel.travelog_server.controller.pinUrl.dto.UpdatePinUrlDto;
import com.travel.travelog_server.model.Pin;
import com.travel.travelog_server.model.PinUrl;
import com.travel.travelog_server.repository.PinRepository;
import com.travel.travelog_server.repository.PinUrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PinUrlService {
    private final PinUrlRepository pinUrlRepository;
    private final PinRepository pinRepository;

    public void createPinUrl(CreatePinUrlDto createPinUrlDto) {
        PinUrl pinUrl = new PinUrl();
        Pin pin = pinRepository.findById(createPinUrlDto.getPinId()).orElseThrow(() -> new IllegalArgumentException("해당 핀을 찾을 수 없습니다."));

        pinUrl.setUrl(createPinUrlDto.getUrl());
        pinUrl.setTitle(createPinUrlDto.getTitle());
        pinUrl.setPin(pin);

        pinUrlRepository.save(pinUrl);
    }

    public void deletePinUrl(Long pinUrlId) {
        pinUrlRepository.deleteById(pinUrlId);
    }

    public void updatePinUrl(Long pinUrlId, UpdatePinUrlDto updatePinUrlDto) {
        PinUrl pinUrl = pinUrlRepository.findById(pinUrlId).orElseThrow(() -> new IllegalArgumentException("해당 핀 URL을 찾을 수 없습니다."));

        pinUrl.setTitle(updatePinUrlDto.getTitle());
        pinUrl.setUrl(updatePinUrlDto.getUrl());

        pinUrlRepository.save(pinUrl);
    }
}

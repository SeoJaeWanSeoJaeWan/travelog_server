package com.travel.travelog_server.service;

import com.travel.travelog_server.controller.day.dto.CreateDayBodyDto;
import com.travel.travelog_server.controller.day.dto.GetDayById;
import com.travel.travelog_server.controller.day.dto.UpdateDayBodyDto;
import com.travel.travelog_server.controller.pin.dto.DayPinsDto;
import com.travel.travelog_server.model.Day;
import com.travel.travelog_server.model.DayPriceSummary;
import com.travel.travelog_server.model.Log;
import com.travel.travelog_server.model.Pin;
import com.travel.travelog_server.repository.DayPriceSummaryRepository;
import com.travel.travelog_server.repository.DayRepository;
import com.travel.travelog_server.repository.LogRepository;
import com.travel.travelog_server.repository.PinRepository;
import com.travel.travelog_server.util.IndexUpdate;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DayService {
    private final DayRepository dayRepository;
    private final PinRepository pinRepository;
    private final LogRepository logRepository;
    private final DayPriceSummaryRepository dayPriceSummaryRepository;

    public void createDay(CreateDayBodyDto createDayBodyDto) {
        Log log = logRepository.findById(createDayBodyDto.getLogId()).orElseThrow(() -> new EntityNotFoundException(("해당 로그를 찾을 수 없습니다.")));

        Day day = new Day();
        day.setIndex(createDayBodyDto.getIndex());
        day.setLog(log);

        dayRepository.save(day);
    }

    public GetDayById getDay(Long dayId) {
        Day day = dayRepository.findById(dayId).orElseThrow(() -> new EntityNotFoundException("해당 일자를 찾을 수 없습니다."));
        List<Pin> pin = pinRepository.findByDayIdOrderByIndexAsc(dayId);

        List<DayPinsDto> transformedPins = pin.stream()
                .map(DayPinsDto::new)
                .toList();

        DayPriceSummary dayPriceSummary = dayPriceSummaryRepository.findByDayId(day.getId());

        return new GetDayById(day,transformedPins,dayPriceSummary);
    }

    @Transactional
    public void deleteDay(Long dayId) {
        Day dayToDelete = dayRepository.findById(dayId).orElseThrow(() -> new EntityNotFoundException("해당 일자를 찾을 수 없습니다."));

        Long logId = dayToDelete.getLog().getId();
        Integer deleteIndex = dayToDelete.getIndex();

        dayRepository.deleteById(dayId);

        List<Day> days = dayRepository.findByLogIdOrderByIndexAsc(logId);
        List<Day> updatedDays = IndexUpdate.deleteIndex(days, deleteIndex);

        dayRepository.saveAll(updatedDays);
    }

    @Transactional
    public void updateDayIndex(Long dayId, UpdateDayBodyDto updateDayBodyDto) {
        Integer index = updateDayBodyDto.getIndex();
        Day dayToUpdate = dayRepository.findById(dayId)
                .orElseThrow(() -> new EntityNotFoundException("해당 일자를 찾을 수 없습니다."));

        List<Day> days = dayRepository.findByLogIdOrderByIndexAsc(dayToUpdate.getLog().getId());
        List<Day> updatedDays = IndexUpdate.updateIndex(days, dayToUpdate.getIndex(), index, dayId);

        dayRepository.saveAll(updatedDays);

        dayToUpdate.setIndex(index);
        dayRepository.save(dayToUpdate);
    }
}

package com.travel.travelog_server.service;

import com.travel.travelog_server.controller.day.dto.CreateDayDto;
import com.travel.travelog_server.model.Day;
import com.travel.travelog_server.model.Log;
import com.travel.travelog_server.repository.DayRepository;
import com.travel.travelog_server.repository.LogRepository;
import com.travel.travelog_server.util.IndexUpdate;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DayService {
    private final DayRepository dayRepository;
    private final LogRepository logRepository;

    public List<Day> getDaysByLogId(Long logId) {
        if (!logRepository.existsById(logId)) {
            throw new EntityNotFoundException("해당 로그를 찾을 수 없습니다.");
        }

        return dayRepository.findByLogIdOrderByIndexAsc(logId);
    }

    public void createDay(CreateDayDto createDayDto) {
        Log log = logRepository.findById(createDayDto.getLogId()).orElseThrow(() -> new EntityNotFoundException(("해당 로그를 찾을 수 없습니다.")));

        Day day = new Day();
        day.setIndex(createDayDto.getIndex());
        day.setLog(log);

        dayRepository.save(day);
    }

    public void deleteDay(Long dayId) {
        Day dayToDelete = dayRepository.findById(dayId).orElseThrow(() -> new EntityNotFoundException("해당 일자를 찾을 수 없습니다."));

        Long logId = dayToDelete.getLog().getId();
        Integer deleteIndex = dayToDelete.getIndex();

        dayRepository.deleteById(dayId);

        List<Day> days = dayRepository.findByLogIdOrderByIndexAsc(logId);
        List<Day> updatedDays = IndexUpdate.deleteIndex(days, deleteIndex);

        dayRepository.saveAll(updatedDays);
    }

    public void updateDayIndex(Long dayId, Integer index) {
        Day dayToUpdate = dayRepository.findById(dayId)
                .orElseThrow(() -> new EntityNotFoundException("해당 일자를 찾을 수 없습니다."));

        List<Day> days = dayRepository.findByLogIdOrderByIndexAsc(dayToUpdate.getLog().getId());
        List<Day> updatedDays = IndexUpdate.updateIndex(days, dayToUpdate.getIndex(), index, dayId);

        dayRepository.saveAll(updatedDays);

        dayToUpdate.setIndex(index);
        dayRepository.save(dayToUpdate);
    }
}

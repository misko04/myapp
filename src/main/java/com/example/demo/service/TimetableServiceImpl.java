package com.example.demo.service;

import com.example.demo.model.Timetable;
import com.example.demo.repository.TimetableRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TimetableServiceImpl implements TimetableService{

    private final TimetableRepository timetableRepository;

    public TimetableServiceImpl(TimetableRepository timetableRepository) {
        this.timetableRepository = timetableRepository;
    }

    @Override
    public List<Timetable> getAllTimetables() {
        return timetableRepository.findAll();
    }

    @Override
    public void saveTimetable(Timetable timetable) {
        timetableRepository.save(timetable);
    }

    @Override
    public Timetable getTimetableById(long id) {
        try {
            Optional<Timetable> table = timetableRepository.findById(id);
            return table.get();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public void deleteTimetableById(long id) {
        timetableRepository.deleteById(id);
    }

    public List<Timetable> getTimetableByUserName(String username) {
        List<Timetable> table = null;
        try {
            table = timetableRepository.getTimetableByUsername(username);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return table;
    }
}

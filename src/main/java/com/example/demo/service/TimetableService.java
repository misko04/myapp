package com.example.demo.service;

import com.example.demo.model.Timetable;
import com.example.demo.model.User;

import java.util.List;

public interface TimetableService {
    List<Timetable> getAllTimetables();

    void saveTimetable(Timetable timetable);

    Timetable getTimetableById(long id);

    void deleteTimetableById(long id);
}

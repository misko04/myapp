package com.example.demo.service;

import com.example.demo.model.Subjects;

import java.util.List;

public interface SubjectService {
    List<Subjects> getAllSubjects();

    void saveSubject(Subjects subjects);

    Subjects getSubjectById(long id);

    void deleteSubjectById(long id);
}

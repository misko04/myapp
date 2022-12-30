package com.example.demo.service;

import com.example.demo.model.Subjects;
import com.example.demo.repository.SubjectRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }
    @Override
    public List<Subjects> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public void saveSubject(Subjects subjects) {
        subjectRepository.save(subjects);
    }

    @Override
    public Subjects getSubjectById(long id) {
        return subjectRepository.getReferenceById(id);
    }

    @Override
    public void deleteSubjectById(long id) {
        subjectRepository.deleteById(id);
    }
}

package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.Timetable;
import com.example.demo.model.User;
import com.example.demo.repository.TimetableRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(long id) {

        return userRepository.getReferenceById(id);
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }



}
package com.example.demo.controler;


import com.example.demo.model.Subjects;
import com.example.demo.model.Timetable;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class WebController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private RolesService rolesService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private TimetableServiceImpl timetableService;


    @GetMapping("/")
public String homePage(){
return "index";
}

    @PostMapping("/saveNewUser")
    public String addUser(@ModelAttribute("User") User user) {
        String pwd = user.getPassword();
        String encryptPwd = passwordEncoder.encode(pwd);
        user.setPassword(encryptPwd);
        userRepository.save(user);
        return "redirect:/";
    }
    @GetMapping("/showNewUser")
    public String viewRegistration(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("listOfRoles", rolesService.getAllRoles());
        return "add-user";
    }

    @GetMapping("/showNewSubject")
    public String addSubject(Model model) {
        Subjects subject = new Subjects();
        model.addAttribute("subject", subject);
        return "add-subject";
    }

    @PostMapping("/saveSubject")
    public String addSubject(@ModelAttribute("subjects") Subjects subjects){
        subjectService.saveSubject(subjects);
        return "redirect:/";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable(value = "id") long id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("listOfRoles", rolesService.getAllRoles());
        model.addAttribute("listOfSubjects", subjectService.getAllSubjects());
        return "update-teacher";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        String pwd = user.getPassword();
        String encryptPwd = passwordEncoder.encode(pwd);
        user.setPassword(encryptPwd);
        userRepository.save(user);
        return "redirect:/viewUser";
    }

    @GetMapping("/viewUser")
    public String viewTeacher(Model model){
        model.addAttribute("listOfUsers", userService.getAllUsers());
        return "viewUser";
    }

    @GetMapping("/timetable/{userName}")
    public String homePage(@PathVariable String userName, Model model){
        model.addAttribute("timetableList", timetableService.getTimetableByUserName(userName));
        return "timetable";
    }

    @GetMapping("/updateTimetable/{username}")
    public String updateTimetable(@PathVariable(value = "username") String username, Model model) {
        List <Timetable> timetable = timetableService.getAllTimetables();
        Optional<User> user = userRepository.findByUserName(username);
        model.addAttribute("timetable", timetable);
        model.addAttribute("user",user);
        model.addAttribute("subject", subjectService.getAllSubjects());
        return "add_to_timetable";
    }

    @PostMapping("/saveTimetable")
    public String saveTimetable(@ModelAttribute("timetable") Timetable timetable) {
        timetableService.saveTimetable(timetable);
        return "redirect:/timetable{username}";
    }
}

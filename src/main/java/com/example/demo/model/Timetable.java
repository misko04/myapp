package com.example.demo.model;


import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "timetable")
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timetable_id", nullable = false)
    private Long id;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "day")
    private String day;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id" , nullable = false, referencedColumnName = "subject_id")
    private Subjects subjects;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id" , nullable = false, referencedColumnName = "user_id")
    private User user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Subjects getSubjects() {
        return subjects;
    }

    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}

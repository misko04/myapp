package com.example.demo.repository;

import com.example.demo.model.Role;
import com.example.demo.model.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable, Long> {
    @Query(value = "SELECT b.* FROM timetable b left join user u on u.user_id = b.user_id where u.user_name=?1", nativeQuery = true)
    List<Timetable> getTimetableByUsername(String userName);
}

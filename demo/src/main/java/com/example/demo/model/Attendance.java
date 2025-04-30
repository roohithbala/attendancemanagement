package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "attendance")
public class Attendance {
    @Id
    private String id;
    private String studentId;  // Unique identifier for the student
    private String date;       // Date of attendance
    private List<Boolean> periods; // Attendance for each period

    // Default constructor for Spring Data
    public Attendance() {}

    public Attendance(String studentId, String date, List<Boolean> periods) {
        this.studentId = studentId;
        this.date = date;
        this.periods = periods;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Boolean> getPeriods() {
        return periods;
    }

    public void setPeriods(List<Boolean> periods) {
        this.periods = periods;
    }
}

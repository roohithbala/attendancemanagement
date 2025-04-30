package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Attendance;
import com.example.demo.service.AttendanceService;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping
    public Attendance createAttendance(@RequestBody Attendance attendance) {
        return attendanceService.saveAttendance(attendance);
    }

    @GetMapping
    public List<Attendance> getAllAttendance() {
        return attendanceService.getAllAttendance();
    }

    @PutMapping("/{id}")
    public Attendance updateAttendance(@PathVariable String id, @RequestBody Attendance attendance) {
        attendance.setId(id);
        return attendanceService.updateAttendance(id, attendance);
    }

    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable String id) {
        attendanceService.deleteAttendance(id);
    }

    // New endpoint to download attendance as CSV with separate columns for each period
    @GetMapping("/download")
    public ResponseEntity<String> downloadAttendanceReport() throws IOException {
        List<Attendance> attendances = attendanceService.getAllAttendance();

        // Generate CSV content
        StringWriter csvWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(csvWriter);
        
        // Add CSV header with separate columns for each period
        writer.println("ID,Student ID,Date,Period1,Period2,Period3,Period4,Period5,Period6,Period7,Period8");

        // Add rows for each attendance record with individual period statuses
        for (Attendance attendance : attendances) {
            writer.printf("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s%n",
                    attendance.getId(),
                    attendance.getStudentId(),
                    attendance.getDate(),
                    attendance.getPeriods().size() > 0 ? (attendance.getPeriods().get(0) ? "Present" : "Absent") : "",
                    attendance.getPeriods().size() > 1 ? (attendance.getPeriods().get(1) ? "Present" : "Absent") : "",
                    attendance.getPeriods().size() > 2 ? (attendance.getPeriods().get(2) ? "Present" : "Absent") : "",
                    attendance.getPeriods().size() > 3 ? (attendance.getPeriods().get(3) ? "Present" : "Absent") : "",
                    attendance.getPeriods().size() > 4 ? (attendance.getPeriods().get(4) ? "Present" : "Absent") : "",
                    attendance.getPeriods().size() > 5 ? (attendance.getPeriods().get(5) ? "Present" : "Absent") : "",
                    attendance.getPeriods().size() > 6 ? (attendance.getPeriods().get(6) ? "Present" : "Absent") : "",
                    attendance.getPeriods().size() > 7 ? (attendance.getPeriods().get(7) ? "Present" : "Absent") : ""
            );
        }

        writer.flush();
        
        // Set headers for download
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", "attendance_report.csv");
        headers.setContentType(MediaType.TEXT_PLAIN);

        return ResponseEntity.ok()
                .headers(headers)
                .body(csvWriter.toString());
    }
}

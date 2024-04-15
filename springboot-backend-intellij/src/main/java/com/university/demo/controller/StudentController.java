package com.university.demo.controller;

import com.university.demo.dto.ResponsePayload;
import com.university.demo.dto.StudentDto;
import com.university.demo.model.Student;
import com.university.demo.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@Slf4j
public class StudentController {

    private StudentService service;

    @PostMapping("/student/save")
    public Student save (@RequestBody StudentDto student){
        return service.save(student);
    }
    @GetMapping("/student/all")
    public ResponseEntity<ResponsePayload> listAll(){
        ResponsePayload rp = ResponsePayload.builder()
                .code(HttpStatus.OK)
                .time(new Date())
                .successMessage("Data fetched successfully")
                .data(
                        Map.of("data", service.list())
                        /**
                         * Instead of
                         * Map<String, List<Student>> data = new HashMap<>();
                         * data.put("data", service.list());
                         */
                ).build();
        log.info("calling list all controller");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                      rp
                );
    }
}

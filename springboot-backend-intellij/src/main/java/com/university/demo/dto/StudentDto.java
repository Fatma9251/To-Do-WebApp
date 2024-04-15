package com.university.demo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class StudentDto {
    private Long id;
    @NonNull
    String fName, lName, email;
    String address;
}

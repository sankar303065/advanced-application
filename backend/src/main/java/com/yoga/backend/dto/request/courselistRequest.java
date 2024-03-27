package com.yoga.backend.dto.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class courselistRequest {
    
    private Long pid;
    private String courseName;
    private String academyName;
    private String description;
    private String imgUrl;
    
}
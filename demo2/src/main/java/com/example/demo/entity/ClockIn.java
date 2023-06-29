package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClockIn {
    int ClockInId;
    int ClockInTime;
    LocalDateTime date;
    String Content;

}

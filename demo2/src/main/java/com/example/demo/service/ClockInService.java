package com.example.demo.service;

import com.example.demo.mapper.BelongMapper;
import com.example.demo.mapper.ClockInMapper;
import lombok.Synchronized;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Service
public class ClockInService implements IClockInService{
    @Autowired
    BelongMapper belongMapper;
    @Autowired
    ClockInMapper clockInMapper;
    @Synchronized
    public boolean clockin(String AccountId,Integer ClockInTime,  String Content){

        return clockInMapper.clockin(ClockInTime,LocalDateTime.now(),Content)&&belongMapper.insertbelong(AccountId);
    }
}

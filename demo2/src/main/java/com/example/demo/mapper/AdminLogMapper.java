package com.example.demo.mapper;

import com.example.demo.entity.AdminLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface AdminLogMapper {
//    @Select("Select count(*) as count,Date(LogTime) from log group by Date(LogTime) order by Date(LogTime) desc")
//    List<LogCount> getlogcount();
//    @Select("Select count(*) as count,Date(ClockInDate)  from clockintb group by Date(ClockInDate) order by Date(ClockInDate) desc")
//    List<ClockInCount>getclockincount();
    @Select("SELECT t.date, SUM(t.clockin_count) AS clockincount, SUM(t.log_count) AS logcount\n" +
            "FROM (\n" +
            "  SELECT DATE(ClockInDate) AS date, COUNT(*) AS clockin_count, 0 AS log_count\n" +
            "  FROM clockintb\n" +
            "  GROUP BY DATE(ClockInDate)\n" +
            "  UNION ALL\n" +
            "  SELECT DATE(LogTime) AS date, 0 AS clockin_count, COUNT(*) AS log_count\n" +
            "  FROM log\n" +
            "  GROUP BY DATE(LogTime)\n" +
            ") t\n" +
            "GROUP BY t.date\n" +
            "ORDER BY t.date DESC;")
    List<AdminLog>getAdminlog();


}

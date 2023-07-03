package com.example.demo.mapper;

import com.example.demo.entity.AdminLog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
    @Delete("DELETE FROM team_account where AccountId=#{AccountId};")
    boolean Deleteteam_accountByID(@Param("AccountId") String AccountId);
    @Delete("DELETE FROM concerntb WHERE Account1Id=#{AccountId} or Account2Id=#{AccountId};")
    boolean DeleteconcernByID(@Param("AccountId") String AccountId);
    @Delete("DELETE FROM goodtb WHERE AccountId=#{AccountId};")
    boolean DeletegoodtbByID(@Param("AccountId") String AccountId);
    @Delete("DELETE FROM collectiontb WHERE AccountId=#{AccountId};")
    boolean DeletecollectiontbByID(@Param("AccountId") String AccountId);
    @Delete("DELETE FROM commentsdtb WHERE AccountId=#{AccountId};")
    boolean DeletecommentsdtbByID(@Param("AccountId") String AccountId);
    @Delete("DELETE FROM wishtb WHERE AccountId =#{AccountId};")
    boolean DeletewishtbByID(@Param("AccountId") String AccountId);
    @Delete("DELETE FROM belongtb WHERE AccountId =#{AccountId};")
    boolean DeletebelongtbByID(@Param("AccountId") String AccountId);
    @Delete("Delete from accounttb where AccountId=#{AccountId};")
    boolean DeleteaccounttbByID(@Param("AccountId") String AccountId);
    @Delete("Delete from clockintb where ClockInId in(select ClockInId from belongtb where AccountId=#{AccountId})")
    boolean DeleteclockintbByID(@Param("AccountId") String AccountId);

}

package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.accounttb;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<accounttb> {
    @Select("Select * from accounttb where AccountId=#{AccountId} and Password=#{Password}")
    accounttb login(@Param("AccountId")Integer AccountId,@Param("Password") String Password);
    @Select("Insert into accounttb values(#{AccountId},null,null,#{Password},null)")
    accounttb register(@Param("AccountId")Integer AccountId,@Param("Password") String Password);
    @Select("Select * from accounttb")
    List<accounttb> finduser();
    @Select("select * from student_info where stuid=#{stuid}")
    accounttb Userinfo(Integer stuid);
    @Delete("Delete from student_info where stuid=#{stuid}")
    Integer DeleteByID(Integer stuid);
}

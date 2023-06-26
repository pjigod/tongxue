package com.example.demo.service;
import com.example.demo.entity.accounttb;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    public UserMapper mapper;
    public List<accounttb> finduser(){
        return mapper.finduser();
    }
    public boolean login(Integer AccountId,String Password){
        if(mapper.login(AccountId,Password)==null)return false;
        else  return  true;
    }

    @Override
    public boolean register(Integer AccountId, String Password) {
        mapper.register(AccountId,Password);
        return true;
    }

    public accounttb Userinfo(Integer id){
        return mapper.Userinfo(id);
    };
}

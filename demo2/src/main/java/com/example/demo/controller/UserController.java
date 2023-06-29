package com.example.demo.controller;
import com.example.demo.entity.accounttb;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.FileUploadService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    private FileUploadService fservice;
    @Autowired
    private UserMapper mapper;
    @GetMapping("all")
    public List<accounttb> getAllUser(){
        List<accounttb> allUser=service.findalluser();
        return  allUser;
    }
    @RequestMapping ("login")
    public boolean login(@RequestParam("AccountId") String AccountId, @RequestParam("Password") String Password, HttpServletRequest request){
        System.out.println(AccountId);
        System.out.println(Password);
        return service.login(AccountId,Password,request);
    }
    @GetMapping("register")
    public boolean register(@RequestParam("AccountId") String AccountId,@RequestParam("Password") String Password){
        System.out.println(AccountId);
        System.out.println(Password);
        return service.register(AccountId,Password);
    }
    @RequestMapping("info")
    public accounttb getuserinfo(@RequestParam("AccountId")String AccountId){
        return service.Userinfo(AccountId);
    }
    @RequestMapping("updateinfo")
    public accounttb updateuserinfo(@RequestParam("AccountId") String AccountId,@RequestParam(value = "Password",required = false) String Password,@RequestParam(value = "EMail",required = false)String EMail,@RequestParam(value = "NickName",required = false)String NickName,@RequestParam(value = "photo",required = false)
    MultipartFile photo,HttpServletRequest request) throws IOException {
        if(photo!=null) fservice.uploadAvator(AccountId,photo,request);
        if(EMail!=null)mapper.updateEmail(AccountId,EMail);
        if(Password!=null)mapper.updatePassword(AccountId,Password);
        if(NickName!=null)mapper.updateNickname(AccountId,NickName);
        return service.Userinfo(AccountId);
    }
//    @GetMapping("query/{id}")
//    public accounttb getUserByID(@PathVariable("id")String stuid){
//        return service.Userinfo(stuid);
//    }
    @RequestMapping("totaltime")
    public float gettotaltime(@RequestParam("AccountId")String AccountId) {
        float totaltime = (float) (Math.round((float) mapper.gettotaltime(AccountId) * 10) / 10);
        return totaltime;
    }
}

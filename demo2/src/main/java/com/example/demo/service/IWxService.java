package com.example.demo.service;

import com.example.demo.entity.WxUserInfo;
import com.example.demo.mapper.WxUserMapper;
import org.apache.ibatis.annotations.Mapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.RequestParam;

public interface IWxService {
    WxUserInfo getLoginCertificate(@RequestParam("code") String code) throws Exception;
    public WxUserInfo getWxUserInfo(@NotNull String code, @NotNull String rawData, @NotNull String encryptedData, @NotNull String iv, @NotNull String signature) throws Exception;
}

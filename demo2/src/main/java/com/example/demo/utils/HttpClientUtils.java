package com.example.demo.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientUtils {

    /**
     * GET请求
     */
    public static String getRequest(String url) throws Exception {
        //HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            HttpGet httpGet = new HttpGet(url);
            response = httpClient.execute(httpGet);
            //响应体
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                //格式化响应体
                return EntityUtils.toString(entity);
            }
        } catch (ClientProtocolException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        } finally {
            response.close();
            httpClient.close();
        }
        return null;
    }
}
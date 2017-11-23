package com.hy.think.net;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * desc:
 *
 * @author hy
 * @version 1.0
 * @Created on 2017/11/2 17:20
 */
public class HttpClientRequest {

    public static void main(String[] args) throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://wthrcdn.etouch.cn/weather_mini?city=杭州");
        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        System.out.println(EntityUtils.toString(entity,"utf-8"));
    }
}

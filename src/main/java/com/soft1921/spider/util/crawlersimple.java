package com.soft1921.spider.util;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class crawlersimple  {
public static void mian(String[] args) throws  Exception{

//创建HttpClient对象
    CloseableHttpClient httpClient= HttpClients.createDefault();
    //请求网址
    HttpGet httpGet= new HttpGet("https://movie.douban.com");
    //设置头对象，鉴权
    httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.105 Safari/537.36");
    //发起请求
    CloseableHttpResponse response= httpClient.execute(httpGet);
    //判断状态码是否为200
    if (response.getStatusLine().getStatusCode()==200){
        HttpEntity httpEntity= response.getEntity();
        String content = EntityUtils.toString(httpEntity,"utf8");
        System.out.println(content);
    }









}

}

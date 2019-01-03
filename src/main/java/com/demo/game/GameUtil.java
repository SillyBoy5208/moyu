package com.demo.game;

import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class GameUtil {
    public static final String chuanShi8 ="http://mu.xyhero.com/chuanqi/s2/denglu.php";
    public static final String moYu9 = "http://mu.xyhero.com/moyu/s9/dengl";
    public static final String chuanQi11 = "http://mu.xyhero.com/cq/s11/denglu.php";
    public static String getCookie(String username,String password,String url) throws Exception{
        CookieStore cookieStore = new BasicCookieStore();
        CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(RequestConfig.custom().setProxy(new HttpHost("127.0.0.1",1080)).build()).setDefaultCookieStore(cookieStore).build();
        HttpPost post = new HttpPost(url);
        post.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36");
        post.setHeader("Referer","http://mu.xyhero.com/moyu/s8/indexdl.php");
        post.setHeader("Content-Type","application/x-www-form-urlencoded");
        NameValuePair name = new BasicNameValuePair("username",username);
        NameValuePair pass = new BasicNameValuePair("password",password);
        NameValuePair submit = new BasicNameValuePair("submit","登录");
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        list.add(name);
        list.add(pass);
        list.add(submit);
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, Charset.forName("gb2312"));
        post.setEntity(entity);
        CloseableHttpResponse response = client.execute(post);
        System.out.println(response.getStatusLine().getStatusCode());
        List<Cookie> cookies = cookieStore.getCookies();
        String session = cookies.get(0).getName()+"="+cookies.get(0).getValue();
        return session;
    }
    public static HttpGet getHttpGet(HttpGet get,String cookie,HttpHost proxy){
        if (proxy!=null)
            get.setConfig(RequestConfig.custom().setProxy(proxy).build());
        get.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36");
        get.setHeader("Cookie",cookie);
        get.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        return get;
    }
    public static CloseableHttpClient getHttpClient(HttpHost proxy){
        CloseableHttpClient httpClient;
        if (proxy!=null)
           return httpClient = HttpClientBuilder.create().setDefaultRequestConfig(RequestConfig.custom().setProxy(proxy).build()).build();
        else return httpClient = HttpClientBuilder.create().build();
    }
    public static HttpHost getProxy(){
        return new HttpHost("127.0.0.1",1080);
    }
}

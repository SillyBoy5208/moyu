package com.demo.game;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Qiji {
    public static void main(String[] args) throws Exception{
        String cookie  ="pgv_pvi=7105711104; pgv_si=s4315177984; __tins__19587789=%7B%22sid%22%3A%201546955713307%2C%20%22vd%22%3A%201%2C%20%22expires%22%3A%201546957513307%7D; __51cke__=; __51laig__=1; PHPSESSID=k6nr9f5gjal84s7pau3c8akgjhd3pf0i";
        String[] urls = {
            "http://mu.xyhero.com/mu/s25/ditu/fuben/expfb/map1.php",
                //"http://mu.xyhero.com/mu/s25/ditu/fuben/moneyfb/map1.php" ,
//                "http://mu.xyhero.com/mu/s25/ditu/8/map5.php",//丛林女巫师
//                "http://mu.xyhero.com/mu/s25/ditu/8/map4.php",//丛林生命体
//                "http://mu.xyhero.com/mu/s25/ditu/8/map3.php",//丛林暗杀者
//                "http://mu.xyhero.com/mu/s25/ditu/8/map2.php",//丛林残暴者
//                "http://mu.xyhero.com/mu/s25/ditu/8/map1.php",//丛林树精灵
               // "http://mu.xyhero.com/mu/s25/ditu/emgc/map6.php",



        };
        ExecutorService executorService = Executors.newCachedThreadPool();

        int len = 0;
        for(int j = 0; j <10;j++){
            final int x = j;
            executorService.execute(()->{
                while (true){

                        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
                        HttpGet httpGet = new HttpGet(urls[0]);
                        httpGet.setHeader("Cookie",cookie);
                        httpGet.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
                        httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.81 Safari/537.36");
                        CloseableHttpResponse response = null;
                        try {
                            response = httpClient.execute(httpGet);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        String res = null;
                        try {
                            res = EntityUtils.toString(response.getEntity(),"gb2312");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Document document = Jsoup.parse(res);
                        String txt = document.getElementsByTag("center").text();


                        System.out.println(len+":"+txt);
//                        try {
//                            Thread.sleep(10);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                        httpGet.releaseConnection();
                        try {
                            httpClient.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                }
            });
        }


    }
    public static void jinru(){

    }
}

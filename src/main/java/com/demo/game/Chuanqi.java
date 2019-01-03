package com.demo.game;

import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Chuanqi {
    public static void main(String[] args) throws Exception{
        String url2 = "http://mu.xyhero.com/cq/s11/ditu/zbmap1/map2.php";
        String url3 = "http://mu.xyhero.com/cq/s11/ditu/zbmap1/map3.php";
        String url4 = "http://mu.xyhero.com/cq/s11/ditu/zbmap1/map4.php";
        String url5 = "http://mu.xyhero.com/cq/s11/ditu/zbmap1/map5.php";
        String url6 = "http://mu.xyhero.com/cq/s11/ditu/zbmap1/map2.php";
        String url73 = "http://mu.xyhero.com/cq/s11/ditu/zbmap2/map1.php";//10万级装备怪物
        String url7 = "http://mu.xyhero.com/cq/s11/ditu/zbmap2/map2.php";//50万级装备怪物
        String url72 = "http://mu.xyhero.com/cq/s11/ditu/zbmap2/map3.php";//100万级装备怪物
        String url71  = "http://mu.xyhero.com/cq/s11/ditu/zbmap1/map6.php";//5万级装备怪物
          String url8 = "http://mu.xyhero.com/cq/s11/ditu/12/map6.php";//红野猪B
        String url9 = "http://mu.xyhero.com/cq/s11/ditu/13/map1.php";//角蝇A
     //   String url13 = "http://mu.xyhero.com/cq/s11/ditu/11/map4.php";//钳虫C
//        String url8 = "http://mu.xyhero.com/cq/s11/ditu/9/map1.php";
//        String url9 = "http://mu.xyhero.com/cq/s11/ditu/qugui/map11.php";//废弃矿洞恶鬼（一刀十怪）
//        String url10 ="http://mu.xyhero.com/cq/s11/ditu/qugui/map12.php";//废弃矿洞恶鬼（一刀百怪）
//        String url11 = "http://mu.xyhero.com/cq/s11/ditu/qugui/map14.php";//废弃矿洞恶鬼（一刀万怪）
        String[] urls = {url7,url71,url71,url73};
       String cookie = GameUtil.getCookie("netty","2672665a",GameUtil.chuanQi11);
        //String cookie = "pgv_pvi=3159361536; pgv_si=s278248448; PHPSESSID=5p8r5e1oenoqs5thtakn4q4lpfcbu7ij; __tins__19587789=%7B%22sid%22%3A%201546221939539%2C%20%22vd%22%3A%201%2C%20%22expires%22%3A%201546223739539%7D; __51cke__=; __51laig__=3";

        HttpHost proxy = new HttpHost("127.0.0.1",1080);
        RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(10*1000).setSocketTimeout(10*1000).setProxy(proxy).build();
        int len = 0;
        while (true){
            for(int i =0;i< urls.length;i++){
                CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
                HttpGet get = new HttpGet(urls[i]);
                get.setHeader("Cookie",cookie);
                get.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
                get.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.81 Safari/537.36");
                CloseableHttpResponse response = null;
                try {
                    response = httpClient.execute(get);
                } catch (IOException e) {
                    e.printStackTrace();
                    cookie = GameUtil.getCookie("netty","2672665a",GameUtil.chuanQi11);
                    Thread.sleep(1000*10);
                    break;
                }
                String res = EntityUtils.toString(response.getEntity(),"gb2312");
                       Document document = Jsoup.parse(res);
                       String txt = document.getElementsByTag("center").text();
                       if (txt.length()<20){
                           System.out.println(txt);
                           cookie = GameUtil.getCookie("netty","2672665a",GameUtil.chuanQi11);
                           len++;
                           Thread.sleep(700);
                           break;
                       }
                       System.out.println(len+":"+txt);
                       Thread.sleep(1000);
                get.releaseConnection();
                httpClient.close();
            }
        }



    }
}

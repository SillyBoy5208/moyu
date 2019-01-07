package com.demo.game;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Moyu {
    public static void main(String[] args) throws Exception{
        String cookie = "";
        String[] bossAddress = {

        };
        while (true){
            for(int i = 0 ; i < bossAddress.length; i++){
                CloseableHttpClient httpClient = HttpClientBuilder.create().build();
                String url = bossAddress[i];
                HttpGet get = new HttpGet(url);
                get.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36");
                get.setHeader("Cookie",cookie);
                get.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
                CloseableHttpResponse response = httpClient.execute(get);
                String res = EntityUtils.toString(response.getEntity());
                System.out.println(res);
                Document document = Jsoup.parse(res);
                document.text();
                get.releaseConnection();
                httpClient.close();
            }
        }
    }
}

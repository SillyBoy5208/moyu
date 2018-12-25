package com.demo.game;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.Soundbank;

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
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Chuanshi {
	
	public static void main(String[] args) throws Exception {
		RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(10*1000).setSocketTimeout(10*1000).build();
		
		CloseableHttpClient client2 = HttpClientBuilder.create().build();
		String[] urls = new String[]{
//				"http://mu.xyhero.com/chuanqi/s2/ditu/1/map1.php",
//				"http://mu.xyhero.com/chuanqi/s2/ditu/1/map2.php",
//				"http://mu.xyhero.com/chuanqi/s2/ditu/1/map3.php",
//				"http://mu.xyhero.com/chuanqi/s2/ditu/1/map4.php",
//				"http://mu.xyhero.com/chuanqi/s2/ditu/1/map5.php",
//				"http://mu.xyhero.com/chuanqi/s2/ditu/2/map1.php",
//				"http://mu.xyhero.com/chuanqi/s2/ditu/2/map2.php",
//				"http://mu.xyhero.com/chuanqi/s2/ditu/2/map3.php",
				//"http://mu.xyhero.com/chuanqi/s2/ditu/2/map4.php",
				"http://mu.xyhero.com/chuanqi/s2/ditu/4/map1.php"
		};
		String cookie = getCookie("开开心心", "2672665a");
		System.out.println(cookie);
		while(true){
			CloseableHttpClient client = HttpClientBuilder.create().build();
			for(int i = 0 ;i < urls.length;i++){
				String uString = urls[i];
				HttpGet get5 = new HttpGet(uString);
				get5.setConfig(config);
				get5.setHeader("Cookie",cookie);
				get5.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
				get5.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.81 Safari/537.36");
					CloseableHttpResponse response = client.execute(get5);
					String  resStr = EntityUtils.toString(response.getEntity(),"gb2312");
					Element element = Jsoup.parse(resStr);
					//System.out.println(resStr);
					Elements elements1 =  element.getElementsByTag("td");
					String myName = elements1.get(0).text();
					String bossName = elements1.get(1).text();
					int bossHP = Integer.parseInt(elements1.get(5).text().substring(3).trim());
//					if (bossHP<=0) {
//						break;
//					}
					System.out.println("我的血量:"+elements1.get(4).text().substring(3));
					System.out.println(bossName+"的血量:"+bossHP);
					Thread.sleep(1000);
			}
			// get.releaseConnection();
			// get2.releaseConnection();
		}
	}
	
	public static String getCookie(String username,String password) throws Exception{
        String url = "http://mu.xyhero.com/chuanqi/s2/denglu.php";
        CookieStore cookieStore = new BasicCookieStore();
        CloseableHttpClient client = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
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

}

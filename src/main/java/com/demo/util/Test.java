package com.demo.util;

import com.ai.Test1;
import com.alibaba.druid.support.json.JSONParser;
import com.sun.imageio.plugins.common.ImageUtil;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.swing.text.html.parser.Entity;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static HttpHost proxy = new HttpHost("127.0.0.1",1080);
    public static void main(String[] args) throws Exception{
        String urlStr = "https://aip.baidubce.com/rpc/2.0/ai_custom/v1/detection/testimage";
        String filePath = "D:\\Users\\CHIZENGYU198\\Desktop\\黑白大图\\1.bmp";
//        System.out.println(getImageLocation(urlStr,filePath));
        System.out.println(ImageToBase64ByLocal(filePath));
//
    }
    public static String getImageLocation(String url,String imgFile) throws Exception{
        CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(RequestConfig.custom().setProxy(proxy).build()).build();
        HttpPost post = new HttpPost(url);
        String token = Test1.getAuth("Gs0e1IVtAbCS9Eat9UizIvWX","VxDpX1MNBDecGPFBE8c72S8IvC7n9ZDN");
        //post.setHeader("access_token",token);
        post.setHeader("Content-Type","application/json");
        //StringEntity stringEntity
        String imageBase64Str = ImageToBase64ByLocal(imgFile);
        NameValuePair image = new BasicNameValuePair("image",imageBase64Str);
        NameValuePair myToken = new BasicNameValuePair("access_token",token);
        NameValuePair threshold = new BasicNameValuePair("threshold","0.9");
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        list.add(image);
        list.add(threshold);
        list.add(myToken);
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list);
        post.setEntity(entity);
        CloseableHttpResponse response = client.execute(post);
        String res = EntityUtils.toString(response.getEntity());
        return res;
    }
    public static String ImageToBase64ByLocal(String imgFile) throws Exception{// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理


        InputStream in = null;
        byte[] data = null;

        // 读取图片字节数组
        try {
            in = new FileInputStream(imgFile);

            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();

        return encoder.encode(data);// 返回Base64编码过的字节数组字符串
    }
}

package com.ai;

import com.demo.util.Base64Util;
import com.demo.util.GsonUtils;
import com.demo.util.HttpUtil;
import com.demo.util.Test;

import java.util.*;

/**
 * easydl物体检测
 */
public class EasydlObjectDetection {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static String easydlObjectDetection(String path) {
        // 请求url
        String url = "https://aip.baidubce.com/rpc/2.0/ai_custom/v1/detection/testimage";
        try {
            Map<String, Object> map = new HashMap<>();
            String  imageBase64 =  Test.ImageToBase64ByLocal(path);
            map.put("image", imageBase64);

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = Test1.getAuth("Gs0e1IVtAbCS9Eat9UizIvWX","VxDpX1MNBDecGPFBE8c72S8IvC7n9ZDN");

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(EasydlObjectDetection.easydlObjectDetection("D:\\Users\\CHIZENGYU198\\Desktop\\Desktop\\test.bmp"));
    }
}
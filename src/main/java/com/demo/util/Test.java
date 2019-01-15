package com.demo.util;

import com.sun.imageio.plugins.common.ImageUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.Socket;

public class Test {
    public static void main(String[] args) throws Exception{
        BufferedImage image = ImageIO.read(new File("D:\\Users\\CHIZENGYU198\\Desktop\\新建文件夹\\1.jpg"));
        System.out.println(image.getRGB(169,141));
    }
}

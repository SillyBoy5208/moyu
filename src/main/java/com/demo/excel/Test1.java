package com.demo.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test1 {
    public static void main(String[] args) throws Exception{
        File file = new File("D:\\test\\授权管理v1.0冒烟测试用例.xlsx");
        Workbook workbook = toWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        System.out.println(sheet.getFirstRowNum());
        System.out.println(sheet.getPhysicalNumberOfRows());
        System.out.println(sheet);
    }
    public static Workbook toWorkbook(File file) throws IOException {
        Workbook wb =null;
        FileInputStream fis = new FileInputStream(file);
        if (file.getName().endsWith("xls")){
            wb = new HSSFWorkbook(fis);
        }else if (file.getName().endsWith("xlsx")){
            wb = new XSSFWorkbook(fis);
        }
        return wb;
    }
}

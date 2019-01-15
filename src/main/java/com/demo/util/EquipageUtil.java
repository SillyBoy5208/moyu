package com.demo.util;

import com.demo.entity.Equipage;

public class EquipageUtil {
    private static int[] array= new int[100];
    static {
        for (int i = 0 ; i <array.length;i++){
            if (i%2==0){
                array[i]=1;
            }
        }
    }
    public static Equipage upEquipage(Equipage equipage){
        if (equipage==null){
            return null;
        }
        if (equipage.geteLevel()>=125){
            return equipage;
        }
        int level = equipage.geteLevel();
        int x = (int)(Math.random()*100);
        if (array[x]==0){
            return equipage;
        }
        if (array[x]==1){
            equipage.seteLevel(level+1);
            return equipage;
        }
        return null;
    }
    public static Equipage strengthenMohun(Equipage equipage){
        if (equipage.getMohunLevel()>=12){
            System.out.println("111111111");
            return equipage;
        }
        if (equipage.getMohunLevel()<=5){
            System.out.println("1111122222");
            int[] array = generateArray(80);
            int x = (int)(Math.random()*100);
            System.out.println("x:"+x);
            System.out.println("array[x]="+array[x]);
            if (array[x]==0){
                return equipage;
            }
            if (array[x]==1){
                int level = equipage.getMohunLevel();
                equipage.setMohunLevel(level+1);
                return equipage;
            }

        }
        if (equipage.getMohunLevel()>5&& equipage.getMohunLevel() <=7){
            System.out.println(">>>>>>>>>>>>");
            int[] array = generateArray(40);
            int x = (int)(Math.random()*100);
            if (array[x]==0){
                return equipage;
            }
            if (array[x]==1){
                equipage.setMohunLevel(equipage.getMohunLevel()+1);
                return equipage;
            }
        }
        if (equipage.getMohunLevel()>7){
            System.out.println("33333333333333333  ");
            int[] array = generateArray(5);
            int x = (int)(Math.random()*100);
            if (array[x]==0){
                return equipage;
            }
            if (array[x]==1){
                equipage.setMohunLevel(equipage.getMohunLevel()+1);
                return equipage;
            }
        }
        return null;
    }
    public static int[] generateArray(int n){
        n= n <= 0 ? 0: n;
        n= n>=100 ?100:n;
        int[] array  = new int[100];
        for(int i = 0 ; i < n ;i++){
            array[i] = 1;
        }
        return array;
    }
}

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
}

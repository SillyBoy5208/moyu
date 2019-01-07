package com.demo.form;

public class PKResponseForm {
    String message;
    int myBlood;

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "PKResponseForm{" +
                "message='" + message + '\'' +
                ", myBlood=" + myBlood +
                ", bossBlood=" + bossBlood +
                ", myBloodReduce=" + myBloodReduce +
                ", bossBloodReduce=" + bossBloodReduce +
                '}';
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getMyBlood() {
        return myBlood;
    }

    public void setMyBlood(int myBlood) {
        this.myBlood = myBlood;
    }

    public int getBossBlood() {
        return bossBlood;
    }

    public void setBossBlood(int bossBlood) {
        this.bossBlood = bossBlood;
    }

    public int getMyBloodReduce() {
        return myBloodReduce;
    }

    public void setMyBloodReduce(int myBloodReduce) {
        this.myBloodReduce = myBloodReduce;
    }

    public int getBossBloodReduce() {
        return bossBloodReduce;
    }

    public void setBossBloodReduce(int bossBloodReduce) {
        this.bossBloodReduce = bossBloodReduce;
    }

    int bossBlood;
    int myBloodReduce;
    int bossBloodReduce;
}

package com.sbrf.reboot;

public class Calculator {

    public static int getAddition(int a, int b){
        return Math.addExact(a,b);
    }

    public static int getSubtraction(int a, int b){
        return a-b;
    }

    public static int getMultiplication(int a, int b){
        return a*b;
    }

    public static int getDivision(int a, int b){
        return a/b;
    }

    public static int getExponentiation(int a, int b){
        int result = a;
        for (int i = 1; i < b; i++) {
            result = result * a;
        }
        return result;
    }

    public static int getModule(int a, int b){
        int c;
        if (b!=0) {
            c=a%b;
            return c;
        }
        else {
            System.out.println("На 0 делить нельзя");
            return 0;
        }
    }

    public static float getPercent(float a, float b){
    float c;
        if (b!=0) {
            c=a/b*100;
            return c;
        }
        else {
            System.out.println("На 0 делить нельзя");
            return 0;
        }
    }
}

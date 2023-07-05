package test;

import com.google.common.base.Preconditions;

public class t1 {
    int i = 0;
    void method1(){};

    public static void main(String[] a){
        Preconditions.checkState(Thread.currentThread().getId() == 111,
                "发的人帆帆帆帆");
        System.out.println("dddd");
    }
}

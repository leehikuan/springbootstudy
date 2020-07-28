package com.leehikuan.springbootstudy.myannotation;

public class Test {
    @MethodTime("test")
    public static void test() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
        }
        System.out.println("test执行完毕");
    }

    public static void main(String[] args) throws InterruptedException {
        test();
    }
}

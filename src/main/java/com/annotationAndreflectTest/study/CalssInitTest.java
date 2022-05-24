package com.annotationAndreflectTest.study;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

// https://blog.csdn.net/Aur_ora/article/details/118437301
public class CalssInitTest {

    public static void main(String[] args) {
        C a = new C();
        System.out.println(a.m);
    }
}

class B {
    static {
        System.out.println("B父类静态被加载");
    }
    public B(){
        System.out.println("B父类实例被加载");
    }
}
class A extends B{
    static {
        m = 100;
        System.out.println("A静态代码块");
    }

    static int m = 300;

    public A() {
        System.out.println("A实例代码块");
    }
}
class C extends A{
    static {
        m = 100;
        System.out.println("C静态代码块");
    }

    static int m = 300;

    public C() {
        System.out.println("C实例代码块");
    }
}
// 类加载时所有静态代码块 会按照顺序合并
package com.lockTest.study;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

// 烧电
public class MainTest {
    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        int[] s = new int[1];
       Thread[] ts = new Thread[10];
        for (int i = 0; i < ts.length; i++) {
            ts[i] = new Thread(() ->{
                long l = System.currentTimeMillis();
                try {
                    a.locktest(0);
                    for (int j = 0; j < 1000; j++) {
                        s[0]++;
                    }
                }finally {
                    a.unlocktest(0);
                    System.out.println(Thread.currentThread().getName()+"耗时："+(System.currentTimeMillis()-l));
                }


            },"name" + i);
        }
        for (int i = 0; i < ts.length; i++) {
            ts[i].start();
           //  ts[i].join();

        }
        for (int i = 0; i < ts.length; i++) {
            //ts[i].start();
              ts[i].join();

        }
       //  Thread.sleep(10000);
        System.out.println( a.m);
        System.out.println( s[0]);
    }
}
    class A {
        Thread thread = null;
        static int m = 0;
        private static final Unsafe unsafe = createUnsafe();
        private static final long stateOffset;
        int state = 0;
        static {
            try {
                stateOffset = unsafe.objectFieldOffset
                        (A.class.getDeclaredField("state"));

            } catch (Exception ex) { throw new Error(ex); }
        }
        protected void locktest(int ags) {
            if(unsafe.compareAndSwapInt(this, stateOffset, 0, 1)){
                if (thread == null) {
                    thread = Thread.currentThread();
                    m++;
                    return;
                }
                if (thread != Thread.currentThread()){
                    System.err.println("当前线程"+thread.getName()+"和"+Thread.currentThread().getName());
                   // locktest(0);
                    for (;;){
                        if(unsafe.compareAndSwapInt(this, stateOffset, 0, 1)){
                            if (thread == null) {
                                thread = Thread.currentThread();
                                m++;
                                return;
                            }
                        }
                    }
                }
            }
        }
        protected void unlocktest(int ags) {

         //   if(unsafe.compareAndSwapInt(this, stateOffset, 1, 0)){
                if (thread == Thread.currentThread()) {
                 //   thread.notifyAll();
                    thread=null;
                    m--;
             //   }

            } else {
                for (;;){
                  //  if(unsafe.compareAndSwapInt(this, stateOffset, 1, 0)){
                        if (thread == Thread.currentThread()) {
                            //   thread.notifyAll();
                            thread=null;
                            m--;
                      //  }
                    }
                }
            }
        }
        public static Unsafe createUnsafe() {
            try {
                Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
                Field field = unsafeClass.getDeclaredField("theUnsafe");
                field.setAccessible(true);
                Unsafe unsafe = (Unsafe) field.get(null);
                return unsafe;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }


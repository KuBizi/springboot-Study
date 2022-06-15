package com.lockTest.study;

import com.sun.istack.internal.NotNull;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

public interface LockTest {
    void lock();
    void lockInterruptibly() throws InterruptedException;
    boolean tryLock();
    boolean tryLock(long time, @NotNull TimeUnit unit) throws InterruptedException;
    void unlock();
    @NotNull
    Condition newCondition();
}

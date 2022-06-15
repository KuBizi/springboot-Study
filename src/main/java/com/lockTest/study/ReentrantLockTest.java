package com.lockTest.study;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest implements LockTest, Serializable {
    private static final long serialVersionUID = 7373984872572414600L;

   // private final SyncTest syncTest;

    @Override
    public void lock() {

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }

    abstract static class SyncTest extends AbstractQueuedSynchronizer {
        abstract void lock();


        final boolean nonfairTryAcquire(int acquires){
            final Thread current = Thread.currentThread();
            int c = getState();
            if (c == 0) {
                if (compareAndSetState(0,acquires)){
                    setExclusiveOwnerThread(current);
                    return true;
                }
            // 重入
            } else if (current == getExclusiveOwnerThread()) {
                int nextc = c + acquires;
                if (nextc < 0) { //  int 最大值：2147483647 + 1 变为负数
                    throw new  Error("Maximum lock count exceeded");
                }
                setState(nextc);
                return true;
            }
            return false;
        }

        protected final boolean tryRelease(int releases) {
            int c = getState() - releases;
            if (Thread.currentThread() != getExclusiveOwnerThread()) {
                throw new IllegalMonitorStateException();
            }
            boolean free = false;
            if(c == 0) {
                free = true;
                setExclusiveOwnerThread(null);
            }
            setState(c);
            return free;
        }

        protected final boolean isHeldExclusively(){
            return getExclusiveOwnerThread() == Thread.currentThread();
        }

        final ConditionObject newCondition() {
            return new ConditionObject();
        }

        final Thread getOwner() {
            return getState() == 0 ? null : getExclusiveOwnerThread();
        }

        final int getHoldCount() {
            return isHeldExclusively() ? getState() : 0;
        }

        final boolean isLocked() {
            return getState() != 0;
        }

        private void readObject(ObjectInputStream s) throws java.io.IOException,ClassNotFoundException {
            s.defaultReadObject();
            setState(0);
        }

    }
    static final class NonfairSyncTest extends SyncTest {
        @Override
        void lock() {
            if (compareAndSetState(0,1)) {
                setExclusiveOwnerThread(Thread.currentThread());
            } else {
                acquire(1);
            }
        }
        protected final boolean tryAcquire(int acquires) {
            return nonfairTryAcquire(acquires);
        }
    }
}

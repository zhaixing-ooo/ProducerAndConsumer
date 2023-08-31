package org.example.DCL;

public class SingleTon {
    //使用volatile关键字防止指令重排，破坏单例
    private volatile static SingleTon uniqueSingleton;

    private SingleTon() {
    }

    public SingleTon getInstance() {
        if (null == uniqueSingleton) {//一重检查
            synchronized (SingleTon.class) {
                if (null == uniqueSingleton) {//双重检查
                    uniqueSingleton = new SingleTon();
                }
            }
        }
        return uniqueSingleton;
    }
}
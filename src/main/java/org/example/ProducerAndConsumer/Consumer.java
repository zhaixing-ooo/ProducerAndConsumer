package org.example.ProducerAndConsumer;

import java.util.Random;
import java.util.concurrent.BlockingDeque;

public class Consumer implements Runnable{
    private BlockingDeque<Data> queue ;

    private static Random random = new Random();

    public Consumer(BlockingDeque<Data> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            while (true){
                System.out.println("当前队顶元素"+queue.peek());
                if(!queue.isEmpty()) {
                    for (Data data : queue) {
                        System.out.print(data.getNum() + " ");
                    }
                    System.out.println();
                }
                Data data = queue.take();
                Thread.sleep(random.nextInt(1000));
                if(data != null){
                    System.out.println("当前水管" + Thread.currentThread().getName()+"抽水容量"+data.getNum()+"L");
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}



import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


public class CountDown {


    public static void main(String[] args) throws InterruptedException {
        // 创建 CountDownLatch 对象，需要等待 3 个线程完成任务
        CountDownLatch latch = new CountDownLatch(1);


        Workermain workermain=new Workermain(latch, "workermain");
        // 创建 3 个线程
        workermain.start();

        // 等待 3 个线程完成任务
        latch.await();
        Worker worker1=new Worker("worker1");
        Worker worker2=new Worker("worker2");
        Worker worker3=new Worker("worker3");
        worker1.start();
        worker2.start();
        worker3.start();


    }
}

class Workermain extends Thread {

    private final CountDownLatch latch;

    public String name;

    public Workermain(CountDownLatch latch, String name) {
        this.latch = latch;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            // 模拟任务耗时
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println(name + "has finished the job!");
        } catch (InterruptedException e) {

        } finally {
            // 一定要保证每个线程执行完毕或者异常后调用countDown()方法
            // 如果不调用会导致其他线程一直等待, 无法继续执行
            // 建议放在finally代码块中, 防止异常情况下未调用countDown()方法
            latch.countDown();
        }
    }
}
    class Worker extends Thread {


        public String name;

        public Worker(String name) {

            this.name = name;
        }

        @Override
        public void run() {
            try {
                // 模拟任务耗时
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println(name + "has finished the job!");
            } catch (InterruptedException e) {

            } finally {
                // 一定要保证每个线程执行完毕或者异常后调用countDown()方法
                // 如果不调用会导致其他线程一直等待, 无法继续执行
                // 建议放在finally代码块中, 防止异常情况下未调用countDown()方法

            }
        }


}
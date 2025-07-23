import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
class RateLimiter {

    private final Semaphore semaphore;
    //构造函数
    public RateLimiter(int permits) {
        this.semaphore = new Semaphore(permits);
    }
     //获取许可
    public void acquirePermit() throws InterruptedException {
        semaphore.acquire();
    }
  //释放许可
    public void releasePermit() {
        semaphore.release();
    }

    public boolean tryAcquirePermit(long timeout, TimeUnit unit) throws InterruptedException {
        return semaphore.tryAcquire(timeout, unit);
    }
}

public class Semaphoretest {

    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter(5); // 允许最多三个线程同时执行
        //模拟十个线程
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                try {
                    rateLimiter.acquirePermit();
                    System.out.println(Thread.currentThread().getName() + " is processing.");
                    TimeUnit.SECONDS.sleep(2); // 模拟处理时间
                    System.out.println(Thread.currentThread().getName() + " processed.");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    rateLimiter.releasePermit();
                }
            }, "Thread-" + i);
            thread.start();
        }
    }
}

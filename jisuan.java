
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;

class Task implements Callable<Integer> {
    int startNumber = 0;
    int endNumber = 0;

    public Task(int startNumber,int endNumber){
        this.startNumber =startNumber;
        this.endNumber = endNumber;
    }
    public Integer call() throws Exception {

        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for(int i=startNumber ;i<= endNumber;i++)
            sum += i;
        return sum;
    }

}

public class jisuan {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);
        Task task = new Task(1,50);
        Task task1 = new Task(51,80);
        Task task2 = new Task(81,100);
        Future<Integer> result = executor.submit(task);//获取线程返回值

        Future<Integer> result1 = executor.submit(task1);


        Future<Integer> result2 = executor.submit(task2);
        executor.shutdown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            int sum = result.get() + result1.get() +result2.get();
            System.out.println("task运行结果" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }
}
import java.util.concurrent.*;


public class Xianchengchi {
    public static void main(String[] args) {

        taskListImpl taskList = new taskListImpl();

        String taskJksj = taskList.poolExecutorJksj();





    }
}

class taskListImpl {

    // 创建一些任务
    int[] taskJksj = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};



    public String poolExecutorJksj() {
        //构建线程池
        ThreadPoolExecutor pool =
                new ThreadPoolExecutor(
                        3,
                        10,
                        3,
                        TimeUnit.SECONDS,
                        new LinkedBlockingDeque<>(5),
                        Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy()
                );



        try {
            for (int i = 0; i < taskJksj.length; i++) {

                int num = i;

                //允许并发执行多个任务
                pool.execute(() -> {

                    taskJksjPool(num);

                });

            }
        } catch (Exception e) {
                throw new RuntimeException(e);
        } finally {
            pool.shutdown();
        }

        return "taskJksjSuccess";

    }

    public void taskJksjPool(int num) {

        System.out.println(Thread.currentThread().getName() + " " + taskJksj[num]);

    }



}
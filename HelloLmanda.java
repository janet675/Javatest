
public class HelloLmanda {
   public static void main(String[] args) {
       Runnable runnable = () -> System.out.println("Hello Lmanda");
       new Thread(runnable).start();
   }

}


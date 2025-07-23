import java.util.*;
import java.util.function.*;

public class Daxie {
    public static void main(String[] args) {
        String inputString = "hello world";

        // 使用 Lambda 表达式创建 Function 接口的实例
        Function<String, String> processString = (s) -> s.toUpperCase().substring(0, 3);

        // 使用 Function 接口的实例进行处理
        String transformedString = processString.apply(inputString);

        
        System.out.println(transformedString);
    }
}


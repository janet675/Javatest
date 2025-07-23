import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dayu5 {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("apples");
        stringList.add("cat");
        stringList.add("bird");

        // 使用 Lambda 表达式过滤字符串列表，只保留长度大于5的字符串
        List<String> filteredStrings = stringList;
                  stringList.stream().filter(s -> s.length() > 5).forEach(System.out::print); // 过滤条件：字符串长度大于 5



    }
}

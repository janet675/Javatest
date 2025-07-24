import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

// 属性注解 @Range
@Retention(RetentionPolicy.RUNTIME) // 运行时可见
@Target(ElementType.FIELD)         // 仅可用于字段
@interface Range {
    int min();  // 最小值
    int max();  // 最大值
}


class Person {


    String name;

    @Range(min = 0, max = 100) // 添加 Range 注解
    int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
public class Fanshe     {
    public  static void main(String[] args) throws Exception{
        // 获取 Class 对象
        Class<?> clazz = Person.class;
        Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
        Object person = constructor.newInstance("lyk", 120);



    }

}
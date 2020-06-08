import com.java8.User;
import org.junit.Test;

import java.util.Optional;

/**
 * 描述
 *
 * @author wxf
 * @date 2020/6/8 21:45
 */
public class TestOptional {
    @Test
    public void test() {
        String name = "wdnmd";
        // 有值则返回该值 null 就返回 orElse的参数值
        String opt = Optional.ofNullable(name).orElse("name是空的");
        System.out.println(opt);
        // 空值返回异常
        String orElseThrow = Optional.ofNullable(name).orElseThrow(() -> new RuntimeException("这是个空值"));
        System.out.println(orElseThrow);
        // 转换值
        User user = new User(null);
        String newUserName = Optional.ofNullable(user).map(User::getName).orElse("李四");
        System.out.println(newUserName);
    }
}

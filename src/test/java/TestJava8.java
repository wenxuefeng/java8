import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class TestJava8 {
    @Test
    public void testConsumer() {
        consumer(98, (m) -> System.out.println("买吃鸡游戏花了" + m + "元"));
    }

    public void consumer(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    @Test
    public void testSupplier() {
        Random random = new Random();
        List<Integer> list = supplier(10, () -> random.nextInt(10));
        list.forEach(System.out::println);
    }

    public List<Integer> supplier(int sum, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < sum; i++) {
            list.add(supplier.get());
        }
        return list;
    }

    @Test
    public void testFunction() {
        String str = function("wdnm", (x) -> x.substring(0, 2));
        System.out.println(str);
    }

    public String function(String str, Function<String, String> function) {
        return function.apply(str);
    }

    @Test
    public void testPredicate() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> integerList = predicate(list, (x) -> x < 3);
        integerList.forEach(System.out::println);
    }

    public List<Integer> predicate(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer> returnList = new ArrayList<>();
        for (Integer i : list) {
            if (predicate.test(i)) {
                returnList.add(i);
            }
        }
        return returnList;
    }
}

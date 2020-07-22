package stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Java 8 API添加了一个新的抽象称为流Stream，可以让你以一种声明的方式处理数据。
 * Stream 使用一种类似用 SQL 语句从数据库查询数据的直观方式来提供一种对 Java 集合运算和表达的高阶抽象。
 * Stream API可以极大提高Java程序员的生产力，让程序员写出高效率、干净、简洁的代码。
 * 这种风格将要处理的元素集合看作一种流， 流在管道中传输， 并且可以在管道的节点上进行处理， 比如筛选， 排序，聚合等。
 */
public class StreamOfJava8 {

    /**
     * +--------------------+       +------+   +------+   +---+   +-------+
     * | stream of elements +-----> |filter+-> |sorted+-> |map+-> |collect|
     * +--------------------+       +------+   +------+   +---+   +-------+
     * @param args
     */
    public static void main(String[] args) {

        //forEach
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

        List<Integer> list = Arrays.asList(3, 3, 2, 4, 5, 6);
        List<Integer> squaresList = list.stream().map(e -> e * e).distinct().collect(Collectors.toList());

        List<String> strings = Arrays.asList("ab", "a", "", "78", " ");
        long count = strings.parallelStream().filter(e -> e.isEmpty()).count();

        random.ints().limit(10).sorted().forEach(System.out::println);

        List<String> strings1 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings1.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println("筛选列表: " + filtered);
        String mergedString = strings1.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);

        mergedString = strings1.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(","));
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }
}

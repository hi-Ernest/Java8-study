package method;

import java.util.ArrayList;
import java.util.List;

public class MethodOfJava8 {

    public static void main(String args[]){
        List names = new ArrayList();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add(111);

        names.forEach(System.out::println);
    }
}

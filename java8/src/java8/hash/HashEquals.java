package java8.hash;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author fw
 * @date 2019/03/18
 */
public class HashEquals {
    public static void main(String[] args) {
        InnerClass i1 = new InnerClass("a", "b","c");
        InnerClass i2 = new InnerClass("a", "b","d");
        InnerClass i3 = new InnerClass("b", "c","e");
        InnerClass i4 = new InnerClass("b", "a","e");
        InnerClass i5 = new InnerClass("b", "a","d");
        InnerClass i6 = new InnerClass("b", "a","f");


        Set<InnerClass> set = new HashSet<>();
        set.add(i1);
        set.add(i2);
        set.add(i3);
        set.add(i4);
        set.add(i5);
        set.add(i6);

        set.stream().forEach(
            i -> {
                System.out.println(i.a + " " + i.b + " " + i.c);
            }
        );
    }
}

package java8.lambda;

import java.util.Arrays;

public class Demo07ComparatorLambda {
    public static void main(String[] args) {
        Demo06Person[] arr = {
            new Demo06Person("古力娜扎", 19),
            new Demo06Person("迪丽热巴", 18),
            new Demo06Person("欧阳娜娜", 20),
        };

        Arrays.sort(arr,(Demo06Person p1, Demo06Person p2)->{return p1.getAge()-p2.getAge();});

        for (Demo06Person person : arr) {
            System.out.println(person);
        }
    }
}

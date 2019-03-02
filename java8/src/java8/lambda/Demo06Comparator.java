package java8.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class Demo06Comparator {

    public static void main(String[] args) {
        Demo06Person[] arr = {
            new Demo06Person("古力娜扎",19),
            new Demo06Person("迪丽热巴",18),
            new Demo06Person("欧阳娜娜",20),
        };

        Comparator<Demo06Person> comp = new Comparator<Demo06Person>() {
            @Override
            public int compare(Demo06Person o1, Demo06Person o2) {
                return o1.getAge() - o2.getAge();
            }
        };

        Arrays.sort(arr, comp);

        for (Demo06Person person : arr) {
            System.out.println(person);
        }
    }
}

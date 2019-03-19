package java8.hash;

import java.util.Objects;
import java.util.Set;

/**
 * @author fw
 * @date 2019/03/18
 */
public class InnerClass {
    String a;
    String b;
    String c;

    public InnerClass(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * a属性相同则不插入，a属性相同则插入
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        InnerClass that = (InnerClass)o;
        return this.a.equals(that.a);
    }

    /**
     * 如果想hashcode确实起到提升效率
     * @return
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + a.hashCode();
        result = 31 * result + b.hashCode();
        return result;
    }
}

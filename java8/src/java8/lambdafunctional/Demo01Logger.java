package java8.lambdafunctional;

public class Demo01Logger {
    public static void main(String[] args) {
        String msg1 = "hello ";
        String msg2 = "world ";
        String msg3 = "java";
        log(1,msg1+msg2+msg3);
    }

    private static void log(int i,String str){
        if(i==1){
            System.out.println(str);
        }
    }
}

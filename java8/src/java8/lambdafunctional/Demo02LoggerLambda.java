package java8.lambdafunctional;

public class Demo02LoggerLambda {
    public static void main(String[] args) {
        String msg1 = "hello ";
        String msg2 = "world ";
        String msg3 = "java";
        //这是一种省略写法，省略了return {} ;
        //即()-> {return (msg1+msg2+msg3)};
        log(1,()->msg1+msg2+msg3);
    }

    private static void log(int i, Demo01Inter inte){
        if(i==1){
            System.out.println(inte.buildMessage());
        }
    }
}

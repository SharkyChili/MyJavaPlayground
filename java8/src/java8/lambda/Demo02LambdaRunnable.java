package java8.lambda;

public class Demo02LambdaRunnable {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("多线程执行")).start();
    }
}

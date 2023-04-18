import java.util.Objects;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Integer count = sc.nextInt();

        if (count <= 0) {
            System.err.println("Error count < 0");
            System.exit(-1);
        }

        Object ob = new Object();

        Thread MyThread = new Thread(new MyThread(ob, count));
        Thread MyThread2 = new Thread(new MyThread2(ob, count));

        MyThread.start();
        MyThread2.start();

    }
}

class MyThread implements Runnable {
    private Integer count_ = 0;
    private Object object_;

    MyThread(Object object, Integer count) {count_ = count; object_= object;}
    public void run() {
        for (int i = 0; i < count_; i++) {
            synchronized (object_) {
            System.out.println("Hen");
            object_.notify();
                try {
                    object_.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

class MyThread2 implements Runnable{
    private Integer count_ = 0;
    private Object object_;
    MyThread2(Object object, Integer count) {count_ = count; object_= object;}
    public void run() {
        for (int i = 0; i < count_; i++) {
            synchronized (object_) {
                System.out.println("Egg");
                object_.notify();
                try {
                    object_.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

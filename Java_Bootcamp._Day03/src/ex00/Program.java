import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Program {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Integer count = sc.nextInt();

        if (count <= 0) {
            System.err.println("Error count < 0");
            System.exit(-1);
        }
        MyThread tr = new MyThread(count);
        tr.start();

        MyThread2 tr2 = new MyThread2(count);
        tr2.start();

        tr.join();
        tr2.join();

        for (int i = 0; i < count; i++) {
            System.out.println("Human");
        }
    }
}

class MyThread extends Thread {

    private Integer count = 0;

    public MyThread(Integer count) {
        this.count = count;
    }

    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println("Hen");
        }
    }
}

class MyThread2 extends Thread {
    private Integer count = 0;

    public MyThread2(Integer count) {
        this.count = count;
    }
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println("Egg");
        }
    }
}

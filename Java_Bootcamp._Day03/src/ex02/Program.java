import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        int arraySize = Integer.parseInt(args[0].substring(12));
        int threadsCount = Integer.parseInt(args[1].substring(15));

        int[] array = createArray(arraySize);

        SumThread[] threads = new SumThread[threadsCount];
        for (int i = 0; i < threadsCount; i++) {
            threads[i] = new SumThread(array, i * arraySize / threadsCount, (i + 1) * arraySize / threadsCount);
            threads[i].start();
        }

        for (int i = 0; i < threadsCount; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int totalSum = 0;
        for (int i = 0; i < threadsCount; i++) {
            totalSum += threads[i].getSum();
            System.out.println("Thread " + (i + 1) + ": from " + (i * arraySize / threadsCount) + " to " + ((i + 1) * arraySize / threadsCount - 1) + " sum is " + threads[i].getSum());
        }

        int expectedSum = sum(array);
        System.out.println("Sum: " + totalSum);
        System.out.println("Expected sum: " + expectedSum);
        System.out.println("Is correct: " + (totalSum == expectedSum));
    }

    private static int[] createArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 20);
        }
        return array;
    }

    private static int sum(int[] array) {
        return Arrays.stream(array).sum();
    }
    
    private static class SumThread extends Thread {
        private int[] array;
        private int start;
        private int end;
        private int sum;

        public SumThread(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        public void run() {
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
        }

        public int getSum() {
            return sum;
        }
    }
}

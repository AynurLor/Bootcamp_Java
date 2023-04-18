public class Program {
    private static volatile Integer count = 0;
    public static void main(String[] args) throws InterruptedException {
        SiteReader file = new SiteReader();
        file.parseFile();
        count = file.getContains().size();
        if (count <= 0) {
            System.err.println("illegalArgument");
            System.exit(-1);
        }
        int threadsCount = Integer.parseInt(args[0].substring("--threadsCount=".length()));
        SumThread[] threads = new SumThread[threadsCount+1];
        for (int i = 1; i < threadsCount+1; i++) {
            threads[i] = new SumThread();
            threads[i].setThread(i);
            threads[i].start();
        }

        for (int i = 1; i < threadsCount+1; i++) {
            threads[i].join();
        }
    }
    private static class SumThread extends Thread {
        private Integer thread = 1;
        public Integer getThread() {
            return thread;
        }
        public void setThread(Integer thread) {
            this.thread = thread;
        }
        @Override
        public void run() {
            while (count > 0) {
                Integer tmp = count;
                count--;
                System.out.format("Thread-%d start download file number %d\n", thread, tmp);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.format("Thread-%d finish download file number %d\n", thread, tmp);
            }
        }
    }
}


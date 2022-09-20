package lecture09.multithread;

public class Multi {
    public static void main(String[] args) {
        Mono.fillArray();

        MyThread m1 = new MyThread(0, Mono.numbers.length / 2);
        MyThread m2 = new MyThread(Mono.numbers.length / 2, Mono.numbers.length);

        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        System.out.printf("total sum = %d\n", m1.sum + m2.sum);
        System.out.printf("mono total sum = %d\n", Mono.findSum());

    }

    static class MyThread implements Runnable {

        int start;
        int end;
        long sum;

        public MyThread(int start, int end) {
            this.start = start;
            this.end = end;
            sum = 0;
        }

        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                sum += Mono.numbers[i];
            }

            System.out.printf("%s: I'm finish the addition!!\n", Thread.currentThread().getName());
        }
    }
}

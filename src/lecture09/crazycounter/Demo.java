package lecture09.crazycounter;

public class Demo {
    public static void main(String[] args) {
        MyCounter m1 = new MyCounter("counter 1");
        MyCounter m2 = new MyCounter("counter 2");

        m1.start();
        m2.start();

        try {
            m1.join();
            m2.join();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(MyCounter.counter);
    }
}

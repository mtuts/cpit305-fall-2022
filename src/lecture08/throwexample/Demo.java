package lecture08.throwexample;

public class Demo {
    public static void main(String[] args) {
        try {
            long x = factorial(10);

            System.out.println(x);
        } catch (RuntimeException e) {
            System.out.println("Process complete");
        }
    }

    public static long factorial(int x) {
        if (x <= 0) {
            return 1;
        }

        if (x == 5) {
            throw new RuntimeException("Reach 5");
        }

        return x * factorial(x - 1);
    }
}

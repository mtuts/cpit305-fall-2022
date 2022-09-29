package lecture09.multithread;

public class Mono {
    static int[] numbers = new int[100000];
    public static void main(String[] args) {
        fillArray();
        long sum = findSum();

        System.out.printf("Sum: %d\n", sum);
    }

    public static void fillArray() {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 100000);
        }
    }

    public static long findSum() {
        long sum = 0;
        for (int i : numbers) {
            // System.out.println(i);
            sum += i;
        }
        return sum;
    }
}

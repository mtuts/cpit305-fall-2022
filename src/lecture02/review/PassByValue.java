package lecture02.review;

public class PassByValue {
    public static void main(String[] args) {
        int i = 8;
        System.out.printf("before i = %d\n", i);
        doubleit(i);
        System.out.printf("after i = %d\n", i);

    }

    public static void doubleit(int i) {
        i = i * 2;
        System.out.printf("inside doubleit i = %d\n", i);
    }
}

package lecture08.finallyexample;

public class Demo {
    public static void main(String[] args) {
        int x = multi(9);

        System.out.println(x);
    }

    static int multi(int x) {
        try {
            System.out.println("try block has been processed!");
            x = x - 1;
            return x;
        } finally {
            x = x + 2;
            return x;
        }

        
    }
}

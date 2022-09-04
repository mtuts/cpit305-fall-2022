package lecture02.review;

public class Demo2 {
    public static void main(String[] args) {
        int x = 5;
        int result = pow(x);
        System.out.printf("%d ^ 2 = %d\n", x, result);
        
        x = 4;
        int e = 5;
        result = pow(x, e);
        System.out.printf("%d ^ %d = %d\n", x, e, result);
        

        System.out.println(Day.dayOfWeek[0]);


        Animal a = new Cat();
    }

    public static int pow(int b) {
        return b * b;
    }

    public static int pow(int b, int e) {
        return (int)Math.pow(b, e);
    }
}

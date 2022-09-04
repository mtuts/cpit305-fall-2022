package lecture02.review;

public class PassByRefrence {
    public static void main(String[] args) {
        MyNumber m = new MyNumber(8);
        System.out.printf("before m.value = %d\n", m.value);
        doubleIt(m);
        System.out.printf("after m.value = %d\n", m.value);
    }

    public static void doubleIt(MyNumber num) {
        num.value = num.value * 2;
    }
}

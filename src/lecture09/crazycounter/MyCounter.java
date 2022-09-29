package lecture09.crazycounter;

public class MyCounter extends Thread {

    public static int counter = 0;
    private String name;

    public MyCounter(String name) {
        this.name = name;
    }
    

    @Override
    public void run() {
        for (int i = 0; i < 1000_000; i++) {
            counter += 1;
        }

        System.out.printf("%s: I'm finish!!\n", name);
    }
}

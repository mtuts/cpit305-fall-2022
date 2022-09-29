package lecture08.custom_exception;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        String str1 = readLine();
        
        if (str1.isEmpty()) {
            throw new EmptyStringException();
        }
        System.out.println(str1);
    }

    private static String readLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int c = System.in.read();
            if (c == '\r' || c == '\n') break;
            sb.append((char)c);
        }
        return sb.toString();
    }
}

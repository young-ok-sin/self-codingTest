import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String text = "WelcomeToSMUPC";
        int idx = (n - 1) % 14;
        System.out.println(text.charAt(idx));
    }
}

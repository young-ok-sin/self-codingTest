import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String line = br.readLine();
            int a = line.charAt(0) - '0';
            int b = line.charAt(2) - '0';
            System.out.println(a+b);
        }
    }
}

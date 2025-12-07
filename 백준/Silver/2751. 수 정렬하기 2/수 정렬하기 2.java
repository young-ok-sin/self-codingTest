import java.io.*;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        
        boolean[] exist = new boolean[2000001];

        for (int i = 0; i < N; i++) {
            exist[Integer.parseInt(br.readLine()) + 1000000] = true;
        }

        for (int i = 0; i <= 2000000; i++) {
            if (exist[i]) {
                sb.append(i - 1000000).append('\n');
            }
        }

        System.out.print(sb);
    }
}

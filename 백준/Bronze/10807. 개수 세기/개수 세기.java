import java.io.*;
import java.util.*;

public class Main {
    static int n, v;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        v = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            if (arr[i] == v) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
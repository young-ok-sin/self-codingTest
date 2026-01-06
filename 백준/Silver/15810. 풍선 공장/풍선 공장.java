import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        long start = 0;
        long end = 1000000000000L;
        long ret = end;

        while (start <= end) {
            long mid = (start + end) / 2;

            long cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += mid / arr[i];
            }

            if (cnt >= m) {
                ret = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(ret);
    }
}
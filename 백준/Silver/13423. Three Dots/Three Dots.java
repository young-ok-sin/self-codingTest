import java.io.*;
import java.util.*;

public class Main {
    static int n,cnt;
    static int[] arr;
    static HashSet<Integer> set;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());
        for(int t = 1; t <= test_case; t++){
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new int[n];
            set = new HashSet<>();
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                set.add(arr[i]);
            }
            Arrays.sort(arr);
            cnt = 0;
            for(int i = 0; i < n; i++){
                for(int j = i+1; j < n; j++){
                    int ret = (arr[j] - arr[i]);
                    if(set.contains(arr[j] + ret)){
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, cnt;
    static long arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        for(int i = 0; i < N; i++){
            long target = arr[i];
            int left = 0;
            int right = N - 1;

            while(left < right){
                if(left == i){
                    left++;
                    continue;
                }
                if(right == i){
                    right--;
                    continue;
                }
                long sum = arr[left] + arr[right];

                if(sum == target){
                    cnt++;
                    break;
                }
                else if(sum < target)   left++;
                else right--;
                }
            }
        System.out.println(cnt);
        }
    }

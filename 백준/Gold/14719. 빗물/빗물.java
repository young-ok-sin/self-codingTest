import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int W, H;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W= Integer.parseInt(st.nextToken());

        arr = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] leftMax = new int[W];
        int[] rightMax = new int[W];

        leftMax[0] = arr[0];
        for(int i = 1; i < W; i++){
            leftMax[i] = Math.max(leftMax[i-1], arr[i]);
        }

        rightMax[W-1] = arr[W-1];
        for(int i = W - 2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i+1], arr[i]);
        }
        int ret = 0;
        for(int i = 0; i < W; i++){
            ret += Math.max(0, Math.min(leftMax[i], rightMax[i])-arr[i]);
        }
        System.out.println(ret);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];

        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());//위치
            arr[i][1] = Integer.parseInt(st.nextToken());//높이
        }
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));
        int maxH = 0;
        for(int i = 0; i < n; i++){
            maxH = Math.max(maxH, arr[i][1]);
        }
        int leftIdx = -1;
        int rightIdx = -1;
        for(int i = 0; i < n; i++){
            if(arr[i][1] == maxH){
                if(leftIdx == -1)   leftIdx = i;
                rightIdx = i;
            }
        }

        int area = 0;
        area += maxH * (arr[rightIdx][0] - arr[leftIdx][0] + 1);

        int curMax = arr[0][1];
        for(int i = 0; i < leftIdx; i++){
            curMax = Math.max(curMax, arr[i][1]);
            int width = arr[i+1][0] - arr[i][0];
            area += curMax * width;
        }

        curMax = arr[n-1][1];
        for(int i = n-1; i > rightIdx; i--){
            curMax = Math.max(curMax, arr[i][1]);
            int width = arr[i][0] - arr[i-1][0];
            area += curMax * width;
        }

        System.out.println(area);
    }
}

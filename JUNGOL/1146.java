import java.util.*;
import java.io.*;

public class 1146 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] < min){
                min = arr[i];
                idx = i;
            }
        }
        int num = 0;
        for(int i = 0; i < n-1; i++){
            int minIdx = i;

            for(int j = i+1; j < n; j++){
                if(arr[j] < arr[minIdx]){
                    minIdx = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
            for(int k = 0; k < n; k++){
                System.out.print(arr[k] + " ");
            }
            System.out.println();
        }
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[] arr1, arr2;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);
        m = Integer.parseInt(br.readLine());
        arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < m; i++){
            int left = 0;
            int right = n-1;
            boolean check = false;

            while(left <= right){
                int mid = (left + right)/2;
                if(arr2[i] < arr1[mid]) right = mid - 1;
                else if (arr2[i] > arr1[mid]) left = mid + 1;
                else {
                    sb.append(1).append("\n");
                    check = true;
                    break;
                }
            }
            if(!check)  sb.append(0).append("\n");
        }
        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, std;
    static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new boolean[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = st.nextToken().equals("1");
        }
        std = Integer.parseInt(br.readLine());
        for(int i = 0; i < std; i++){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if(gender == 1) men(num);
            else if(gender == 2) women(num);
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] ? 1 : 0);
            System.out.print(" ");
            if (i % 20 == 0) System.out.println();
        }
    }

    static void women(int num){
        arr[num] = !arr[num];
        int i = 1;
        while(num - i >= 1 && num + i <= n){
            if(arr[num + i] == arr[num - i]){
                arr[num + i] = !arr[num + i];
                arr[num - i] = !arr[num - i];
                i++;
            }
            else break;
        }
    }

    static void men(int num){
        int i = 1;
        int total;

        while((total= num * i) <= n){
            arr[total] = !arr[total];
            i++;
        }
    }
}

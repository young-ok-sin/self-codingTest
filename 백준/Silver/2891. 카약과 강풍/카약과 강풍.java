import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 팀의 수
        int s = Integer.parseInt(st.nextToken()); // 손상된 팀의 수
        int r = Integer.parseInt(st.nextToken()); // 카약 여분있는 팀의 수

        st = new StringTokenizer(br.readLine());
        int[] broken = new int[s];
        for(int i = 0; i < s; i++){
            broken[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] rest = new int[r];
        for (int i = 0; i < r; i++){
            rest[i] = Integer.parseInt(st.nextToken());
        }
        int[] boat = new int[n+1];
        Arrays.fill(boat,1);

        for(int i = 0; i < s; i++){
            boat[broken[i]]--;
        }
        for(int i = 0; i < r; i++){
            boat[rest[i]]++;
        }
        for(int i = 1; i <= n; i++){
            if(boat[i] == 0){
                if( i-1 >= 1 && boat[i-1] >= 2 ){
                    boat[i-1]--;
                    boat[i]++;
                } else if ( i+1 <= n && boat[i+1] >= 2 ) {
                    boat[i+1]--;
                    boat[i]++;
                }
            }
        }
        int ret = 0;
        for(int i = 1; i <= n; i++){
            if(boat[i] == 0){
                ret++;
            }
        }
        System.out.println(ret);
    }
}

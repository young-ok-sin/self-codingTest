import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            HashSet<String> set = new HashSet<>();

            for(int j = 0; j < n; j++){
                set.add(br.readLine());
            }

            boolean pos = true;

            for(String num : set){
                for(int len = 1; len < num.length(); len++){
                    String prefix = num.substring(0,len);
                    if(set.contains(prefix)){
                        pos = false;
                        break;
                    }
                }
                if(!pos) break;
            }
            sb.append(pos ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }
}

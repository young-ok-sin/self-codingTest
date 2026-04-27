import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken()); // 버스
        int b = Integer.parseInt(st.nextToken()); // 지하철
        
        if (a == b) {
            System.out.println("Anything");
        } else if (a < b) {
            System.out.println("Bus");
        } else {
            System.out.println("Subway");
        }
    }
}
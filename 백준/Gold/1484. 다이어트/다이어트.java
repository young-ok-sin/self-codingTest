import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int g;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        g = Integer.parseInt(br.readLine());

        long r = 2;
        long l = 1;
        boolean isFound = false;

        while(l < r){
            long dif = r * r - l * l;

            if(dif == g){
                System.out.println(r);
                isFound = true;
                r++;
            } else if (dif < g) {
                r++;
            } else{
                l++;
            }
            if (2 * r - 1 > g && l == r - 1) break;
        }
        if(!isFound){
            System.out.println(-1);
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String []arr = new String[n];

        for(int i = 0; i < n; i++){
            arr[i] = br.readLine();
            arr[i] = arr[i].toLowerCase();
        }

        for(int i = 0; i < n; i++){
            int []alpha = new int[26];
            String input = arr[i];
            for(int j = 0; j < arr[i].length(); j++){
                char a = input.charAt(j);
                if(a >= 'a' && a <= 'z'){
                    alpha[a - 'a']++;
                }
            }
            int min = Integer.MAX_VALUE;
            for(int k = 0; k < 26; k++){
                min = Math.min(min, alpha[k]);
            }
            System.out.print("Case " + (i+1) + ": ");
            if(min == 0) {
                System.out.println("Not a pangram");
            } else if(min == 1) {
                System.out.println("Pangram!");
            } else if(min == 2) {
                System.out.println("Double pangram!!");
            } else {
                System.out.println("Triple pangram!!!");
            }
        }
    }
}

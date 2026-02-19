import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String doctor = br.readLine();
        int num = 0, sum = 0;

        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == 'a')  num++;
            else if(input.charAt(i) == 'h') break;
        }
        for(int i = 0; i < doctor.length(); i++){
            if(doctor.charAt(i) == 'a')  sum++;
            else if(doctor.charAt(i) == 'h') break;
        }
        System.out.println(num >= sum? "go" : "no");
    }
}

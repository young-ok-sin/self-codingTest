import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        if(input.equals("NLCS")) System.out.println("North London Collegiate School");
        if(input.equals("BHA")) System.out.println("Branksome Hall Asia");
        if(input.equals("KIS")) System.out.println("Korea International School");
        if(input.equals("SJA")) System.out.println("St. Johnsbury Academy");

    }
}
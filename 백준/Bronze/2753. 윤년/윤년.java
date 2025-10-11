import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        boolean status = false;

        if(a % 4 == 0 && a % 100 != 0) status = true;
        else if (a % 400 == 0) {
            status = true;
        }
        System.out.println(status ? 1:0);
    }
}

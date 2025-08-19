import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int a[] = new int[n];
		int sum = 0;
		int temp = 0;
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		Arrays.sort(a);
		
		for(int i = 0; i < n; i++) {
			temp += a[i];
			sum += temp;
		}

		System.out.println(sum);
	}

}

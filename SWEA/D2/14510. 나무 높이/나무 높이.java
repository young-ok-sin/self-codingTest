import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, day, maxHeight;
	static int[] tree, gap;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			
			N = Integer.parseInt(br.readLine());
			tree = new int[N];
			gap = new int[N];
			maxHeight = -1;
			day = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N ;i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				if(tree[i] > maxHeight)	maxHeight = tree[i];
			}
			
			int one = 0;
			int two = 0;
			
			for(int i = 0; i < N; i++) {
				gap[i] = maxHeight - tree[i];
				
				if(gap[i] == 0)	continue;
				
				two += gap[i]/2;
				one += gap[i]%2;
			}
			if(two > one) {
				while(Math.abs(two - one) > 1) {
					two--;
					one += 2;
				}
			}
			
			if(one > two) {
				day = one * 2 -1;
			}else if(two > one) {
				day = two * 2;
			}else {
				day = one + two;
			}
			System.out.println("#" + test_case + " "+ day);
		}
		
	}
}
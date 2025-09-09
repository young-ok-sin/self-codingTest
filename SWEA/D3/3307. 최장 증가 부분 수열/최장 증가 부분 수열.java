import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arr[] = new int[N];
			
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int len = 0;
			int sort_arr[] = new int[N];
			
			for(int i = 0; i < N; i++) {
				int idx = Arrays.binarySearch(sort_arr, 0, len,arr[i]);
				
				if(idx < 0) { //음수 값 인덱스로 변환
					idx = -(idx+ 1) ;
				}
				sort_arr[idx] = arr[i];
				if(idx == len) len++;
			}
			
			System.out.println("#"+ test_case+" " + len);
		}

	}

}

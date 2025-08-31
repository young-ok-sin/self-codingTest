import java.util.Scanner;

public class Main {
    static int N;
    static int blue, white;
    static int arr[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N+1][N+1];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        divide(0,0,N);
        System.out.println(white +"\n" + blue);
    }
    static void divide(int r, int c, int size){
        int sum = 0;
        for(int i = r; i < r + size; i++) {
            for(int j = c; j < c + size; j++){
                sum += arr[i][j];
            }
        }
        if(sum == 0){
            ++white;
        }else if(sum == size * size) {
            ++blue;
        }else{
            int nsize = size / 2;
            divide(r,c,nsize);
            divide(r,c + nsize,nsize);
            divide(r + nsize,c,nsize);
            divide(r + nsize,c + nsize,nsize);
        }
    }
}

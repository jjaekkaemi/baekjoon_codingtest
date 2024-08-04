
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int white, blue ;
    static int n ;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for(int i = 0 ; i<n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j<n ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        find(0,0,n);
        System.out.println(white);
        System.out.println(blue);
    }
    public static void find(int r, int c, int total){
        int sum = 0 ;
        for(int i = r ; i<total+r ; i++){
            for(int j = c ; j<total+c ; j++){
                if(arr[i][j]==0){ // white

                    sum++;
                }
            }
        }
        if(sum==total*total){
            white++;
        } else if(sum==0){
            blue++;
        } else {
            int half = total/2;
            find(r, c, half);
            find(r, c+half, half);
            find(r+half, c, half);
            find(r+half, c+half, half);
        }
    }

}

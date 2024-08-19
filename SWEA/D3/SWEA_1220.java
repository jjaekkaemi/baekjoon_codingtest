import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int TEST_CASE = 10;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 1 ; t<TEST_CASE+1 ; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][n];
            int answer = 0 ;
            for(int i = 0 ; i<n ;i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j<n ; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken()); // 자석 담기
                }
            }
            for(int j = 0 ; j<n ; j++){
                int start = 0; // 이전에 어떤 자석이 있었는지 알려줄 변수
                for(int i = 0 ; i<n ;i++){
                    if(arr[i][j]==1){ // 만약 N극을 만나면 기록해놓기
                        start = 1;
                    }
                    if(arr[i][j] == 2 && start==1){ // S극일 때 이전에 N극이 있었다면 교착상태 발생!
                        answer++;
                        start = 2;

                    }
                }
            }
            System.out.printf("#%d %d\n",t,answer);
        }
    }

}
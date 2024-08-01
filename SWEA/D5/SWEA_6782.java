
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int TEST_CASE = Integer.parseInt(st.nextToken());
        for(int t = 0 ; t<TEST_CASE ; t++){
            st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken()); // long으로 값 받기
            int answer = 0 ;
            while(n!=2){ // n이 2라면 break
                if(Math.sqrt(n) - (int)Math.sqrt(n) == 0){ // 완전제곱수라면
                    n = (long) Math.sqrt(n); // 제곱해서 n에 넣어주기
                    answer++;
                } else {
                    int r = (int)Math.sqrt(n)+1; // 완전제곱수가 아니라면 제곱한 int값에서 +1을 해서
                    answer += r * r - n + 1; // 그 값의 제곱과 이 수의 차이 만큼 answer에 더해주기 (+1 횟수 줄이기)
                    n = r ; // n에 r 넣어주기
                }
            }
            System.out.printf("#%d %d\n", t+1, answer);
        }

    }
}

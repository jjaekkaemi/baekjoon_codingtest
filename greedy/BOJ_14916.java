import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int result = 0;
        while(true){
            if(n==1) { // n이 1이면 stop
                result = -1;
                break;
            }
            if(n%5==0) { // 5로 나누어지면 5로 나눈 몫으로 + 하고 stop
                result += (int)n/5;
                break;
            }
            n-=2 ; // 2씩 빼기
            result++;
        }
        System.out.println(result);
    }
}
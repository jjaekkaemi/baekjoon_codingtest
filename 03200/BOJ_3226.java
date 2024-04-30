import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int answer = 0 ;
        for(int i = 0 ; i<N ; i++){

            st = new StringTokenizer(br.readLine());
            String callStartTime = st.nextToken();
            int callTotalTime = Integer.parseInt(st.nextToken());
            String[] startTime = callStartTime.split(":");
            int hour = Integer.parseInt(startTime[0]);
            int min = Integer.parseInt(startTime[1]);
            int sumTime = min+callTotalTime;
            int HOUR = 0, OUT = 0, IN = 0;
            if(hour>=7 && hour<19){
                HOUR = 18;
                OUT = 5;
                IN = 10;
            }else{
                HOUR = 6;
                OUT = 10;
                IN = 5;
            }
            int outTime = sumTime-60;
            if(outTime>0) {
                int inTime = callTotalTime-outTime;
                if(hour==HOUR) answer += outTime*OUT;
                else answer += outTime*IN;
                answer += inTime*IN;
            }
            else answer += callTotalTime*IN;

        }
        System.out.println(answer);
    }
}
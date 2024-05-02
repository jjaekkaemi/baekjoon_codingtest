import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int calWatt(int fee){
        if (fee<=200){
            return fee/2;
        } else if (fee<=29900){
            return ((fee-200)/3)+100;
        } else if (fee<=4979900) {
            return ((fee-29900)/5)+10000;
        } else{
            return ((fee-4979900)/7)+1000000;
        }
    }
    public static int calFee(int watt){
        if(watt<=100){
            return watt*2;
        } else if(watt<=10000){
            return 100*2 + (watt-100)*3;
        } else if(watt<=1000000){
            return 100*2 + 9900*3 + (watt-10000)*5;
        } else {
            return 100*2 + 9900*3 + 990000*5 + (watt-1000000)*7;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int totalFee = Integer.parseInt(st.nextToken());
            int differFee = Integer.parseInt(st.nextToken());
            if(totalFee==0 && differFee==0) break;
            int watt = calWatt(totalFee);

            int left = 0;
            int right = watt/2;

            while(left<=right){
                int mid = (left+right)/2;
                int fee1 = calFee(mid);
                int fee2 = calFee(watt-mid);
                int diff = Math.abs(fee1-fee2);
                if(differFee<diff) {
                    left = mid + 1;
                } else if (differFee>diff) {
                    right = mid -1;
                } else{
                    System.out.println(calFee(mid));
                    break;
                }
            }
        }
    }
}
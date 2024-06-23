import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int STDUENT_NUM = 20;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i<n+1; i++){
            int result = 0;
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] arr = new int[STDUENT_NUM];
            for(int j = 0 ; j<STDUENT_NUM ; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for(int j = 0 ; j<STDUENT_NUM ; j++){
                for(int k = j+1 ; k<STDUENT_NUM ; k++){
                    if(arr[k]<arr[j]) result++; // 앞에 있는 애가 키가 더 크다면 +1 하기 !
                }
            }
            System.out.println(num+" "+result);

        }
    }
}
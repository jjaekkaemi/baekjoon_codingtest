
import java.util.*;

public class Main {
    static int[] srr; // 선택한 어레이
    static int[] arr ; // 입력받는 어레이
    static final int MAX_NUM = 9 ;
    static final int ORI_NUM = 7;
    static final int TOTAL_SUM = 100;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[MAX_NUM];
        srr = new int[MAX_NUM-ORI_NUM];
        for(int i = 0 ; i<MAX_NUM ; i++){
            arr[i] = sc.nextInt();
        }
        findMember();
        for(int i = 0 ; i<MAX_NUM ; i++){
            if(srr[0]!=i && srr[1]!=i){
                System.out.println(arr[i]);
            }
        }
    }
    public static void findMember(){
        for(int i = 0 ; i<MAX_NUM ; i++){
            srr[0] = i;
            for(int j = i+1 ; j<MAX_NUM ; j++){
                srr[1] = j;
                int sum = 0;
                for(int k = 0 ; k<MAX_NUM ; k++){
                    if(k!=srr[0] && k!=srr[1]){
                        sum+=arr[k];
                    }
                }
                if(sum==TOTAL_SUM) {
                    return;
                }
            }
        }
    }
}

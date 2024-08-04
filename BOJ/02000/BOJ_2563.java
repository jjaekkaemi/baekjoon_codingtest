
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static final int MAX_NUM = 100; // 도화지 크기
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n][2]; // 색종이 담을 어레ㅣ
        int[][] paper = new int[MAX_NUM][MAX_NUM]; // 도화지 표시할 어레이
        for(int i = 0 ; i<n ; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0 ; i<n ; i++){
            int x = arr[i][0];
            int y = arr[i][1];

            for(int j = x ; j<x+10 ; j++){ // 좌표에서 +10씩 해서 어레이에 1표시
                for(int k = y ; k<y+10 ; k++){
                    paper[j][k] = 1;
                }
            }
        }
        int sum = 0 ;
        for(int i = 0 ; i<MAX_NUM ; i++){ // 1표시한 어레이 체크
            for(int j = 0 ; j<MAX_NUM ; j++){
                if(paper[i][j]==1) {
                    sum++;
                }
            }
        }
        System.out.println(sum);

    }
}

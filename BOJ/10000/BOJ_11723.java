package bit;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int b = 0;
        int all = 0b11111111111111111111; // 1~20
        int empty = 0;
        int n = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int num = 0;
            switch (str) {
                case "add":
                    num = Integer.parseInt(st.nextToken()); // num 자릿수에 or 연산
                    b |= (1 << (num - 1));
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken()); // num 자릿수에 ~ 연산을 이용하여 and 연산하기
                    b &= ~(1 << (num - 1));
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    bw.write(((b & (1 << (num - 1))) != 0 ? 1 : 0) + "\n"); // num 번째 비트를 체크하고 출력
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    b ^= (1 << (num - 1)); // num 자릿수에 xor 연산

                    break;
                case "all":
                    b = all;
                    break;
                case "empty":
                    b = empty;
                    break;
            }
        }
        bw.flush(); // 출력 버퍼 플러시
        bw.close(); // BufferedWriter 닫기
        br.close(); // BufferedReader 닫기
    }
}

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 테스트 케이스 수 입력
        int T = sc.nextInt();

        // 각 테스트 케이스 처리
        for (int t = 1; t <= T; t++) {
            // N과 방향 입력
            int N = sc.nextInt();
            String direction = sc.next();

            // 격자 입력 받기
            int[][] board = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            // 방향에 따른 이동 처리
            switch (direction) {
                case "up":
                    board = moveUp(board, N);
                    break;
                case "down":
                    board = moveDown(board, N);
                    break;
                case "left":
                    board = moveLeft(board, N);
                    break;
                case "right":
                    board = moveRight(board, N);
                    break;
            }

            // 결과 출력
            System.out.println("#" + t);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }

        sc.close();
    }

    // 위로 밀기
    private static int[][] moveUp(int[][] board, int N) {
        // 각 열에 대해 처리
        for (int col = 0; col < N; col++) {
            int[] newCol = new int[N]; // 열을 압축해서 저장할 배열
            int index = 0; // 새 열에 값을 넣을 위치
            boolean merged = false; // 타일이 합쳐졌는지 체크

            // 위로 이동하는 로직
            for (int row = 0; row < N; row++) {
                if (board[row][col] != 0) { // 0이 아닌 타일만 처리
                    // 이전 타일과 같으면 합치기
                    if (index > 0 && newCol[index - 1] == board[row][col] && !merged) {
                        newCol[index - 1] *= 2; // 같은 숫자 타일 합치기
                        merged = true; // 이미 합쳐졌으므로 더는 합치지 않음
                    } else {
                        newCol[index] = board[row][col]; // 새로운 위치에 타일 추가
                        index++;
                        merged = false; // 합치기 가능 상태로 변경
                    }
                }
            }

            // 새로운 배열로 원래 열을 덮어쓰기
            for (int row = 0; row < N; row++) {
                board[row][col] = newCol[row];
            }
        }
        return board;
    }

    // 아래로 밀기
    private static int[][] moveDown(int[][] board, int N) {
        // 각 열에 대해 처리
        for (int col = 0; col < N; col++) {
            int[] newCol = new int[N]; // 열을 압축해서 저장할 배열
            int index = N - 1; // 아래쪽부터 값을 넣을 위치
            boolean merged = false;

            // 아래로 이동하는 로직
            for (int row = N - 1; row >= 0; row--) {
                if (board[row][col] != 0) { // 0이 아닌 타일만 처리
                    // 이전 타일과 같으면 합치기
                    if (index < N - 1 && newCol[index + 1] == board[row][col] && !merged) {
                        newCol[index + 1] *= 2; // 같은 숫자 타일 합치기
                        merged = true; // 이미 합쳐졌으므로 더는 합치지 않음
                    } else {
                        newCol[index] = board[row][col]; // 새로운 위치에 타일 추가
                        index--;
                        merged = false; // 합치기 가능 상태로 변경
                    }
                }
            }

            // 새로운 배열로 원래 열을 덮어쓰기
            for (int row = 0; row < N; row++) {
                board[row][col] = newCol[row];
            }
        }
        return board;
    }

    // 왼쪽으로 밀기
    private static int[][] moveLeft(int[][] board, int N) {
        // 각 행에 대해 처리
        for (int row = 0; row < N; row++) {
            int[] newRow = new int[N]; // 행을 압축해서 저장할 배열
            int index = 0; // 왼쪽부터 값을 넣을 위치
            boolean merged = false;

            // 왼쪽으로 이동하는 로직
            for (int col = 0; col < N; col++) {
                if (board[row][col] != 0) { // 0이 아닌 타일만 처리
                    // 이전 타일과 같으면 합치기
                    if (index > 0 && newRow[index - 1] == board[row][col] && !merged) {
                        newRow[index - 1] *= 2; // 같은 숫자 타일 합치기
                        merged = true; // 이미 합쳐졌으므로 더는 합치지 않음
                    } else {
                        newRow[index] = board[row][col]; // 새로운 위치에 타일 추가
                        index++;
                        merged = false; // 합치기 가능 상태로 변경
                    }
                }
            }

            // 새로운 배열로 원래 행을 덮어쓰기
            for (int col = 0; col < N; col++) {
                board[row][col] = newRow[col];
            }
        }
        return board;
    }

    // 오른쪽으로 밀기
    private static int[][] moveRight(int[][] board, int N) {
        // 각 행에 대해 처리
        for (int row = 0; row < N; row++) {
            int[] newRow = new int[N]; // 행을 압축해서 저장할 배열
            int index = N - 1; // 오른쪽부터 값을 넣을 위치
            boolean merged = false;

            // 오른쪽으로 이동하는 로직
            for (int col = N - 1; col >= 0; col--) {
                if (board[row][col] != 0) { // 0이 아닌 타일만 처리
                    // 이전 타일과 같으면 합치기
                    if (index < N - 1 && newRow[index + 1] == board[row][col] && !merged) {
                        newRow[index + 1] *= 2; // 같은 숫자 타일 합치기
                        merged = true; // 이미 합쳐졌으므로 더는 합치지 않음
                    } else {
                        newRow[index] = board[row][col]; // 새로운 위치에 타일 추가
                        index--;
                        merged = false; // 합치기 가능 상태로 변경
                    }
                }
            }

            // 새로운 배열로 원래 행을 덮어쓰기
            for (int col = 0; col < N; col++) {
                board[row][col] = newRow[col];
            }
        }
        return board;
    }
}

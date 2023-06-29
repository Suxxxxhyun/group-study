import java.io.*;
import java.util.*;

/** 2023.06.29 2차시도 (21:10 ~ 21:55)
 * 1차시도: bfs -> TLE -> add edge case: (board[N-1][N-1]==0 return 0;) -> solve -> 정해 아님
 * 2차시도: dfs -> fail -> debugging: canDaeGakAtPosition -> solve
 */
public class Main {

    private static final int GARO = 1;
    private static final int SERO = 2;
    private static final int DAEGAK = 3;

    private static int[][] board;
    private static int N, count;
    public static void main(String[] args) throws IOException {
        initialBoard();
        dfs(0, 1, GARO);
        System.out.println(count);
    }

    private static void dfs(int row, int col, int pipeType) {

        // base:
        if(row == N-1 && col == N-1) {
            count++;
        }

        // recur:
        // 연결된 곳: 가로->가로,  세로->세로,  대각->가로,세로  공통 -> 대각
        // 갈 수 있는 곳: pipe type마다 차지하는 위치에 벽이 있는지 확인
        if(pipeType == GARO) {
            // 가로 -> 가로
            if(canGaroAtPosition(row, col+1)) { dfs(row, col+1, GARO); }
        } else if(pipeType == SERO) {
            // 세로 -> 세로
            if(canSeroAtPosition(row+1, col)) { dfs(row+1, col, SERO); }
        } else {
            // 대각 -> 가로
            if(canGaroAtPosition(row, col+1)) { dfs(row, col+1, GARO); }
            // 대각 -> 세로
            if(canSeroAtPosition(row+1, col)) { dfs(row+1, col, SERO); }
        }
        // 대각 -> 대각
        if(canDaeGakAtPosition(row+1, col+1)) { dfs(row+1, col+1, DAEGAK); }
    }

    /// param: 파이프의 끝지점 row, col
    private static boolean canDaeGakAtPosition(int row, int col) {
        if(!isInRange(row, col)) {
            return false;
        }
        return ((board[row][col-1] == 0) && (board[row-1][col] == 0) && (board[row][col] == 0));
    }

    private static boolean canGaroAtPosition(int row, int col) {
        if(!isInRange(row, col)) {
            return false;
        }
        return board[row][col] == 0;
    }

    private static boolean canSeroAtPosition(int row, int col) {
        if(!isInRange(row, col)) {
            return false;
        }
        return board[row][col] == 0;
    }

    private static boolean isInRange(int row, int col) {
        return 0 <= row && row < N && 0 <= col && col < N;
    }

    private static void initialBoard() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int row=0; row<N; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col=0; col<N; col++) {
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }
    }
}

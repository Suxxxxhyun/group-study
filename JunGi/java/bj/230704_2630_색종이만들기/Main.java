import java.io.*;
import java.util.*;

/** 2023.07.04 (13:25 ~ )
 * 제한: 1초, 128mb
 * 입력:
 * - 한변 길이 N: 2 ~ 128
 * - board[i][j] = 0 <- 하얀색, 1 <- 파란색
 *
 * Goal: "잘라진" 하얀색 종이와 파란색 종이의 개수 구하기
 *
 * <종이자르기 규칙>
 * - 전체종이가 모두 같은 색으로 칠해져 있지 않는 경우 -> 1,2,3,4 구역으로 나눈다.
 * - 1,2,3,4 구역에 대해 재귀적으로 반복한다.
 * - 같은 색으로 칠해져있거나, 하나의 정사각형 칸이 되는 경우 재귀를 종료한다.
 *
 * Type: recursion
 *
 * [재귀 설계]
 * dfs(startRow, startCol, length)
 * base case1: 길이가 1칸인 경우
 * base case2: 현재 영역이 모두 같은 색으로 칠해져있는 경우
 *  -> 해당 영역의 개수를 1 증가 시킨다.
 * recur case: 1,2,3,4 구역
 */
public class Main {
    private static int N, whiteCount, blueCount;
    private static int[][] board;
    public static void main(String[] args) throws IOException {
        initialBoard();
        dfs(0, 0, N);
        System.out.println(whiteCount);
        System.out.println(blueCount);
    }

    private static void dfs(int startRow, int startCol, int length) {

        //check:
        boolean allSame = isAllSame(startRow, startCol, length);
        //base1, base2
        if(length == 1 || allSame) {
            if (board[startRow][startCol] == 0) {
                whiteCount++;
            } else {
                blueCount++;
            }
            return;
        }
        //recur
        //1구역
        dfs(startRow, startCol, length / 2);
        //2구역
        dfs(startRow, startCol + length / 2, length / 2);
        //3구역
        dfs(startRow + length / 2, startCol, length / 2);
        //4구역
        dfs(startRow + length / 2, startCol + length / 2, length / 2);

    }

    private static boolean isAllSame(int startRow, int startCol, int length) {
        int color = board[startRow][startCol];
        for(int row=startRow; row<startRow+length; row++) {
            for(int col=startCol; col<startCol+length; col++) {
                if(color != board[row][col]) {
                    return false;
                }
            }
        }
        return true;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2023.06.27 (풀이참고) (약 35m)
 * 입력: 행의 개수 N, 열의 개수 M: 1~50 -> O(N^4)
 * Goal: 스위치를 K번 누른 후에 켜져있는 행의 최댓값
 * <p>
 * - 각 열에 스위치가 하나씩 있다.
 * - 스위치를 누르면 그 열에 있는 모든 램프의 상태가 바뀐다.
 * - 켜져있는 행: 그 행의 램프가 모두 켜져있는 경우
 * <p>
 * ex1. [1, 0, 1, 0, 1, 0] K=2 -> 사실1
 * ex2. [0, 0] K=2 res=1, K=3 res=0 -> 사실2
 * ex3. [0, 0] -> 경우의 수를 따져보면 -> 사실3
 *      [1, 0]
 * <p>
 * 사실1. 행의 꺼져있는 램프 수 > K이면 그 행은 킬 수 없다.
 * 사실2. 행의 꺼져있는 램프 수와 K는 둘다 홀수이거나 둘다 짝수여야 그 행을 킬 수 있다.
 * 사실3. 각행의 초기 램프 상대가 다르면 각 행을 모두 킬 수 있는 방법은 없다.
 * -> 다르게 말하면, 각 행의 초기램프 상태가 같은 경우만 파악하면 된다.
 * <p>
 * 설계:
 * * 각 행을 킬 수 있는지 확인하고, 킬 수 있으면 같은 상태인 행 찾기 O(N)
 * 1. 각 행 (target)을 탐색한다.
 * 2. 현재 행이 킬 수 있는 행인지 확인한다.
 * 3. 킬 수 있으면, 다른 행 (compare)을 탐색하며 현재 행과 같은 상태인지 확인한다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);
        int[][] board = new int[N][M];
        for (int row = 0; row < N; row++) {
            String info = br.readLine();
            for (int col = 0; col < M; col++) {
                board[row][col] = info.charAt(col) - '0';
            }
        }
        int K = Integer.parseInt(br.readLine());
        int result = pro(N, M, board, K);
        System.out.println(result);
    }

    /**
     * 각 행을 킬 수 있는지 확인하고, 킬 수 있으면 같은 상태인 행 개수 찾기
     */
    private static int pro(int N, int M, int[][] board, int K) {
        int max = 0;
        //1. 각 행(target)을 탐색한다.
        for (int target = 0; target < N; target++) {
            //2. 현재 행이 킬 수 있는 행인지 확인한다.
            if (!canAllLampOn(target, board, K)) {
                continue;
            }
            //3. 킬 수 있으면, 다른 행(compare)을 탐색하며 현재행과 같은 상태인지 확인한다.
            int count = 1;
            for (int compare = target + 1; compare < N; compare++) {
                if (isSameLampState(target, compare, board)) {
                    count++;
                }
            }
            //4. 최댓값을 갱신한다.
            max = Math.max(max, count);
        }
        return max;
    }

    private static boolean isSameLampState(int target, int compare, int[][] board) {
        for (int col = 0; col < board[0].length; col++) {
            if (board[target][col] != board[compare][col]) {
                return false;
            }
        }
        return true;
    }

    private static boolean canAllLampOn(int row, int[][] board, int K) {
        //1. 행의 꺼져있는 램프 수 <= K인 경우
        int offCount = 0;
        for (int col = 0; col < board[0].length; col++) {
            if (board[row][col] == 0) {
                offCount++;
            }
        }
        //2. 행의 꺼져있는 램프 수, K가 모두 홀수이거나 모두 짝수인 경우
        return offCount <= K && offCount % 2 == K % 2;
    }
}

package Programmers;

public class PG_160585_230629 {
    static char[][] arr;

    public int solution(String[] board) {
        int answer = 1;

        arr = new char[3][3];
        int oCount = 0;
        int xCount = 0;

        // O,X 카운트
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = board[i].charAt(j);
                if (arr[i][j] == 'O') oCount++;
                if (arr[i][j] == 'X') xCount++;
            }
        }

        // 조건1. x는 o보다 많을 수 없다 || o - x = 1이 나와야 한다
        if (xCount > oCount || oCount - xCount > 1) return 0;

        // 조건2. 둘 다 이길 수 없다
        if (winner('O') > 0 && winner('X') > 0) return 0;

        // 조건3. o가 이겼다면 하나 많아야 한다 (같으면 실패)
        if (winner('O') > 0 && oCount == xCount) return 0;

        // 조건4. x가 이겼다면 o랑 같아야 한다 (다르면 실패)
        if (winner('X') > 0 && oCount != xCount) return 0;

        // 모든 조건을 뚫을경우 1 출력
        return answer;
    }

    // 승리자 파악
    static int winner(char a) {
        int winnerCount = 0;
        for (int i = 0; i < 3; i++) {
            // 가로 확인
            if (arr[i][0] == a && arr[i][1] == a && arr[i][2] == a) winnerCount++;

            // 세로 확인
            if (arr[0][i] == a && arr[1][i] == a && arr[2][i] == a) winnerCount++;
        }

        // 왼쪽 아래 대각선 확인
        if (arr[0][0] == a && arr[1][1] == a && arr[2][2] == a) winnerCount++;

        // 오른쪽 아래 대각선 확인
        if (arr[0][2] == a && arr[1][1] == a && arr[2][0] == a) winnerCount++;

        return winnerCount;
    }

}

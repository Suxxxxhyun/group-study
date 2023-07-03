package Programmers;

public class PG_68936_230703 {
    // 09:50~10:44
// 백트래킹?
    /**
     같은 숫자로 이루어지지 않은 경우 분할
     **/
        static int[] result = new int[2];

        public int[] solution(int[][] arr) {
            QuadTree(arr, 0, 0, arr.length);
            return result;
        }


        static void QuadTree(int[][] arr, int x, int y, int size) {
            // 첫값 지정 (0 or 1)
            int start = arr[x][y];

            // false일 경우 모두 같은 숫자
            boolean flag = false;

            // 다른 숫자 있는지 체크
            // 전체에서 시작해서 size/2, size/2, size/2 ... 1
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    if(start != arr[i][j]) {
                        flag = true;
                        break;
                    }
                }
            }

            // 분할정복
            if (flag) {
                // 1사분면
                QuadTree(arr, x, y, size/2);
                // 2사분면
                QuadTree(arr, x, y + size/2, size/2);
                // 3사분면
                QuadTree(arr, x + size/2, y, size/2);
                // 4사분면
                QuadTree(arr, x + size/2, y + size/2, size/2);
            } else {
                if (start == 0) result[0]++;
                else result[1]++;
            }
        }

}

package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class PG_147354_230321 {
    public static void main(String[] args) {
        int[][] data = new int[][]{{2,2,6},{1,5,10},{4,2,9},{3,8,3}};

        System.out.println(solution(data,2,2,3));
    }

    static int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[col - 1] == o2[col - 1]) {
                    return o2[0] - o1[0];
                } else {
                    return o1[col - 1] - o2[col - 1];
                }
            }
        });

        for(int i = row_begin - 1; i <= row_end - 1; i++) {
            int xor_Sum = 0;

            for(int j = 0; j < data[i].length; j++) {
                xor_Sum += data[i][j] % (i + 1);
            }
            answer ^= xor_Sum;
        }

        return answer;
    }
}

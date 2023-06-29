/** 2023.06.29 (09:06 ~ 09:32)
 *
 * type: 완탐조합
 * 설계:
 * 1. 완탐조합 구하기
 * 2. base case 도달시, sb에 기록
 */

import java.io.*;
import java.util.*;

public class Main {
    private static int k, sLength;
    private static int[] s, combiArr;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        while(initialInput()) {
            combination(-1, 0);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static boolean initialInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        if(k == 0) {
            return false;
        }
        combiArr = new int[6];
        s = new int[k];
        int idx = 0;
        while(st.hasMoreTokens()) {
            s[idx++] = Integer.parseInt(st.nextToken());
        }
        return true;
    }

    private static void combination(int idx, int count) {
        // base:
        if(count == 6) {
            appendResult();
            return;
        }
        // recur:
        for(int i=idx+1; i<k; i++) {
            combiArr[count] = s[i];
            combination(i, count + 1);
        }
    }

    private static void appendResult() {
        for(int i=0; i<combiArr.length; i++) {
            sb.append(combiArr[i]).append(" ");
        }
        sb.append("\n");
    }
}

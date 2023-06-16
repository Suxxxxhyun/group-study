package BOJ.Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14888_230616 {
    static int N;
    static int[] arr;
    static int max = -1000000000;
    static int min = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 0덧셈 1뺄셈 2곱셈 3나눗셈 순
        int[] oper = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        String temp = "";
        addOper(0, temp, oper);

        sb.append(max + "\n" + min);
        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    // 연산자 차례로 추가
    static void addOper(int cnt, String formula, int[] oper) {
        // 연산자 모두 생성 완료
        if (cnt == N-1){
            cals(formula);
        }

        // plus +
        if (oper[0] != 0) {
            oper[0]--;
            addOper(cnt+1, formula + "+", oper);
            oper[0]++;
        }
        // minus -
        if (oper[1] != 0) {
            oper[1]--;
            addOper(cnt+1, formula + "-", oper);
            oper[1]++;
        }
        // mul *
        if (oper[2] != 0) {
            oper[2]--;
            addOper(cnt+1, formula + "*", oper);
            oper[2]++;
        }
        // div /
        if (oper[3] != 0) {
            oper[3]--;
            addOper(cnt+1, formula + "/", oper);
            oper[3]++;
        }
    }

    // 수식 계산
    static void cals(String formula) {
        int result = arr[0];
        for (int i = 1; i < N; i++) {
            char oper = formula.charAt(i - 1);

            if (oper == '+'){
                result += arr[i];
            } else if (oper == '-') {
                result -= arr[i];
            } else if (oper == '*') {
                result *= arr[i];
            } else if (oper == '/') {
                result /= arr[i];
            }
        }
        if (result > max) {
            max = result;
        }
        if (result < min) {
            min = result;
        }
    }
}

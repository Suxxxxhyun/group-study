package SWEA.D3;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1229_230513 {
    static int N, M;
    static ArrayList<Integer> list;
    static String[] commendStr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 10; i++) {
            // 암호문 초기화
            list = new ArrayList<>();
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            // 그냥 입력만 받음
            M = Integer.parseInt(br.readLine());

            // 명령어 String 배열 초기화
            commendStr = br.readLine().split(" ");


            PwModify();
            sb.append(String.format("#%d ", i));
            PrintPass();
        }
        System.out.println(sb);
    }
    // 명령어 수행
    static void PwModify() {
        for (int j = 0; j < commendStr.length; j++) {
            switch (commendStr[j]) {
                case "I":
                    int startAdd = Integer.parseInt(commendStr[j + 1]);
                    int startTarg = j + 3;
                    int endTarg = startTarg + Integer.parseInt(commendStr[j + 2]) - 1;

                    for (int k = endTarg; k >= startTarg; k--) {
                        int Target = Integer.parseInt(commendStr[k]);
                        list.add(startAdd, Target);
                    }
                    break;
                case "D":
                    int startDel = Integer.parseInt(commendStr[j + 1]);
                    int cntDel = Integer.parseInt(commendStr[j + 2]);
                    for (int k = 0; k < cntDel; k++) {
                        list.remove(startDel);
                    }
                    break;
             }
        }
    }

    // 10개 항 출력
    static void PrintPass() {
        for (int j = 0; j < 10; j++) {
            sb.append(list.get(j) + " ");
        }
        sb.append("\n");
    }
}

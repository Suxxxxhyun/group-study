package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1228_230504 {
    static Queue<Integer> que;
    static ArrayList<String> list;
    static String[] commendArr;
    static String commend;
    static int commendLen, mainLen, i;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        for (i = 1; i <= 10; i++) {
            // 원본 암호문 길이
            mainLen = Integer.parseInt(br.readLine());

            // 원본 암호문 초기화
            passInit();

            // 명령어 길이
            commendLen = Integer.parseInt(br.readLine());

            // 명령어 배열로 초기화
            commend = br.readLine();
            commendArr = commend.split(" ");

            // 필요한 명령어 index 탐색
            searchIdx();

            // 명령어 수행
            Process();

            // 수정된 암호문 출력
            printPass();
        }
        System.out.println(sb);
    }
    static void passInit() throws IOException{
        list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < mainLen; j++) {
            list.add(st.nextToken());
        }
    }

    static void searchIdx() {
        que = new LinkedList<>();
        for (int j = 0; j < commendArr.length; j++) {
            if(commendArr[j].equals("I")) {
                que.add(j);
            }
        }
    }
    static void Process() {
        while (!que.isEmpty()) {
            int commendIdx = que.poll();
            int inputIdx = Integer.parseInt(commendArr[commendIdx + 1]);
            int inputLen = Integer.parseInt(commendArr[commendIdx + 2]);
            int startIdx = (commendIdx + 3);
            int endIdx = (startIdx + inputLen) - 1;

            for (int j = endIdx; j >= startIdx; j--) {
                list.add(inputIdx, commendArr[j]);
            }
        }
    }

    static void printPass() {
        sb.append(String.format("#%d ", i));
        for (int j = 0; j < 10; j++) {
            sb.append(list.get(j) + " ");
        }
        sb.append("\n");
    }
}

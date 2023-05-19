package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class SEWA_1230_230505 {
    static int N, M;
    static ArrayList<Integer> list;
    static String[] commend;
    static int startIdx, endIdx, insertIdx, deleteIdx, addIdx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10; i++) {
            list = new ArrayList<>();
            N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            while (N-- > 0) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            M = Integer.parseInt(br.readLine());
            commend = br.readLine().split(" ");
            CommendEx();

            sb.append(String.format("#%d ", i));
            for (int j = 0; j < 10; j++) {
                sb.append(list.get(j) + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void CommendEx() {
        for (int j = 0; j < commend.length; j++) {
            switch (commend[j]) {
                case "I":
                    insertIdx = Integer.parseInt(commend[j + 1]);
                    startIdx = j + 2;
                    endIdx = startIdx + Integer.parseInt(commend[startIdx]);

                    for (int i = endIdx; i > startIdx; i--) {
                        list.add(insertIdx, Integer.parseInt(commend[i]));
                    }
                    break;
                case "D":
                    deleteIdx = Integer.parseInt(commend[j + 1]);
                    startIdx = Integer.parseInt(commend[j + 2]);

                    for (int i = 0; i < startIdx; i++) {
                        list.remove(deleteIdx);
                    }
                    break;
                case "A":
                    addIdx = list.size() - 1;
                    startIdx = j + 2;
                    endIdx = startIdx + Integer.parseInt(commend[j + 1]);

                    for (int i = startIdx; i < endIdx; i++) {
                        list.add(addIdx, Integer.parseInt(commend[i]));
                    }
                    break;
            }
        }
    }
}

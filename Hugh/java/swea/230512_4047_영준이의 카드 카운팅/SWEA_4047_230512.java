package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SWEA_4047_230512 {
    static int T, start, end;
    static ArrayList<String> arr;
    static int[] numArr;
    static String S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            S = br.readLine();
            arr = new ArrayList<>();
            start = 0;
            end = 3;
            while (end <= S.length() + 1) {
                arr.add(S.substring(start, end));
                start += 3;
                end += 3;
            }
            Set<String> set = new HashSet<>(arr);
            if (set.size() != arr.size()) {
                sb.append(String.format("#%d %s\n", i, "ERROR"));
                continue;
            }

            numArr = new int[4];
            for (int j = 0; j < arr.size(); j++) {
                switch (arr.get(j).charAt(0)) {
                    case 'S':
                        numArr[0]++;
                        break;
                    case 'D':
                        numArr[1]++;
                        break;
                    case 'H':
                        numArr[2]++;
                        break;
                    case 'C':
                        numArr[3]++;
                        break;
                }
            }

            sb.append(String.format("#%d ", i));
            for (int j = 0; j < 4; j++) {
                sb.append(String.format("%d ", 13 - numArr[j]));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

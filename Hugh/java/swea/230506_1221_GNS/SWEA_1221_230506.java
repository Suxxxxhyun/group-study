package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1221_230506 {
    static int T;
    static String N;
    static int M;
    static int[] numArr;
    static String[] StringArr;

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            N = st.nextToken();
            M = Integer.parseInt(st.nextToken());

            StringToInt();
            Arrays.sort(numArr);
            IntToString();

            sb.append(String.format("#%d\n", i));
            for (int j = 0; j < M; j++) {
                sb.append(StringArr[j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void StringToInt() throws IOException {
        numArr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < M; j++) {
            switch (st.nextToken()) {
                case "ZRO":
                    numArr[j] = 0;
                    break;
                case "ONE":
                    numArr[j] = 1;
                    break;
                case "TWO":
                    numArr[j] = 2;
                    break;
                case "THR":
                    numArr[j] = 3;
                    break;
                case "FOR":
                    numArr[j] = 4;
                    break;
                case "FIV":
                    numArr[j] = 5;
                    break;
                case "SIX":
                    numArr[j] = 6;
                    break;
                case "SVN":
                    numArr[j] = 7;
                    break;
                case "EGT":
                    numArr[j] = 8;
                    break;
                case "NIN":
                    numArr[j] = 9;
                    break;

            }
        }
    }

    static void IntToString() {
        StringArr = new String[M];

        for (int j = 0; j < M; j++) {
            switch (numArr[j]) {
                case 0:
                    StringArr[j] = "ZRO";
                    break;
                case 1:
                    StringArr[j] = "ONE";
                    break;
                case 2:
                    StringArr[j] = "TWO";
                    break;
                case 3:
                    StringArr[j] = "THR";
                    break;
                case 4:
                    StringArr[j] = "FOR";
                    break;
                case 5:
                    StringArr[j] = "FIV";
                    break;
                case 6:
                    StringArr[j] = "SIX";
                    break;
                case 7:
                    StringArr[j] = "SVN";
                    break;
                case 8:
                    StringArr[j] = "EGT";
                    break;
                case 9:
                    StringArr[j] = "NIN";
                    break;

            }
        }
    }
}

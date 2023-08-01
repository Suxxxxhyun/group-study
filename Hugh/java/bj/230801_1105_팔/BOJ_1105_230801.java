package BOJ.Greedy;

import java.io.*;
import java.util.StringTokenizer;

/*
    09:28~09:49
    최대 20억
    8이 안들어가는 수 있으면 0?
    L <= R

    * 서로 자릿수 다를 경우 8이 안들어 가는 수 존재
    * 자릿수 같을경우 L의 큰 자릿수부터 8체크
    1234 4321 = 0
    8808 8880 = 2
 */
public class BOJ_1105_230801 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String L = st.nextToken();
        String R = st.nextToken();

        int cnt = 0;
        if (L.length() == R.length()) {
            for (int i = 0; i < L.length(); i++) {
                if (L.charAt(i) == R.charAt(i)) {
                    if (L.charAt(i) == '8') cnt++;
                } else {
                    break;
                }
            }
        }

        bw.write(Integer.toString(cnt));
        bw.flush();

        bw.close();
    }
}

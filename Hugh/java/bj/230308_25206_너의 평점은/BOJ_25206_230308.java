package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_25206_230308 {

    static double grades = 0.0;
    static double score = 0.0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 20; i++){
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            Double b = Double.parseDouble(st.nextToken());
            String c = st.nextToken();

            if (c.equals("P"))
                continue;

            grades += b;



            switch (c) {
                case "A+": score += (4.5 * b);
                    break;
                case "A0": score += (4.0 * b);
                    break;
                case "B+": score += (3.5 * b);
                    break;
                case "B0": score += (3.0 * b);
                    break;
                case "C+": score += (2.5 * b);
                    break;
                case "C0": score += (2.0 * b);
                    break;
                case "D+": score += (1.5 * b);
                    break;
                case "D0": score += (1.0 * b);
                    break;
                case "F": score += 0.0;
                    break;
            }
        }
        System.out.println(Math.round((score/grades)*1000000)/1000000.0);
    }
}

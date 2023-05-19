package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9020_230312_1 {
    static boolean[] prime = new boolean[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        get_prime();

        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int p = n/2;
            int q = n/2;

            while(true) {
                //두 파티션이 모두 소수일 경우
                if(prime[p] == false && prime[q] == false) {
                    sb.append(p).append(" ").append(q).append("\n");
                    break;
                }
                p--;
                q++;
            }
        }
        System.out.println(sb.toString());

    }

    //에라토스테네스의 체
    static void get_prime(){
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++){
            if(prime[i]) continue;

            for(int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }

        }
    }
}


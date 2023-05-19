package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9020_230312 {
    static boolean[] prime = new boolean[10001];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        get_prime();
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int p = n/2;
            int q = n/2;

            if(prime[p] == false){
                System.out.println(p + " " + q);
            }else{
                while(true){
                    p--;
                    q++;
                    if(prime[p] == false && prime[q] == false){
                        System.out.println(p + " " + q);
                        break;
                    }
                }
            }
        }
    }

    static void get_prime(){
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i]) continue;

            for (int j = i * i; j < prime.length; j += i){
                prime[j] = true;
            }
        }
    }
}


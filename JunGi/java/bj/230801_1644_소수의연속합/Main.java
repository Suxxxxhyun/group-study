/** 2023.08.01 (10:15 ~ 10:43 96% fail ~ 10:59 solve) (2포인터 잘못 구현)


 제한: 2초, 128mb
 입력:
 1. N: 1~4백만
 2. O(N), O(N logN)
 목표: 자연수 N을 연속된 소수의 합으로 나타낼 수 있는 경우의 수

 설계:
 1. 1 ~ 4백만 사이의 소수List 구하기
 2. 투포인터 ("연속된" 소수의 합 조건에 의해)

 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Integer> primes;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        if(target == 1) {
            System.out.println(0);
            return;
        }

        int count = pro(target);
        System.out.println(count);
    }

    private static int pro(int target) {
        //1. 1 ~ 4백만 사이의 소수List 구하기 -> O(N logN)
        initPrimesV1(target);
        //2. 투포인터 -> O(N)
        int count = twoPointer(target);
        return count;
    }

    private static int twoPointer(int target) {
        int count = 0;
        int p1 = 0;
        int p2 = 0;
        int sum = primes.get(p1);
        while(true) {
            // sum이 target보다 같은 경우
            if(sum==target) {
                count ++;
                p2 ++;
                if(p2 == primes.size()) break;
                sum += primes.get(p2);
            } else if(sum < target){// sum이 target보다 작은 경우
                p2 ++;
                if(p2 == primes.size()) break;
                sum += primes.get(p2);
            } else{// sum이 target보다 큰 경우
                sum -= primes.get(p1);
                p1 ++;
            }
        }
        return count;
    }

    private static void initPrimesV1(int target) {
        primes = new ArrayList<>();
        for(int i=1; i<=target; i++) {
            if(isPrime(i)) {
                primes.add(i);
            }
        }
    }

    private static boolean isPrime(int target) {
        if(target == 1) {
            return false;
        }
        for(int num=2; num<=Math.sqrt(target); num++) {
            if(target % num == 0) {
                return false;
            }
        }
        return true;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/** 2023.07.03 (09:31 ~ )
 * Time Complexity:
 * Goal: 손님이 먹을 수 있는 초밥 "가짓수"의 "최댓값" 구하기
 * Type:
 *
 * - 회전하는 벨트 위, 여러 종류의 초밥, 같은 종류 초밥 가능
 *
 * 행사1. 벨트의 임의의 한 위치 ~ k개 접시 "연속"해서 먹을 경우
 * 행사2. 쿠폰에 해당하는 종류의 초밥 하나 무료 제공. 벨트 위에 없을 경우, 새로 만들어 제공
 *  -> Goal에 의해, 임의의 한 위치 ~ k개에 없는 초밥종류를 먹어야 함
 *
 * ---
 * 초밥벨트: [7, 9, 7, 30, 2, 7, 9, 25]
 * ex1. k=4, d= 30
 * 시작위치 idx1: (9, 7, 30, 2) -> 4가지
 * 시작위치 idx3: (30, 2, 7, 9) -> 4가지
 * 시작위치 idx4: (2, 7, 9, 25) -> 4가지 + 1가지(쿠폰)
 *
 * ---
 * 완탐: O(N * k) -> O(30,000 * 3,000) -> O(9천만) -> 가능
 *
 * ---
 * 설계
 * * 초밥벨트는 circular array
 * 1. 시작위치 idx=0 ~ N-1 탐색 시작    O(N)
 * 2. k길이 만큼 탐색 O(K)
 * 3. Set에 기록   O(1)
 * 4. 종류개수 세기   O(1)
 *
 *
 * */
public class Main {
    private static int[] susiBelt;
    private static int N, d, k, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        initialValues(br.readLine().split(" "));
        initialBelt(br);
        int result = pro();
        System.out.println(result);
    }

    private static int pro() {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        // 시작위치 idx=0 ~ N-1 탐색 시작    O(N)
        for(int start=0; start<N; start++) {
            set.clear();
            boolean contain = false;
            for(int length=0; length<k; length++) {
                int susi = susiBelt[(start+length)%N];
                set.add(susi);
                if(susi == c) {
                    contain = true;
                }
            }
            if(contain) {
                max = Math.max(set.size(), max);
            } else {
                max = Math.max(set.size()+1, max);
            }
        }
        return max;
    }

    private static void initialBelt(BufferedReader br) throws IOException {
        susiBelt = new int[N];
        for(int susi=0; susi<N; susi++) {
            susiBelt[susi] = Integer.parseInt(br.readLine());
        }
    }

    private static void initialValues(String[] input) {
        N = Integer.parseInt(input[0]);
        d = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);
        c = Integer.parseInt(input[3]);
    }
}

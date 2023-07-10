import java.util.*;
import java.io.*;

/*** (2023.07.10) (09: 55 ~ 10:50)
 설계시작: 09:55 ~ 32m
구현시작: 10:27분 ~ 23m

 제한: 1초, 128mb
 입력:
  1. 동굴 길이 (== 장애물 개수) N (2 ~ 200,000) (짝수)
  2. 동굴 높이 H (2 ~ 500,000)
  -> O(N * logH), O(H * logN), O(N), O(H)

 goal: 개똥벌레가 파괴해야하는 "장애물의 최솟값"과 그러한 "구간의 개수" 구하기

 - 동굴 길이와 장애물 개수는 같다.
 - 동굴 높이가 H라면, 1 ~ H 구간 중 한 구간을 일직선으로 날아간다.

 - 첫 번째 장애물은 항상 송곳이다.
 - 항상 송곳과 고드름이 번갈아 등장한다.



 1. 장애물마다 구간 개수에 추가 -> O(N * M)

 길이: 50만
 1 ~ 50만 += 1

 vs
 1. 길이 개수 구하고 O(N)
 길이: 50만
 길이 50만 = 1
 2. 끝나면 길이 구간 누적합 O(N)
 -> O(2N)

 설계
 1. 고드름 길이별 개수 기록

  길이: 1  2  3  4  5
  개수: 0  2  3  2  0

 2. 송곳 길이별 개수 기록

  길이: 1  2  3  4  5
  개수: 1  1  4  1  0

 3. 고드름 구간별 개수 누적합 구하기

 길이(idx): 1  2  3  4  5
 개수:      0  2  3  2  0

 (idx 뒤에서부터)
 구간(idx): 1  2  3  4  5
 개수:      7  7  5  2  0

 (idx 뒤에서부터)
 4. 송곳 구간별 개수 누적합 구하기
 구간: 5  4  3  2  1
 개수: 7  6  5  1  0

 5. 고드름 + 송곳 누적합 합하기
 arr[i] = 고드름[i] + 송곳[N-1-i]

 6. 최솟값, 최솟값 개수 구하기
 */


public class Main {
    private static int N, H;
    private static List<Integer> ceils = new ArrayList<>();
    private static List<Integer> floors = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        H = Integer.parseInt(info[1]);

        for(int i=0; i<N; i++) {
            int length = Integer.parseInt(br.readLine());
            if(i % 2 == 0) {
                floors.add(length);
            } else {
                ceils.add(length);
            }
        }

        int[] lengthCountAboutCeils = getLengthCountAboutTarget(ceils);
        int[] lengthCountAbountFloors = getLengthCountAboutTarget(floors);

        updateCumulativeSumAboutArea(lengthCountAboutCeils);
        updateCumulativeSumAboutArea(lengthCountAbountFloors);

        int[] result = sumTarget(lengthCountAboutCeils, lengthCountAbountFloors);

        int min = Integer.MAX_VALUE;
        for(int idx = 1; idx <= H; idx++) {
            int num = result[idx];
            min = Math.min(min, num);
        }

        int count = 0;
        for(int idx = 1; idx <= H; idx++) {
            int num = result[idx];
            if(num == min) {
                count ++;
            }
        }
        System.out.println(String.format("%d %d", min, count));
    }

    private static int[] getLengthCountAboutTarget(List<Integer> target) {
        int[] lengthArr = new int[H + 1];

        for(int num = 0; num < target.size(); num ++) {
            int length = target.get(num);
            lengthArr[length] += 1;
        }
        return lengthArr;
    }

    private static void updateCumulativeSumAboutArea(int[] target) {
        for(int idx = H-2; idx >= 0; idx --) {
            target[idx] = target[idx] + target[idx + 1];
        }
    }

    private static int[] sumTarget(int[] floors, int[] ceils) {
        int[] result = new int[floors.length];
        for(int idx = 1; idx < floors.length; idx ++) {
            result[idx] = floors[idx] + ceils[floors.length - idx];
        }
        return result;
    }
}

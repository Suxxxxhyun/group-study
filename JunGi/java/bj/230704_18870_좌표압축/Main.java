import java.io.*;
import java.util.*;

/* 2023.07.04 (14:13 ~

 제한: 2초, 512mb
 입력:
 - N (1 ~ 1,000,000) -> O(N), O(N * logN)

 goal: X1, X2, .., Xn -> 각각을 압축하라
 
 <압축>
 1. Xi -> 압축 -> X'i
 2. 압축값: Xi보다 작은값을 갖는 임의의 Xj의 개수

 type: 정렬 O(N * logN)

 nums = [-10, -9, 2, 4, 4]

 nums = [999, 999, 999, 1000, 1000]


 설계:
 1. nums copy본 오름차순 정렬
 2. 압축값: idx값
 3. map에 존재하지 않으면, <num, idx> 기록하고
 4. map에 존재하면 continue
 5. nums 순회하며, num의 값에 해당하는 idx값 map에서 가져오기

 */
public class Main {
    private static int N;
    private static int[] nums, copyNums;
    private static Map<Integer, Integer> numAndZipNum = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        copyNums = new int[N];

        String[] numsInfo = br.readLine().split(" ");
        for(int num=0; num<N; num++) {
            nums[num] = Integer.parseInt(numsInfo[num]);
            copyNums[num] = Integer.parseInt(numsInfo[num]);
        }
        pro();
    }

    private static void pro() {
//        1. nums copy본 오름차순 정렬
        Arrays.sort(copyNums);
//        2. 압축값: idx값
        for(int idx=0; idx<N; idx++) {
            int num = copyNums[idx];
//        3. map에 존재하지 않으면, <num, zipNum> 기록하고
            if(!numAndZipNum.containsKey(num)) {
                int zipNum = numAndZipNum.size();
                numAndZipNum.put(num, zipNum);
            }
        }
//        5. nums 순회하며, num의 값에 해당하는 idx값 map에서 가져오기
        StringBuilder sb = new StringBuilder();
        for(int num=0; num<N; num++) {
            sb.append(numAndZipNum.get(nums[num])).append(" ");
        }
        System.out.println(sb);
    }
}

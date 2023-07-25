import java.util.*;

/** 2023.07.24 (19:04 ~ 20:13 TLE)

입력:
 1. 아파트개수 N: 1 ~ 2억
 2. 기지국설치된 아파트개수 S: 1 ~ 1만
 3. 전파도달거리 W: 1 ~ 1만
 4. 가능 시간복잡도: O(logN), O(S^2), O(S* logN)

목표: 모든 아파트에 전파를 전달하기 위해 증설해야 할 기지국의 최소 개수

---
1. n 배열을 만들지 않고 풀어야 한다.
2. 전파에 닿지 않는 아파트 개수로는 해결 못할듯.
-> 범위로 표현한다면?

---
ex1. 닿지않는 아파트: [1, 2], [6, 9]
시작지점 + W지점 설치: 2, 8
닿지않는 아파트 갱신: [9, 9]
시작지점 + W지점 설치: 9

ex2. 닿지않는 아파트: [1, 6], [12, 16]
시작지점 + W지점 설치: 3, 14
닿지않는 아파트 갱신[6, 6]
시작지점 + W지점 설치: 6

---
설계
0. 닿지않는 아파트[시작지점, 끝지점] 초기화
1. 설치지점 구하기
 - 시작지점 == 끝지점인 경우, return 시작지점
 - 시작지점 + W >= 끝지점인 경우, return 끝지점
 - 시작지점 + W < 끝지점인 경우, return 시작지점 + W
 
2. 닿지않는 아파트 갱신
 - 시작지점: 설치지점 + W + 1
 - 끝지점: 끝지점
 - 시작지점 > 끝지점 -> remove
 - else -> 갱신
*/

/** 2023.07.24 시도2 (20:36 ~ 20:50)
ref: https://small-stap.tistory.com/81

learned:
 - 가능 시간복잡도가 O(S)라면, S를 한 번만 순회하면서 해결할 수 있는 풀이를 생각할 것
 - 시간복잡도가 빡빡하고 + 유형이 생각나지 않는다면, 수학적으로 접근할 수 있는지 고민할 것

설계
0. stations을 순회하며,
1. length 구하기
2. length에 대한 기지국 설치개수 구하기
-> O(S)

*/

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        // answer = pro1(n, stations, w);
        answer = pro2(n, stations, w);
        return answer;
    }
    
    private int pro2(int n, int[] stations, int w) {
        int count = 0;
        int start = 1;
        for(int i=0; i<stations.length; i++) {
            int end = stations[i] - w - 1;
            int length = end - start + 1;
            int installCount = getInstallCount(length, w);
            count += installCount;
            // System.out.printf("start: %d, end: %d, length: %d, installCount: %d\n", start, end, length, installCount);
            start = stations[i] + w + 1;
            if(i == stations.length - 1 && start <= n) {
                length = n - start + 1;
                installCount = getInstallCount(length, w);
                count += installCount;
            }
        }
        return count;
    }
    
    private int getInstallCount(int length, int w) {
        return (int) Math.ceil((double)length / (2*w+1));
    }
    
//     private int pro1(int n, int[] stations, int w) {
//         // 0.
//         int count = 0;
//         List<int[]> remainApartRanges = initRemainApartRange(n, stations, w);    //O(S)
//         while(!remainApartRanges.isEmpty()) {
            
//             for(int i=0; i<remainApartRanges.size(); i++) {
//                 int[] apartRange = remainApartRanges.get(i);
            
//                 // 1. 설치지점 구하기
//                 int installPosition = getInstallPosition(apartRange[0], apartRange[1], w);
//                 count ++;
            
//                 // 2. 남은아파트 범위 갱신
//                 int newStart = installPosition + w + 1;
//                 int newEnd = apartRange[1];
//                 if(newStart > newEnd) {
//                     remainApartRanges.remove(i);
//                 } else {
//                     remainApartRanges.get(i)[0] = newStart;
//                     remainApartRanges.get(i)[1] = newEnd;
//                 }
//             }
//         }
//         return count;
//     }
    
//     private int getInstallPosition(int start, int end, int w) {
//         if(start == end) {
//             return end;
//         }
//         if(start + w >= end) {
//             return end;
//         }
//         return start + w;
//     }
    
//     private List<int[]> initRemainApartRange(int n, int[] stations, int w) {
//         List<int[]> remainApartRange = new ArrayList<>();
        
//         int start = 1;
//         for(int i=0; i<stations.length; i++) {
            
//             int end = stations[i] - w - 1;
//             if(isCorrectRange(start, end, n)) {
//                 remainApartRange.add(new int[] {start, end});
//             }
//             start = stations[i] + w + 1;
            
//             if(i == stations.length-1) {
//                 if(isCorrectRange(start, n, n)) {
//                     remainApartRange.add(new int[] {start, n});
//                 }   
//             }
//         }
//         // print(remainApartRange);
//         return remainApartRange;
//     }
    
//     private boolean isCorrectRange(int start, int end, int n) {
//         return start <= end && 1 <= start && end <= n;
//     }
    
//     private void print(List<int[]> list) {
//         for(int[] t: list) {
//             System.out.printf("[%d, %d]\n", t[0], t[1]);
//         }
//     }
}

/*
2023.06.20
13:25 ~ 13:38

Goal: "연속된 자연수들로" n을 표현하는 "방법의 수"
Hint: 연속된 자연수들로 구성 -> 투포인터?
Type: 투포인터 (O(N))

[투포인터 설계]
* 그림 그려놓고 left, right, 종료조건 생각 *
1. right 증가 조건은?
2. left 증가 조건은?
3. ** 종료조건은? **

arr = [1, 2, 3, 4, 5, 6, 7, ...n]
초기:  l,r
    sum=1

1) sum이 n보다 작으면 r ++
2) sum이 n보다 크면 l ++
3) sum이 n과 같으면? l ++
    -> ex. 1, 2, 3, 4, 5 = 15 -> 1에서 연속된 수로 n이 구하는 경우를 구했으니, 1은 제외대상
4) 종료조건: l > r
    -> ex. 맨 끝에 도달했을 때, sum이 n보다 같은경우임. l ++ -> l, r 역전
5) 시간복잡도: O(N)
*/

class Solution {
    public int solution(int n) {
        int answer = twoPointer(n);
        return answer;
    }
    
    private int twoPointer(int n) {
        int[] arr = initialArr(n);
        int count = 0;
        int left = 0, right = 0, sum = arr[0];
        while(left <= right) {
            if(sum < n) {
                sum += arr[++right];
            } else if(sum > n) {
                sum -= arr[left++];
            } else {
                sum -= arr[left++];
                count ++;
            }
        }
        return count;
    }
    
    private int[] initialArr(int n) {
        int[] arr = new int[n];
        for(int idx=0; idx<n; idx++) {
            arr[idx] = idx + 1;
        }
        return arr;
    }
}

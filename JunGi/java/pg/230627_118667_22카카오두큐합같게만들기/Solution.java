import java.util.*;
/*
2023.06.27 복습
10:10 ~ 10:45

goal: 각 큐의 원소 합을 같게 만들기 위해 필요한 작업의 최소 횟수

작업
 1) q1.pop -> p2.add
 2) p2.pop -> p1.add

 -> 큐의 원소들은 순서를 유지한다. 
 -> 즉, 최초 상태에서 pointer p1, p2를 움직이며 두 수합이 최초로 같은 경우를 찾으면 된다.
type: two pointer
time: O(N)
*/
class Solution {
    public long solution(int[] queue1, int[] queue2) {
        long sum = getSum(queue1, queue2);
        if(sum % 2 == 1) {
            return -1;
        }
        List<Long> nums = makeList(queue1, queue2);
        long answer = twoPointer(nums, queue1.length, sum / 2);
        return answer;
	}
    
    private long twoPointer(List<Long> nums, int queueLength, long wantSum) {
        long q1Sum = initialQ1Sum(nums, queueLength);
        long q2Sum = initialQ2Sum(nums, queueLength);
        
        int p1 = 0, p2 = queueLength-1;
        int size = nums.size();
        long count = 0;
        while(p1 < size-1 && p2 < size-1) {
            if(q1Sum < wantSum) {
                p2 ++;
                q1Sum += nums.get(p2);
                q2Sum -= nums.get(p2);
            } else if(q1Sum > wantSum) {
                q1Sum -= nums.get(p1);
                q2Sum += nums.get(p1);
                p1 ++;
            } else {
                return count;
            }
            count++;
        }
        return -1;
    }
    
    private long initialQ1Sum(List<Long> nums, int length) {
        long q1Sum = 0L;
        for(int idx=0; idx<length; idx++) {
            q1Sum += nums.get(idx);
        }
        return q1Sum;
    }
    
    private long initialQ2Sum(List<Long> nums, int length) {
        long q2Sum = 0L;
        for(int idx=length; idx<nums.size(); idx++) {
            q2Sum += nums.get(idx);
        }
        return q2Sum;
    }
    
    private List<Long> makeList(int[] q1, int[] q2) {
        List<Long> list = new ArrayList<>();
        for(int num: q1) {
            list.add((long)num);
        }
        for(int num: q2) {
            list.add((long)num);
        }
        return list;
    }
    
    // edge: 원소합 홀수인 경우
    private long getSum(int[] q1, int[] q2) {
        long sum = 0;
        for(int idx=0, n=q1.length; idx<n; idx++) {
            sum += (long) q1[idx] + (long) q2[idx];
        }
        return sum;
    }
}

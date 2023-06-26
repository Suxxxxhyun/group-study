import java.util.*;

/*
2023.06.26
09:39 ~ 10:03 (25m)

Goal: 원하는 제품을 모두 할인 받을 수 있는 회원등록 날짜의 총 일수
 - 회원등록시: 10일 유효
 - 10일간 할인 원하는 제품 모두 할인 받아야함

Type: 완탐 O(10 * 100,000)

[설계]
* 원하는품목과 개수 Map에 기록
1. discount 배열 10칸씩 순회
2. want품목이면 record에 기록
3. 모두 수량이 이치하면 count 1 증가

*/
import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int count = pro(initialMap(want, number), discount);
        return count;
    }
    
    private int pro(Map<String, Integer> wantAndNum, String[] discount) {
        int count = 0;
        //1. discount 배열 10칸씩 순회
        for(int start=0, n=discount.length; start<n-9; start++) {
            Map<String, Integer> record = new HashMap<>();
            
            for(int day=0; day<10; day++) {
                String discountItem = discount[start+day];
                //2. want 품목이면 기록한다.
                if(wantAndNum.containsKey(discountItem)) {
                    record.put(discountItem, record.getOrDefault(discountItem, 0) + 1);
                }
            }
            //3. 모두 수량이 일치하면 count 1증가한다.
            if(isAllItemDiscounted(wantAndNum, record)) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean isAllItemDiscounted(Map<String, Integer> wantAndNum, Map<String, Integer> record) {
        // 할인받은 품목 종류가 다르면 모두할인 받은게 아니다.
        if(wantAndNum.size() != record.size()) {
            return false;
        }
        // 할인받은 품목 수량이 다르면 모두할인 받은게 아니다.
        for(String key: wantAndNum.keySet()) {
            if(wantAndNum.get(key) != record.get(key)) {
                return false;
            }
        }
        return true;
    }
    
    private Map<String, Integer> initialMap(String[] want, int[] number) {
        Map<String, Integer> map = new HashMap<>();
        for(int idx=0; idx<want.length; idx++) {
            map.put(want[idx], number[idx]);
        }
        return map;
    }
}

package Level2;

import java.util.*;

//https://nack1400.tistory.com/94블로그 참조
//자바 LinkedList는 단순 연결리스트가 아닌 이중원형연결리스트로 구현되어있다. 그래서 원래대로라고하면, 캐시힛일경우, 맨앞에 요소를 추가해야하지만,
//맨 뒤에 추가해도 상관이 없다.(23라인)
class Solution17680 {

    int answer = 0;
    List<String> list = new LinkedList<String>();

    public int solution(int cacheSize, String[] cities) {

        if(cacheSize == 0){
            answer = cities.length * 5;
        } else {
            for(int i=0; i<cities.length; i++){
                String str = cities[i].toUpperCase();
                if(list.contains(str)){
                    answer += 1;
                    list.remove(str);
                    list.add(str);
                } else {
                    if(list.size() < cacheSize){
                        answer += 5;
                        list.add(str);
                    } else {
                        answer += 5;
                        list.remove(0);
                        list.add(str);
                    }
                }
            }
        }
        return answer;
    }
}
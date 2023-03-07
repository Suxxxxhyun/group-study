package Programmers;
import java.util.*;
public class Prog_17680 {
    class Solution {
        public int solution(int cacheSize, String[] cities) {
            if(cacheSize == 0)
                return cities.length * 5;

            int answer = 0;

            LinkedList<String> cache = new LinkedList<>();
            for (int i = 0; i < cities.length; i++){
                String s = cities[i].toUpperCase();
                if(cache.remove(s)){
                    answer += 1;
                    cache.add(s);
                }else{
                    answer += 5;
                    if(cache.size() >= cacheSize){
                        cache.remove(0);
                    }
                    cache.add(s);
                }
            }

            return answer;
        }
    }
}

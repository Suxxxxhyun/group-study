/*
2023.06.18
13:30 ~ 14:06 (설계:20분, 구현:14분, 디버깅:2분)
*/
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Price> stack = new Stack<>();
        
        for(int idx=0; idx<prices.length; idx++) {
            int price = prices[idx];
            int time = idx + 1;
            if(stack.isEmpty()) {
                stack.add(new Price(time, price));
            } else {
                while(!stack.isEmpty()) {
                    Price prevPrice = stack.peek();
                    // 현재가격보다, 이전가격(스택top)이 더 높다면 가격이 떨어짐.
                    if(price < prevPrice.price) {
                        stack.pop();
                        answer[prevPrice.time-1] = time - prevPrice.time;
                    } else {
                        break;
                    }
                }
                stack.add(new Price(time, price));
            }
        }
        
        // 스택에 남아있는 가격들은 마지막까지 가격이 떨어지지 않은 가격들임.
        while(!stack.isEmpty()) {
            Price price = stack.pop();
            answer[price.time-1] = prices.length - price.time;
        }
        return answer;
    }
}

class Price {
    int time;
    int price;
    
    public Price(int time, int price) {
        this.time = time;
        this.price = price;
    }
    
    public String toString() {
        return "t: " + time + " p: " + price + "\n";
    }
}

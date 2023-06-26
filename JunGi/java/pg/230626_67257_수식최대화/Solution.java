import java.util.*;

/*
2023.06.26 복습1
10:05 ~ 10:47 (42m..)

Goal: 우승 시 받을 수 있는 가장 큰 금액 구하기
-> 연산자 우선순위 순열 구해서 큰 금액 갱신하기
-> 순열 + 구현문제

- 3가지 연산자: +, -, * -> 순열  ( (+,-) != (-,+))
- 연산자의 우선순위를 자유롭게 재정의
- 단, 같은 순위의 연산자는 X
- 계산된 결과는 절댓값으로 반영한다.

[설계]
1. expression에 포함된 연산자 종류 (1개~3개)에 대한 순열 구하기
 - opers = [-, *] 인경우
 - permu = [-, *], [*, -]
2. 우선순위에 맞게 연산 수행하여 결과값 갱신
 - [-, *]
 - 연산자에 맞게 계산하고 연산자 및 피연산자를 지우는 작업을 하기 위해선 리스트가 필요함
 - String expression -> list expression 파싱&변환 작업 필요
 - 지우고, 결과값 넣는 과정에서 idx 주의할 것
 
[까다로운 & 시간 오래걸린점]
1. 문자열 -> list parsing작업
*/

class Solution {
    private List<Character> operators, permuOperators;
    private List<String> express;
    private long maxResult = 0L;
    private String expression;
    public long solution(String expression) {
        this.expression = expression;
        pro(expression);
        return maxResult;
    }
    
    private void pro(String expression) {
        //1. expression에 포함된 연산자 종류(1~3개) 구하기
        initialOperators(expression);
        //2. 연산자 우선순위 순열 구하기
        permutation(0, new boolean[operators.size()]);
        //3. base도달 시, 우선순위에 맞게 결과값 구하기
    }
    
    private void permutation(int count, boolean[] visited) {
        // base:
        if(count == operators.size()) {
            //3. base도달 시, 우선순위에 맞게 결과값 구하기
            maxResult = Math.max(maxResult, calculateResult());
            return;
        }
        // recur:
        for(int idx=0; idx<operators.size(); idx++) {
            if(!visited[idx]) {
                visited[idx] = true;
                permuOperators.add(operators.get(idx));
                permutation(count+1, visited);
                visited[idx] = false;
                permuOperators.remove(count);
            }
        }
    }
    
    private long calculateResult() {
        express = stringToList(expression);
        // 우선순위에 맞게 연산을 수행한다.
        for(char c: permuOperators) {
            
            for(int idx=0; idx<express.size(); idx++) {
                if(!express.get(idx).equals(c + "")) {
                    continue;
                }
                // 연산자가 같은 경우
                //1) 결과값 구하기
                long result = 0L;
                long previous = Long.parseLong(express.get(idx-1));
                long after = Long.parseLong(express.get(idx+1));
                if(c == '+') {
                    result = previous + after;
                } else if( c== '-') {
                    result = previous - after;
                } else {
                    result = previous * after;
                }
                //2) 피연산자, 연산자 지우고 결과값 반영
                for(int i=0; i<3; i++) { express.remove(idx-1); }
                express.add(idx-1, result + "");
                //3) 인덱스 조절
                idx -= 1;
            }
        }
        return Math.abs(Long.parseLong(express.get(0)));
    }
    
    // String을 파싱하여 List로 변환
    private List<String> stringToList(String expression) {
        String[] express = expression.replaceAll("[-]", " - ")
            .replaceAll("[*]", " * ").replaceAll("[+]", " + ").split(" ");
        List<String> list = new ArrayList<>();
        for(String s: express) {
            list.add(s);
        }
        return list;
    }
    
    // expression에 포함된 연산자 종류(1~3개) 구하기
    private void initialOperators(String expression) {
        operators = new ArrayList<>();
        permuOperators = new ArrayList<>();
        for(char c: expression.toCharArray()) {
            if(!operators.contains(c) && isOperator(c)) {
                operators.add(c);
            }
        }
    }
    
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*';
    }
}

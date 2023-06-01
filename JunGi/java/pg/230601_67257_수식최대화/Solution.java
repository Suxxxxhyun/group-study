import java.util.*;
/*
유형: 순열 + 구현
시간: 45분
오래걸린이유: 문자열 parsing, String -> List<String>, base case 구현부분 디버깅
*/
class Solution {
    private List<String> originalExpress;
    private List<Character> operations;
    private char[] permuOperations;
    private long maxResult = 0L;
    public long solution(String expression) {
        initialOperations(expression);
        permuOperations = new char[operations.size()];
        initialExpress(expression);
        permutation(0, new boolean[permuOperations.length]);
        return maxResult;
    }
    
    private void initialExpress(String expression) {
        String[] nums = expression.replaceAll("[-*+]", " ").split(" ");
        String[] opers = expression.replaceAll("[0-9]+", " ").trim().split(" ");
        String[] temp = new String[nums.length + nums.length-1];
        for(int idx=0; idx<nums.length; idx++) {
            temp[idx*2] = nums[idx];
            if(idx!=nums.length-1) {
                temp[idx*2+1] = opers[idx];
            }
        }
        originalExpress = new ArrayList<>();
        for(String e: temp) {
            originalExpress.add(e);
        }
    }
    
    private void permutation(int count, boolean[] visited) {
        
        // base:
        if(count == permuOperations.length) {
            maxResult = Math.max(maxResult, calculateExpression());
            return;
        }
        // recur:
        for(int i=0; i<operations.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                permuOperations[count] = operations.get(i);
                permutation(count+1, visited);
                visited[i] = false;
                permuOperations[count] = 0;
            }
        }
    }
    
    private long calculateExpression() {
        List<String> express = copy(originalExpress);
        for(char o: permuOperations) {
            String oper = "" + o;
            for(int idx=0; idx<express.size(); idx++) {
                String curExpress = express.get(idx);
                if(!curExpress.equals(oper)) { continue; }
                long result = 0L;
                if(curExpress.equals("+")) {
                    result = Long.parseLong(express.remove(idx-1)) + Long.parseLong(express.remove(idx));
                } else if(curExpress.equals("*")) {
                    result = Long.parseLong(express.remove(idx-1)) * Long.parseLong(express.remove(idx));
                } else {
                    result = Long.parseLong(express.remove(idx-1)) - Long.parseLong(express.remove(idx));
                }
                express.remove(idx-1);
                express.add(idx-1, result + "");
                idx--;
            }
        }
        return Math.abs(Long.parseLong(express.get(0)));
    }
    
    private List<String> copy(List<String> list) {
        List<String> copy = new ArrayList<>();
        for(int i=0; i<list.size(); i++) { copy.add(list.get(i)); }
        return copy;
    }
    
    private void initialOperations(String expression) {
        operations = new ArrayList<>();
        for(char c: expression.toCharArray()) {
            if(isOperation(c) && !operations.contains(c)) {
                operations.add(c);
            }
        }
    }
    
    private boolean isOperation(char c) {
        return c=='+' || c=='*' || c=='-';
    }
}

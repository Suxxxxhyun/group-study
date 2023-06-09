import java.util.*;

/*
2023.06.09 (50m solve)

오래걸린이유:
1. parsing 
-> 모르겠어서 하드코딩함

2. 정렬 
-> 하나의 String을 구간별로 정렬을 적용하는 법을 고민하는데 오래걸림
-> 구간을 필드로 갖는 객체를 만들고,
-> implements comparable<T> + compareTo(T target) overriding해서,
-> 정렬조건에 맞게 구현하기

3. 런타임 디버깅
-> getNumberLastIdx 에서 실수가 있었음.
-> 런타임 오류시, input size를 작게/크게/edge case 넣어서 테스트해볼 것

[설계]
1. HEAD, NUMBER, TAIL parsing
2. 정렬조건에 맞게 정렬
*/


class Solution {
    public String[] solution(String[] files) {
        List<File> list = new ArrayList<>();
        for(String file: files) {
            String[] parsedInfo = parser(file);
            String head = parsedInfo[0];
            String number = parsedInfo[1];
            String tail = parsedInfo[2];
            
            list.add(new File(head, number, tail));
        }
        
        Collections.sort(list);
        String[] answer = new String[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i).toString();
        }
        return answer;
    }
    
    private String[] parser(String file) {
        int numberFirstIdx = getFirstNumIdx(file);
        String head = file.substring(0, numberFirstIdx);
        
        int numberLastIdx = getNumberLastIdx(file, numberFirstIdx);
        String number = file.substring(numberFirstIdx, numberLastIdx+1);
        
        String tail = file.substring(numberLastIdx+1, file.length());
        
        return new String[] {head, number, tail};
    }
    
    private int getNumberLastIdx(String file, int firstNumIdx){
        int lastNumIdx = firstNumIdx;
        for(int idx=firstNumIdx, count=0; idx<file.length() && count<5; idx++, count++) {
            char c = file.charAt(idx);
            if('0' <= c && c <= '9') {
                lastNumIdx = idx;
            } else {
                break;
            }
        }
        return lastNumIdx;
    }
    
    private int getFirstNumIdx(String file) {
        int minIdx = Integer.MAX_VALUE;
        for(int idx=0; idx<file.length(); idx++) {
            char c = file.charAt(idx);
            if('0' <= c && c <= '9') {
                minIdx = idx;
                break;
            }
        }
        return minIdx;
    }
}

class File implements Comparable<File> {
    String head;
    String number;
    String tail;
    
    public File(String head, String number, String tail) {
        this.head = head;
        this.number = number;
        this.tail = tail;
    }
    
    public int compareTo(File o1) {
        // 1. HEAD 부분을 기준으로 대소문자 구분없이 사전순 정렬
        if(this.head.toLowerCase().compareTo(o1.head.toLowerCase()) == 0) {
            // 2. NUMBER 숫자 순으로 정렬
            if(Integer.parseInt(this.number) - Integer.parseInt(o1.number) == 0) {
                // 3. 원래 입력에 주어진 순서 유지
                return 0;
            }
            return Integer.parseInt(this.number) - Integer.parseInt(o1.number);
        }
        return this.head.toLowerCase().compareTo(o1.head.toLowerCase());
    }
    
    public String toString() {
        return head + number + tail;
    }
}

package Level1;

//방법 1 접근) 투포인터로 풀으려고 하다가, L을 어떤식으로 처리해야하지?
//방법 2 접근) 0~9까지의 숫자를 구분자로 하여, 문자를 쪼개려고 했더니, 이렇게 되면 "one"~"nine"까지만 숫자를 만들 수 있고, 0~9까지의 숫자는 넣어줄 수가 없음.
//방법 3 접근) list를 생성해서 zero~nine까지 넣어주고, 단순 반복문으로 처리

import java.util.*;
class Solution81301 {

    //string클래스(immutable한 객체)
    //+연산자로 문자열을 추가하면, 객체를 계속해서 생성하는 꼴이므로,
    //stringbuilder이용, stringbuilder에서 만든 문자열을 초기화하고싶다면,
    //sb = new StringBuilder();보다는 sb.setLength(0)으로 길이를 0으로 바꾼다.(더 효율적)
    StringBuilder sb = new StringBuilder();
    ArrayList<String> list = new ArrayList<String>();
    //answer에 누적해서 답을 넣어주고, 최종적으로 Integer로 형변환하자.
    StringBuilder answer = new StringBuilder();

    public int solution(String s) {

        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        list.add("eight");
        list.add("nine");


        for(int i=0; i<s.length(); i++){
            char x = s.charAt(i);
            if(!(x >= '0' && x <= '9')){
                if(!list.contains(sb.toString())){
                    sb.append(x);
                } else {
                    int idx = list.indexOf(sb.toString());
                    answer.append(String.valueOf(idx));
                    sb.setLength(0);
                    sb.append(x);
                }
            } else {
                if(!sb.toString().equals("")){
                    int idx = list.indexOf(sb.toString());
                    answer.append(String.valueOf(idx));
                    sb.setLength(0);
                }
                answer.append(x);
            }
            //System.out.println(answer.toString());
        }
        if(!sb.toString().equals("")){
            int idx = list.indexOf(sb.toString());
            answer.append(String.valueOf(idx));
        }

        return Integer.parseInt(answer.toString());
    }
}
package Level3;

//https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%8C%8C%EC%9D%BC%EB%AA%85-%EC%A0%95%EB%A0%AC-Java
//블로그 참조

import java.util.*;
public class Solution17686 {
    public String[] solution(String[] files) {

        Arrays.sort(files, new Comparator<String>(){
           public int compare(String o1, String o2){
               String[] file1 = depatch(o1);
               String[] file2 = depatch(o2);

               int headValue = file1[0].compareTo(file2[0]);

               //0이라는 것은 file1[0]의 값과 file2[0]의 값이 서로 같다.
               if(headValue == 0){
                   int num1 = Integer.parseInt(file1[1]);
                   int num2 = Integer.parseInt(file2[1]);
                   return num1 - num2;
               } else {
                   return headValue;
               }
           }
        });
        return files;
    }

    public String[] depatch(String str){
        String head = "";
        String number = "";
        String tail = "";

        int idx = 0;
        for( ; idx < str.length(); idx++){
            char ch = str.charAt(idx);
            if(ch >= '0' && ch <= '9'){
                break;
            }
            head += ch;
        }

        for( ; idx < str.length(); idx++){
            char ch = str.charAt(idx);
            if(!(ch >= '0' && ch <= '9')){
                break;
            }
            number += ch;
        }

        for( ; idx < str.length(); idx++){
            char ch = str.charAt(idx);
            tail += ch;
        }

        String[] file = {head.toUpperCase(), number, tail};

        return file;
    }
}

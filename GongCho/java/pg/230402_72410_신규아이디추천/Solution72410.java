package Level1;

public class Solution72410 {

    StringBuilder ans = new StringBuilder();
    String answer = "";
    public String solution(String new_id) {

        String step1 = new_id.toLowerCase();
        System.out.println("1 = " + step1);

        for(int i=0; i<step1.length(); i++){
            char ch = step1.charAt(i);
            if((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch == '-') || (ch == '_') || (ch == '.')){
                ans.append(String.valueOf(ch));
            }
        }
        System.out.println("ans = " + ans);

        String step3 = ans.toString();
        //자바의 replace와 replaceAll의 차이는
        //String a = "무궁화 대한사람 대한사람";
        //a = a.replace("대한","민국");
        //[무궁화 민국사람 민국사람]

        //String a = "무궁화 대한사람 대한사람";
        //a = a.replaceAll("대한","민국");
        //[무궁화 민국사람 민국사람]

        //String a = "무궁화. 대한사람. 대한사람";
        //a = a.replace(".","/");
        //[무궁화/ 민국사람/ 민국사람]

        //String a = "무궁화. 대한사람. 대한사람";
        //a = a.replaceAll(".","/");
        //[//////////////]
        step3 = step3.replace("..",".");
        while(step3.contains("..")){
            step3 = step3.replace("..", ".");
        }
        System.out.println("3 = " + step3);

        String step4 = step3;
        if(step4.length() > 0){
            if(step4.charAt(0) == '.'){
                step4 = step4.substring(1,step4.length());
            }
        }

        if(step4.length() > 0){
            if(step4.charAt(step4.length()-1) == '.'){
                step4 = step4.substring(0,step4.length() - 1);
            }
        }
        System.out.println("4 = " + step4);

        String step5 = step4;
        if(step5.equals("")){
            step5 = "a";
        }
        System.out.println(step5);

        String step6 = step5;
        if(step6.length() >= 16){
            step6 = step6.substring(0,15);
        }
        if(step6.charAt(step6.length() - 1) == '.'){
            step6 = step6.substring(0,step6.length() - 1);
        }
        System.out.println(step6);

        String step7 = step6;
        if(step7.length() <= 2){
            char last = step7.charAt(step7.length()-1);
            while(step7.length() < 3){
                step7 += last;
            }
        }
        System.out.println(step7);

        answer = String.valueOf(step7);

        return answer.toString();
    }
}

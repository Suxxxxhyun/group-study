class Solution2_0319 {
    public String solution(String sentence) {
        boolean[] used = new boolean[26];// 알파벳 사용여부 
        int cnt = 0;
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<sentence.length(); i++){
            char alp = sentence.charAt(i);
            int idx = Character.toLowerCase(alp)-'a'; // 숫자로
            if(idx>=0){
                if(!used[idx]){// 처음문자
                    used[idx] =true;
                    cnt ++;
                }
            }
        }
        // 모두 사용했을경우 
        if(cnt == 26){
            answer = "perfect";
        }
        else{// 없는 알파벳 넣기
            for(int i=0; i<26; i++){
                if(!used[i]){
                    sb.append((char)(i+'a'));
                }
            }
            answer = sb.toString();
        }
        return answer;
    }
}
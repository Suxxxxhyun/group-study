import java.util.*;

class Solution {
    private Map<String, String> idAndNikname = new HashMap<>();
    public String[] solution(String[] record) {
        
        List<String> result = new ArrayList<>();
        for(String rec: record) {
            String[] recInfo = rec.split(" ");
            String order = recInfo[0];
            String id = recInfo[1];
            
            if(order.equals("Enter")) {
                String nikname = recInfo[2];
                enter(result, id, nikname);
            } else if(order.equals("Leave")) {
                leave(result, id);
            } else {
                String nikname = recInfo[2];
                change(id, nikname);
            }
        }
        String[] answer = new String[result.size()];
        convertIdToNikname(result, answer);
        return answer;
    }
    
    private void convertIdToNikname(List<String> result, String[] answer) {
        for(int i=0; i<result.size(); i++) {
            String res = result.get(i); 
            int idx = res.indexOf("님");
            String nik = res.substring(0, idx);
            answer[i] = String.format("%s님", idAndNikname.get(nik)) + res.substring(idx + 1, res.length());
        }
    }
    
    private void enter(List<String> result, String id, String nikname) {
        result.add(String.format("%s님이 들어왔습니다.", id));
        idAndNikname.put(id, nikname);
    }
    
    private void leave(List<String> result, String id) {
        result.add(String.format("%s님이 나갔습니다.", id));
    }
    
    private void change(String id, String nikname) {
        idAndNikname.put(id, nikname);
    }
}

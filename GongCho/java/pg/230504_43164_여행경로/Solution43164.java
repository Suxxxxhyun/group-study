package Programmers;

import java.util.*;
//9:53 ~ 10:20
public class Solution43164 {
  
	boolean[] visited;
	List<String> list = new ArrayList<String>();
	  
	public String[] solution(String[][] tickets) {
	      
		String ans = "ICN";
		visited = new boolean[tickets.length];
		  
		dfs(tickets, ans, "ICN", 0);
		Collections.sort(list);
		  
		return list.get(0).split(" ");
	}
	  
	void dfs(String[][] tickets, String ans, String start, int idx){
		if(idx == tickets.length){
			list.add(ans);
			return;
		}
		      
		      
		for(int i=0; i<tickets.length; i++){
			if(!visited[i] && tickets[i][0].equals(start)){
				visited[i] = true;
				dfs(tickets, ans + " " + tickets[i][1], tickets[i][1], idx + 1);
				visited[i] = false;
			}
		}
	}
}

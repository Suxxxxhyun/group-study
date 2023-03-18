package baekjun.sort;

import java.io.*;
import java.util.*;

public class Main1082502 {
	
	static int n;
	static StringTokenizer st;
	static class Student{
		int kor, eng, math;
		String name;
		
		public Student(String name, int kor, int eng, int math) {
			this.name =name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
	}
	
	static Student[] stu;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		stu = new Student[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			stu[i] = new Student(name, kor, eng, math);
		}
		
		Arrays.sort(stu, new Comparator<Student>() {
			public int compare(Student o1, Student o2) {
				if(o2.kor == o1.kor) {
					if(o1.eng == o2.eng) {
						if(o2.math == o1.math) {
							return (o1.name + o2.name).compareTo(o2.name + o1.name);
						}
						return o2.math - o1.math;
					}
					return o1.eng - o2.eng;
				}
				return o2.kor - o1.kor;
			}
		});
		
		for(int i=0; i<stu.length; i++) {
			sb.append(stu[i].name).append('\n');
		}
		System.out.println(sb);
	}

}

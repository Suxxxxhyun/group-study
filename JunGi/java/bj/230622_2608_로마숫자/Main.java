/** 2023.06.22 (15:46 ~ 15:36 + 30) (문제가 길고, 핵심을 도출해내기까지 오래걸림)
 * [유형]
 * Goal: 입력으로 주어진 두 로마수를 더한 값을 아라비아 숫자와 로마수로 출력
 * => 로마수 <--변환--> 아라비아수
 *
 * 알 수 있는 사실
 * 1. (수 -> 로마자) 현재수와 가장 근접한(이하인데 가장 가까운) 로마자부터 써야 한다.
 * ex. num = 451이라면, 현재 수 451가 가장 근접한 CD (400)을 써야함.
 * 2. (수 -> 로마자) 해당 로마자는 문제조건 3번과 2번을 만족해야 한다.
 * ** 1번에 의해 해보면, 문제조건 3번과 2번을 알아서 만족한다. ** => 이걸 파악하는게 가장 핵심
 * 
 * [수 -> 로마자 변환 설계]
 * 1. 현재 num 이하 값들 중 가장 근접한 로마자 찾기
 * 2. 해당 로마자의 값만큼 num에 반영
 * 3. num -> 0이면 종료
 * 
 * [로마자 -> 수 변환 설계]
 * * 로마자는 1글자, 2글자짜리가 있으므로 이 두경우를 모두 살펴봐야함.
 * 1. 현재 로마자의 맨앞 한글자 혹은 맨앞 두글자와 일치하는 가장 큰 로마자 찾기
 * (단, 현재 로마자가 한글자뿐이면 한글자만 고려)
 * 2. 해당 로마자의 숫자 누적합 및 현재 로마자에서 제거
 *3. 현재 로마자가 ""이면 종료
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String roma1 = br.readLine();
		String roma2 = br.readLine();

		int num1 = romaToNum(roma1);
		int num2 = romaToNum(roma2);

		int result = num1 + num2;
		String result2 = numToRoma(result);

		System.out.println(result);
		System.out.println(result2);
	}

	private static String numToRoma(int num) {
		List<Roma> romas = initialRomas();
		StringBuilder sb = new StringBuilder();
		while (num != 0) {
//			System.out.println("num: " + num);
			for (int idx = romas.size() - 1; idx >= 0; idx--) {
				if (romas.get(idx).num <= num) {
					num -= romas.get(idx).num;
					sb.append(romas.get(idx).roma);
					break;
				}
			}
		}
//		System.out.println(sb.toString());
		return sb.toString();
	}

	private static int romaToNum(String roma) {
		List<Roma> romas = initialRomas();
		int result = 0;
		while (!roma.equals("")) {
			String c1 = "";
			String c2 = "";
			// 남은 roma길이가 2이상인 경우
			if (roma.length() >= 2) {
				c1 = "" + roma.charAt(0);
				c2 = "" + roma.charAt(0) + roma.charAt(1);
				for (int idx = romas.size() - 1; idx >= 0; idx--) {
					if (romas.get(idx).roma.equals(c1)) {
						result += romas.get(idx).num;
						roma = roma.substring(1, roma.length());
						break;
					} else if (romas.get(idx).roma.equals(c2)) {
						result += romas.get(idx).num;
						roma = roma.substring(2, roma.length());
						break;
					}
				}
			} else {
				// 남은 roma길이가 1인 경우
				c1 = "" + roma.charAt(0);
				for (int idx = romas.size() - 1; idx >= 0; idx--) {
					if (romas.get(idx).roma.equals(c1)) {
						result += romas.get(idx).num;
						roma = "";
						break;
					}
				}
			}
		}
		return result;
	}

	private static List<Roma> initialRomas() {
		List<Roma> romas = new ArrayList<>();
		romas.add(new Roma("I", 1));
		romas.add(new Roma("IV", 4));
		romas.add(new Roma("V", 5));
		romas.add(new Roma("IX", 9));
		romas.add(new Roma("X", 10));
		romas.add(new Roma("XL", 40));
		romas.add(new Roma("L", 50));
		romas.add(new Roma("XC", 90));
		romas.add(new Roma("C", 100));
		romas.add(new Roma("CD", 400));
		romas.add(new Roma("D", 500));
		romas.add(new Roma("CM", 900));
		romas.add(new Roma("M", 1000));
		return romas;
	}
}

class Roma {
	String roma;
	int num;

	public Roma(String roma, int num) {
		this.roma = roma;
		this.num = num;
	}
}

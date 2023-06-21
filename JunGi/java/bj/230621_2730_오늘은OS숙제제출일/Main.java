/** 2023.06.21 3번째 시도
 * 11:43 ~ 12:53
 * fail 
 * -> 윤년 조건틀림
   -> before: ((year % 4 == 0) && (year % 100 == 0)) || (year % 400 == 0);
   -> after: ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
 */
import java.io.*;

public class Main {
	private static int[] months = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			String[] info = inputParser(br.readLine());
			String[] deadLine = dateParser(info[0]);
			String[] submit = dateParser(info[1]);

			int dMonth = Integer.parseInt(deadLine[0]);
			int dDay = Integer.parseInt(deadLine[1]);
			int dYear = Integer.parseInt(deadLine[2]);

			int sMonth = Integer.parseInt(submit[0]);
			int sDay = Integer.parseInt(submit[1]);

			// case1: 같은 날짜인 경우
			if (isSameDay(dMonth, dDay, sMonth, sDay)) {
				sb.append("SAME DAY\n");
			} else if (isSameMonth(dMonth, sMonth)) {
				// case2: 같은 월인 경우 -> // 일수 차이만 계산한다.
				int diff = dDay - sDay;
				String rangeResult = getRangeResult(sMonth, sDay, dYear, diff);
				sb.append(rangeResult);
			} else if (isPriorYearSubmit(dMonth, sMonth)) {
				// case3: 다른월. 마감월이 1월이고, 제출월이 12월인 경우 (이전해에 제출한 상황)
				int dDate = calculateDate(dYear, dMonth, dDay);
				// 이전해에 제출했으므로, 마감날짜에 이전해의 총일수를 더해준다.
				if (isYunYear(dYear - 1)) {
					dDate += 366;
				} else {
					dDate += 365;
				}
				int sDate = calculateDate(dYear - 1, sMonth, sDay);
				int diff = dDate - sDate;
				String rangeResult = getRangeResult(sMonth, sDay, dYear - 1, diff);
				sb.append(rangeResult);
			} else if (isAfterYearSubmit(dMonth, sMonth)) {
				// case4: 다른월. 마감월이 12월인 경우, 제출월이 1월인 경우 (다음해에 제출한 상황)
				int dDate = calculateDate(dYear, dMonth, dDay);
				int sDate = calculateDate(dYear + 1, sMonth, sDay);
				// 다음해에 제출했으므로, 제출날짜에 올해의 총일수를 더해준다.
				if (isYunYear(dYear)) {
					sDate += 366;
				} else {
					sDate += 365;
				}
				int diff = dDate - sDate;
				String rangeResult = getRangeResult(sMonth, sDay, dYear + 1, diff);
				sb.append(rangeResult);
			} else {
				// case5: 그외의 다른월. (같은해에 제출한 상황)
				int dDate = calculateDate(dYear, dMonth, dDay);
				int sDate = calculateDate(dYear, sMonth, sDay);
				int diff = dDate - sDate;
				String rangeResult = getRangeResult(sMonth, sDay, dYear, diff);
				sb.append(rangeResult);
			}
		}
		System.out.println(sb.toString().trim());
	}

	private static String getRangeResult(int sMonth, int sDay, int sYear, int diff) {
		if (isOutOfRange(diff)) {
			return "OUT OF RANGE\n";
		} else if (diff == 1) {
			return String.format("%d/%d/%d IS %d DAY PRIOR\n", sMonth, sDay, sYear, diff);
		} else if (diff > 0) {
			return String.format("%d/%d/%d IS %d DAYS PRIOR\n", sMonth, sDay, sYear, diff);
		} else if (diff == -1) {
			return String.format("%d/%d/%d IS %d DAY AFTER\n", sMonth, sDay, sYear, Math.abs(diff));
		}
		return String.format("%d/%d/%d IS %d DAYS AFTER\n", sMonth, sDay, sYear, Math.abs(diff));
	}

	private static int calculateDate(int year, int month, int day) {
		int date = 0;
		// 윤년은 2월이 29일까지 존재. 윤년이고, 달이 3월 이후면 date + 1
		if (isYunYear(year)) {
//			System.out.println("윤년이다.");
			if (month >= 3) {
				date += 1;
			}
		}

		for (int m = 1; m < month; m++) {
			date += months[m];
		}
		date += day;
		return date;
	}

	private static boolean isYunYear(int year) {
		return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
	}

	private static boolean isAfterYearSubmit(int dMonth, int sMonth) {
		return dMonth == 12 && sMonth == 1;
	}

	private static boolean isPriorYearSubmit(int dMonth, int sMonth) {
		return dMonth == 1 && sMonth == 12;
	}

	private static boolean isSameDay(int dMonth, int dDay, int sMonth, int sDay) {
		return (dMonth == sMonth) && (dDay == sDay);
	}

	private static boolean isSameMonth(int dMonth, int sMonth) {
		return dMonth == sMonth;
	}

	private static boolean isOutOfRange(int diff) {
		return -7 > diff || diff > 7;
	}

	private static String[] inputParser(String input) {
		String[] parsed = input.split(" ");
		return parsed;
	}

	private static String[] dateParser(String date) {
		String[] parsed = date.split("/");
		return parsed;
	}
}

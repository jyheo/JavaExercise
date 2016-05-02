package javalang;

import java.util.Calendar;

/**
 * Created by jyheo on 2016-04-25.
 * Created by yunhee on 2016-04-26.
 */

public class javalang {
    final static String input = "1, 2, 3, 4.4, 5, 6";
    final static String input2 = "A thread-safe, mutable sequence of characters. " +
            "A string buffer is like a String, but can be modified. At any point in time it contains some particular sequence of characters," +
            " but the length and content of the sequence can be changed through certain method calls.";

    @Override
    public String toString() {
         return "Hellojava";
    }

    public static void printCalendar(Calendar cal, boolean Korean) {
        // TODO: cal의 내용을 Korean이 true/false에 따라 아래와 같이 출력하기.
        if(Korean) {
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH) + 1;
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int week = cal.get(Calendar.DAY_OF_WEEK);
            int hour = cal.get(Calendar.HOUR);
            int minute = cal.get(Calendar.MINUTE);

            StringBuffer a = new StringBuffer(year + "년 " + month + "월 " + day + "일 ");
            switch(week) {
                case Calendar.SUNDAY : a.append("일요일 "); break;
                case Calendar.MONDAY : a.append("월요일 "); break;
                case Calendar.TUESDAY : a.append("화요일 "); break;
                case Calendar.WEDNESDAY : a.append("수요일 "); break;
                case Calendar.THURSDAY : a.append("목요일 "); break;
                case Calendar.FRIDAY: a.append("금요일 "); break;
                case Calendar.SATURDAY : a.append("토요일 "); break;
            }
            a.append(hour + "시 " + minute + "분")
            System.out.println(a); // StringBuffer를 이용하여 한꺼번에 출력
        }
        // true인 경우: 2016년 4월 26일 화요일 14시 12분

        else {
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH) + 1;
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int week = cal.get(Calendar.DAY_OF_WEEK);
            int hour = cal.get(Calendar.HOUR);
            int minute = cal.get(Calendar.MINUTE);

            StringBuffer a = new StringBuffer(day + "-" + month + "-" + year + " ");
            switch(week) {
                case Calendar.SUNDAY : a.append("Sun. "); break;
                case Calendar.MONDAY : a.append("Mon. "); break;
                case Calendar.TUESDAY : a.append("Tue. "); break;
                case Calendar.WEDNESDAY : a.append("Wen. "); break;
                case Calendar.THURSDAY : a.append("Tur. "); break;
                case Calendar.FRIDAY: a.append("Fri. "); break;
                case Calendar.SATURDAY : a.append("Sat. "); break;
            }
            a.append(hour + ":" + minute);
            System.out.println(a); // StringBuffer를 이용하여 한꺼번에 출력
        }
        // false인 경우: 26-4-2016 Tue. 14:12
    }

    public static void main(String[] args) {
        // StringTokenizer was deprecated! use split() of String
        String[] tokens = input.split(","); // ","를 기준으로 구분하여 배열에 저장
        float sum = 0;
        for (int i = 0; i < tokens.length; i++) {
            System.out.println(tokens[i].trim()); // 배열 내 공백을 제거하여 배열원소 하나씩 출력
        }
        for (int i = 0; i < tokens.length; i++) {
            sum += Float.parseFloat(tokens[i]); // 문자열을 float형으로 변환하여 sum에 하나씩 더해나감
        }
        // TODO: input 문자열의 숫자를 모두 합하여 sum에 넣기.
        System.out.println("sum:" + sum);

        // TODO: input2 문자열에서 .을 !로 바꾸기 Hint: String.replace()
        String new_input2 = input2; // 이 부분을 고칠 것.
        input2.replace(".", "!"); // "."을 "!"로 바꿈
        System.out.println(new_input2);

        // TODO: 아래 문장 수행결과로 HelloJava 가 출력되도록 class javalng에 메소드를 추가하기.
        System.out.println(new javalang());

        Calendar now = Calendar.getInstance();
        printCalendar(now, true);
    }
}

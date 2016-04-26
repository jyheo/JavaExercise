package javalang;

import java.util.Calendar;

/**
 * Created by jyheo on 2016-04-25.
 */

public class javalang {
    final static String input = "1, 2, 3, 4.4, 5, 6";
    final static String input2 = "A thread-safe, mutable sequence of characters. " +
            "A string buffer is like a String, but can be modified. At any point in time it contains some particular sequence of characters," +
            " but the length and content of the sequence can be changed through certain method calls.";

    public static void printCalendar(Calendar cal, boolean Korean) {
        // TODO: cal의 내용을 Korean이 true/false에 따라 아래와 같이 출력하기.
        // true인 경우: 2016년 4월 26일 화요일 14시 12분
        // false인 경우: 26-4-2016 Tue. 14:12
                Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH)+1;
        int day = now.get(Calendar.DAY_OF_MONTH);
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int min = now.get(Calendar.MINUTE);
        int week = now.get(Calendar.DAY_OF_WEEK);
        if(Korean){
            StringBuffer KrDay = new StringBuffer(year + "년 " + month + "월 " + day + "일 ");
            switch(week) {
                case Calendar.SUNDAY:
                    System.out.print("일요일");
                    break;
                case Calendar.MONDAY:
                    System.out.print("월요일");
                    break;
                case Calendar.TUESDAY:
                    System.out.print("화요일");
                    break;
                case Calendar.WEDNESDAY:
                    System.out.print("수요일");
                    break;
                case Calendar.THURSDAY:
                    System.out.print("목요일");
                    break;
                case Calendar.FRIDAY:
                    System.out.print("금요일");
                    break;
                case Calendar.SATURDAY:
                    System.out.print("토요일");
                    break;
            }
            KrDay.append(" " + hour + "시 " + min + "분");
            System.out.println(KrDay);
        }
        else {
            StringBuffer EnDay = new StringBuffer(day + "-" + month + "-" + year + " ");
            switch(week) {
                case Calendar.SUNDAY:
                    System.out.print("Sun.");
                    break;
                case Calendar.MONDAY:
                    System.out.print("Mon.");
                    break;
                case Calendar.TUESDAY:
                    System.out.print("Tue.");
                    break;
                case Calendar.WEDNESDAY:
                    System.out.print("Wed.");
                    break;
                case Calendar.THURSDAY:
                    System.out.print("Thu.");
                    break;
                case Calendar.FRIDAY:
                    System.out.print("Fri.");
                    break;
                case Calendar.SATURDAY:
                    System.out.print("Sat.");
                    break;
            }
            EnDay.append(" " + hour + ":" + min);
            System.out.println(EnDay);
        }
    }

    public String toString(){
        return "HelloJava";
    }

    public static void main(String[] args) {
        // StringTokenizer was deprecated! use split() of String
        String[] tokens = input.split(",");
        float sum = 0;
        for (int i = 0; i < tokens.length; i++) {
            System.out.println(tokens[i].trim());
            sum+= Float.parseFloat(tokens[i].trim());
        }
        // TODO: input 문자열의 숫자를 모두 합하여 sum에 넣기.
        System.out.println("sum:" + sum);

        // TODO: input2 문자열에서 .을 !로 바꾸기
        // Hint: String.replace()
        String new_input2 = input2;// 이 부분을 고칠 것.
        new_input2 = input2.replace(".", "!");
        System.out.println(new_input2);

        // TODO: 아래 문장 수행결과로 HelloJava 가 출력되도록 class javalng에 메소드를 추가하기.
        System.out.println(new javalang());

        Calendar now = Calendar.getInstance();
        printCalendar(now, true);
    }
}

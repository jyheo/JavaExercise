package javalang;

/**
 * Created by 철순 on 2016-04-26.
 */

import java.util.Calendar;

public class javalang {
    final static String input = "1, 2, 3, 4.4, 5, 6";
    final static String input2 = "A thread-safe, mutable sequence of characters. " +
            "A string buffer is like a String, but can be modified. At any point in time it contains some particular sequence of characters," +
            " but the length and content of the sequence can be changed through certain method calls.";

    public static void printCalendar(Calendar cal, boolean Korean) {
        int year = cal.get(cal.YEAR);
        int month = cal.get(cal.MONTH);
        int date = cal.get(cal.DATE);
        int week = cal.get(cal.DAY_OF_WEEK);
        int hour = cal.get(cal.HOUR);
        int minute = cal.get(cal.MINUTE);
        String K_Week[] = {"일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"};
        String E_Week[] = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

        StringBuffer print = new StringBuffer();

        if(Korean) {
            print.append(year+"년 ");
            print.append(month+"월 ");
            print.append(date+"일 ");
            print.append(K_Week[week-1]+" ");
            print.append(hour+"시 ");
            print.append(minute+"분");
        }
        else{
            print.append(date+"-"+month+"-"+year+" ");
            print.append(E_Week[week-1]+". ");
            print.append(hour+":"+minute);
        }
        System.out.println(print);
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
            sum += Float.parseFloat(tokens[i]);
        }
        System.out.println("sum:" + sum);

        String new_input2 = input2.replace(".",  "!"); // 이 부분을 고칠 것.
        System.out.println(new_input2);

        // TODO: 아래 문장 수행결과로 HelloJava 가 출력되도록 class javalng에 메소드를 추가하기.
        System.out.println(new javalang());

        Calendar now = Calendar.getInstance();
        printCalendar(now, true);
        printCalendar(now, false);
    }
}

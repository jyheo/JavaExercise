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
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        int hour = cal.get(Calendar.HOUR);
        int hourOfDay = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);


        if(Korean){
            StringBuffer sb= new StringBuffer();
            sb.append(year+"년");
            sb.append(month+"월");
            sb.append(day+"일");
            switch(dayOfWeek) {
                case Calendar.SUNDAY : sb.append("일요일"); break;
                case Calendar.MONDAY : sb.append("월요일"); break;
                case Calendar.TUESDAY : sb.append("화요일"); break;
                case Calendar.WEDNESDAY : sb.append("수요일"); break;
                case Calendar.THURSDAY : sb.append("목요일"); break;
                case Calendar.FRIDAY: sb.append("금요일"); break;
                case Calendar.SATURDAY : sb.append("토요일"); break;
            }
            sb.append(hourOfDay+"시");
            sb.append(minute+"분");
            System.out.println(sb);
        }
        else{
            StringBuffer sc= new StringBuffer();
            sc.append(day+"-");
            sc.append(month+"-");
            sc.append(year+"-");
            switch(dayOfWeek) {
                case Calendar.SUNDAY : sc.append("Sun."); break;
                case Calendar.MONDAY : sc.append("Mon."); break;
                case Calendar.TUESDAY : sc.append("Tue."); break;
                case Calendar.WEDNESDAY : sc.append("Wed."); break;
                case Calendar.THURSDAY : sc.append("Thu"); break;
                case Calendar.FRIDAY: sc.append("Fri"); break;
                case Calendar.SATURDAY : sc.append("Sat"); break;
            }
            sc.append(hour+":");
            sc.append(minute);
            System.out.println(sc);
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
        }
        for(int i=0; i < tokens.length; i++){
            sum+=Float.parseFloat(tokens[i].trim());
        }

        System.out.println("sum:" + sum);


        String new_input2 = input2.replace(".","!");
        System.out.println(new_input2);


        System.out.println(new javalang());

        Calendar now = Calendar.getInstance();
        printCalendar(now, true);
    }
}

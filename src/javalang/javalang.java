package javalang;

import java.util.Calendar;


public class javalang {
    final static String input = "1, 2, 3, 4.4, 5, 6";   //숫자모두더해 합
    final static String input2 = "A thread-safe, mutable sequence of characters. " +
            "A string buffer is like a String, but can be modified. At any point in time it contains some particular sequence of characters," +
            " but the length and content of the sequence can be changed through certain method calls.";

    @Override
    public String toString() {
        return "HelloJava";
    }

    public static void printCalendar(Calendar cal, boolean Korean) {

        if(Korean){

            StringBuffer sb=new StringBuffer("");

            sb.append(cal.get(Calendar.YEAR)+("년 "));
            sb.append(cal.get(Calendar.MONTH) + 1+("월 "));
            sb.append(cal.get(Calendar.DATE)+("일 "));
            switch(cal.get(Calendar.DAY_OF_WEEK)) {
                case Calendar.SUNDAY : sb.append("일요일 "); break;
                case Calendar.MONDAY : sb.append("월요일 "); break;
                case Calendar.TUESDAY : sb.append("화요일 "); break;
                case Calendar.WEDNESDAY : sb.append("수요일 "); break;
                case Calendar.THURSDAY : sb.append("목요일 "); break;
                case Calendar.FRIDAY:sb.append("금요일 "); break;
                case Calendar.SATURDAY :sb.append("토요일 "); break;
            }

            sb.append(cal.get(Calendar.HOUR_OF_DAY)+("시 "));
            sb.append(cal.get(Calendar.MINUTE)+("분 "));
            System.out.println(sb);
        }
        else{
            StringBuffer bs=new StringBuffer("");

            bs.append(cal.get(Calendar.DATE)+("-"));
            bs.append(cal.get(Calendar.MONTH) + 1+("-"));
            bs.append(cal.get(Calendar.YEAR)+(" "));


            int DayOfWeek=cal.get(Calendar.DAY_OF_WEEK);
            switch(DayOfWeek) {
                case Calendar.SUNDAY :bs.append("SUN. "); break;
                case Calendar.MONDAY : bs.append("MON. "); break;
                case Calendar.TUESDAY : bs.append("TUE. "); break;
                case Calendar.WEDNESDAY : bs.append("WEN. "); break;
                case Calendar.THURSDAY :bs.append("THU. "); break;
                case Calendar.FRIDAY: bs.append("FRI. "); break;
                case Calendar.SATURDAY :bs.append("SAT. "); break;
            }

            bs.append(cal.get(Calendar.HOUR_OF_DAY)+(": "));
            bs.append(cal.get(Calendar.MINUTE));
            System.out.println(bs);
        }


        // TODO: cal의 내용을 Korean이 true/false에 따라 아래와 같이 출력하기.
        // true인 경우: 2016년 4월 26일 화요일 14시 12분
        // false인 경우: 26-4-2016 Tue. 14:12
    }

    public static void main(String[] args) {
        // StringTokenizer was deprecated! use split() of String //(deprecated)스트링 토크나이저 쓰지말라고 권유
        String[] tokens = input.split(",");    //콤마를 기준으로 구분, 배열로 리턴
        float sum = 0;
        for (int i = 0; i < tokens.length; i++) {
            sum+= Float.parseFloat(tokens[i].trim());
            //문자열을 실수로 바꿔서 합구하기!!!!!중요
            //trim은 앞뒤의 공백없애라는뜻
        }
        // TODO: input 문자열의 숫자를 모두 합하여 sum에 넣기.
        System.out.println("sum:" + sum);

        // TODO: input2 문자열에서 .을 !로 바꾸기
        // Hint: String.replace()
        String new_input2 = input2.replace(".","!"); // 이 부분을 고칠 것.

        System.out.println(new_input2);

        // TODO: 아래 문장 수행결과로 HelloJava 가 출력되도록 class javalng에 메소드를 추가하기.

        System.out.println(new javalang());

        Calendar now = Calendar.getInstance();
        printCalendar(now, true);
        printCalendar(now,false);
    }
}


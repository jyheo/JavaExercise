package javalang;

import java.util.Calendar;

public class javalang {
    final static String input = "1, 2, 3, 4.4, 5, 6";
    final static String input2 = "A thread-safe, mutable sequence of characters. " +
            "A string buffer is like a String, but can be modified. At any point in time it contains some particular sequence of characters," +
            " but the length and content of the sequence can be changed through certain method calls.";

    public static void printCalendar(Calendar cal, boolean Korean) {
        StringBuffer sb = new StringBuffer();
        cal = Calendar.getInstance();
        if (Korean == true) {
            sb.append(cal.get(cal.YEAR) + "년 ");
            sb.append((cal.get(cal.MONTH) + 1) + "월 ");
            sb.append(cal.get(cal.DATE) + "일 ");
            //System.out.print(cal.get(cal.YEAR) + "년 " + (cal.get(cal.MONTH)+1) + "월 " + cal.get(cal.DATE) + "일 ");
            switch (cal.get(cal.DAY_OF_WEEK)) {
                case Calendar.SUNDAY:
                    sb.append("일요일");
                    break;
                case Calendar.MONDAY:
                    sb.append("월요일");
                    break;
                case Calendar.TUESDAY:
                    sb.append("화요일");
                    break;
                case Calendar.WEDNESDAY:
                    sb.append("수요일");
                    break;
                case Calendar.THURSDAY:
                    sb.append("목요일");
                    break;
                case Calendar.FRIDAY:
                    sb.append("금요일");
                    break;
                case Calendar.SATURDAY:
                    sb.append("토요일");
                    break;
            }
            sb.append(" ");
            sb.append(cal.get(cal.HOUR_OF_DAY) + "시 ");
            sb.append(cal.get(cal.MINUTE) + "분");

            System.out.print(sb);
        } else {
            sb.append(cal.get(cal.DATE) + "-");
            sb.append((cal.get(cal.MONTH) + 1) + "-");
            sb.append(cal.get(cal.YEAR) + " ");
            //System.out.print(cal.get(cal.YEAR) + "년 " + (cal.get(cal.MONTH)+1) + "월 " + cal.get(cal.DATE) + "일 ");
            switch (cal.get(cal.DAY_OF_WEEK)) {
                case Calendar.SUNDAY:
                    sb.append("Sun. ");
                    break;
                case Calendar.MONDAY:
                    sb.append("Mon. ");
                    break;
                case Calendar.TUESDAY:
                    sb.append("Tue. ");
                    break;
                case Calendar.WEDNESDAY:
                    sb.append("Wed. ");
                    break;
                case Calendar.THURSDAY:
                    sb.append("Thu. ");
                    break;
                case Calendar.FRIDAY:
                    sb.append("Fri. ");
                    break;
                case Calendar.SATURDAY:
                    sb.append("Sat. ");
                    break;
            }
            sb.append(cal.get(cal.HOUR_OF_DAY) + ":");
            sb.append(cal.get(cal.MINUTE));

            System.out.print(sb);
            // TODO: cal의 내용을 Korean이 true/false에 따라 아래와 같이 출력하기.
            // true인 경우: 2016년 4월 26일 화요일 14시 12분
            // false인 경우: 26-4-2016 Tue. 14:12
        }
    }

    public String toString() {
        return "HelloJava";
    }

    public static void main(String[] args) {
        // StringTokenizer was deprecated! use split() of String
        String[] tokens = input.split(",");

        float sum = 0;
        for (int i = 0; i < tokens.length; i++) {
            System.out.println(tokens[i].trim());
        }
        for(int i=0; i<tokens.length; i++){
            sum += Float.parseFloat(tokens[i]);
        }
        // TODO: input 문자열의 숫자를 모두 합하여 sum에 넣기
        System.out.println("sum:" + sum);

        // TODO: input2 문자열에서 .을 !로 바꾸기
        // Hint: String.replace()
        String new_input2 = input2.replace('.','!'); // 이 부분을 고칠 것.
        System.out.println(new_input2);

        // TODO: 아래 문장 수행결과로 HelloJava 가 출력되도록 class javalng에 메소드를 추가하기.
        System.out.println(new javalang());

        Calendar now = Calendar.getInstance();
        printCalendar(now, true);
    }
}

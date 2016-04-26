import java.util.Calendar;
/**
 * Created by jiyeon on 2016-04-26.
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

    public static void printCalendar(Calendar cal, boolean Korean) {//Calendar사용
        if (Korean) {
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH) + 1;
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int hour = cal.get(Calendar.HOUR);
            int minute = cal.get(Calendar.MINUTE);
            int week = cal.get(Calendar.DAY_OF_WEEK);
            switch(week){
                case Calendar.SUNDAY : System.out.print("일요일");break;
                case Calendar.MONDAY : System.out.print("월요일");break;
                case Calendar.TUESDAY : System.out.print("화요일");break;
                case Calendar.WEDNESDAY : System.out.print("수요일");break;
                case Calendar.THURSDAY : System.out.print("목요일");break;
                case Calendar.FRIDAY : System.out.print("금요일");break;
                case Calendar.SATURDAY : System.out.print("토요일");break;
            }
            System.out.println(year + "년" + month + "월" + day + "일" +week+""+ hour + "시" + minute + "분");
        }
    if(!Korean){
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        int week = cal.get(Calendar.DAY_OF_WEEK);
        switch(week){
            case Calendar.SUNDAY : System.out.print("SUN");break;
            case Calendar.MONDAY : System.out.print("MON");break;
            case Calendar.TUESDAY : System.out.print("TUE");break;
            case Calendar.WEDNESDAY : System.out.print("WED");break;
            case Calendar.THURSDAY : System.out.print("THR");break;
            case Calendar.FRIDAY : System.out.print("FRI");break;
            case Calendar.SATURDAY : System.out.print("SAT");break;
        }
        System.out.println(day+"-"+month+"-"+year+"."+hour +":"+ minute);
    }

        // TODO: cal의 내용을 Korean이 true/false에 따라 아래와 같이 출력하기.
        // true인 경우: 2016년 4월 26일 화요일 14시 12분
        // false인 경우: 26-4-2016 Tue. 14:12
    }

    public static void main(String[] args) {
        // StringTokenizer was deprecated! use split() of String
        String[] tokens = input.split(",");
        float sum = 0;
        for (int i = 0; i < tokens.length; i++) {

            System.out.println(tokens[i].trim());
            sum += Float.parseFloat(tokens[i]);//sum만들기
        }
        System.out.println("sum:" + sum);

        String new_input2 = input2.replace(".","!");  //.을 !로 바꾸기
        System.out.println(new_input2);


        System.out.println(new javalang());//javalang toString 이용함
        Calendar now = Calendar.getInstance();
        printCalendar(now, true);
    }
}

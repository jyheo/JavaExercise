package javalang;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by jyheo on 2016-04-25.
 */

public class javalang {
    final static String input = "1, 2, 3, 4.4, 5, 6";
    final static String input2 = "A thread-safe, mutable sequence of characters. " +
            "A string buffer is like a String, but can be modified. At any point in time it contains some particular sequence of characters," +
            " but the length and content of the sequence can be changed through certain method calls.";

    @Override
    public String toString() {
        return "Hello Java";
    }

    public static void printCalendar(Calendar cal, boolean Korean) {
        if(Korean) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 M월 d일 E요일  a hh시 mm분");
            System.out.println(sdf.format(cal.getTime()));
        }
        if(!Korean){
            SimpleDateFormat sdf = new SimpleDateFormat("d-M-yyyy E  a hh시  mm분");
            System.out.println(sdf.format(cal.getTime()));
        }
    }

    public static void main(String[] args) {
        // StringTokenizer was deprecated! use split() of String
        String[] tokens = input.split(",");
        float sum = 0;
        for (int i = 0; i < tokens.length; i++) {
           float f = Float.parseFloat(tokens[i].trim());
            sum+=f;

        }
        // TODO: input 문자열의 숫자를 모두 합하여 sum에 넣기.
        System.out.println("sum:" + sum);

        // TODO: input2 문자열에서 .을 !로 바꾸기
        // Hint: String.replace()

        String new_input2 = input2; // 이 부분을 고칠 것.
        System.out.println(new_input2.replace(".","!"));

        // TODO: 아래 문장 수행결과로 HelloJava 가 출력되도록 class javalng에 메소드를 추가하기.
          System.out.println(new javalang());

        Calendar now = Calendar.getInstance();
        printCalendar(now, true);
    }
}

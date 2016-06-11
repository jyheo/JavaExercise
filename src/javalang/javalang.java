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
         int year = cal.get(Calendar.YEAR); 
         int month = cal.get(Calendar.MONTH) + 1; 
         int day = cal.get(Calendar.DAY_OF_MONTH); 
         int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); 
         int hour = cal.get(Calendar.HOUR); 
         int hourOfDay = cal.get(Calendar.HOUR_OF_DAY); 
         int minute = cal.get(Calendar.MINUTE); 
 
 
         if(Korean){ 
             StringBuffer sb = new StringBuffer(); 
             sb.append(year + "년 "); 
             sb.append(month + "월 "); 
             sb.append(day + "일 "); 
             switch(dayOfWeek) { 
                 case Calendar.SUNDAY : sb.append("일요일 "); break; 
                 case Calendar.MONDAY : sb.append("월요일 "); break; 
                 case Calendar.TUESDAY : sb.append("화요일 "); break; 
                 case Calendar.WEDNESDAY :sb.append("수요일 "); break; 
                 case Calendar.THURSDAY : sb.append("목요일 "); break; 
                 case Calendar.FRIDAY: sb.append("금요일 "); break; 
                 case Calendar.SATURDAY : sb.append("토요일 "); break; 
             } 
             sb.append(hourOfDay + "시 "); 
             sb.append(minute + "분 "); 
             System.out.println(sb); 
         } 
 
 
         else{ 
             StringBuffer sv = new StringBuffer(); 
             sv.append(day + "-"); 
             sv.append(month + "-"); 
             sv.append(year + " "); 
             switch(dayOfWeek) { 
                 case Calendar.SUNDAY : sv.append("Sun. "); break; 
                 case Calendar.MONDAY : sv.append("Mon. "); break; 
                 case Calendar.TUESDAY : sv.append("Tue. "); break; 
                 case Calendar.WEDNESDAY : sv.append("Wed. "); break; 
                 case Calendar.THURSDAY : sv.append("Thurs. "); break; 
                 case Calendar.FRIDAY: sv.append("Fri. "); break; 
                 case Calendar.SATURDAY : sv.append("Sat. "); break; 
             } 
             sv.append(hour + ":"); 
             sv.append(minute); 
             System.out.println(sv); 
         } 
     } 
 
 
     public static void main(String[] args) { 
         // StringTokenizer was deprecated! use split() of String
	 String[] tokens = input.split(","); 
         float sum = 0; 
         for (int i = 0; i < tokens.length; i++) { 
             System.out.println(tokens[i].trim()); 
             sum+=Float.parseFloat(tokens[i].trim()); 
         }
	 // TODO: input 문자열의 숫자를 모두 합하여 sum에 넣기. 
         System.out.println("sum:" + sum); 
 
	 // TODO: input2 문자열에서 .을 !로 바꾸기 
         // Hint: String.replace() 
         String new_input2 = input2.replace(".","!"); // 이 부분을 고칠 것 
         System.out.println(new_input2); 
 
 
         // TODO: 아래 문장 수행결과로 HelloJava 가 출력되도록 class javalang에 메소드를 추가하기. 
         System.out.println(new javalang()); 
 
 
         Calendar now = Calendar.getInstance(); 
         printCalendar(now, true); 
         printCalendar(now, false); 
     } 
 } 

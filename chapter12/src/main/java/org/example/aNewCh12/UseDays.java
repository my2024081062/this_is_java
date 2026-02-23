package org.example.aNewCh12;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class UseDays {
    public void useDateClasses(){
        Date now1 = new Date();
        String str1 = now1.toString();
        System.out.println(str1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String str2 = sdf.toString();
        System.out.println(str2);
        System.out.println("--------------------------");

        Calendar now2 = Calendar.getInstance();

        int year = now2.get(Calendar.YEAR);
        int month = now2.get(Calendar.MONTH) + 1;
        int day = now2.get(Calendar.DAY_OF_MONTH);
        int week = now2.get(Calendar.DAY_OF_MONTH);

        String strWeek = switch (week){
            case Calendar.MONDAY -> "월";
            case Calendar.TUESDAY -> "화";
            case Calendar.WEDNESDAY -> "수";
            case Calendar.THURSDAY -> "목";
            case Calendar.FRIDAY -> "금";
            case Calendar.SATURDAY -> "토";
            default -> "일";
        };

        int amPm = now2.get(Calendar.AM_PM);
        String strAmPm = amPm == Calendar.AM ? "오전" : "오후";

        int hour = now2.get(Calendar.HOUR);
        int minute = now2.get(Calendar.MINUTE);
        int second = now2.get(Calendar.SECOND);

        System.out.print(year + "년 ");
        System.out.print(month + "월 ");
        System.out.println(day + "일 ");
        System.out.print(strWeek + "요일 ");
        System.out.println(strAmPm + " ");
        System.out.print(hour + "시 ");
        System.out.print(minute + "분 ");
        System.out.println(second + "초 ");
        System.out.println("--------------------------");

        TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
        Calendar now3 = Calendar.getInstance(timeZone);

        amPm = now3.get(Calendar.AM_PM);
        strAmPm = amPm == Calendar.AM ? "오전" : "오후";

        hour = now3.get(Calendar.HOUR);
        minute = now3.get(Calendar.MINUTE);
        second = now3.get(Calendar.SECOND);

        System.out.print("America/Los_Angeles : ");
        System.out.println(strAmPm + " ");
        System.out.print(hour + "시 ");
        System.out.print(minute + "분 ");
        System.out.println(second + "초 ");

        String[] availableIDs = TimeZone.getAvailableIDs();
        for(String id : availableIDs){
            System.out.println(id);
        }
        System.out.println("--------------------------");

        LocalDateTime now4 = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");
        System.out.println("현재시간: " + now4.format(dtf));

        LocalDateTime rs1 = now4.plusYears(1);
        System.out.println("1년 덧셈: " + rs1.format(dtf));

        LocalDateTime rs2 = now4.minusMonths(2);
        System.out.println("2월 뺄셈: " + rs1.format(dtf));

        LocalDateTime rs3 = now4.plusDays(7);
        System.out.println("7일 덧셈: " + rs1.format(dtf));
        System.out.println("--------------------------");

        LocalDateTime start = LocalDateTime.of(2021,1,1,0,0,0);
        System.out.println("시작일: " + start.format(dtf));
        LocalDateTime end = LocalDateTime.of(2021,12,31,0,0,0);
        System.out.println("종료일: " + end.format(dtf));

        if(start.isBefore(end)){
            System.out.println("진행 중입니다.");
        }
        else if(start.isEqual(end)){
            System.out.println("종료합니다.");
        }
        else if(start.isAfter(end)){
            System.out.println("종료되었습니다.");
        }

        long remainYear = start.until(end, ChronoUnit.YEARS);
        long remainMonth = start.until(end, ChronoUnit.MONTHS);
        long remainDay = start.until(end, ChronoUnit.DAYS);
        long remainHour = start.until(end, ChronoUnit.HOURS);
        long remainMinute = start.until(end, ChronoUnit.MINUTES);
        long remainSecond = start.until(end, ChronoUnit.SECONDS);

        System.out.println("남은 년도" + remainYear);
        System.out.println("남은 월" + remainMonth);
        System.out.println("남은 일" + remainDay);
        System.out.println("남은 시" + remainHour);
        System.out.println("남은 분" + remainMinute);
        System.out.println("남은 초" + remainSecond);
        System.out.println("--------------------------");
    }
}

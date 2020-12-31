package dateandtime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateAndTimeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// LocalDate.now()
		System.out.println("====================LocalDate class==================");
		System.out.println("==================LocatDate.now()=========================");
		LocalDate date = LocalDate.now();
		LocalDate dob = LocalDate.of(2019, 8, 12);
		System.out.println("************* " + date.isAfter(dob));
		System.out.println("************* " + date.isBefore(dob));
		System.out.println("************* " + date.isEqual(dob));

		System.out.println(date);

		int dd = date.getDayOfMonth();
		System.out.println(dd);

		int mmm = date.getMonthValue();
		System.out.println(mmm);

		int year = date.getYear();
		System.out.println(year);

		System.out.printf("%d-%d-%d", dd, mmm, year);
		System.out.println();

		Month mm = date.getMonth();
		System.out.println(mm);

		DayOfWeek day = date.getDayOfWeek();
		System.out.println(day);

		// LocalTime.now()
		System.out.println("====================LocalDate class==================");
		System.out.println("==================LocalTime()=============================");
		LocalTime time = LocalTime.now();
		System.out.println(time);

		System.out.println("==================getHour()=============================");
		int hour = time.getHour();
		System.out.println(hour);

		System.out.println("==================getMinute()=============================");
		int min = time.getMinute();
		System.out.println(min);

		System.out.println("==================getSecond()=============================");
		int ss = time.getSecond();
		System.out.println(ss);

		System.out.println("==================getNano()=============================");
		int nanosec = time.getNano();
		System.out.println(nanosec);

		System.out.println("==============time in format hour:min:sec:nano =====================");
		System.out.printf("%d:%d:%d:%d", hour, min, ss, nanosec);
		System.out.println();

		System.out.println("===================== LocalTime.NOON==========================");
		LocalTime time1 = LocalTime.NOON;
		System.out.println(time1);

		System.out.println("===================== LocalTime.MIN==========================");
		LocalTime time2 = LocalTime.MIN;
		System.out.println(time2);

		System.out.println("===================== LocalTime.MAX==========================");
		LocalTime time3 = LocalTime.MAX;
		System.out.println(time3);

		System.out.println("===================== LocalTime.MIDNIGHT==========================");
		LocalTime time4 = LocalTime.MIDNIGHT;
		System.out.println(time4);

		System.out.println("====================LocalDateTime class==================");
		System.out.println("==================LocalDateTime()=============================");

		System.out.println("================ LocalDateTime.now()=======================");
		LocalDateTime dateAndTime = LocalDateTime.now();
		System.out.println(dateAndTime); // all date and time api can be called in this also

		System.out.println("=============customize date and time==================");
		LocalDateTime ldt = LocalDateTime.of(1996, Month.AUGUST, 8, 12, 45); // there are so many overloaded method
		System.out.println(ldt);

		System.out.println("-=================plusMonth()================");
		LocalDateTime addMonth = ldt.plusMonths(6);
		System.out.println(addMonth);

		System.out.println("-=================addDay()================");
		LocalDateTime addDay = ldt.plusDays(10);
		System.out.println(addDay);

		System.out.println("-=================addYear()================");
		LocalDateTime addYear = ldt.plusYears(10);
		System.out.println(addYear);

		System.out.println("-=================minusDay()================");
		LocalDateTime minusDay = ldt.minusDays(8);
		System.out.println(minusDay);

		System.out.println("-=================minusMonth()================");
		LocalDateTime minusMonth = ldt.minusMonths(8);
		System.out.println(minusMonth);

		System.out.println("-=================minusYear()================");
		LocalDateTime minusYear = ldt.minusYears(6);
		System.out.println(minusYear);

		System.out.println("=======================period class in date and time api==============");

		LocalDate birthDay = LocalDate.of(1996, 8, 8);
		LocalDate today = LocalDate.now();

		Period age = Period.between(birthDay, today);
		System.out
				.println("Age is " + age.getYears() + " yrs" + age.getMonths() + " months " + age.getDays() + " days");

		System.out.println(age.isNegative());

		// to check year is leap or not
		System.out.println("=======================isLeap()================");
		Year yr = Year.of(1999);
		System.out.println(yr.isLeap());
		System.out.println(Year.isLeap(2000));

		System.out.println("====================ZoneId===================");
		ZoneId zone = ZoneId.systemDefault();
		System.out.println(zone);

		ZoneId la = ZoneId.of("America/Los_Angeles");
		System.out.println(la);
		ZonedDateTime zoneDateTime = ZonedDateTime.now(la);
		System.out.println(zoneDateTime);
		System.out.println(convertTime(90));

	}

	public static String convertTime(int min) {
		int hours = min / 60;
		int minutes = min % 60;
		if (hours == 0) {
			return minutes + " min";
		} else if (minutes == 0) {
			return hours + " hrs";
		} else {
			return hours + " hrs " + minutes + " min";
		}
	}

}

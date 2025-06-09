package date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Required_Date {
	public static void main(String[] args) {
		Date date= new Date();
		SimpleDateFormat simpleDate= new SimpleDateFormat("yyyy-MM-dd");
		String todayDate = simpleDate.format(date);
		System.out.println(todayDate);
		Calendar cal = simpleDate.getCalendar();
        cal.add(Calendar.DAY_OF_MONTH,30);
        String endDate = simpleDate.format(cal.getTime());
        System.out.println(endDate);
	}
	

}

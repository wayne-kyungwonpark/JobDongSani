package test.date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTest {

	public static void main(String[] args) {
		
		
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM", Locale.KOREA);
//		Date currentTime = new Date();
//		String ym = formatter.format(currentTime);
		long now = System.currentTimeMillis();
		System.out.println(now);
		System.out.println(String.valueOf(now).length());
	}
}

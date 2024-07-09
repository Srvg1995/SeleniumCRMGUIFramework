package practice.basics;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaBasics {

	public static void main(String[] args) {
		
		Date d=new Date();
		
		
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String actDate = sim.format(d);
		System.out.println(actDate);
		
		
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,30);
		String dateRequired = sim.format(cal.getTime());
		System.out.println(dateRequired);
		

	}

}

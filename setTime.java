import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class setTime {
	
	public static void main(String[] args){
		Date now = new Date();
		Date lzDate = setHour("2016-05-26");
		long mss = now.getTime()-lzDate.getTime();
		int ss = (int) (mss/1000);
		System.out.println(ss);
	}
	/**
	 * 设置时间为中午12:00
	 * @param date1
	 * @return
	 * 
	 */
	public static Date setHour(String date1){
		Date date = null;
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date preDate = format.parse(date1);
			Calendar cal = Calendar.getInstance();
			cal.setTime(preDate);
			cal.set(Calendar.HOUR, 12);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			
			date = cal.getTime();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return date;
		
	}
	/**
	 * 计算毫秒数
	 * @param date
	 * @return
	 */
	public static long getMsD(Date date){
		long ms = 0;
		
			ms = date.getTime();

		
		return ms;
	}
	
}

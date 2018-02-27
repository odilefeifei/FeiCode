import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class NextMonth {
	public static void main(String args[]){
		String preMonth = "2016-02-28";
		String nextMonth = getNextMonth(preMonth);
		long mss = getMs(nextMonth) - getMs(preMonth);
		int ss = (int) (mss/1000);
		System.out.println(ss);
	}
	
	/**
	 * 获取下一个月的时间
	 * @param preMonth
	 * @return
	 */
	public static String getNextMonth(String preMonth) {
		String nextM = "";
		try{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date preDate = format.parse(preMonth);
			Calendar cal = Calendar.getInstance();
			cal.setTime(preDate);
			//下面的就是把当前日期加一个月
			cal.add(Calendar.MONTH, 1);
			nextM = format.format(cal.getTime());
			
		}catch (Exception e) {
			e.printStackTrace(System.err);
		}
		
		
		return nextM;
	}
	
	
	/**
	 * 计算毫秒数
	 * @param date
	 * @return
	 */
	public static long getMs(String date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		long ms = 0;
		try {
			Date date1 = sdf.parse(date);
			ms = date1.getTime();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(System.err);
		}
		return ms;
	}
	
	
}

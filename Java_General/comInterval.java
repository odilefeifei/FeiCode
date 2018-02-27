import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class comInterval {
	public static void main(String args[]) throws ParseException{
		System.out.println(comInter("2013-03-26"));
		//System.out.println(getMonth("2013-06-26"));
		//System.out.println(parseYear("2013-03-25"));
	}
	
	public static double comInter(String yearstr) throws ParseException{
		double interval = 0.00;
		if(!yearstr.equals("")){
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");//时间格式
			Date year_d = df.parse(yearstr);
	        Date now = new Date();

			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			
			c1.setTime(year_d);
			c2.setTime(now);
	        int year =c2.get(Calendar.YEAR)-c1.get(Calendar.YEAR);
	        int month = year*12 + c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
	        
	        double years = 0.00;
	        years = month / (double)12;
	        //四舍五入
	        BigDecimal b  = new BigDecimal(years);  
	        interval = b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();  
	        
		}
		
		return interval;
	}
	
	public static int getMonth(String yearStr) throws ParseException{
		int month = 0;
		try {
			
			if(!yearStr.equals("")){
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//时间格式 月份
		        Date yeard = df.parse(yearStr);
				Calendar cal = Calendar.getInstance();         
		        cal.setTime(yeard);   
		        cal.get(Calendar.MONTH);
		        month = cal.get(Calendar.MONTH)+1;
		        
			}

			
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		
		return month;    
		
	}
	
	public static String parseYear(String yearstr) throws ParseException{
		String year_str = "";
		
		if(!yearstr.equals("")){
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//时间格式
	        Date year_d = df.parse(yearstr);
	        year_str = df.format(year_d);
		}
		
        return year_str;
	}
}

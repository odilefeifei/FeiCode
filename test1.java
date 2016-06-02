import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class test1 {
	public static void main(String args[]) throws ParseException{
		String yearStr = "2016-11-02";
		

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//时间格式 月份
        Date yeard = df.parse(yearStr);
        String years = df.format(yeard);
        
        
        Calendar cal = Calendar.getInstance();         
        cal.setTime(yeard);   
        cal.get(Calendar.MONTH);
        cal.getTime();
        int month = cal.get(Calendar.MONTH)+1;
        
        System.out.println(month);
		
	}
}

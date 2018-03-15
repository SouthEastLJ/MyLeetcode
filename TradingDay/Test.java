
import  java.text.SimpleDateFormat;
import  java.util.Arrays;
import  java.util.Calendar;
import  java.util.Date;
import  java.util.List;

public  class  Test {

    public  static  SimpleDateFormat sdf = new  SimpleDateFormat("yyyyMMdd");

    public  static  void  main(String[] args) {
        Calendar cal = Calendar.getInstance();
        
        // 待确认交易日：15点之前取当前日期，15点之后取下一交易日
        String nextDay = sdf.format(new Date());
        
        int n = 1;//T+n交易日
        
        for(int i=0;i<=n;i++)
        {
	        if (cal.get(Calendar.HOUR_OF_DAY) >= 15) {
	            if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY ) {
	                cal.add(Calendar.DAY_OF_MONTH, 3 );
	                nextDay = sdf.format(cal.getTime());
	            } 
	            else {
	                nextDay = getNextDay(nextDay);
	            }
	        }
//	        nextDay = getNextDay(nextDay);

	//        nextDay = "20180330";
	       
	        // 时间必须要从小到大排序，否则会出问题
	        String[] a = {"20180317", "20180318", "20180319", "20180323", "20180324"};
	        List<String> holidayList = Arrays.asList(a);
//	        System.out.println("有效的最近交易日nextDay:"  + getDayAfterHoliday(nextDay, holidayList));
	        nextDay=getDayAfterHoliday(nextDay, holidayList);
        }
        System.out.println("有效的最近交易日nextDay:"  + nextDay);
    }

    public  static  String getDayAfterHoliday(String nextDay, List<String> holidayList) {
        if  (null  != holidayList) {
            for  (int  i = 0; i < holidayList.size(); i++) {
                if  (holidayList.get(i).equals(nextDay)) {
                    nextDay = getDayAfterHoliday(getNextDay(nextDay), holidayList);
                }
            }
        }
        nextDay = getDayExceptWeekend(nextDay);
        return  nextDay;
    }

    /**
     * 获取下一天
     * 
     * @param day 当前日期yyyyMMdd
     * @return
     */
    public  static  String getNextDay(String day) {
        Calendar cal = formatYYYYMMDD(day);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return  sdf.format(cal.getTime());
    }

    /**
     * 如果当前日期处于周末，则返回下周一
     * 
     * @param day 当前日期yyyyMMdd
     * @return
     */
    public  static  String getDayExceptWeekend(String day) {
        Calendar cal = formatYYYYMMDD(day);
        if  (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            cal.add(Calendar.DAY_OF_MONTH, 2);
        } else  if  (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }
        return  sdf.format(cal.getTime());
    }

    /**
     * 将字符串类型日期转换为Calendar
     * 
     * @param day 当前日期yyyyMMdd
     * @return
     */
    public  static  Calendar formatYYYYMMDD(String day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(day.substring(0, 4)), (Integer.parseInt(day.substring(4, 6)) - 1), Integer.parseInt(day.substring(6)));
        return  cal;
    }
}
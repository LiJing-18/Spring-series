package com.karat.cn.common.util;

import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.*;
import java.util.*;

/**
 * 时间转换工具类
 * @author 开发
 *
 */
public class BaseTools {
	/**
	 * 默认的用户名称，用于在没有登录的情况下生成静态页面，主要是在安装的时候使用
	 */
	public static final String DEFAULTADMINNAME = "sasasa";

	// 默认时间
	public static String DEFAULTTIME = "2010-06-25 12:48:21";
	
	//日期格式化yyyyMMdd
	public static final String DATEFORMATEYMD = "yyyyMMdd";
	
	//日期格式化yyyyMMddHHmmss
	public static final String DATEFORMATEYMDHMS = "yyyyMMddHHmmss";
	
	private static final int FIRST_DAY = Calendar.SUNDAY;

	/**
	 * 设置日期格式
	 * 
	 * @return
	 */
	public static String tagdate() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String time = formatter.format(cal.getTime()).toString();
		return time;
	}
	
	public static String tagyMdHms() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = formatter.format(cal.getTime()).toString();
		return time;
	}

	public static Date defaulttime() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.CHINA);
			Date date = sdf.parse(DEFAULTTIME);
			return date;
		} catch (ParseException e) {

		}
		return null;

	}
	/**
	 * 转换用户填写的发货时间
	 * @param memberdelivertime
	 * @return
	 */
	public static Date getMemberDeliverTime(String memberdelivertime){
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd",Locale.CHINA);
		Date date = null;
		try {
			date = formatter.parse(memberdelivertime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 获取系统时间
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static Date systemtime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.CHINA);
		String dateString = formatter.format(date);
		ParsePosition pos = new ParsePosition(0);
		Date currenttime = formatter.parse(dateString, pos);
		return currenttime;
	}
	
	/**
	 * 获取系统时间long
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static long systemtimeLong() {
		return new Date().getTime();
	}

	/**
	 * 转换数据库日期格式
	 * 
	 * @param object
	 * @return
	 */
	public static String formateDbDate(Date object) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.CHINA);
		String dateString = formatter.format(object);
		return dateString;
	}
	public static String formateDbDate2(Date object) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd",Locale.CHINA);
		String dateString = formatter.format(object);
		return dateString;
	}
	
	/**
	 * 获得当天零时零分零秒
	 * @return
	 */
	public static Date initDateByDay(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}
	/**
	 * 转换数据库long型日期至字符串类型
	 * @param millsec
	 * @return
	 */
	public static String formateMillsecDateToStr(long millsec){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.CHINA);
		Date date= new Date(millsec);
		return formatter.format(date);
	}
	public static String formateMillsecDateToStr2(long millsec){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd",Locale.CHINA);
		Date date= new Date(millsec);
		return formatter.format(date);
	}
	
	
	public static String formateStringDate(String createDate){
		String time="yyyy-MM-dd hh:mm:ss";//转换前
		SimpleDateFormat formatter, FORMATTER;
		formatter = new SimpleDateFormat(time);
		Date date = null;
		try {
			date = formatter.parse(createDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FORMATTER = new SimpleDateFormat("yyyy-MM-dd");//转换后的格式
		/*System.out.println("OldDate-->"+createDate);
		System.out.println("NewDate-->"+FORMATTER.format(date));*/ 
		return FORMATTER.format(date);
	}
	
	public static String getStringDate(String createDate){
		String time="yyyy-MM-dd";//转换前
		SimpleDateFormat formatter, FORMATTER;
		formatter = new SimpleDateFormat(time);
		Date date = null;
		try {
			date = formatter.parse(createDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FORMATTER = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//转换后的格式
		/*System.out.println("OldDate-->"+createDate);
		System.out.println("NewDate-->"+FORMATTER.format(date));*/ 
		return FORMATTER.format(date);
	}
	
	public static long string2Long(String time) throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.CHINA);
        Date date  = formatter.parse(time);  
		long time1=date.getTime();
		return time1;
	}
	public static Date string2Time(String dateString) throws ParseException {

		DateFormat dateFormat;
		dateFormat = new SimpleDateFormat("yy-MM-dd", Locale.CHINA);
		dateFormat.setLenient(false);
		Date timeDate = dateFormat.parse(dateString);
		Date dateTime = new Date(timeDate.getTime());
		return dateTime;
	}

	public static Date string2Timeyyyymmdd(String dateString) throws ParseException {

		DateFormat dateFormat;
		dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
		dateFormat.setLenient(false);
		Date timeDate = dateFormat.parse(dateString);
		Date dateTime = new Date(timeDate.getTime());
		return dateTime;
	}
	public static String string2stringyyyymmdd(String dateString) throws ParseException {
		DateFormat dateFormat;
		dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
		dateFormat.setLenient(false);
		Date timeDate = dateFormat.parse(dateString);
		String datestr = dateFormat.format(timeDate);
		return datestr;
	}
	
	
	public static Date StringToDate(String timeString) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
		Date date = null;
		try {
			date = formatter.parse(timeString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * 获取指定日期的 年/月/日 时/分/秒
	 * @param dateStr
	 * @param type 1:年 2:月 3:日 4:时 5:分 6:秒
	 * @return
	 */
	public static int  getSetDate(String dateStr, int type){
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		 Calendar cal = Calendar.getInstance(); 
		 Date dt = null;
		 try {
			 dt = sdf.parse(dateStr);
			 cal.setTime(dt);
		 } catch (ParseException e) {
			e.printStackTrace();
		 }
		 if (type == 1){
			 return cal.get(Calendar.YEAR);
		 } else if(type == 2){
			 return cal.get(Calendar.MONTH) + 1;
		 } else if(type == 3){
			 return cal.get(Calendar.DAY_OF_MONTH); 
		 } else if(type == 4){
			 return cal.get(Calendar.HOUR_OF_DAY); 
		 } else if(type == 5){
			 return cal.get(Calendar.MINUTE); 
		 } else if(type == 6){
			 return cal.get(Calendar.SECOND); 
		 }
		 return 0;
	}
	/**
	 * 获取网站根目录
	 * 
	 * @return
	 */
	public static String getBasePath() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String path = request.getContextPath();
		return path;
	}
	
	
	/**
	 * 获取week
	 * @param date
	 * @return
	 */
	public static String getWeek(Date date) {
		String[] weeks = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (week_index < 0) {
			week_index = 0;
		}
		return weeks[week_index];
	}
	
	public static List<String> getThisMonthDay(int year, int month){
		List<String> list = new ArrayList<String>();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal = Calendar.getInstance();
//		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);
		cal.set(year, month, 1);
		cal.add(Calendar.MONTH, 0);
		cal.add(Calendar.DATE, -1);
		String lastDay = sf.format(cal.getTime());
		String aDay = "";
		int i = 1;
		while (!lastDay.equals(aDay)) {
			cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), i);
			aDay = sf.format(cal.getTime());
			list.add(sf.format(cal.getTime()));
			i++;
		}
		return list;
	}
	
	/**
	 * 查询从今天起N天(暂为14天)
	 * @return
	 */
	public static List<String> getFromTodayNDays() {
		List<String> list = new ArrayList<String>();
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
//		SimpleDateFormat sdf = new SimpleDateFormat("E:yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		cal.set(Calendar.DAY_OF_WEEK, 2);
		for (int i = 0; i < 14; i++) {
			if (sdf.format(cal.getTime()).equals(sdf.format(date))) {
				cal.add(Calendar.DATE, 0);
			}
			list.add(sdf.format(cal.getTime()));
			cal.add(Calendar.DATE, 1);
		}
		return list;
	}
	
	/**
	 * 查询从今天起 到 结束时间endTime前三天  的数据
	 * @param endTime
	 * @return
	 */
	public static List<String> getbeforeTodayNDays(String endTime) {
		List<String> list = new ArrayList<String>();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		try {
			long day = (sd.parse(endTime).getTime() - sd.parse(formateDbDate(new Date())).getTime()) / (24 * 60 * 60 * 1000);
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if (day > 3) {
				Date date = new Date();
				for (int i = 0; i < day - 2; i++) {
					if (sdf.format(cal.getTime()).equals(sdf.format(date))) {
						cal.add(Calendar.DATE, 0);
					}
					list.add(sdf.format(cal.getTime()));
					cal.add(Calendar.DATE, 1);
				}
			} else {
				list.add(sdf.format(cal.getTime()));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 查询当前时间N个小时后的时间
	 * @return
	 */
	public static String getCurrentTimeAfterNTime(long time, int n) {
		Calendar dar = Calendar.getInstance();
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dar.setTimeInMillis(time);
		dar.add(Calendar.HOUR_OF_DAY, n);
		return dft.format(dar.getTime());
	}
	/**
	 * 查询当前时间n秒后的时间
	 * @param n
	 * @return
	 */
	public static long getCurrentTimeAfterNTime(long n) {
		long currentTime = System.currentTimeMillis() ;
		currentTime += n*1000;
		return currentTime;
	}
	
	public static String todateDash() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String time = formatter.format(cal.getTime()).toString();
		return time;
	}
	 
	//生成随机数字和字母,  
    public static String getStringRandom(int length) {  
    	String val = "";  
        Random random = new Random();  
        //参数length，表示生成几位随机数  
        for(int i = 0; i < length; i++) {  
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";  
            //输出字母还是数字  
            if( "char".equalsIgnoreCase(charOrNum) ) {  
                //输出是大写字母还是小写字母  
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;  
                val += (char)(random.nextInt(26) + temp);  
            } else if( "num".equalsIgnoreCase(charOrNum) ) {  
                val += String.valueOf(random.nextInt(10));  
            }  
        }  
        return val;  
    }
	//生成随机的不重复的数字集合（8个数字）
    public static Set<Integer> getNumRandom(int length){
	   Random r = new Random(); 
	   Set<Integer> set=new HashSet<Integer>();
   	   for(;set.size()<8;){
   		   int j=r.nextInt(length);
   		   set.add(j);	
   		} 
   	   return set;
    }
	/**
	 * 获取配置文件信息
	 * @param url    conf/common
	 * @param parm   prop_waitTime
	 * @return
	 */
	public static int getPropertiesNum(String url, String parm) {
		ResourceBundle bundle = ResourceBundle.getBundle(url);
		int propWaitTime;
		try {
			propWaitTime = Integer.parseInt(bundle.getString(parm));
		} catch (NumberFormatException e) {
			propWaitTime = 0;
		}
		return propWaitTime;
	}
	
	public static String getDigitalConversion(long num) {
		String digStr = "";
		if (num >= 100000) {
			/*BigDecimal b = new BigDecimal(num/10000d);
			digStr =  b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + ""; */
			DecimalFormat df = new DecimalFormat(".##");
			digStr = df.format(num / 10000d) + "万";
		} else {
			digStr = num + "";
		}
		return digStr;
	}
	
	public static int getmaxRateCount(int num) {
		int maxRateCount = (num / 100 + 1) * 100;
		if (num > maxRateCount - (num / 100 + 1) * 10) {
			maxRateCount = (num / 100 + 2) * 100;
		}
		return maxRateCount;
	}
	/**
	 *  获取昨天/明天的时间
	 * @param type 1:昨天  2:明天
	 * @return
	 */
	public static String getYesTomDayDate(int type) {
		Calendar cal = Calendar.getInstance();
		if (type == 1){
			cal.add(Calendar.DATE, -1);
		}else if (type == 2){
			cal.add(Calendar.DATE, 1);
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String time = formatter.format(cal.getTime()).toString();
		return time;
	}
	
	/**
	 * 计算百分比
	 */
	public static int getPercent(int num1,int num2){
		if(num2 > 0){
			return new BigDecimal((double)num1/(double)num2*100).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
		}else{
			return 0;
		}
	}
	
	/**
	 * 根据传来的有效截止日期算还有多少有效时间
	 * 
	 * @throws ParseException
	 * 
	 */
	public static String getRemainingTime(String time) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long mm = sdf.parse(time).getTime();
		Long date = BaseTools.systemtimeLong();
		long dd = mm - date;
		String str = "";
		if (dd > 0) {
			dd = dd / 1000;
			int s = (int) (dd % 60);
			int m = (int) (dd / 60 % 60);
			int h = (int) (dd / 3600 % 24);
			int d = (int) (dd / 86400);
			if(d>0){
				str=d+"天";
			}else if(h>0){
				str=h+"小时";
			}else if(m>0){
				str=m+"分";
			}else if(s>0){
				str="不足一分钟";
			}
		} else {
			str += "已过期";
		}
		return str;
	}
	
	/**
	 * 根据传来的有效日期判断当前日期是否在其中
	 * 
	 * @throws ParseException
	 * 
	 */
	public static String inValidTime(String time,String time2) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long mm = sdf.parse(time).getTime();
		Long nn = sdf.parse(time2).getTime();
		Long date = BaseTools.systemtimeLong();
		if(mm<=date&&date<=nn){
			return "1";
		}else{
			return "0";
		}
	}
	
	//计算本周七天日期(从星期日到星期六)
	//如dateFormat=2016-08-28
	public static List<String> getWeekdays(String dateFormat) {
		List<String> list = new ArrayList<String>();
		Calendar calendar = Calendar.getInstance();
    	calendar.setTime(BaseTools.getMemberDeliverTime(dateFormat));
    	while (calendar.get(Calendar.DAY_OF_WEEK) != FIRST_DAY) {
            calendar.add(Calendar.DATE, -1);
    	}
        for (int i = 0; i < 7; i++) {
        	SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        	list.add(dateFormat2.format(calendar.getTime()));
            calendar.add(Calendar.DATE, 1);
        }
        return list;
	}
	
	/**
	 * 查询从今天前或后N天(暂为5天)
	 * @return
	 */
	public static List<String> getBeforeAfterTodayNDaysWeek(String type, String dateFormat) {
		List<String> list = new ArrayList<String>();
		Calendar calendar = Calendar.getInstance();
    	calendar.setTime(BaseTools.getMemberDeliverTime(dateFormat));
    	//type=0查询前面N天,type=1查询后面N天
    	if ("0".equals(type)) {
    		calendar.add(Calendar.DATE, -5-1);
    	}
        for (int i = 0; i < 5; i++) {
        	calendar.add(Calendar.DATE, 1);
        	SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        	list.add(dateFormat2.format(calendar.getTime()));
        	//System.out.println(dateFormat2.format(calendar.getTime()));
        }
        return list;
	}
    /** 
     * 随机指定范围内N个不重复的数 
     * 最简单最基本的方法 
     * @param min 指定范围最小值 
     * @param max 指定范围最大值 
     * @param n 随机数个数 
     */  
    public static int[] randomCommon(int min, int max, int n){  
        if (n > (max - min + 1) || max < min) {  
               return null;  
           }  
        int[] result = new int[n];  
        int count = 0;  
        while(count < n) {  
            int num = (int) (Math.random() * (max - min)) + min;  
            boolean flag = true;  
            for (int j = 0; j < n; j++) {  
                if(num == result[j]){  
                    flag = false;  
                    break;  
                }  
            }  
            if(flag){  
                result[count] = num;  
                count++;  
            }  
        }  
        return result;  
    }
    
    /**
     * 随机指定范围内N个不重复的数(最优)
     * @param min 包含
     * @param max 不包含
     * @param choose 个数,最大数为max-min
     * @return
     */
	public static int[] GetRandomSequence(int min, int max, int choose) {
		max -= min;
		int[] sequence = new int[max];
		int[] output = new int[choose];

		for (int i = 0; i < max; i++) {
			sequence[i] = min + i;
		}
		Random random = new Random();
		int end = max - 1;
		for (int i = 0; i < choose; i++) {
			int num = random.nextInt(end + 1);
			output[i] = sequence[num];
			sequence[num] = sequence[end];
			end--;
		}
		return output;
	}
    
    //数字分割 例如99999999  分割为99,999,999
    public static String formatTosepara(int data) {
        DecimalFormat df = new DecimalFormat("#,###"); 
        return df.format(data);
    }
    public static String formatTosepara(long data) {
        DecimalFormat df = new DecimalFormat("#,###"); 
        return df.format(data);
    }

	// 获取当前时间 yyyy-MM-dd
	public static String getSystemTime() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
	}
	
	// 获取当前时间 yyyy-MM-dd HH:mm:ss
	public static String getDetailSystemTime() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
	}
		
    //判断选择的日期是否是本周 (当前周) 
   public static boolean isThisWeek(long time)  
   {  
       Calendar calendar = Calendar.getInstance();  
       int currentWeek = calendar.get(Calendar.WEEK_OF_YEAR);  
       calendar.setTime(new Date(time));  
       int paramWeek = calendar.get(Calendar.WEEK_OF_YEAR);  
       if(paramWeek==currentWeek){  
          return true;  
       }  
       return false;  
   }  
   
	/**
	 * 两个时间相隔比较(返回相差XX天XX小时)
	 * @param dateStart 格式:2017-04-26 17:32:58
	 * @param dateStop 格式:2017-04-28 11:22:41
	 */
	public static String twoTimeCompare(String dateStart, String dateStop){
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       Date d1 = null;
       Date d2 = null;
       try {
           d1 = format.parse(dateStart);
           d2 = format.parse(dateStop);
   
           //毫秒ms
           long diff = d2.getTime() - d1.getTime();
   
           //long diffSeconds = diff / 1000 % 60;
          // long diffMinutes = diff / (60 * 1000) % 60;
           long diffHours = diff / (60 * 60 * 1000) % 24;
           long diffDays = diff / (24 * 60 * 60 * 1000);
   
          /* System.out.print("两个时间相差：");
           System.out.print(diffDays + " 天, ");
           System.out.print(diffHours + " 小时, ");
           System.out.print(diffMinutes + " 分钟, ");
           System.out.print(diffSeconds + " 秒.");
           System.out.println();*/
           return diffDays+ "天" + diffHours + "小时";
       } catch (Exception e) {
           e.printStackTrace();
       }
       return "";
	}
    // 获得本周日24点时间  
    public  static Date getTimesWeeknight() {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(getTimesWeekmorning());  
        cal.add(Calendar.DAY_OF_WEEK, 7);  
        return cal.getTime();  
    }  

    // 获得本周一0点时间  
    public static Date getTimesWeekmorning() {  
        Calendar cal = Calendar.getInstance();  
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);  
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);  
        return  cal.getTime();  
    }
    
    // 获取周几零点时间
    // 星期日为一周的第一天 	SUN 	MON 	TUE 	WED 	THU 	FRI 	SAT
    // DAY_OF_WEEK返回值 	1 		2 		3 		4 		5	 	6 		7
	// Type为1 则代表加一个周 type为-1 代表减一个周
    public static long getWeekOneZeroTime(int week,int type){
    	Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, week);//周几 如果是周一 就为2  以此类推 周三为4
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.WEEK_OF_MONTH, type);	//type == -1 获取上周周几零点 type == 0 获取本周周几零点  type ==1 获取下周周几零点
		return calendar.getTimeInMillis();
    }
	//数字转换为字母
	public static String intToABC(String a){
		int i= Integer.parseInt(a);
	    char c1=(char) (i+64);
	    String fina = c1 + "";
	    return fina;
	}
	
	// 查询某日N天后的日期
	public static String getDateFromOneDayNDays(String dateFormat, int n) {
		Calendar calendar = Calendar.getInstance();
    	calendar.setTime(BaseTools.getMemberDeliverTime(dateFormat));
    	calendar.add(Calendar.DATE, n);
    	SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat2.format(calendar.getTime());
	}
	public static String getDateFromToDayNDays(int n) {
		Calendar calendar = Calendar.getInstance();
    	calendar.add(Calendar.DATE, n);
    	SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat2.format(calendar.getTime());
	}
	//查询显示时间0.5-5分钟后时间(30-300s)
	public static String getMinuteFromOneDay(String dataFormat,int n){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.CHINA);
		Date date = null;
		try {
			date = formatter.parse(dataFormat);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	calendar.add(Calendar.SECOND,n);
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(calendar.getTime());
	}
	
	public static String dateConversion(String dateFormat) {
		String month = digitalProcessing(dateFormat.substring(5, 7));
		String day = digitalProcessing(dateFormat.substring(8, dateFormat.length()));
		return month + "月" + day + "日";
	}
	
	public static String digitalProcessing(String digital) {
		if ("0".equals(digital.substring(0, 1))) {
			digital = digital.substring(1);
		}
		return digital;
	}
	
	
	/*** 获取当前时间前3分钟* @param stuff* @return*/
	public static String getCurrentTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
		Calendar beforeTime = Calendar.getInstance();   
		beforeTime.add(Calendar.MINUTE, -2);
		// 3分钟之前的时间   
		Date beforeD = beforeTime.getTime();   
		String time = sdf.format(beforeD);
		return time; 
	}
	//获取本周的开始时间
	@SuppressWarnings("unused")
	public static Date getBeginDayOfWeek() {
		Date date = new Date();
		if (date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
		if (dayofweek == 1) {
				dayofweek += 7;
		}
		cal.add(Calendar.DATE, 2 - dayofweek);
		return cal.getTime();
	}
	 
	//获取本周的结束时间
	public static Date getEndDayOfWeek(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(getBeginDayOfWeek());  
		cal.add(Calendar.DAY_OF_WEEK, 6); 
		Date weekEndSta = cal.getTime();
		return weekEndSta;
	}

	/**
	 * 当前时间所在一周的周一和周日时间
	 * @return
	 */
	public static Map<String,String> getWeekDate() {
		Map<String,String> map = new HashMap<String,String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 
         Calendar cal = Calendar.getInstance();  
         cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一  
         int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天  
         if(dayWeek==1){
             dayWeek = 8;
         }
         System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期  
 
         cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - dayWeek);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值  
         Date mondayDate = cal.getTime();
         String weekBegin = sdf.format(mondayDate);  
         System.out.println("所在周星期一的日期：" + weekBegin);  
 
 
         cal.add(Calendar.DATE, 4 +cal.getFirstDayOfWeek());
         Date sundayDate = cal.getTime();
         String weekEnd = sdf.format(sundayDate);  
         System.out.println("所在周星期日的日期：" + weekEnd);
 
         map.put("mondayDate", weekBegin);
         map.put("sundayDate", weekEnd);
        return map;
    }

    public static void main(String[] args) {
    	System.out.println(getWeekDate().get("mondayDate"));
    	//System.out.println(BaseTools.formateMillsecDateToStr(BaseTools.getCurrentTimeAfterNTime(120)));
	}
}

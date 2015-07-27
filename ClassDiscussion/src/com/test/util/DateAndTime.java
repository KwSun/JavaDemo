package com.test.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * 通用日期类，处理返回各种格式的日期
 * @author apple
 */
public class DateAndTime {
	
	private static Date date = new Date();
	
	private static final Calendar NOW = Calendar.getInstance();

	public static int getYear()
	{
		return NOW.get(Calendar.YEAR);
	}
	
	public static int getMonth()
	{
		return NOW.get(Calendar.MONTH) + 1;
	}
	
	public static int getDay()
	{
		return NOW.get(Calendar.DAY_OF_MONTH);
	}
	
	
	/**
	 * 返回 年月
	 * @return  格式    2015-06
	 */
	public static String getYearMonth()
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
		return df.format(date);
	}
	
	
	/**
	 * 返回 年月日
	 * @return  当前日期格式  2015-06-13
	 */
	public static String getYearMonthDay()
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}
	
	/**
	 * 自定义分隔符，返回以分隔符分割的日期
	 * 返回 年月日
	 * @return  当前日期格式  2015 06 13
	 */
	public static String getYearMonthDay(String separator)
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy"+separator+"MM"+separator+"dd");
		return df.format(date);
	}
	
	/**
	 * 返回 年月日时分秒
	 * @return    当前日期格式 2015-06-13 18:53:40
	 */
	public static String getFullDateTime()
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date);
	}
	
	
	/**
	 * 返回 时分秒
	 * @return    当前日期格式 18:53:40
	 */
	public static String getHourMinSec()
	{
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		return df.format(date);
	}
	
	/**
	 * 返回 年月日星期
	 * @return   当前日期格式  2015年6月13日 星期四
	 */
	public static String getCurrentlyTime() 
	{
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
		return dateFormat.format(date);
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(DateAndTime.getYear());
		System.out.println(DateAndTime.getMonth());
		System.out.println(DateAndTime.getDay());
		System.out.println(DateAndTime.getYearMonth());
		System.out.println(DateAndTime.getYearMonthDay());
		System.out.println(DateAndTime.getYearMonthDay("\\"));
		System.out.println(DateAndTime.getFullDateTime());
		System.out.println(DateAndTime.getHourMinSec());
		System.out.println(DateAndTime.getCurrentlyTime());
		
	}
}

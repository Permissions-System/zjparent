package com.zjgt.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(DateUtil.prevDay("2015-10-30",  1));

	}
	
	public static String nextDay(String s, int n) {   
        try {   
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
  
            Calendar cd = Calendar.getInstance();   
            cd.setTime(sdf.parse(s));   
            cd.add(Calendar.DATE, n);//增加一天   
            //cd.add(Calendar.MONTH, n);//增加一个月   
  
            return sdf.format(cd.getTime());   
  
        } catch (Exception e) {   
            return null;   
        }   
  
    }   
	
	public static String prevDay(String s, int n) {   
        try {   
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
  
            Calendar cd = Calendar.getInstance();   
            cd.setTime(sdf.parse(s));   
            cd.add(Calendar.DATE, -n);// 之前一天   
            //cd.add(Calendar.MONTH, n);//增加一个月   
  
            return sdf.format(cd.getTime());   
  
        } catch (Exception e) {   
            return null;   
        }   
  
    }   


}

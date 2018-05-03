/*     */ package com.zjgt.p2p.base.util;
/*     */ 
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ 
/*     */ public class IdcardUtils extends StringUtils
/*     */ {
/*     */   public static final int CHINA_ID_MIN_LENGTH = 15;
/*     */   public static final int CHINA_ID_MAX_LENGTH = 18;
/*  27 */   public static final String[] CITY_CODE = { "11", "12", "13", "14", "15", "21", "22", "23", "31", "32", "33", "34", "35", "36", "37", "41", "42", "43", "44", "45", "46", "50", "51", "52", "53", "54", "61", "62", "63", "64", "65", "71", "81", "82", "91" };
/*     */ 
/*  37 */   public static final int[] POWER = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
/*     */ 
/*  42 */   public static final String[] VERIFY_CODE = { "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" };
/*     */   public static final int MIN = 1930;
/*  47 */   public static Map<String, String> cityCodes = new HashMap();
/*     */ 
/*  49 */   public static Map<String, Integer> twFirstCode = new HashMap();
/*     */ 
/*  51 */   public static Map<String, Integer> hkFirstCode = new HashMap();
/*     */ 
/*     */   public static String conver15CardTo18(String idCard)
/*     */   {
/* 134 */     String idCard18 = "";
/* 135 */     if (idCard.length() != 15) {
/* 136 */       return null;
/*     */     }
/* 138 */     if (isNum(idCard))
/*     */     {
/* 140 */       String birthday = idCard.substring(6, 12);
/* 141 */       Date birthDate = null;
/*     */       try {
/* 143 */         birthDate = new SimpleDateFormat("yyMMdd").parse(birthday);
/*     */       } catch (ParseException e) {
/* 145 */         return null;
/*     */       }
/* 147 */       Calendar cal = Calendar.getInstance();
/* 148 */       if (birthDate != null) {
/* 149 */         cal.setTime(birthDate);
/*     */       }
/*     */ 
/* 152 */       String sYear = String.valueOf(cal.get(1));
/* 153 */       idCard18 = idCard.substring(0, 6) + sYear + idCard.substring(8);
/*     */ 
/* 155 */       char[] cArr = idCard18.toCharArray();
/* 156 */       if (cArr != null) {
/* 157 */         int[] iCard = converCharToInt(cArr);
/* 158 */         int iSum17 = getPowerSum(iCard);
/*     */ 
/* 160 */         String sVal = getCheckCode18(iSum17);
/* 161 */         if (sVal.length() > 0)
/* 162 */           idCard18 = idCard18 + sVal;
/*     */         else
/* 164 */           return null;
/*     */       }
/*     */     }
/*     */     else {
/* 168 */       return null;
/*     */     }
/* 170 */     return idCard18;
/*     */   }
/*     */ 
/*     */   public static boolean validateCard(String idCard)
/*     */   {
/* 177 */     String card = idCard.trim();
/* 178 */     if (validateIdCard18(card)) {
/* 179 */       return true;
/*     */     }
/*     */ 
/* 182 */     return (validateIdCard15(card));
/*     */   }
/*     */ 
/*     */   public static boolean validateIdCard18(String idCard)
/*     */   {
/* 194 */     boolean bTrue = false;
/* 195 */     if (idCard.length() == 18)
/*     */     {
/* 197 */       String code17 = idCard.substring(0, 17);
/*     */ 
/* 199 */       String code18 = idCard.substring(17, 18);
/* 200 */       if (isNum(code17)) {
/* 201 */         char[] cArr = code17.toCharArray();
/* 202 */         if (cArr != null) {
/* 203 */           int[] iCard = converCharToInt(cArr);
/* 204 */           int iSum17 = getPowerSum(iCard);
/*     */ 
/* 206 */           String val = getCheckCode18(iSum17);
/* 207 */           if ((val.length() > 0) && 
/* 208 */             (val.equalsIgnoreCase(code18))) {
/* 209 */             bTrue = true;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 215 */     return bTrue;
/*     */   }
/*     */ 
/*     */   public static boolean validateIdCard15(String idCard)
/*     */   {
/* 226 */     if (idCard.length() != 15) {
/* 227 */       return false;
/*     */     }
/* 229 */     if (isNum(idCard)) {
/* 230 */       String proCode = idCard.substring(0, 2);
/* 231 */       if (cityCodes.get(proCode) == null) {
/* 232 */         return false;
/*     */       }
/* 234 */       String birthCode = idCard.substring(6, 12);
/* 235 */       Date birthDate = null;
/*     */       try {
/* 237 */         birthDate = new SimpleDateFormat("yy").parse(birthCode.substring(0, 2));
/*     */       } catch (ParseException e) {
/* 239 */         e.printStackTrace();
/*     */       }
/* 241 */       Calendar cal = Calendar.getInstance();
/* 242 */       if (birthDate != null) {
/* 243 */         cal.setTime(birthDate);
/*     */       }
/* 245 */       if (!(valiDate(cal.get(1), Integer.valueOf(birthCode.substring(2, 4)).intValue(), Integer.valueOf(birthCode.substring(4, 6)).intValue())))
/*     */       {
/* 247 */         return false;
/*     */       }
/*     */     } else {
/* 250 */       return false;
/*     */     }
/* 252 */     return true;
/*     */   }
/*     */ 
/*     */   public static String[] validateIdCard10(String idCard)
/*     */   {
/* 266 */     String[] info = new String[3];
/* 267 */     String card = idCard.replaceAll("[\\(|\\)]", "");
/* 268 */     if ((card.length() != 8) && (card.length() != 9) && (idCard.length() != 10)) {
/* 269 */       return null;
/*     */     }
/* 271 */     if (idCard.matches("^[a-zA-Z][0-9]{9}$")) {
/* 272 */       info[0] = "台湾";
/* 273 */       String char2 = idCard.substring(1, 2);
/* 274 */       if (char2.equals("1")) {
/* 275 */         info[1] = "M";
/* 276 */       } else if (char2.equals("2")) {
/* 277 */         info[1] = "F";
/*     */       } else {
/* 279 */         info[1] = "N";
/* 280 */         info[2] = "false";
/* 281 */         return info;
/*     */       }
/* 283 */       info[2] = ((validateTWCard(idCard)) ? "true" : "false");
/* 284 */     } else if (idCard.matches("^[1|5|7][0-9]{6}\\(?[0-9A-Z]\\)?$")) {
/* 285 */       info[0] = "澳门";
/* 286 */       info[1] = "N";
/*     */     }
/* 288 */     else if (idCard.matches("^[A-Z]{1,2}[0-9]{6}\\(?[0-9A]\\)?$")) {
/* 289 */       info[0] = "香港";
/* 290 */       info[1] = "N";
/* 291 */       info[2] = ((validateHKCard(idCard)) ? "true" : "false");
/*     */     } else {
/* 293 */       return null;
/*     */     }
/* 295 */     return info;
/*     */   }
/*     */ 
/*     */   public static boolean validateTWCard(String idCard)
/*     */   {
/* 306 */     String start = idCard.substring(0, 1);
/* 307 */     String mid = idCard.substring(1, 9);
/* 308 */     String end = idCard.substring(9, 10);
/* 309 */     Integer iStart = (Integer)twFirstCode.get(start);
/* 310 */     Integer sum = Integer.valueOf(iStart.intValue() / 10 + iStart.intValue() % 10 * 9);
/* 311 */     char[] chars = mid.toCharArray();
/* 312 */     Integer iflag = Integer.valueOf(8);
/*     */     Integer localInteger1;
/* 313 */     for (char c : chars) {
/* 314 */       sum = Integer.valueOf(sum.intValue() + Integer.valueOf(c + "").intValue() * iflag.intValue());
/* 315 */       localInteger1 = iflag; Integer localInteger2 = iflag = Integer.valueOf(iflag.intValue() - 1);
/*     */     }
/* 317 */     return (((sum.intValue() % 10 == 0) ? 0 : 10 - (sum.intValue() % 10)) == Integer.valueOf(end).intValue());
/*     */   }
/*     */ 
/*     */   public static boolean validateHKCard(String idCard)
/*     */   {
/* 334 */     String card = idCard.replaceAll("[\\(|\\)]", "");
/* 335 */     Integer sum = Integer.valueOf(0);
/* 336 */     if (card.length() == 9) {
/* 337 */       sum = Integer.valueOf((Integer.valueOf(card.substring(0, 1).toUpperCase().toCharArray()[0]).intValue() - 55) * 9 + (Integer.valueOf(card.substring(1, 2).toUpperCase().toCharArray()[0]).intValue() - 55) * 8);
/*     */ 
/* 339 */       card = card.substring(1, 9);
/*     */     } else {
/* 341 */       sum = Integer.valueOf(522 + (Integer.valueOf(card.substring(0, 1).toUpperCase().toCharArray()[0]).intValue() - 55) * 8);
/*     */     }
/*     */ 
/* 344 */     String mid = card.substring(1, 7);
/* 345 */     String end = card.substring(7, 8);
/* 346 */     char[] chars = mid.toCharArray();
/* 347 */     Integer iflag = Integer.valueOf(7);
/*     */     Integer localInteger1;
/* 348 */     for (char c : chars) {
/* 349 */       sum = Integer.valueOf(sum.intValue() + Integer.valueOf(c + "").intValue() * iflag.intValue());
/* 350 */       localInteger1 = iflag; Integer localInteger2 = iflag = Integer.valueOf(iflag.intValue() - 1);
/*     */     }
/* 352 */     if (end.toUpperCase().equals("A"))
/* 353 */       sum = Integer.valueOf(sum.intValue() + 10);
/*     */     else {
/* 355 */       sum = Integer.valueOf(sum.intValue() + Integer.valueOf(end).intValue());
/*     */     }
/* 357 */     return (sum.intValue() % 11 == 0);
/*     */   }
/*     */ 
/*     */   public static int[] converCharToInt(char[] ca)
/*     */   {
/* 368 */     int len = ca.length;
/* 369 */     int[] iArr = new int[len];
/*     */     try {
/* 371 */       for (int i = 0; i < len; ++i)
/* 372 */         iArr[i] = Integer.parseInt(String.valueOf(ca[i]));
/*     */     }
/*     */     catch (NumberFormatException e) {
/* 375 */       e.printStackTrace();
/*     */     }
/* 377 */     return iArr;
/*     */   }
/*     */ 
/*     */   public static int getPowerSum(int[] iArr)
/*     */   {
/* 387 */     int iSum = 0;
/* 388 */     if (POWER.length == iArr.length) {
/* 389 */       for (int i = 0; i < iArr.length; ++i) {
/* 390 */         for (int j = 0; j < POWER.length; ++j) {
/* 391 */           if (i == j) {
/* 392 */             iSum += iArr[i] * POWER[j];
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 397 */     return iSum;
/*     */   }
/*     */ 
/*     */   public static String getCheckCode18(int iSum)
/*     */   {
/* 407 */     String sCode = "";
/* 408 */     switch (iSum % 11)
/*     */     {
/*     */     case 10:
/* 410 */       sCode = "2";
/* 411 */       break;
/*     */     case 9:
/* 413 */       sCode = "3";
/* 414 */       break;
/*     */     case 8:
/* 416 */       sCode = "4";
/* 417 */       break;
/*     */     case 7:
/* 419 */       sCode = "5";
/* 420 */       break;
/*     */     case 6:
/* 422 */       sCode = "6";
/* 423 */       break;
/*     */     case 5:
/* 425 */       sCode = "7";
/* 426 */       break;
/*     */     case 4:
/* 428 */       sCode = "8";
/* 429 */       break;
/*     */     case 3:
/* 431 */       sCode = "9";
/* 432 */       break;
/*     */     case 2:
/* 434 */       sCode = "x";
/* 435 */       break;
/*     */     case 1:
/* 437 */       sCode = "0";
/* 438 */       break;
/*     */     case 0:
/* 440 */       sCode = "1";
/*     */     }
/*     */ 
/* 445 */     return sCode;
/*     */   }
/*     */ 
/*     */   public static int getAgeByIdCard(String idCard)
/*     */   {
/* 456 */     if (!(validateCard(idCard))) {
/* 457 */       return -1;
/*     */     }
/* 459 */     if (idCard.length() == 15) {
/* 460 */       idCard = conver15CardTo18(idCard);
/*     */     }
/*     */ 
/* 463 */     Calendar cal = Calendar.getInstance();
/* 464 */     int iAge = cal.get(1) - Integer.valueOf(idCard.substring(6, 10)).intValue();
/* 465 */     int iMonth = cal.get(2) + 1 - Integer.valueOf(idCard.substring(10, 12)).intValue();
/* 466 */     int iDay = cal.get(5) - Integer.valueOf(idCard.substring(12, 14)).intValue();
/* 467 */     if ((iMonth < 0) || ((iMonth == 0) && (iDay < 0))) {
/* 468 */       --iAge;
/*     */     }
/* 470 */     return iAge;
/*     */   }
/*     */ 
/*     */   public static String getBirthByIdCard(String idCard)
/*     */   {
/* 480 */     Integer len = Integer.valueOf(idCard.length());
/* 481 */     if (len.intValue() < 15)
/* 482 */       return null;
/* 483 */     if (len.intValue() == 15) {
/* 484 */       idCard = conver15CardTo18(idCard);
/*     */     }
/* 486 */     return idCard.substring(6, 14);
/*     */   }
/*     */ 
/*     */   public static Short getYearByIdCard(String idCard)
/*     */   {
/* 496 */     Integer len = Integer.valueOf(idCard.length());
/* 497 */     if (len.intValue() < 15)
/* 498 */       return null;
/* 499 */     if (len.intValue() == 15) {
/* 500 */       idCard = conver15CardTo18(idCard);
/*     */     }
/* 502 */     return Short.valueOf(idCard.substring(6, 10));
/*     */   }
/*     */ 
/*     */   public static Short getMonthByIdCard(String idCard)
/*     */   {
/* 513 */     Integer len = Integer.valueOf(idCard.length());
/* 514 */     if (len.intValue() < 15)
/* 515 */       return null;
/* 516 */     if (len.intValue() == 15) {
/* 517 */       idCard = conver15CardTo18(idCard);
/*     */     }
/* 519 */     return Short.valueOf(idCard.substring(10, 12));
/*     */   }
/*     */ 
/*     */   public static Short getDateByIdCard(String idCard)
/*     */   {
/* 530 */     Integer len = Integer.valueOf(idCard.length());
/* 531 */     if (len.intValue() < 15)
/* 532 */       return null;
/* 533 */     if (len.intValue() == 15) {
/* 534 */       idCard = conver15CardTo18(idCard);
/*     */     }
/* 536 */     return Short.valueOf(idCard.substring(12, 14));
/*     */   }
/*     */ 
/*     */   public static String getGenderByIdCard(String idCard)
/*     */   {
/* 546 */     String sGender = "N";
/* 547 */     if (idCard.length() == 15) {
/* 548 */       idCard = conver15CardTo18(idCard);
/*     */     }
/* 550 */     String sCardNum = idCard.substring(16, 17);
/* 551 */     if (Integer.parseInt(sCardNum) % 2 != 0)
/* 552 */       sGender = "M";
/*     */     else {
/* 554 */       sGender = "F";
/*     */     }
/* 556 */     return sGender;
/*     */   }
/*     */ 
/*     */   public static String getProvinceByIdCard(String idCard)
/*     */   {
/* 566 */     int len = idCard.length();
/* 567 */     String sProvince = null;
/* 568 */     String sProvinNum = "";
/* 569 */     if ((len == 15) || (len == 18)) {
/* 570 */       sProvinNum = idCard.substring(0, 2);
/*     */     }
/* 572 */     sProvince = (String)cityCodes.get(sProvinNum);
/* 573 */     return sProvince;
/*     */   }
/*     */ 
/*     */   public static boolean isNum(String val)
/*     */   {
/* 583 */     return (((val == null) || ("".equals(val))) ? false : val.matches("^[0-9]*$"));
/*     */   }
/*     */ 
/*     */   public static boolean valiDate(int iYear, int iMonth, int iDate)
/*     */   {
/* 598 */     Calendar cal = Calendar.getInstance();
/* 599 */     int year = cal.get(1);
/*     */ 
/* 601 */     if ((iYear < 1930) || (iYear >= year)) {
/* 602 */       return false;
/*     */     }
/* 604 */     if ((iMonth < 1) || (iMonth > 12))
/* 605 */       return false;
/*     */     int datePerMonth;
/* 607 */     switch (iMonth)
/*     */     {
/*     */     case 4:
/*     */     case 6:
/*     */     case 9:
/*     */     case 11:
/* 612 */       datePerMonth = 30;
/* 613 */       break;
/*     */     case 2:
/* 615 */       boolean dm = ((iYear % 4 == 0) && (iYear % 100 != 0)) || ((iYear % 400 == 0) && (iYear > 1930) && (iYear < year));
/*     */ 
/* 617 */       datePerMonth = (dm) ? 29 : 28;
/* 618 */       break;
/*     */     case 3:
/*     */     case 5:
/*     */     case 7:
/*     */     case 8:
/*     */     case 10:
/*     */     default:
/* 620 */       datePerMonth = 31;
/*     */     }
/* 622 */     return ((iDate >= 1) && (iDate <= datePerMonth));
/*     */   }
/*     */ 
/*     */   static
/*     */   {
/*  53 */     cityCodes.put("11", "北京");
/*  54 */     cityCodes.put("12", "天津");
/*  55 */     cityCodes.put("13", "河北");
/*  56 */     cityCodes.put("14", "山西");
/*  57 */     cityCodes.put("15", "内蒙古");
/*  58 */     cityCodes.put("21", "辽宁");
/*  59 */     cityCodes.put("22", "吉林");
/*  60 */     cityCodes.put("23", "黑龙江");
/*  61 */     cityCodes.put("31", "上海");
/*  62 */     cityCodes.put("32", "江苏");
/*  63 */     cityCodes.put("33", "浙江");
/*  64 */     cityCodes.put("34", "安徽");
/*  65 */     cityCodes.put("35", "福建");
/*  66 */     cityCodes.put("36", "江西");
/*  67 */     cityCodes.put("37", "山东");
/*  68 */     cityCodes.put("41", "河南");
/*  69 */     cityCodes.put("42", "湖北");
/*  70 */     cityCodes.put("43", "湖南");
/*  71 */     cityCodes.put("44", "广东");
/*  72 */     cityCodes.put("45", "广西");
/*  73 */     cityCodes.put("46", "海南");
/*  74 */     cityCodes.put("50", "重庆");
/*  75 */     cityCodes.put("51", "四川");
/*  76 */     cityCodes.put("52", "贵州");
/*  77 */     cityCodes.put("53", "云南");
/*  78 */     cityCodes.put("54", "西藏");
/*  79 */     cityCodes.put("61", "陕西");
/*  80 */     cityCodes.put("62", "甘肃");
/*  81 */     cityCodes.put("63", "青海");
/*  82 */     cityCodes.put("64", "宁夏");
/*  83 */     cityCodes.put("65", "新疆");
/*  84 */     cityCodes.put("71", "台湾");
/*  85 */     cityCodes.put("81", "香港");
/*  86 */     cityCodes.put("82", "澳门");
/*  87 */     cityCodes.put("91", "国外");
/*  88 */     twFirstCode.put("A", Integer.valueOf(10));
/*  89 */     twFirstCode.put("B", Integer.valueOf(11));
/*  90 */     twFirstCode.put("C", Integer.valueOf(12));
/*  91 */     twFirstCode.put("D", Integer.valueOf(13));
/*  92 */     twFirstCode.put("E", Integer.valueOf(14));
/*  93 */     twFirstCode.put("F", Integer.valueOf(15));
/*  94 */     twFirstCode.put("G", Integer.valueOf(16));
/*  95 */     twFirstCode.put("H", Integer.valueOf(17));
/*  96 */     twFirstCode.put("J", Integer.valueOf(18));
/*  97 */     twFirstCode.put("K", Integer.valueOf(19));
/*  98 */     twFirstCode.put("L", Integer.valueOf(20));
/*  99 */     twFirstCode.put("M", Integer.valueOf(21));
/* 100 */     twFirstCode.put("N", Integer.valueOf(22));
/* 101 */     twFirstCode.put("P", Integer.valueOf(23));
/* 102 */     twFirstCode.put("Q", Integer.valueOf(24));
/* 103 */     twFirstCode.put("R", Integer.valueOf(25));
/* 104 */     twFirstCode.put("S", Integer.valueOf(26));
/* 105 */     twFirstCode.put("T", Integer.valueOf(27));
/* 106 */     twFirstCode.put("U", Integer.valueOf(28));
/* 107 */     twFirstCode.put("V", Integer.valueOf(29));
/* 108 */     twFirstCode.put("X", Integer.valueOf(30));
/* 109 */     twFirstCode.put("Y", Integer.valueOf(31));
/* 110 */     twFirstCode.put("W", Integer.valueOf(32));
/* 111 */     twFirstCode.put("Z", Integer.valueOf(33));
/* 112 */     twFirstCode.put("I", Integer.valueOf(34));
/* 113 */     twFirstCode.put("O", Integer.valueOf(35));
/* 114 */     hkFirstCode.put("A", Integer.valueOf(1));
/* 115 */     hkFirstCode.put("B", Integer.valueOf(2));
/* 116 */     hkFirstCode.put("C", Integer.valueOf(3));
/* 117 */     hkFirstCode.put("R", Integer.valueOf(18));
/* 118 */     hkFirstCode.put("U", Integer.valueOf(21));
/* 119 */     hkFirstCode.put("Z", Integer.valueOf(26));
/* 120 */     hkFirstCode.put("X", Integer.valueOf(24));
/* 121 */     hkFirstCode.put("W", Integer.valueOf(23));
/* 122 */     hkFirstCode.put("O", Integer.valueOf(15));
/* 123 */     hkFirstCode.put("N", Integer.valueOf(14));
/*     */   }
/*     */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.base.util.IdcardUtils
 * JD-Core Version:    0.5.3
 */
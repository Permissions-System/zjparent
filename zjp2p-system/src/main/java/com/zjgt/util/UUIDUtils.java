/*     */ package com.zjgt.util;
/*     */ 
/*     */ import java.net.UnknownHostException;
/*     */ import java.util.StringTokenizer;
/*     */ import java.util.UUID;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ public class UUIDUtils
/*     */ {
/*  33 */   private static char[] radixDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
/*     */ 
/*  49 */   Logger logger = LoggerFactory.getLogger(UUIDUtils.class);
/*     */ 
/*     */   public static String generate()
/*     */   {
/*  77 */     StringBuffer uid = new StringBuffer(32);
/*     */ 
/*  80 */     uid.append(getSystemMillisRadix32());
/*     */ 
/*  95 */     UUID randomUUid = UUID.randomUUID();
/*     */ 
/*  97 */     uid = uid.append(randomUUid.toString().replaceAll("-", "").substring(0, 3));
/*     */ 
/*  99 */     return uid.toString();
/*     */   }
/*     */ 
/*     */   public static String getIPAddress(String uuid)
/*     */     throws UnknownHostException
/*     */   {
/* 111 */     String ipHex = uuid.substring(12, 20);
/* 112 */     StringBuffer buf = new StringBuffer();
/* 113 */     buf.append(toInt(ipHex.substring(6, 8), 2)).append(".");
/* 114 */     buf.append(toInt(ipHex.substring(4, 6), 2)).append(".");
/* 115 */     buf.append(toInt(ipHex.substring(2, 4), 2)).append(".");
/* 116 */     buf.append(toInt(ipHex.substring(0, 2), 2));
/* 117 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   public static int getPort(String uuid)
/*     */   {
/* 127 */     int port = toInt(uuid.substring(20, 24), 4);
/* 128 */     return port;
/*     */   }
/*     */ 
/*     */   public static long getTimestamp(String uuid)
/*     */   {
/* 138 */     String timestampStr = uuid.substring(0, 9);
/* 139 */     return Long.parseLong(timestampStr, 32);
/*     */   }
/*     */ 
/*     */   private static int[] getIPAddressIntAry(String ipAddr)
/*     */   {
/* 189 */     String ipStr = ipAddr.trim();
/* 190 */     if ("localhost".equalsIgnoreCase(ipStr)) {
/* 191 */       ipStr = "127.0.0.1";
/*     */     }
/*     */ 
/* 194 */     int[] addrInts = new int[4];
/* 195 */     StringTokenizer tokenizer = new StringTokenizer(ipStr, ".");
/* 196 */     int i = 0;
/* 197 */     while (tokenizer.hasMoreTokens()) {
/* 198 */       String token = tokenizer.nextToken();
/* 199 */       addrInts[(i++)] = Integer.parseInt(token);
/*     */     }
/* 201 */     return addrInts;
/*     */   }
/*     */ 
/*     */   private static String getSystemMillisRadix32()
/*     */   {
/* 210 */     String millisStr = Long.toString(System.currentTimeMillis(), 32).toUpperCase();
/* 211 */     int len = millisStr.length();
/* 212 */     if (len < 9) {
/* 213 */       StringBuffer buffer = new StringBuffer(10);
/* 214 */       buffer.append(millisStr);
/* 215 */       int offset = 9 - len;
/* 216 */       for (int i = 0; i < offset; ++i) {
/* 217 */         buffer.append("0");
/*     */       }
/* 219 */       millisStr = buffer.toString();
/* 220 */     } else if (len > 9) {
/* 221 */       millisStr = millisStr.substring(len - 9);
/*     */     }
/* 223 */     return millisStr;
/*     */   }
/*     */ 
/*     */   private static String toHex(int value, int length)
/*     */   {
/* 238 */     StringBuffer buffer = new StringBuffer(length);
/* 239 */     int shift = length - 1 << 2;
/* 240 */     for (int i = -1; ++i < length; ) {
/* 241 */       buffer.append(radixDigits[(value >> shift & 0xF)]);
/* 242 */       value <<= 4;
/*     */     }
/*     */ 
/* 245 */     return buffer.toString();
/*     */   }
/*     */ 
/*     */   private static String toHex(int[] intAry)
/*     */   {
/* 251 */     StringBuffer buffer = new StringBuffer(intAry.length * 2);
/* 252 */     for (int i = 0; i < intAry.length; ++i) {
/* 253 */       int int1 = intAry[i];
/* 254 */       int int2 = int1 >> 4;
/* 255 */       buffer.append(radixDigits[(int2 & 0xF)]);
/* 256 */       buffer.append(radixDigits[(int1 & 0xF)]);
/*     */     }
/* 258 */     return buffer.toString();
/*     */   }
/*     */ 
/*     */   private static int toInt(byte[] bytes)
/*     */   {
/* 264 */     int value = 0;
/* 265 */     int aryLen = bytes.length;
/* 266 */     for (int i = aryLen - 1; i >= 0; --i) {
/* 267 */       value <<= 8;
/* 268 */       value |= bytes[i] & 0xFF;
/*     */     }
/*     */ 
/* 271 */     return value;
/*     */   }
/*     */ 
/*     */   private static int toInt(String hexStr, int len)
/*     */   {
/* 281 */     int value = 0;
/*     */ 
/* 284 */     for (int i = 0; i < len; i += 2) {
/* 285 */       char c = hexStr.charAt(i);
/*     */       int high;
/* 286 */       if (c <= '9')
/* 287 */         high = c - '0';
/*     */       else {
/* 289 */         high = '\n' + c - 65;
/*     */       }
/* 291 */       c = hexStr.charAt(i + 1);
/*     */       int low;
/* 292 */       if (c <= '9')
/* 293 */         low = c - '0';
/*     */       else {
/* 295 */         low = '\n' + c - 65;
/*     */       }
/* 297 */       value <<= 8;
/* 298 */       value |= (0xFF & high) << 4 | 0xFF & low;
/*     */     }
/* 300 */     return value;
/*     */   }
/*     */ 
/*     */   public static byte[] toBytes(int value)
/*     */   {
/* 308 */     byte[] bytes = new byte[4];
/* 309 */     bytes[0] = (byte)(value & 0xFF);
/* 310 */     value >>>= 8;
/* 311 */     bytes[1] = (byte)(value & 0xFF);
/* 312 */     value >>>= 8;
/* 313 */     bytes[2] = (byte)(value & 0xFF);
/* 314 */     value >>>= 8;
/* 315 */     bytes[3] = (byte)(value & 0xFF);
/* 316 */     return bytes;
/*     */   }
/*     */ 
/*     */   public static String toHex(byte[] byteAry)
/*     */   {
/* 323 */     StringBuffer buffer = new StringBuffer(byteAry.length * 2);
/* 324 */     for (int i = byteAry.length - 1; i >= 0; --i) {
/* 325 */       int b1 = byteAry[i] & 0xF;
/* 326 */       int b2 = byteAry[i] >>> 4 & 0xF;
/* 327 */       buffer.append(radixDigits[b2]);
/* 328 */       buffer.append(radixDigits[b1]);
/*     */     }
/* 330 */     return buffer.toString();
/*     */   }
/*     */ 
/*     */   public static String toShortString(UUID u)
/*     */   {
/* 391 */     long mostSigBits = u.getMostSignificantBits();
/* 392 */     long leastSigBits = u.getLeastSignificantBits();
/* 393 */     return digits(mostSigBits >> 32, 8) + digits(mostSigBits >> 16, 4) + digits(mostSigBits, 4) + digits(leastSigBits >> 48, 4) + digits(leastSigBits, 12);
/*     */   }
/*     */ 
/*     */   private static String digits(long val, int digits)
/*     */   {
/* 408 */     long hi = 1L << digits * 4;
/* 409 */     return Long.toString(hi | val & hi - 1L, 36).substring(1);
/*     */   }
/*     */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.util.UUIDUtils
 * JD-Core Version:    0.5.3
 */
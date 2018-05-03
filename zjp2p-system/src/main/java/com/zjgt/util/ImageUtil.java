/*     */ package com.zjgt.util;
/*     */ 
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.PrintStream;
/*     */ import java.net.URL;
/*     */ import java.util.Iterator;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.imageio.stream.FileImageInputStream;
/*     */ import javax.imageio.stream.FileImageOutputStream;
/*     */ import javax.imageio.stream.ImageInputStream;
/*     */ import javax.imageio.stream.ImageOutputStream;
/*     */ 
/*     */ public class ImageUtil
/*     */ {
/*     */   public static boolean updateImg(String inUrl, String outUrl)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       File inFile = new File(inUrl);
/*  28 */       File outFile = new File(outUrl + "\\" + inFile.getName());
/*  29 */       ImageInputStream iis = ImageIO.createImageInputStream(inFile);
/*  30 */       Iterator iter = ImageIO.getImageReaders(iis);
/*  31 */       if (!(iter.hasNext())) {
/*  32 */         boolean e = inFile.delete();
/*  33 */         System.out.println("文件不是图片: " + e);
/*  34 */         return false;
/*     */       }
/*     */ 
/*  37 */       ImageOutputStream fos = new FileImageOutputStream(outFile);
/*     */ 
/*  39 */       ImageInputStream fis = new FileImageInputStream(inFile);
/*  40 */       byte[] buffer = new byte[1024];
/*  41 */       int len = 0;
/*     */ 
/*  43 */       while ((len = fis.read(buffer)) > 0) {
/*  44 */         fos.write(buffer, 0, len);
/*     */       }
/*  46 */       fis.close();
/*  47 */       fos.close();
/*     */     }
/*     */     catch (Exception e) {
/*  50 */       e.printStackTrace();
/*     */     }
/*  52 */     return true;
/*     */   }
/*     */ 
/*     */   public static boolean updateImg(File inFile, String outUrl)
/*     */   {
/*     */     try
/*     */     {
/*  62 */       File outFile = new File(outUrl + "\\" + inFile.getName());
/*  63 */       ImageInputStream iis = ImageIO.createImageInputStream(inFile);
/*  64 */       Iterator iter = ImageIO.getImageReaders(iis);
/*  65 */       if (!(iter.hasNext())) {
/*  66 */         boolean e = inFile.delete();
/*  67 */         System.out.println("文件不是图片: " + e);
/*  68 */         return false;
/*     */       }
/*     */ 
/*  71 */       ImageOutputStream fos = new FileImageOutputStream(outFile);
/*     */ 
/*  73 */       ImageInputStream fis = new FileImageInputStream(inFile);
/*  74 */       byte[] buffer = new byte[1024];
/*  75 */       int len = 0;
/*     */ 
/*  77 */       while ((len = fis.read(buffer)) > 0) {
/*  78 */         fos.write(buffer, 0, len);
/*     */       }
/*  80 */       fis.close();
/*  81 */       fos.close();
/*     */     }
/*     */     catch (Exception e) {
/*  84 */       e.printStackTrace();
/*     */     }
/*  86 */     return true;
/*     */   }
/*     */ 
/*     */   public static BufferedImage downImg(File inFile)
/*     */   {
/*  95 */     ImageInputStream fis = null;
/*  96 */     BufferedImage image = null;
/*     */     try {
/*  98 */       fis = new FileImageInputStream(inFile);
/*  99 */       image = ImageIO.read(fis);
/* 100 */       return image;
/*     */     } catch (Exception e) {
/* 102 */       e.printStackTrace();
/*     */     }
/* 104 */     return null;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 111 */     String filepath = "D:\\Desert.jpg";
/* 112 */     String outUrl = "/img";
/* 113 */     URL path = ImageUtil.class.getClassLoader().getResource("");
/* 114 */     System.out.println(path);
/* 115 */     System.out.println(getXmlPath());
/* 116 */     updateImg(filepath, getXmlPath());
/*     */   }
/*     */ 
/*     */   public static String getXmlPath()
/*     */   {
/* 128 */     String path = Thread.currentThread().getContextClassLoader().getResource("").toString();
/*     */ 
/* 130 */     path = path.replace('/', '\\');
/* 131 */     path = path.replace("file:", "");
/* 132 */     path = path.replace("classes\\", "");
/* 133 */     path = path.replace("WEB-INF", "img");
/* 134 */     path = path.substring(1);
/*     */ 
/* 136 */     return path;
/*     */   }
/*     */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.util.ImageUtil
 * JD-Core Version:    0.5.3
 */
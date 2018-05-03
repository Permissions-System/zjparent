package com.zjgt.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.PrintStream;
import java.net.URL;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;

public class ImageUtil
{
  public static boolean updateImg(String inUrl, String outUrl)
  {
    try
    {
      File inFile = new File(inUrl);
      File outFile = new File(outUrl + "\\" + inFile.getName());
      ImageInputStream iis = ImageIO.createImageInputStream(inFile);
      Iterator iter = ImageIO.getImageReaders(iis);
      if (!(iter.hasNext())) {
        boolean e = inFile.delete();
        System.out.println("文件不是图片: " + e);
        return false;
      }

      ImageOutputStream fos = new FileImageOutputStream(outFile);

      ImageInputStream fis = new FileImageInputStream(inFile);
      byte[] buffer = new byte[1024];
      int len = 0;

      while ((len = fis.read(buffer)) > 0) {
        fos.write(buffer, 0, len);
      }
      fis.close();
      fos.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return true;
  }

  public static boolean updateImg(File inFile, String outUrl)
  {
    try
    {
      File outFile = new File(outUrl + "\\" + inFile.getName());
      ImageInputStream iis = ImageIO.createImageInputStream(inFile);
      Iterator iter = ImageIO.getImageReaders(iis);
      if (!(iter.hasNext())) {
        boolean e = inFile.delete();
        System.out.println("文件不是图片: " + e);
        return false;
      }

      ImageOutputStream fos = new FileImageOutputStream(outFile);

      ImageInputStream fis = new FileImageInputStream(inFile);
      byte[] buffer = new byte[1024];
      int len = 0;

      while ((len = fis.read(buffer)) > 0) {
        fos.write(buffer, 0, len);
      }
      fis.close();
      fos.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return true;
  }

  public static BufferedImage downImg(File inFile)
  {
    ImageInputStream fis = null;
    BufferedImage image = null;
    try {
      fis = new FileImageInputStream(inFile);
      image = ImageIO.read(fis);
      return image;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void main(String[] args)
  {
    String filepath = "D:\\Desert.jpg";
    String outUrl = "/img";
    URL path = ImageUtil.class.getClassLoader().getResource("");
    System.out.println(path);
    System.out.println(getXmlPath());
    updateImg(filepath, getXmlPath());
  }

  public static String getXmlPath()
  {
    String path = Thread.currentThread().getContextClassLoader().getResource("").toString();

    path = path.replace('/', '\\');
    path = path.replace("file:", "");
    path = path.replace("classes\\", "");
    path = path.replace("WEB-INF", "img");
    path = path.substring(1);

    return path;
  }
}
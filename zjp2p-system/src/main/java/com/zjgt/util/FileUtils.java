package com.zjgt.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils
{
  private static final int BUFFER_SIZE = 16384;

  public static boolean mkdir(String dirName)
  {
    File dir = new File(dirName);
    if (dir.exists()) {
      return false;
    }
    if (!(dirName.endsWith(File.separator)))
      dirName = dirName + File.separator;
    return (dir.mkdirs());
  }

  public static BufferedReader initBufferedReader(File file)
  {
    return initBufferedReader(file, "UTF-8");
  }

  public static BufferedReader initBufferedReader(File file, String encode)
  {
    BufferedReader reader = null;
    try {
      FileInputStream in = new FileInputStream(file);
      InputStreamReader inreader = new InputStreamReader(in, encode);
      reader = new BufferedReader(inreader);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return reader;
  }

  public static BufferedReader initBufferedReader(InputStream inputStream, String encode)
  {
    BufferedReader reader = null;
    try {
      InputStreamReader inreader = new InputStreamReader(inputStream, encode);

      reader = new BufferedReader(inreader);
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return reader;
  }

  public static String readFromInputStream(InputStream inputStream) {
    BufferedReader reader = initBufferedReader(inputStream, "UTF-8");
    return read(reader);
  }

  public static String readFromInputStream(InputStream inputStream, String encode)
  {
    BufferedReader reader = initBufferedReader(inputStream, encode);

    return read(reader);
  }

  public static String read(BufferedReader reader)
  {
    StringBuffer buffer = new StringBuffer("");
    if (reader != null) {
      String str = "";
      String LINE_SEPARATOR = System.getProperty("line.separator");
      try {
        while ((str = reader.readLine()) != null)
          buffer.append(str).append(LINE_SEPARATOR);
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }
    return buffer.toString();
  }

  public static String readFromFile(File file) {
    return readFromFile(file, "UTF-8");
  }

  public static String readFromFile(File file, String encode) {
    BufferedReader reader = initBufferedReader(file, encode);
    return read(reader);
  }

  public static List<String> readFromFileAsList(File file, String encode, int initialCapcity)
  {
    List fileList = new ArrayList(initialCapcity);
    BufferedReader bfReader = initBufferedReader(file, encode);
    if (bfReader != null)
      try
      {
    	  String str=null;
        while (( str = bfReader.readLine()) != null)
        {
          fileList.add(str); }
      } catch (Exception e) {
        e.printStackTrace();
      }
    try
    {
      bfReader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return fileList;
  }

  public static List<String> readFromInputStreamAsList(InputStream inputStream, String encode)
  {
    List fileList = new ArrayList();
    try {
      InputStreamReader inreader = new InputStreamReader(inputStream, encode);

      BufferedReader reader = new BufferedReader(inreader);

      String tmps;
      while ((tmps = reader.readLine()) != null)
      {
        fileList.add(tmps);
      }
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return fileList;
  }

  public static String readAll(String path) {
    try {
      BufferedReader br = initBufferedReader(new File(path));

      StringBuffer sb = new StringBuffer();
      String tmps;
      while ((tmps = br.readLine()) != null)
      {
        sb.append(tmps + "\n");
      }
      return sb.toString();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static List<String> readLines(String path) {
    try {
      BufferedReader br = initBufferedReader(new File(path));

      List strlist = new ArrayList();
      String tmps;
      while ((tmps = br.readLine()) != null)
      {
        strlist.add(tmps);
      }
      return strlist;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void writeTofile(String filename, String content) {
    writeTofile(filename, content, "UTF-8");
  }

  public static void writeTofile(String filename, String content, Boolean b) {
    writeTofile(filename, content, "UTF-8", b);
  }

  public static void writeTofile(String filename, String content, String encode, Boolean b)
  {
    try {
      FileOutputStream out = new FileOutputStream(filename, b.booleanValue());
      OutputStreamWriter outwriter = new OutputStreamWriter(out, encode);
      BufferedWriter writer = new BufferedWriter(outwriter);
      writer.write(content);
      writer.flush();
      writer.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void writeTofile(String filename, String content, String encode)
  {
    writeTofile(filename, content, encode, Boolean.valueOf(true));
  }

  public static void inputStreamToFile(InputStream ins, File file) {
    OutputStream os = null;
    try {
      os = new FileOutputStream(file);
      int bytesRead = 0;
      byte[] buffer = new byte[8192];
      while ((bytesRead = ins.read(buffer, 0, 8192)) != -1)
        os.write(buffer, 0, bytesRead);
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (ins != null)
        try {
          ins.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      if (os != null)
        try {
          os.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
    }
  }

  public static void copy(File src, String dst)
  {
    try
    {
      InputStream in = null;
      OutputStream out = null;
      try {
        in = new BufferedInputStream(new FileInputStream(src), 16384);

        out = new BufferedOutputStream(new FileOutputStream(dst), 16384);

        byte[] buffer = new byte[16384];
        while (in.read(buffer) > 0)
          out.write(buffer);
      }
      finally {
        if (null != in) {
          in.close();
        }
        if (null != out)
          out.close();
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void copy(File src, File dst)
  {
    try {
      InputStream in = null;
      OutputStream out = null;
      try {
        in = new BufferedInputStream(new FileInputStream(src), 16384);

        out = new BufferedOutputStream(new FileOutputStream(dst), 16384);

        byte[] buffer = new byte[16384];
        while (in.read(buffer) > 0)
          out.write(buffer);
      }
      finally {
        if (null != in) {
          in.close();
        }
        if (null != out)
          out.close();
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static boolean deleteFile(String sPath) {
    boolean flag = false;
    File file = new File(sPath);

    if ((file.isFile()) && (file.exists())) {
      file.delete();
      flag = true;
    }
    return flag;
  }

  public static void main(String[] args) {
    String filepath = "D:\\image\\0.jpg";
    String outUrl = "D:\\images";
    File f = new File(filepath);
    System.out.println(f.getName());
    copy(f, outUrl + "\\" + f.getName());
  }
}
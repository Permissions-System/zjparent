package com.zjgt.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import javax.imageio.ImageIO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DrawImgeUtil
{
  static Logger logger = LoggerFactory.getLogger(DrawImgeUtil.class);

  public static String getValidationCodes(OutputStream os) {
    char[] codeTable = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    BufferedImage image = new BufferedImage(100, 43, 1);

    Graphics graphic = image.getGraphics();

    graphic.setColor(new Color(14474460));
    graphic.fillRect(0, 0, 100, 43);

    char[] codes = new char[4];

    for (int i = 0; i <= 3; ++i) {
      codes[i] = codeTable[(int)(codeTable.length * java.lang.Math.random())];
    }

    graphic.setColor(Color.BLACK);
    graphic.setFont(new Font("Arial", 1, 20));
    for (int i = 0; i <= 3; ++i) {
      graphic.drawChars(codes, i, 1, 2 + 25 * i, 25 + i);
    }

    Random rand = new Random();
    for (int i = 0; i < 15; ++i) {
      graphic.drawOval(rand.nextInt(120), rand.nextInt(40), 1, 1);
    }

    graphic.dispose();
    try
    {
      ImageIO.write(image, "JPEG", os);
    } catch (IOException e) {
      logger.error("生成验证码失败 , " + e);
    }
    return new String(codes, 0, codes.length);
  }
}
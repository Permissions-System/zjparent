package com.zjgt.util;

public class RichManUtil
{
  public static double countWorth(RichManBean richMan)
  {
    return (richMan.sumEveryYear() + richMan.saveNYear());
  }
}
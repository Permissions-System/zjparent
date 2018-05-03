package com.zjgt.util;

public class RichManBean
{
  private double monthIn;
  private double monthIncrease;
  private double investRate;
  private int year;
  private double incomeRate;
  private double deposit;

  public RichManBean()
  {
    this.monthIncrease = 5.0D;
  }

  public double getMonthIn()
  {
    return this.monthIn;
  }

  public void setMonthIn(double monthIn)
  {
    this.monthIn = monthIn;
  }

  public double getMonthIncrease()
  {
    return this.monthIncrease;
  }

  public void setMonthIncrease(double monthIncrease)
  {
    this.monthIncrease = monthIncrease;
  }

  public double getInvestRate()
  {
    return this.investRate;
  }

  public void setInvestRate(double investRate)
  {
    this.investRate = investRate;
  }

  public int getYear()
  {
    return this.year;
  }

  public void setYear(int year)
  {
    this.year = year;
  }

  public double getIncomeRate()
  {
    return this.incomeRate;
  }

  public void setIncomeRate(double incomeRate)
  {
    this.incomeRate = incomeRate;
  }

  public double getDeposit()
  {
    return this.deposit;
  }

  public void setDeposit(double deposit)
  {
    this.deposit = deposit;
  }

  public static void countWorth()
  {
  }

  public double annualInvestAmount()
  {
    return (this.monthIn * 12.0D * this.investRate / 100.0D);
  }

  public double incomeNYear()
  {
    return (annualInvestAmount() * Math.pow(1.0D + this.monthIncrease / 100.0D, this.year - 1));
  }

  public double investNYear(int year)
  {
    return (annualInvestAmount() * this.monthIncrease / 100.0D * Math.pow(1.0D + this.monthIncrease / 100.0D, year - 2));
  }

  public double sum(int year)
  {
    return (annualInvestAmount() * (1.0D + this.incomeRate / 100.0D) * (Math.pow(1.0D + this.incomeRate / 100.0D, year) - 1.0D) / this.incomeRate / 100.0D);
  }

  public double sumNYeat(int n)
  {
    return (investNYear(n) * (1.0D + this.incomeRate / 100.0D) * (Math.pow(1.0D + this.incomeRate / 100.0D, this.year - n + 1) - 1.0D) / this.incomeRate / 100.0D);
  }

  public double sumEveryYear()
  {
    double sum = 0.0D;
    for (int i = 1; i <= this.year; ++i) {
      if (i == 1)
        sum += sum(i);
      else if (i == this.year) {
        sum += investNYear(i) * (1.0D + this.incomeRate / 100.0D) * (1.0D + this.incomeRate / 100.0D - 1.0D) / this.incomeRate / 100.0D;
      }
      else {
        sum += sumNYeat(i);
      }
    }
    return sum;
  }

  public double saveNYear()
  {
    return (this.deposit * Math.pow(1.0D + this.incomeRate / 100.0D, this.year - 1));
  }
}
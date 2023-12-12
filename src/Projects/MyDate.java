package Projects;

public class MyDate
{
  private int day;
  private int month;
  private int year;

  private int numberOfDays;
  private String monthName;

  public MyDate(int day, int month, int year)
  {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public MyDate(int month)
  {
    this.month = month;
  }

  public MyDate()
  {
    this.day = 0;
    this.month = 0;
    this.year = 0;
  }

  public MyDate add(MyDate duration) {
    int newMonth = this.month + duration.getMonth();
    int newYear = this.year + duration.getYear();
    int newDay = this.day + duration.getDay();

    // Adjust for month overflow
    if (newMonth > 12) {
      newYear += (newMonth - 1) / 12;
      newMonth = (newMonth - 1) % 12 + 1;
    }

    // Adjust for day overflow
    int maxDaysInMonth = new MyDate(newMonth, 1, newYear).numberOfDaysInMonth();
    if (newMonth == 2 && newDay > maxDaysInMonth) {
      // Handle leap year
      if (new MyDate(newMonth, 1, newYear).isLeapYear()) {
        newDay = maxDaysInMonth + 1;
      } else {
        newDay = maxDaysInMonth;
      }
    } else if (newDay > maxDaysInMonth) {
      newDay = maxDaysInMonth;
    }

    return new MyDate(newDay, newMonth, newYear);
  }


  public int getDay () {
    return day;
  }

  public int getMonth () {
    return month;
  }

  public int getYear () {
    return year;
  }

  public String getMonthName () {
    if (month >= 1 && month <= 12)
    {
      String[] monthNames = {"January", "February", "March", "April", "May",
          "June", "July", "August", "September", "October", "November",
          "December"};
      return monthNames[month - 1];
    }
    return "Invalid Month";
  }

  public int numberOfDaysInMonth () {
    if (isLeapYear() && month == 2)
    {
      return 29;
    }
    else if (!isLeapYear() && month == 2)
    {
      return 28;
    }
    else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
        || month == 10 || month == 12)
    {
      return 31;
    }
    else
    {
      return 30;
    }
  }

  public void set ( int day, int month, int year){
    this.day = day;
    this.month = month;
    this.year = year;

    if (year < 0)
    {
      this.year = year * (-1);
    }
    if (month < 1)
    {
      this.month = 1;
    }
    if (month > 12)
    {
      this.month = 12;
    }
    if (day < 1)
    {
      this.day = 1;
    }
    if (day > numberOfDaysInMonth())
    {
      this.day = numberOfDaysInMonth();
    }
  }

  public boolean isLeapYear () {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
  }

  public int yearBetween (MyDate otherDate){
    return Math.abs(this.year - otherDate.getYear());
  }

  public MyDate addDefaultDuration () {
    int defaultDurationMonths = 12; // Assuming default duration is 12 months
    return add(new MyDate(defaultDurationMonths));
  }

  public boolean isBefore(MyDate otherDate) {
    if (otherDate == null) {
      throw new IllegalArgumentException("Comparison date cannot be null");
    }

    if (this.year < otherDate.year) {
      return true;
    } else if (this.year > otherDate.year) {
      return false;
    }

    // Years are equal, check months
    if (this.month < otherDate.month) {
      return true;
    } else if (this.month > otherDate.month) {
      return false;
    }

    // Months are equal, check days
    return this.day < otherDate.day;
  }

  public String expectedDuration(){
    int months = getMonth();
    return months + " " + "months";
  }

  @Override public String toString () {
    return String.format("%02d/%02d/%04d", day, month, year);
  }

}


package Projects;

/**
 * The MyDate class represents a date with day, month, and year components
 * It provides methods for date manipulation
 * Calculation of the number of days in a month, and checking for leap years
 *
 * @author
 * @version 1.0 - December 2023
 */

public class MyDate
{
  private int day;
  private int month;
  private int year;

  private int numberOfDays;
  private String monthName;

  /**
   * Three-argument constructor for initializing a date with day, month, and year
   *
   * @param day   The day component of the date
   * @param month The month component of the date
   * @param year  The year component of the date
   */
  public MyDate(int day, int month, int year)
  {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  /**
   * One-argument constructor for initializing a date with only the month component
   *
   * @param month The month component of the date
   */
  public MyDate(int month)
  {
    this.month = month;
  }

  /**
   * Constructor for creating an empty date
   */
  public MyDate()
  {
    this.day = 0;
    this.month = 0;
    this.year = 0;
  }

  /**
   * Adds a specified duration to the current date and returns a new date
   *
   * @param duration The duration to add to the current date
   * @return A new date representing the result of the addition
   */
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


  /**
   * Getter for the day component of the date
   *
   * @return The day
   */
  public int getDay () {
    return day;
  }

  /**
   * Getter for the month component of the date
   *
   * @return The month
   */
  public int getMonth () {
    return month;
  }

  /**
   * Getter for the year component of the date
   *
   * @return The year
   */
  public int getYear () {
    return year;
  }

  /**
   * Getter for the name of the month based on the month component
   *
   * @return The name of the month
   */
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

  /**
   * Getter for the number of days in the month based on the month component and leap year status
   *
   * @return The number of days in the month
   */
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

  /**
   * Sets the day, month, and year components of the date
   *
   * @param day   The day to set
   * @param month The month to set
   * @param year  The year to set
   */
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

  /**
   * Checks if the current year is a leap year
   *
   * @return True if the year is a leap year, false otherwise
   */
  public boolean isLeapYear () {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
  }

  /**
   * Calculates the difference in years between the current date and another date
   *
   * @param otherDate The date to calculate the difference with
   * @return The difference in years
   */
  public int yearBetween (MyDate otherDate){
    return Math.abs(this.year - otherDate.getYear());
  }

  /**
   * Adds a default duration of 12 months to the current date
   *
   * @return A new date representing the result of the addition
   */
  public MyDate addDefaultDuration () {
    int defaultDurationMonths = 12; // Assuming default duration is 12 months
    return add(new MyDate(defaultDurationMonths));
  }

  /**
   * Checks if the current date is before another date
   *
   * @param otherDate The date to compare with
   * @return True if the current date is before the other date, false otherwise
   * @throws IllegalArgumentException if the comparison date is null
   */
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

  /**
   * Getter for the expected duration of the date in months
   *
   * @return The expected duration as a string displaying "x months"
   */
  public String expectedDuration(){
    int months = getMonth();
    return months + " " + "months";
  }

  /**
   * A string method representation the date in the format "dd/mm/yyyy"
   *
   * @return The string representation of the date
   */
  @Override public String toString () {
    return String.format("%02d/%02d/%04d", day, month, year);
  }

}


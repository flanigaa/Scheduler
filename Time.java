import java.time.*;

// Class to hold a single time with day of week with or without date
public class Time implements Comparable<Time> {

  protected LocalDate date;
  protected int day;
  protected int hour;
  protected int minute;

  public Time(int aDay, int anHour, int aMinute) {
    this.day = aDay;
    if (anHour >= 0 && anHour <= 23)
      this.hour = anHour;
    if (aMinute >= 0 && aMinute <= 59)
      this.minute = aMinute;
  }

  public Time(LocalDate aDate, int aDay, int anHour, int aMinute) {
    this.date = aDate;
    this.day = aDay;
    if (anHour >= 0 && anHour <= 23)
      this.hour = anHour;
    if (aMinute >= 0 && aMinute <= 59)
      this.minute = aMinute;
  }

  /**
   * Compares to days and returns the difference in the first value that is different
   * starting from day > hour > minute. Is used to check if the second time is within
   * the next day and to measure the difference of times.
   *
   * Other MUST be the greater day in order to handle going from Sunday to Monday.
   *
   * ex. originalTime.compareTo(otherTime) : if originalTime is Sunday and otherTime
   * is Monday, it will correctly tell that it's the next day, but if original is Monday
   * and other is Sunday, the comparison will return the difference of the days instead
   * of the hours
   * @param  Time other         a Time after the one being compared to
   * @return      returns the difference of times
   */
  public int compareTo(Time other) {
    // if both times have a date, return the difference if there is one, else
    // continue with standard comparison
    if (this.date != null && other.date != null) {
      if (this.date.compareTo(other.date) != 0) {
        return this.date.compareTo(other.date);
      }
    }

    boolean nextDay = DayOfWeek.isNextDay(this.day, other.day);

    // if other day is not the day after this day and days aren't the same
    if (!nextDay && !DayOfWeek.isSameDay(this.day, other.day)) {
      return this.day - other.day;

    // if other day is day after this day
    } else if (nextDay) {
      return this.hour - (other.hour + 24); // add 24 to represent next day

    // if day is the same
    } else {
      if (this.hour != other.hour) {
        return this.hour - other.hour;
      } else {
        return this.minute - other.minute;
      }
    }
  }

	/**
	* Returns value of date
	* @return
	*/
	public LocalDate getDate() {
		return this.date;
	}

	/**
	* Returns value of day
	* @return
	*/
	public int getDay() {
		return this.day;
	}

	/**
	* Returns value of hour
	* @return
	*/
	public int getHour() {
		return this.hour;
	}

	/**
	* Returns value of minute
	* @return
	*/
	public int getMinute() {
		return this.minute;
	}

	/**
	* Sets new value of date
	* @param
	*/
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	* Sets new value of day
	* @param
	*/
	public void setDay(int day) {
		this.day = day;
	}

	/**
	* Sets new value of hour
	* @param
	*/
	public void setHour(int hour) {
		this.hour = hour;
	}

	/**
	* Sets new value of minute
	* @param
	*/
	public void setMinute(int minute) {
		this.minute = minute;
	}
}

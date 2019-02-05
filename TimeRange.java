// Denotes a single time range that a task can be scheduled for
// IMPORTANT: TimeRange will be considered invalid if the end time is after the
// next day. Thus TimeRanges can be no greater than 48 hours.
//  ex. start=Sunday end=Monday -- OKAY
//  ex. start=Wednesday end=Thursday -- OKAY
//  ex. start=Monday end=Sunday -- INVALID
//  ex. start=Monday end=Thursday -- INVALID
public class TimeRange implements Comparable<TimeRange> {

  protected Time startTime; // Start of time range
  protected Time endTime; // End time of range
  protected boolean passesMidnight; // Whether or not the end time is "before" the start time and thus goes into the next day

  public TimeRange(Time start, Time end) {
    // checks that end time is after the start time
    // includes a check if start is Sunday and end is Monday (check DayOfWeek for more info)
    // if ((end.compareTo(start) >= 0) ||
    //     (start.day == DayOfWeek.SUNDAY && end.day == DayOfWeek.MONDAY) ) {
    if ((DayOfWeek.isSameDay(start.day, end.day) || DayOfWeek.isNextDay(start.day, end.day)) &&
        (start.compareTo(end) <= 0)) {
      this.startTime = start;
      this.endTime = end;
    } else {
      System.out.println("Invalid TimeRange during creation!");
    }

    if (DayOfWeek.isNextDay(start.day, end.day)) {
      this.passesMidnight = true;
    } else {
      this.passesMidnight = false;
    }
  }

  /**
   * Finds which time range comes first
   * @param  TimeRange other         TimeRange to compare to
   * @return           Returns a negative if this range is before the other
   *                           Returns 0 if they are the same range
   *                           Returns a positive if this range is after the other
   */
  public int compareTo(TimeRange other) {
    // if both time ranges have different start days, uses DayOfWeek's compare
    // function to find which day should come first
    if (!DayOfWeek.isSameDay(this.startTime.day, other.startTime.day)) {
      return DayOfWeek.compare(this.startTime.day, other.startTime.day);
    // if the start days are the same, uses Time's compareTo function to find
    // which time comes first
    } else {
      // calculates the difference in start time
      int startDifference = this.startTime.compareTo(other.startTime);
      // checks that the start times aren't the same
      if (startDifference != 0) {
        // if not the same, return the difference
        return startDifference;
      // if the start times are the same, return the difference of the end times
      } else {
        return this.endTime.compareTo(other.endTime);
      }
    }
  }

	/**
	* Returns value of startTime
	* @return
	*/
	public Time getStartTime() {
		return this.startTime;
	}

	/**
	* Returns value of endTime
	* @return
	*/
	public Time getEndTime() {
		return this.endTime;
	}

	/**
	* Returns value of passesMidnight
	* @return
	*/
	public boolean passesMidnight() {
		return this.passesMidnight;
	}

	/**
	* Sets new value of startTime
	* @param
	*/
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	/**
	* Sets new value of endTime
	* @param
	*/
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	/**
	* Sets new value of passesMidnight
	* @param
	*/
	public void setPassesMidnight(boolean passesMidnight) {
		this.passesMidnight = passesMidnight;
	}
}

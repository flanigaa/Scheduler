// Denotes a day of the week or a signal of any day
// Starts on Monday, ends on Sunday followed by any day
public class DayOfWeek {
  public static int MONDAY = 1;
  public static int TUESDAY = 2;
  public static int WEDNESDAY = 3;
  public static int THURSDAY = 4;
  public static int FRIDAY = 5;
  public static int SATURDAY = 6;
  public static int SUNDAY = 7;
  public static int ANY = 8;
  private static int NEXT_ANY = 9;

  /**
   * Returns the next day given a valid day
   * @param  int day           a day represented by an int x, 0 < x < 10
   * @return     returns the value of the next day
   */
  public static int nextDay(int day) {
    // checks for valid day input
    if (day > 0 && day < 10) {
      // if not Sunday, ANY, or NEXT_ANY, returns the next day
      if (day < DayOfWeek.SUNDAY) {
        return ++day;
      // if Sunday, return Monday
      } else if (day == DayOfWeek.SUNDAY) {
        return DayOfWeek.MONDAY;
      // if ANY or NEXT_ANY, return NEXT_ANY
      } else if (day == DayOfWeek.ANY || day == DayOfWeek.NEXT_ANY) {
        return DayOfWeek.NEXT_ANY;
      // if day is invalid, return -1
      } else {
        return -1;
      }
    } else {
      return -1;
    }
  }

  /**
   * Checks if two days are consecutive
   * @param  int dayOne        first day
   * @param  int dayTwo        second day
   * @return     returns true if dayOne is one day before dayTwo or if dayOne is
   * ANY and dayTwo is NEXT_ANY
   */
  public static boolean isNextDay(int dayOne, int dayTwo) {
    // checks for valid day input
    if (dayOne > 0 && dayOne < 10 && dayTwo > 0 && dayTwo < 10) {

      // checks for ANY or NEXT_ANY for other special case
      if (dayOne == DayOfWeek.ANY || dayOne == DayOfWeek.NEXT_ANY ||
          dayTwo == DayOfWeek.ANY || dayTwo == DayOfWeek.NEXT_ANY) {
        // if dayOne is ANY and dayTwo is NEXT_ANY
        if (dayOne == DayOfWeek.ANY && dayTwo == DayOfWeek.NEXT_ANY) {
          return true;
        } else {
          return false;
        }

      // checks if the days are Monday then Sunday for special case
      } else if (dayOne == DayOfWeek.SUNDAY && dayTwo == DayOfWeek.MONDAY) {
        return true;

      // checks if dayOne is one day before dayTwo
      } else if (++dayOne == dayTwo) {
        return true;

      // days are valid but dayTwo is not the next day
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  /**
   * Checks if two given days are the same day
   * @param  int dayOne        first day
   * @param  int dayTwo        second day
   * @return     returns true if both days are the same
   */
  public static boolean isSameDay(int dayOne, int dayTwo) {
    // checks for valid days
    if (dayOne > 0 && dayOne < 10 && dayTwo > 0 && dayTwo < 10) {
      if (dayOne == dayTwo) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  /**
   * Checks which day comes first
   * Priority is ANY > NEXT_ANY > MONDAY > TUESDAY > ... > SUNDAY
   * NOTE: does not handle invalid days correctly (returns -2)
   * @param  int dayOne        first day
   * @param  int dayTwo        second day
   * @return     returns -1 if dayOne comes before dayTwo,
   *                    returns 0 if dayOne is the same day as dayTwo
   *                    returns 1 if dayOne comes after dayTwo
   */
  public static int compare(int dayOne, int dayTwo) {
    if (DayOfWeek.isSameDay(dayOne, dayTwo)) {
      return 0;
    } else if (dayOne == DayOfWeek.ANY && dayTwo == DayOfWeek.NEXT_ANY) {
      return -1;
    } else if (dayOne == DayOfWeek.NEXT_ANY && dayTwo == DayOfWeek.ANY) {
      return 1;
    } else if (dayOne == DayOfWeek.ANY || dayOne == DayOfWeek.NEXT_ANY) {
      return -1;
    } else if (dayTwo == DayOfWeek.ANY || dayTwo == DayOfWeek.NEXT_ANY) {
      return 1;
    } else if (dayOne < dayTwo) {
      return -1;
    } else if (dayOne > dayTwo) {
      return 1;
    } else {
      return -2;
    }
  }

  public static String toString(int day) {
    if (day == DayOfWeek.MONDAY) {
      return "MONDAY";
    } else if (day == DayOfWeek.TUESDAY) {
      return "TUESDAY";
    } else if (day == DayOfWeek.WEDNESDAY) {
      return "WEDNESDAY";
    } else if (day == DayOfWeek.THURSDAY) {
      return "THURSDAY";
    } else if (day == DayOfWeek.FRIDAY) {
      return "FRIDAY";
    } else if (day == DayOfWeek.SATURDAY) {
      return "SATURDAY";
    } else if (day == DayOfWeek.SUNDAY) {
      return "SUNDAY";
    } else if (day == DayOfWeek.ANY) {
      return "ANY";
    } else if (day == DayOfWeek.NEXT_ANY) {
      return "NEXT_ANY";
    } else {
      return "INVALID DAY";
    }
  }
}

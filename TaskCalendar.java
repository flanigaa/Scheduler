import java.time.*;
import java.util.Calendar;

public class TaskCalendar {
  protected LocalDate focusDate;
  protected int daysInMonth;
  protected int weeksInMonth;

  public TaskCalendar() {
    this.focusDate = LocalDate.now();
    this.daysInMonth = this.focusDate.lengthOfMonth();
    this.weeksInMonth = getWeeksInMonth(this.focusDate);
  }

  public TaskCalendar(LocalDate aDate) {
    this.focusDate = aDate;
    this.daysInMonth = this.focusDate.lengthOfMonth();
    this.weeksInMonth = getWeeksInMonth(this.focusDate);
  }

  public void updateFocusDay(LocalDate newDate) {
    this.focusDate = newDate;
    this.daysInMonth = this.focusDate.lengthOfMonth();
    this.weeksInMonth = getWeeksInMonth(this.focusDate);
  }

  // @TODO: Fix method
  public int getWeeksInMonth(LocalDate date) {
    int year = this.focusDate.getYear();
    int month = this.focusDate.getMonthValue();
    int day = this.daysInMonth;

    Calendar calendar = Calendar.getInstance();
    calendar.setFirstDayOfWeek(Calendar.MONDAY);
    calendar.set(Calendar.YEAR, year);
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    calendar.set(Calendar.MONTH, month);
    // calendar.set(year, month, day);

    year = calendar.get(Calendar.YEAR);
    month = calendar.get(Calendar.MONTH);
    day = calendar.get(Calendar.DAY_OF_MONTH);
    // int weeks = calendar.get(Calendar.WEEK_OF_MONTH);
    int weeks = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
    // return calendar.get(Calendar.WEEK_OF_MONTH);
    return calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
  }

  public void minusMonths(long num) {
    LocalDate newDate = this.focusDate.minusMonths(num);
    updateFocusDay(newDate);
  }

  public void plusMonths(long num) {
    LocalDate newDate = this.focusDate.plusMonths(num);
    int month = newDate.getMonthValue();
    int day = newDate.getDayOfMonth();
    updateFocusDay(newDate);
  }

  public LocalDate getFocusDate() {
    return this.focusDate;
  }

  public int getWeeksInMonth() {
    return this.weeksInMonth;
  }

  public int getDaysInMonth() {
    return this.daysInMonth;
  }
}

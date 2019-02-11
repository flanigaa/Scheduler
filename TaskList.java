import java.util.*;
import java.time.*;

public class TaskList {

  protected ArrayList<Task> tasks;

  public TaskList() {
    this.tasks = new ArrayList<Task>();
  }

  public TaskList(ArrayList<Task> list) {
    this.tasks = list;
  }

  public void addTask(Task newTask) {
    this.tasks.add(newTask);
  }

  /**
   * Returns the full list of tasks
   * @return list of all tasks
   */
  public ArrayList<Task> getTasks() {
    return this.tasks;
  }

  /**
   * Returns the list of tasks that are scheduled for the given day
   * @param  LocalDate date          day to check for scheduled tasks
   * @return           list of tasks scheduled for the given day
   */
  public ArrayList<Task> getTasks(LocalDate date) {
    ArrayList<Task> list = new ArrayList<Task>();
    for (Task task : this.tasks) {
      ArrayList<TimeRange> setTimes = task.getSetTimes();
      for (TimeRange range : setTimes) {
        if (range.getStartTime().getDate().isEqual(date)) {
          list.add(task);
        }
      }
    }
    return list;
  }

  /**
   * Returns a list of uncompleted tasks in the TaskList
   * @return list of uncompleted tasks
   */
  public ArrayList<Task> getUncompletedTasks() {
    ArrayList<Task> list = new ArrayList<Task>();
    for (Task t : this.tasks) {
      if (!t.isCompleted()) {
        list.add(t);
      }
    }
    return list;
  }

  /**
   * Returns the list of uncompleted tasks that are scheduled for the given day
   * @param  LocalDate date          day to check for uncompleted, scheduled tasks
   * @return           list of uncompleted tasks scheduled for the given day
   */
  public ArrayList<Task> getUncompletedTasks(LocalDate date) {
    ArrayList<Task> list = new ArrayList<Task>();
    for (Task task : this.tasks) {
      if (!task.isCompleted()) {
        ArrayList<TimeRange> setTimes = task.getSetTimes();
        for (TimeRange range : setTimes) {
          if (range.getStartTime().getDate().isEqual(date)) {
            list.add(task);
          }
        }
      }
    }
    return list;
  }

  /**
   * Returns a list of completed tasks in the TaskList
   * @return list of completed tasks
   */
  public ArrayList<Task> getCompletedTasks() {
    ArrayList<Task> list = new ArrayList<Task>();
    for (Task t : this.tasks) {
      if (t.isCompleted()) {
        list.add(t);
      }
    }
    return list;
  }

  /**
   * Returns the list of completed tasks that are scheduled for the given day
   * @param  LocalDate date          day to check for completed, scheduled tasks
   * @return           list of completed tasks scheduled for the given day
   */
  public ArrayList<Task> getCompletedTasks(LocalDate date) {
    ArrayList<Task> list = new ArrayList<Task>();
    for (Task task : this.tasks) {
      if (task.isCompleted()) {
        ArrayList<TimeRange> setTimes = task.getSetTimes();
        for (TimeRange range : setTimes) {
          if (range.getStartTime().getDate().isEqual(date)) {
            list.add(task);
          }
        }
      }
    }
    return list;
  }
}

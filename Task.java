import java.util.ArrayList;
import java.time.*;

public class Task {

  protected String name; // Name of task
  protected float estimatedTime; // Estimated time to complete task
  protected ArrayList<TimeRange> preferredTimes; // List of preferred times to schedule task
  protected boolean requiredTimes; // Whether the task MUST be scheduled during the preferred times
  protected String description; // Desciption of task
  protected Urgency urgency; // Urgency level of the task
  protected LocalDate deadline; // Deadline for task completion
  protected LocalDate earliestStart; // Earliest date to start the task (if none set to current day)
  protected int sessionsDesired; // Desired number of sessions to break tasks into
  protected int sessionsLimit; // Max number of sessions to break tasks into
  protected boolean completed; // Whether the task has been completed or not

  public Task(String aName, float time, ArrayList<TimeRange> preferredTimeSet,
      boolean required, String aDescription, Urgency anUrgency,
      LocalDate aDeadline, int desired, int limit, LocalDate start) {
    this.name = aName;
    this.estimatedTime = time;
    this.preferredTimes = preferredTimeSet;
    this.requiredTimes = required;
    this.description = aDescription;
    this.urgency = anUrgency;
    this.deadline = aDeadline;
    if (start != null) {
      this.earliestStart = start;
    } else {
      this.earliestStart = LocalDate.now();
    }
    this.sessionsDesired = desired;
    this.sessionsLimit = limit;
    this.completed = false;
  }
}

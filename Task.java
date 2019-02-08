import java.util.ArrayList;
import java.time.*;

public class Task {

  protected String name; // Name of task
  protected float estimatedTime; // Estimated time to complete task
  protected String description; // Desciption of task
  protected Urgency urgency; // Urgency level of the task

  protected ArrayList<TimeRange> preferredTimes; // List of preferred times to schedule task
  protected boolean requiredTimes; // Whether the task MUST be scheduled during the preferred times

  protected LocalDateTime deadlineDateTime; // Deadline date and time for task completion
  protected LocalDateTime earliestStartDateTime; // Earliest date and time to start the task (if none set to current day)

  protected int sessionsDesired; // Desired number of sessions to break tasks into
  protected int sessionsLimit; // Max number of sessions to break tasks into

  protected boolean pastDeadline; // Whether the task is past its deadline
  protected boolean completed; // Whether the task has been completed or not

  protected ArrayList<TimeRange> setTimes; // Times currently scheduled to work on task

  public Task(String aName, float time, String aDescription, Urgency anUrgency,
      ArrayList<TimeRange> preferredTimeSet, boolean required,
      LocalDateTime aDeadlineDateTime, LocalDateTime startDateTime, int desired,
      int limit) {
    this.name = aName;
    this.estimatedTime = time;
    this.description = aDescription;
    this.urgency = anUrgency;
    this.preferredTimes = preferredTimeSet;
    this.requiredTimes = required;
    this.deadlineDateTime = aDeadlineDateTime;
    // gets local date and time
    LocalDateTime currentDateTime = LocalDateTime.now();
    // sets deadline date and time to local if none given
    if (startDateTime != null) {
      this.earliestStartDateTime = startDateTime;
    } else {
      this.earliestStartDateTime = currentDateTime;
    }
    this.sessionsDesired = desired;
    this.sessionsLimit = limit;
    // checks if task is already past deadline
    if (currentDateTime.isBefore(this.deadlineDateTime)) {
      this.pastDeadline = false;
    } else {
      this.pastDeadline = true;
    }
    this.completed = false;
    this.setTimes = new ArrayList<TimeRange>();
  }


////////////////////////////////GET METHODS/////////////////////////////////////
	/**
	* Returns value of name
	* @return
	*/
	public String getName() {
		return this.name;
	}

	/**
	* Returns value of estimatedTime
	* @return
	*/
	public float getEstimatedTime() {
		return this.estimatedTime;
	}

	/**
	* Returns value of description
	* @return
	*/
	public String getDescription() {
		return this.description;
	}

	/**
	* Returns value of urgency
	* @return
	*/
	public Urgency getUrgency() {
		return this.urgency;
	}

	/**
	* Returns value of preferredTimes
	* @return
	*/
	public ArrayList<TimeRange> getPreferredTimes() {
		return this.preferredTimes;
	}

	/**
	* Returns value of requiredTimes
	* @return
	*/
	public boolean isRequiredTimes() {
		return this.requiredTimes;
	}

	/**
	* Returns value of deadlineDateTime
	* @return
	*/
	public LocalDateTime getDeadlineDateTime() {
		return this.deadlineDateTime;
	}

	/**
	* Returns value of earliestStartDateTime
	* @return
	*/
	public LocalDateTime getEarliestStartDateTime() {
		return this.earliestStartDateTime;
	}

	/**
	* Returns value of sessionsDesired
	* @return
	*/
	public int getSessionsDesired() {
		return this.sessionsDesired;
	}

	/**
	* Returns value of sessionsLimit
	* @return
	*/
	public int getSessionsLimit() {
		return this.sessionsLimit;
	}

	/**
	* Returns value of pastDeadline
	* @return
	*/
	public boolean isPastDeadline() {
		return this.pastDeadline;
	}

	/**
	* Returns value of completed
	* @return
	*/
	public boolean isCompleted() {
		return this.completed;
	}

	/**
	* Returns value of setTimes
	* @return
	*/
	public ArrayList<TimeRange> getSetTimes() {
		return this.setTimes;
	}

  ////////////////////////////////SET METHODS///////////////////////////////////

	/**
	* Sets new value of name
	* @param
	*/
	public void setName(String name) {
		this.name = name;
	}

	/**
	* Sets new value of estimatedTime
	* @param
	*/
	public void setEstimatedTime(float estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	/**
	* Sets new value of description
	* @param
	*/
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	* Sets new value of urgency
	* @param
	*/
	public void setUrgency(Urgency urgency) {
		this.urgency = urgency;
	}

	/**
	* Sets new value of preferredTimes
	* @param
	*/
	public void setPreferredTimes(ArrayList<TimeRange> preferredTimes) {
		this.preferredTimes = preferredTimes;
	}

	/**
	* Sets new value of requiredTimes
	* @param
	*/
	public void setRequiredTimes(boolean requiredTimes) {
		this.requiredTimes = requiredTimes;
	}

	/**
	* Sets new value of deadlineDateTime
	* @param
	*/
	public void setDeadlineDateTime(LocalDateTime deadlineDateTime) {
		this.deadlineDateTime = deadlineDateTime;
	}

	/**
	* Sets new value of earliestStartDateTime
	* @param
	*/
	public void setEarliestStartDateTime(LocalDateTime earliestStartDateTime) {
		this.earliestStartDateTime = earliestStartDateTime;
	}

	/**
	* Sets new value of sessionsDesired
	* @param
	*/
	public void setSessionsDesired(int sessionsDesired) {
		this.sessionsDesired = sessionsDesired;
	}

	/**
	* Sets new value of sessionsLimit
	* @param
	*/
	public void setSessionsLimit(int sessionsLimit) {
		this.sessionsLimit = sessionsLimit;
	}

	/**
	* Sets new value of pastDeadline
	* @param
	*/
	public void setPastDeadline(boolean pastDeadline) {
		this.pastDeadline = pastDeadline;
	}

	/**
	* Sets new value of completed
	* @param
	*/
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	/**
	* Sets new value of setTimes
	* @param
	*/
	public void setSetTimes(ArrayList<TimeRange> setTimes) {
		this.setTimes = setTimes;
	}
}
